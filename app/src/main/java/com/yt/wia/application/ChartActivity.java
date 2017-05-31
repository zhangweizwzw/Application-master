package com.yt.wia.application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.yt.wia.config.SystemSettings;

public class ChartActivity extends AppCompatActivity implements View.OnClickListener {
    private Button lin1btn,bar1btn,fixedbtn,areavaluebtn,revenueeprobtn,highnewprobtn,areaproductionbtn;
    private Button webview1,webview2,webview3,webview4,webview5,webview6,webview7,webview8,webview9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);

        initView();
    }

    private void initView() {
        lin1btn= (Button) findViewById(R.id.lin1btn);
        lin1btn.setOnClickListener(this);
        bar1btn= (Button) findViewById(R.id.bar1btn);
        bar1btn.setOnClickListener(this);
        fixedbtn= (Button) findViewById(R.id.fixedbtn);
        fixedbtn.setOnClickListener(this);
        areavaluebtn= (Button) findViewById(R.id.areavaluebtn);
        areavaluebtn.setOnClickListener(this);
        revenueeprobtn= (Button) findViewById(R.id.revenueeprobtn);
        revenueeprobtn.setOnClickListener(this);
        highnewprobtn= (Button) findViewById(R.id.highnewprobtn);
        highnewprobtn.setOnClickListener(this);
        areaproductionbtn= (Button) findViewById(R.id.areaproductionbtn);
        areaproductionbtn.setOnClickListener(this);
        webview1= (Button) findViewById(R.id.webview1);
        webview1.setOnClickListener(this);
        webview2= (Button) findViewById(R.id.webview2);
        webview2.setOnClickListener(this);
        webview3= (Button) findViewById(R.id.webview3);
        webview3.setOnClickListener(this);
        webview4= (Button) findViewById(R.id.webview4);
        webview4.setOnClickListener(this);
        webview5= (Button) findViewById(R.id.webview5);
        webview5.setOnClickListener(this);
        webview6= (Button) findViewById(R.id.webview6);
        webview6.setOnClickListener(this);
        webview7= (Button) findViewById(R.id.webview7);
        webview7.setOnClickListener(this);
        webview8= (Button) findViewById(R.id.webview8);
        webview8.setOnClickListener(this);
        webview9= (Button) findViewById(R.id.webview9);
        webview9.setOnClickListener(this);
    }


    /**
     * 点击事件
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.lin1btn://高新技术企业数量
                startActivity(new Intent(this,HightNewActivity.class));
                break;
            case R.id.bar1btn://单位面积情况税收情况
                startActivity(new Intent(this,UnitAreaActivity.class));
                break;
            case R.id.fixedbtn://固定资产投资
                startActivity(new Intent(this,FixedFundActivity.class));
                break;
            case R.id.areavaluebtn://地区生产总值占比
                startActivity(new Intent(this,AreaValueFundActivity.class));
                break;
            case R.id.revenueeprobtn://税收收入占比
                startActivity(new Intent(this,RevenueProportionActivity.class));
                break;
            case R.id.highnewprobtn://高新技术占比
                startActivity(new Intent(this,HightNewProActivity.class));
                break;
            case R.id.areaproductionbtn://地区生产总值
                startActivity(new Intent(this,AreaProductionActivity.class));
                break;
            case R.id.webview1://工业总产值
                goChartact(SystemSettings.CHARTREQUEST_URL+"getgyzcz","工业总产值报表");
                break;
            case R.id.webview2://规模上工业企业
                goChartact(SystemSettings.CHARTREQUEST_URL+"getgmysgyzcz","规模上工业企业报表");
                break;
            case R.id.webview3://高新技术企业
                goChartact(SystemSettings.CHARTREQUEST_URL+"getgxjsqyzcz","高新技术企业报表");
                break;
            case R.id.webview4://出口总额
                goChartact(SystemSettings.CHARTREQUEST_URL+"getexport","出口总额报表");
                break;
            case R.id.webview5://进口总额
                goChartact(SystemSettings.CHARTREQUEST_URL+"getimport","进口总额报表");
                break;
            case R.id.webview6://财政收入
                goChartact(SystemSettings.CHARTREQUEST_URL+"getczsr","财政收入报表");
                break;
            case R.id.webview7://公共财政预算收入
                goChartact(SystemSettings.CHARTREQUEST_URL+"getggczyssr","公共财政预算收入报表");
                break;
            case R.id.webview8://税收收入
                goChartact(SystemSettings.CHARTREQUEST_URL+"getsssr","税收收入报表");
                break;
            case R.id.webview9://行业情况
                goChartact(SystemSettings.CHARTREQUEST_URL+"gethyqk","行业情况报表");
                break;
        }
    }

    public void goChartact(String chartUrl,String titleText){
        Intent intent=new Intent();
        intent.putExtra("chartUrl",chartUrl);
        intent.putExtra("titleText",titleText);
        intent.setClass(this,ChartWebviewActivity.class);
        startActivity(intent);
    }
}
