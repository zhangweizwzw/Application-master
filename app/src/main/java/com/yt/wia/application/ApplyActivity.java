package com.yt.wia.application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.yt.wia.model.ApplyBean;
import com.yt.wia.model.ResultBean;
import com.yt.wia.utils.ProcessUtil;
import com.yt.wia.utils.ProvingUtil;
import com.yt.wia.utils.ToastUtil;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class ApplyActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG="ApplyActivity";
    private EditText name_et,people_et,phone_et,postbox_et;
    private EditText projectname_et,invest_et,demand_et,project_content_et,renvenue_et,job_et,business_et;
    private TextView text_center,text_right;
    private ImageView image_left;
    private Button sure;
    public static final MediaType JSON=MediaType.parse("application/json; charset=utf-8");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply);

        initView();
    }

    private void initView() {
        //初始化标题
        text_center= (TextView) findViewById(R.id.text_center);
        text_center.setText("申请");
        image_left= (ImageView) findViewById(R.id.image_left);
        image_left.setImageResource(R.mipmap.title_back);
        image_left.setOnClickListener(this);

        name_et= (EditText) findViewById(R.id.name_et);
        people_et= (EditText) findViewById(R.id.people_et);
        phone_et= (EditText) findViewById(R.id.phone_et);
        postbox_et= (EditText) findViewById(R.id.postbox_et);

        projectname_et= (EditText) findViewById(R.id.projectname_et);
        invest_et= (EditText) findViewById(R.id.invest_et);
        demand_et= (EditText) findViewById(R.id.demand_et);
        project_content_et= (EditText) findViewById(R.id.project_content_et);
        renvenue_et= (EditText) findViewById(R.id.renvenue_et);
        job_et= (EditText) findViewById(R.id.job_et);
        business_et= (EditText) findViewById(R.id.business_et);

        sure= (Button) findViewById(R.id.sure);
        sure.setOnClickListener(this);
    }


    public void goCommit(ApplyBean applyBean){
        Gson gson=new Gson();
        String jsonstr=gson.toJson(applyBean);
        RequestBody body=RequestBody.create(JSON,jsonstr);
        ProcessUtil.showProcess(this,"正在加载，请稍后...");
        OkHttpUtils
                .put()
//                .url(SystemSettings.NEWREQUEST_URL)
                .url("http://192.168.1.112:8080/manager/zs/save")
                .requestBody(body)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e) {
                        ProcessUtil.dismiss();
                        Log.i(TAG,"提交申请错误："+e.toString());
                        ToastUtil.showToast(ApplyActivity.this,"服务器繁忙，请稍后重试！");
                    }

                    @Override
                    public void onResponse(String response) {
                        ProcessUtil.dismiss();
                        Log.i(TAG,"提交申请返回："+response);
                        Gson gson=new Gson();
                        ResultBean rbean=gson.fromJson(response,ResultBean.class);
                        if(rbean.isResult()){
                            goback(1);
                        }else{
                            ToastUtil.showToast(ApplyActivity.this,"服务器繁忙，请稍后重试！");
                        }

                    }
                });
    }

    public void goback(int isreflash){
        Intent intent=new Intent();
        intent.putExtra("isreflash",isreflash);
        setResult(1,intent);
        finish();
    }
    /**
     *
     * 点击事件
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.image_left:
                goback(0);
                break;
            case R.id.sure:
                String  str_names=name_et.getText().toString();//项目名称
                String  str_people=people_et.getText().toString();//联系人
                String  str_phone=phone_et.getText().toString();//联系电话
                String  str_postbox=postbox_et.getText().toString();//电子邮件

                String  str_projectname=projectname_et.getText().toString();//项目名称
                String  str_invest=invest_et.getText().toString();//投资额
                String  str_demand=demand_et.getText().toString();//土地需求面积
                String  str_project_content=project_content_et.getText().toString();//项目建设内容
                String  str_renvenue=renvenue_et.getText().toString();//税收情况
                String  str_job=job_et.getText().toString();//就业情况
                String  str_business=business_et.getText().toString();//营业额

                if(str_names.isEmpty()){
                    ToastUtil.showToast(this,"请输入项目名称");
                }else if(str_people.isEmpty()){
                    ToastUtil.showToast(this,"请输入联系人");
                }else if(str_phone.isEmpty()){
                    ToastUtil.showToast(this,"请输入联系电话");
                }else if(!ProvingUtil.isPhone(str_phone) && !ProvingUtil.isdianhua(str_phone)){
                    ToastUtil.showToast(this,"请输入正确的电话号码");
                }else if(str_postbox.isEmpty()){
                    ToastUtil.showToast(this,"请输入电子邮件");
                } else if(!ProvingUtil.checkEmail(str_postbox)){
                    ToastUtil.showToast(this,"请输入正确的邮箱");
                }else if(str_projectname.isEmpty()){
                    ToastUtil.showToast(this,"请输入项目名称");
                }else if(str_invest.isEmpty()){
                    ToastUtil.showToast(this,"请输入投资额");
                }else if(str_demand.isEmpty()){
                    ToastUtil.showToast(this,"请输入土地需求面积");
                }else if(str_project_content.isEmpty()){
                    ToastUtil.showToast(this,"请输入项目建设内容");
                }else if(str_renvenue.isEmpty()){
                    ToastUtil.showToast(this,"请输入税收情况");
                }else if(str_job.isEmpty()){
                    ToastUtil.showToast(this,"请输入就业情况");
                }else if(str_business.isEmpty()){
                    ToastUtil.showToast(this,"请输入营业额");
                }else{
                    ApplyBean abean=new ApplyBean();
                    abean.setProjectName(str_names);
                    abean.setPersonName(str_people);
                    abean.setPhone(str_phone);
                    abean.setMail(str_postbox);

                    abean.setOrgName(str_projectname);
                    abean.setTze(str_invest);
                    abean.setRequireTdmj(str_demand);
                    abean.setProjectContext(str_project_content);
                    abean.setSsqk(str_renvenue);
                    abean.setJyqk(str_job);
                    abean.setYye(str_business);
                    //set 值
                    goCommit(abean);
                }
                break;
        }
    }
}
