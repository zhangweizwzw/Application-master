package com.yt.wia.application;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.yt.wia.adapter.ApplyListAdapter;
import com.yt.wia.commons.ThreadToast;
import com.yt.wia.config.Strings;
import com.yt.wia.config.SystemSettings;
import com.yt.wia.model.ApplyListBean;
import com.yt.wia.model.ApplyRequestBean;
import com.yt.wia.utils.ProcessUtil;
import com.yt.wia.utils.ToastUtil;
import com.yt.wia.view.XListView;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.jar.Pack200;

import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class ApplyListActivity extends AppCompatActivity implements View.OnClickListener, XListView.IXListViewListener {
    private static final String TAG="ApplyListActivity";
    private TextView text_center,text_right;
    private ImageView image_left;
    public static final MediaType JSON=MediaType.parse("application/json; charset=utf-8");
    private EditText project_et;
    private Button select_btn;
    private int size=10;
    private XListView apply_lv;
    private ApplyListAdapter aAadpter;
    private List<ApplyListBean.ListBean> alist=new ArrayList<ApplyListBean.ListBean>();
    private int totalPage=0;//总页数
    private int page=1;//当前页数
    private String  projectname="";

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what==0){
                alist.clear();
                page=1;
                initDate(0,projectname,1);
                onLoad();
            }else if(msg.what==1){
                page++;
                if(page<=totalPage){
                    initDate(0,projectname,page);
                    onLoad();
                }else{
                    ToastUtil.showToast(ApplyListActivity.this,"没有更多内容！");
                    apply_lv.stopLoadMore();
                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply_notes);

        initView();
        initDate(1,"",1);
    }

    private void initView() {
        text_center= (TextView) findViewById(R.id.text_center);
        text_center.setText("申请记录");
        text_right= (TextView) findViewById(R.id.text_right);
        text_right.setText("申请");
        text_right.setOnClickListener(this);
        image_left= (ImageView) findViewById(R.id.image_left);
        image_left.setImageResource(R.mipmap.title_back);
        image_left.setOnClickListener(this);

        project_et= (EditText) findViewById(R.id.project_et);
        select_btn= (Button) findViewById(R.id.select_btn);
        select_btn.setOnClickListener(this);

        apply_lv= (XListView) findViewById(R.id.apply_lv);
        aAadpter=new ApplyListAdapter(this,alist);
        apply_lv.setAdapter(aAadpter);
        apply_lv.setPullLoadEnable(true);
        apply_lv.setXListViewListener(this);
    }

    private void initDate(int isloading,String projectname,int pageNo) {
        Log.i(TAG,"PAGENO="+ pageNo);
        final ApplyRequestBean abean=new ApplyRequestBean();
        abean.setSize(size);
        abean.setOrgName(projectname);
        abean.setProjectName(projectname);
        abean.setPageNo(pageNo);
        abean.setReviewLink("0");

        Gson gson=new Gson();
        String jsonstr=gson.toJson(abean);
        RequestBody body=RequestBody.create(JSON,jsonstr);

        if(isloading==1){
            ProcessUtil.showProcess(this,"正在加载，请稍后...");
        }
        OkHttpUtils
                .put()
//                .url(SystemSettings.NEWREQUEST_URL)
                .url("http://192.168.1.112:8080/manager/zs/findAll")
                .requestBody(body)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e) {
                        ProcessUtil.dismiss();
                        Log.i(TAG,"申请列表错误："+e.toString());
                        ToastUtil.showToast(ApplyListActivity.this,"服务器繁忙，请稍后重试！");
                    }

                    @Override
                    public void onResponse(String response) {
                        ProcessUtil.dismiss();
                        Log.i(TAG,"申请返回列表："+response);
                        Gson gson=new Gson();
                        ApplyListBean abean=gson.fromJson(response, ApplyListBean.class);
                        totalPage=abean.getTotal();
                        alist.addAll(abean.getList());
                        aAadpter.notifyDataSetChanged();
                    }
                });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1&&resultCode==1){
        int  code=data.getIntExtra("isreflash",0);
            if(code==1){
                handler.sendEmptyMessage(0);
                project_et.setText("");
                projectname="";
            }
        }
}

    @Override
    public void onRefresh() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0);
            }
        }, 1500);
    }


    @Override
    public void onLoadMore() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                handler.sendEmptyMessage(1);
            }
        }, 1500);
    }

    private void onLoad() {
        apply_lv.stopRefresh();
        apply_lv.stopLoadMore();
        Date date=new Date();
        SimpleDateFormat format=new SimpleDateFormat("yy-MM-dd HH:mm:ss");
        apply_lv.setRefreshTime(format.format(date));
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
            case R.id.select_btn:
                projectname=project_et.getText().toString();

                initDate(0,projectname,1);
                break;
            case R.id.text_right:
                startActivityForResult(new Intent(this,ApplyActivity.class),1);
                break;
        }
    }
}
