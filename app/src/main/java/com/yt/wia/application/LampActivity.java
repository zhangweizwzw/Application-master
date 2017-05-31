package com.yt.wia.application;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yt.wia.adapter.LampListAdapter;
import com.yt.wia.config.SystemSettings;
import com.yt.wia.model.ControllerBean;
import com.yt.wia.model.LampListBean;
import com.yt.wia.model.LampRequestBean;
import com.yt.wia.utils.ProcessUtil;
import com.yt.wia.utils.ToastUtil;
import com.yt.wia.view.MaterialSpinner;
import com.yt.wia.view.XListView;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class LampActivity extends AppCompatActivity implements View.OnClickListener, XListView.IXListViewListener {
    private static final String TAG="LampActivity";
    private TextView text_center;
    private ImageView image_left;
    private MaterialSpinner amass;
    private String amass_name="";//集中器名称
    private List<ControllerBean> cb;//集中器集合
    private XListView lamplv;
    private int totalPage=0;//总页数
    private int page=1;//当前页数
    private Button sure_btn;
    private LampListAdapter lampAdapter;
    public static final MediaType JSON=MediaType.parse("application/json; charset=utf-8");
    private List<LampListBean.ListBean>  lamplist=new ArrayList<LampListBean.ListBean>();
    private String[] contrs;
    private EditText controller;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what==0){
                getLampList(1,0);
                onLoad();
            }else if(msg.what==1){
                page++;
                if(page<=totalPage){
                    getLampList(page,0);
                    onLoad();
                }else{
                    ToastUtil.showToast(LampActivity.this,"没有更多内容！");
                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lamp);

        initView();
        getAmassArray();
    }

    private void initView() {
        //初始胡标题
        text_center= (TextView) findViewById(R.id.text_center);
        text_center.setText("路灯");
        image_left= (ImageView) findViewById(R.id.image_left);
        image_left.setImageResource(R.mipmap.title_back);
        image_left.setOnClickListener(this);

        controller= (EditText) findViewById(R.id.controller);

        lamplv= (XListView) findViewById(R.id.lamplv);
        lamplv.setPullLoadEnable(true);
        lamplv.setXListViewListener(this);
        lampAdapter=new LampListAdapter(this,lamplist);
        lamplv.setAdapter(lampAdapter);

//        lamplv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent=new Intent();
//                intent.putExtra("lid", lamplist.get(position).getCntr_cntr_id()+"");
//                intent.setClass(LampActivity.this,LampDetailActivity.class);
//                startActivity(intent);
//            }
//        });
        sure_btn= (Button) findViewById(R.id.sure_btn);
        sure_btn.setOnClickListener(this);

        amass= (MaterialSpinner) findViewById(R.id.amass);
        amass.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener(){
            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, Object item) {
                amass_name=contrs[position];
            }
        });
    }

    private void getLampList(int page,int isShowProcess) {
        /**
         * 第一页清空列表
         */
        if(page==1){
            lamplist.clear();
        }
        /**
         * 集中器为全部
         */
        if(amass_name.equals("全部")){
            amass_name="";
        }

        String strContr=controller.getText().toString();
        Log.i(TAG,"集中器="+amass_name);
        Log.i(TAG,"控制器="+strContr);
        Log.i(TAG,"当前page="+page);

        LampRequestBean lBean=new LampRequestBean();
        lBean.setPageNo(page+"");
        lBean.setSize("5");
        lBean.setCntr_cntr_name(amass_name);
        lBean.setLamp_cntr_name(strContr);

        Gson gson=new Gson();
        String jsonstr=gson.toJson(lBean);
        RequestBody body=RequestBody.create(JSON,jsonstr);

        if(isShowProcess==1){//是否显示正在加载页面
            ProcessUtil.showProcess(this,"正在加载，请稍后...");
        }
        OkHttpUtils
                .put()
                .url(SystemSettings.LAMP_URL+"findlist")
                .requestBody(body)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e) {
                        ProcessUtil.dismiss();
                        ToastUtil.showToast(LampActivity.this,"服务器繁忙，请稍后重试！");
                    }

                    @Override
                    public void onResponse(String response) {
                        ProcessUtil.dismiss();

                        Log.i(TAG,"列表="+response);
                        Gson gson=new Gson();
                        LampListBean lbean=gson.fromJson(response,LampListBean.class);
                        totalPage=lbean.getPages();//获取总页数

                        lamplist.addAll(lbean.getList());
                        lampAdapter.notifyDataSetChanged();
                    }
                });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.image_left:
                finish();
                break;
            case R.id.sure_btn:
                if(amass_name.isEmpty()){
                    ToastUtil.showToast(this,"请选择集中器名称！");
                }else{
                    getLampList(1,1);
                }
                break;
        }
    }

    public void getAmassArray() {
        OkHttpUtils
                .post()
                .url(SystemSettings.LAMP_URL+"findalllamp")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e) {
                        ToastUtil.showToast(LampActivity.this,"服务器繁忙，请稍后重试！");
                        ProcessUtil.dismiss();
                    }

                    @Override
                    public void onResponse(String response) {
                        Log.i(TAG,"获取控制器名称返回="+response);
                        Gson gson=new Gson();
                        cb=gson.fromJson(response,new TypeToken<ArrayList<ControllerBean>>(){}.getType());
                        setSpinnerData(cb);
                    }
                });
    }


    /**
     * 设置集中器spinner
     * @param cbean
     */
    public void setSpinnerData(List<ControllerBean> cbean){
        String[] controllers = new String[cbean.size()+1];
        controllers[0]="全部";
        Log.i(TAG,"spinner长度="+ cbean.size());
        for(int i=1;i<cbean.size()+1;i++){
            controllers[i]=cbean.get(i-1).getCntr_cntr_name();
        }
        amass.setItems(controllers);
        amass_name=controllers[amass.getSelectedIndex()];
        contrs=controllers;

        getLampList(1,1);//获取路灯列表
    }

    @Override
    public void onRefresh() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0);
            }
        }, 2000);
    }


    @Override
    public void onLoadMore() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                handler.sendEmptyMessage(1);
            }
        }, 2000);
    }

    private void onLoad() {
        lamplv.stopRefresh();
        lamplv.stopLoadMore();
        Date date=new Date();
        SimpleDateFormat format=new SimpleDateFormat("yy-MM-dd HH:mm:ss");
        lamplv.setRefreshTime(format.format(date));
    }
}
