package com.yt.wia.application;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.yt.wia.model.ApplyBean;
import com.yt.wia.model.ApplyListBean;
import com.yt.wia.utils.ProcessUtil;
import com.yt.wia.utils.ToastUtil;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.w3c.dom.Text;

import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class ApplyDetailActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG="ApplyDetailActivity";
    private TextView text_center;
    private ImageView image_left;
    public static final MediaType JSON=MediaType.parse("application/json; charset=utf-8");
    private EditText name_et,people_et,phone_et,postbox_et;
    private EditText projectname_et,invest_et,demand_et,project_content_et,renvenue_et,job_et,business_et;
    private EditText shenhe_people_et,shenhe_time_et,istongguo_et,shenhe_shuoming_et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply_detail);

        initView();
        initData();
    }

    private void initView() {
        text_center= (TextView) findViewById(R.id.text_center);
        text_center.setText("详情");
        image_left= (ImageView) findViewById(R.id.image_left);
        image_left.setImageResource(R.mipmap.title_back);
        image_left.setOnClickListener(this);

        //第一行
        name_et= (EditText) findViewById(R.id.name_et);
        people_et= (EditText) findViewById(R.id.people_et);
        phone_et= (EditText) findViewById(R.id.phone_et);
        postbox_et= (EditText) findViewById(R.id.postbox_et);
        //第二行
        projectname_et= (EditText) findViewById(R.id.projectname_et);
        invest_et= (EditText) findViewById(R.id.invest_et);
        demand_et= (EditText) findViewById(R.id.demand_et);
        project_content_et= (EditText) findViewById(R.id.project_content_et);
        renvenue_et= (EditText) findViewById(R.id.renvenue_et);
        job_et= (EditText) findViewById(R.id.job_et);
        business_et= (EditText) findViewById(R.id.business_et);
        //第三行
        shenhe_people_et= (EditText) findViewById(R.id.shenhe_people_et);
        shenhe_time_et= (EditText) findViewById(R.id.shenhe_time_et);
        istongguo_et= (EditText) findViewById(R.id.istongguo_et);
        shenhe_shuoming_et= (EditText) findViewById(R.id.shenhe_shuoming_et);
    }

    private void initData() {
        long id=getIntent().getLongExtra("id",0L);
        OkHttpUtils
                .post()
                .url("http://192.168.1.101:8080/manager/zs/findOne")
                .addParams("id",id+"")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e) {
                        ProcessUtil.dismiss();
                        Log.i(TAG,"申请详情错误："+e.toString());
                        ToastUtil.showToast(ApplyDetailActivity.this,"服务器繁忙，请稍后重试！");
                    }

                    @Override
                    public void onResponse(String response) {
                        ProcessUtil.dismiss();
                        Log.i(TAG,"申请详情返回："+response);

                        Gson gson=new Gson();
                        ApplyBean abean=gson.fromJson(response,ApplyBean.class);
                        //第一行
                        name_et.setText(abean.getOrgName());
                        people_et.setText(abean.getPersonName());
                        phone_et.setText(abean.getPhone());
                        postbox_et.setText(abean.getMail());
                        //第二行
                        projectname_et.setText(abean.getProjectName());
                        invest_et.setText(abean.getTze());
                        demand_et.setText(abean.getRequireTdmj());
                        project_content_et.setText(abean.getProjectContext());
                        renvenue_et.setText(abean.getSsqk());
                        job_et.setText(abean.getJyqk());
                        business_et.setText(abean.getYye());
                        //第三行
                        shenhe_people_et.setText(abean.getReviews().get(0).getReviewUserName());
                        shenhe_time_et.setText(abean.getReviews().get(0).getReviewTime());
                        if(abean.getReviews().get(0).getReviewResult().equals("true")){
                            istongguo_et.setText("是");
                        }else{
                            istongguo_et.setText("否");
                        }
                        shenhe_shuoming_et.setText(abean.getReviews().get(0).getReviewDesc());
                    }
                });
    }

    /**
     * 点击事件
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.image_left:
                finish();
                break;
        }
    }
}
