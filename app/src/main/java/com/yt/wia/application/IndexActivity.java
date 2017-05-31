package com.yt.wia.application;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;

import com.yt.wia.commons.ThreadToast;
import com.yt.wia.commons.UpdateManager;
import com.yt.wia.config.DbUserBean;
import com.yt.wia.config.Strings;
import com.yt.wia.config.SystemSettings;
import com.yt.wia.config.Users;
import com.yt.wia.extend.AvatarAdapter;
import com.yt.wia.extend.MyXutilsApplication;
import com.yt.wia.utils.JsonUtils;
import com.yt.wia.utils.ProcessUtil;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.DbManager;
import org.xutils.common.util.KeyValue;
import org.xutils.db.sqlite.WhereBuilder;
import org.xutils.ex.DbException;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


@ContentView(R.layout.index)
public class IndexActivity extends Activity{
    private final String TAG="IndexActivity";

    @ViewInject(value =R.id.password)
    private EditText etPassword;
    @ViewInject(value = R.id.pinCode)
    private EditText etPinCode;
    @ViewInject(value = R.id.index_gridview)
    private GridView gridView;

    private AvatarAdapter adapter;

    private DbManager db;
    List<DbUserBean> adapterList=new ArrayList<DbUserBean>();
    private final static int ITEM_ONE=1;
    private final static int ITEM_TWO=2;
    private MyXutilsApplication app;
    //用户信息地址
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);//隐藏标题
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//设置全屏
        x.view().inject(this);

        //检查版本更新
//        UpdateManager um=new UpdateManager(this);
//        um.checkUpdate();

        this.initDb();
        //获取本地保存的用户信息
        try {
            List<DbUserBean> dbLista = db.findAll(DbUserBean.class);
            List<DbUserBean> dbList = db.selector (DbUserBean.class)
                    .orderBy("insertDate",true)
                    .limit(3) //只查询三条记录
                    .findAll();
            judeDbList(dbList);
        } catch (DbException e) {
            e.printStackTrace();
        }
        //设置用户头像
        this.setAvatar();
        app= (MyXutilsApplication) getApplication();
    }

    /**
     * 判断用户头像个数,显示位置
     * @param dbList
     */
    private void judeDbList(List<DbUserBean> dbList) {
        if (dbList!=null){
            Log.i("===adList===", dbList + "");
            gridView.setVisibility(View.VISIBLE);
            if (dbList.size()==ITEM_ONE){
                gridView.setNumColumns(1);
                for (DbUserBean u:dbList){
                    adapterList.add(u);
                }

            }else if (dbList.size()==ITEM_TWO){
                gridView.setNumColumns(2);
                for (DbUserBean u:dbList){
                    adapterList.add(u);
                }
            }else{
                gridView.setNumColumns(3);
                for (DbUserBean u:dbList){
                    adapterList.add(u);
                }
            }

        }
    }

    /**
     * 设置用户头像效果
     */
    private void setAvatar() {
        adapter=new AvatarAdapter(this,adapterList);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AvatarAdapter avatarAdapter = (AvatarAdapter) parent.getAdapter();
                avatarAdapter.setNotifyDataChanged(position);
                DbUserBean u=adapterList.get(position);
                etPassword.setText(adapterList.get(position).getPassword());
                etPinCode.setText(adapterList.get(position).getUpasword());
            }
        });
    }

    /**
     * 初始化DbManager
     */
    private void initDb() {
        db=x.getDb(MyXutilsApplication.myXutilsApplication().getDaoConfig());
    }

    /**
     * 登录按钮点击事件
     * @param v
     */
    public void onLoginBtnClick(View v) {
        final String password=etPassword.getText().toString().trim();
        final String pinCode=etPinCode.getText().toString().trim();
        //判断用户名密码是否为空
        if (TextUtils.isEmpty(password)||TextUtils.isEmpty(pinCode)){
            ThreadToast.backThreadLongToast(getApplicationContext(),Strings.Login_Click);
        }else{
            ProcessUtil.showProcess(this,"正在加载，请稍后...");
            OkHttpUtils
                    .post()
                    .url(SystemSettings.NEWREQUEST_URL+"loginVerify")
                    .addParams("account",password)
                    .addParams("password", pinCode)
                    .build()
                    .execute(new StringCallback() {
                        @Override
                        public void onError(Call call, Exception e) {
                            ProcessUtil.dismiss();
                            ThreadToast.backThreadLongToast(getApplicationContext(),Strings.Login_Fail);
                        }

                        @Override
                        public void onResponse(String response) {
                            Log.i(TAG,"登录返回="+response);
                            ProcessUtil.dismiss();
                            if("SUCCESS".equals(response)){
                                startActivity(new Intent(IndexActivity.this, MainActivity.class));
                                finish();

                                Users users= JsonUtils.getJson(response);
                                try {
                                    List<DbUserBean> dulist=db.selector(DbUserBean.class).where("password","=",password).findAll();

                                    if(dulist!=null){
                                        if(dulist.size()!=0){
                                            WhereBuilder whereBuilder = WhereBuilder.b();
                                            whereBuilder.and("password","=",password);
                                            db.update(DbUserBean.class,whereBuilder,
                                                    new KeyValue("insertDate",new Date()));//对User表中复合whereBuilder所表达的条件的记录更新email和mobile
                                        }else{
                                            DbUserBean dbUser=new DbUserBean(0,password,users.getAvatarImage(),new Date(),pinCode);
                                            db.save(dbUser);
                                        }
                                    }else{
                                        DbUserBean dbUser=new DbUserBean(0,password,users.getAvatarImage(),new Date(),pinCode);
                                        db.save(dbUser);
                                    }
                                    startActivity(new Intent(IndexActivity.this, MainActivity.class));
                                    finish();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }else{//登录失败
                                ThreadToast.backThreadLongToast(getApplicationContext(),Strings.Login_Fail);
                                dao();
                            }

//                            Users users= JsonUtils.getJson(response);
//                            //验证用户名,密码正确后,保存用户信息到本地,并跳转到主页面
//                            if (users.getStatus().equals("true")){//登录成功
//                                //保存用户数据
//                                app.userName=users.getUserName();//姓名
//                                app.sex=users.getSex();//性别
//                                app.addr=users.getAddr();//地址
//                                try {
//                                    List<DbUserBean> dulist=db.selector(DbUserBean.class).where("password","=",password).findAll();
//
//                                    if(dulist!=null){
//                                        if(dulist.size()!=0){
//                                            WhereBuilder whereBuilder = WhereBuilder.b();
//                                            whereBuilder.and("password","=",password);
//                                            db.update(DbUserBean.class,whereBuilder,
//                                                    new KeyValue("insertDate",new Date()));//对User表中复合whereBuilder所表达的条件的记录更新email和mobile
//                                        }else{
//                                            DbUserBean dbUser=new DbUserBean(0,password,users.getAvatarImage(),new Date(),pinCode);
//                                            db.save(dbUser);
//                                        }
//                                    }else{
//                                        DbUserBean dbUser=new DbUserBean(0,password,users.getAvatarImage(),new Date(),pinCode);
//                                        db.save(dbUser);
//                                    }
//                                    startActivity(new Intent(IndexActivity.this, MainActivity.class));
//                                    finish();
//                                } catch (Exception e) {
//                                    e.printStackTrace();
//                                }
//                            }else{//登录失败
//                                ThreadToast.backThreadLongToast(getApplicationContext(),Strings.Login_Fail);
//                                dao();
//                            }
                        }
                    });
        }
    }
    //清空密码框
    private void dao() {
        etPinCode.setText("");
    }

}

