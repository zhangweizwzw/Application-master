package com.yt.wia.application;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.yt.wia.config.SystemSettings;
import com.yt.wia.model.LampListBean;
import com.yt.wia.model.LampRequestBean;
import com.yt.wia.utils.ProcessUtil;
import com.yt.wia.utils.ToastUtil;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class LampDetailActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG="LampDetailActivity";
    private TextView jname,jaddress,jphone,jweidu,jjingdu,jstatus;//集中器
    private TextView lname,lmac,lid,lweidu,ljigndu,lstatus,lhuilu,ltype,llight,lv,la,lw,lwyin,lcharge,ltemp;//灯控器
    public static final MediaType JSON=MediaType.parse("application/json; charset=utf-8");
    private RelativeLayout large_lina;
    private LinearLayout small_lina;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lamp_detail);
        
        initView();
        getDtiail();
    }

    private void initView() {
        jname= (TextView) findViewById(R.id.jname);
        jaddress= (TextView) findViewById(R.id.jaddress);
        jphone= (TextView) findViewById(R.id.jphone);
        jweidu= (TextView) findViewById(R.id.jweidu);
        jjingdu= (TextView) findViewById(R.id.jjingdu);
        jstatus= (TextView) findViewById(R.id.jstatus);

        lname= (TextView) findViewById(R.id.lname);
        lmac= (TextView) findViewById(R.id.lmac);
        lid= (TextView) findViewById(R.id.lid);
        lweidu= (TextView) findViewById(R.id.lweidu);
        ljigndu= (TextView) findViewById(R.id.ljigndu);
        lstatus= (TextView) findViewById(R.id.lstatus);
        lhuilu= (TextView) findViewById(R.id.lhuilu);
        ltype= (TextView) findViewById(R.id.ltype);
        llight= (TextView) findViewById(R.id.llight);
        lv= (TextView) findViewById(R.id.lv);
        la= (TextView) findViewById(R.id.la);
        lw= (TextView) findViewById(R.id.lw);
        lwyin= (TextView) findViewById(R.id.lwyin);
        lcharge= (TextView) findViewById(R.id.lcharge);
        ltemp= (TextView) findViewById(R.id.ltemp);

        large_lina= (RelativeLayout) findViewById(R.id.large_lina);
        large_lina.setOnClickListener(this);
        small_lina= (LinearLayout) findViewById(R.id.small_lina);
        small_lina.setOnClickListener(this);
    }

    public void getDtiail() {
        String strlid=getIntent().getStringExtra("lid");
        Log.i(TAG,strlid);

        LampRequestBean lBean=new LampRequestBean();
        lBean.setLamp_cntr_id(strlid);

        Gson gson=new Gson();
        String jsonstr=gson.toJson(lBean);
        RequestBody body=RequestBody.create(JSON,jsonstr);

        ProcessUtil.showProcess(this,"正在加载，请稍后...");
        OkHttpUtils
                .put()
                .url(SystemSettings.LAMP_URL+"findlist")
                .requestBody(body)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e) {
                        ProcessUtil.dismiss();
                        ToastUtil.showToast(LampDetailActivity.this,"服务器繁忙，请稍后重试！");
                    }

                    @Override
                    public void onResponse(String response) {
                        ProcessUtil.dismiss();

                        Log.i(TAG,"详情="+response);
                        Gson gson=new Gson();
                        LampListBean lbean=gson.fromJson(response,LampListBean.class);

                        if(lbean.getList().size()!=0){
                            setDetail(lbean);
                        }else{
                            ToastUtil.showToast(LampDetailActivity.this,"信息获取失败！");
                        }

                    }
                });

    }

    private void setDetail(LampListBean abean) {
        LampListBean.ListBean lbean=abean.getList().get(0);

        jname.setText(lbean.getCntr_cntr_name());
        jaddress.setText(lbean.getCntr_cntr_adrs());
        jphone.setText(lbean.getCntr_cntr_mbph());
        jweidu.setText(lbean.getCntr_cntr_lttd()+"");
        jjingdu.setText(lbean.getCntr_cntr_lngt()+"");
        jstatus.setText(lbean.getCntr_cntr_ccst());

        lname.setText(lbean.getLamp_cntr_name());
        lmac.setText(lbean.getLamp_cntr_mcad());
        lid.setText(lbean.getLamp_cntr_id()+"");
        lweidu.setText(lbean.getLamp_cntr_lttd()+"");
        ljigndu.setText(lbean.getLamp_cntr_lngt()+"");
        lstatus.setText(lbean.getLamp_cntr_lccn());
        lhuilu.setText(lbean.getLamp_subordinate_circuit());
        ltype.setText(lbean.getType_name());
        llight.setText(lbean.getLamp_cntr_lmnn());
        lv.setText(lbean.getLamp_cntr_vltg());
        la.setText(lbean.getLamp_cntr_crnt());
        lw.setText(lbean.getLamp_cntr_pwr());
        lwyin.setText(lbean.getLamp_cntr_pwfc());
        lcharge.setText(lbean.getLamp_cntr_elqn());
        ltemp.setText(lbean.getLamp_cntr_tmpr());

    }

    /**
     * 点击事件
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.large_lina:
                finish();
                break;
            case R.id.small_lina:

                break;
        }
    }
}
