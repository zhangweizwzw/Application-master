package com.yt.wia.application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.yt.wia.config.SystemSettings;

import org.w3c.dom.Text;

/**
 * 商务部
 */
public class BusinessActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView text_center;
    private ImageView image_left;
    private Button fixedbtn,areavaluebtn,revenueeprobtn,highnewprobtn,areaproductionbtn,gyzczbtn,gmysgyzczbtn,gxjsqyzczbtn;
    private Button exportbtn,importbtn,czsrbtn,ggczyssrbtn,sssrbtn,hyqkbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business);
        initView();


    }

    private void initView() {
        //初始胡标题
        text_center= (TextView) findViewById(R.id.text_center);
        text_center.setText("商务部");
        image_left= (ImageView) findViewById(R.id.image_left);
        image_left.setImageResource(R.mipmap.title_back);
        image_left.setOnClickListener(this);

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
        gyzczbtn= (Button) findViewById(R.id.gyzczbtn);
        gyzczbtn.setOnClickListener(this);
        gmysgyzczbtn= (Button) findViewById(R.id.gmysgyzczbtn);
        gmysgyzczbtn.setOnClickListener(this);
        gxjsqyzczbtn= (Button) findViewById(R.id.gxjsqyzczbtn);
        gxjsqyzczbtn.setOnClickListener(this);
        exportbtn= (Button) findViewById(R.id.exportbtn);
        exportbtn.setOnClickListener(this);
        importbtn= (Button) findViewById(R.id.importbtn);
        importbtn.setOnClickListener(this);
        czsrbtn= (Button) findViewById(R.id.czsrbtn);
        czsrbtn.setOnClickListener(this);
        ggczyssrbtn= (Button) findViewById(R.id.ggczyssrbtn);
        ggczyssrbtn.setOnClickListener(this);
        sssrbtn= (Button) findViewById(R.id.sssrbtn);
        sssrbtn.setOnClickListener(this);
        hyqkbtn= (Button) findViewById(R.id.hyqkbtn);
        hyqkbtn.setOnClickListener(this);
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
            case R.id.fixedbtn:
                startActivity(new Intent(this,FixedFundActivity.class));
                break;
            case R.id.areavaluebtn:
                startActivity(new Intent(this,AreaValueFundActivity.class));
                break;
            case R.id.revenueeprobtn:
                startActivity(new Intent(this,RevenueProportionActivity.class));
                break;
            case R.id.highnewprobtn:
                startActivity(new Intent(this,HightNewProActivity.class));
                break;
            case R.id.areaproductionbtn:
                startActivity(new Intent(this,AreaProductionActivity.class));
                break;
            case R.id.gyzczbtn:
                goChartact(SystemSettings.CHARTREQUEST_URL+"getgyzcz","工业总产值报表");
                break;
            case R.id.gmysgyzczbtn:
                goChartact(SystemSettings.CHARTREQUEST_URL+"getgmysgyzcz","规模上工业企业报表");
                break;
            case R.id.gxjsqyzczbtn:
                goChartact(SystemSettings.CHARTREQUEST_URL+"getgxjsqyzcz","高新技术企业报表");
                break;
            case R.id.exportbtn:
                goChartact(SystemSettings.CHARTREQUEST_URL+"getexport","出口总额报表");
                break;
            case R.id.importbtn:
                goChartact(SystemSettings.CHARTREQUEST_URL+"getimport","进口总额报表");
                break;
            case R.id.czsrbtn:
                goChartact(SystemSettings.CHARTREQUEST_URL+"getczsr","财政收入报表");
                break;
            case R.id.ggczyssrbtn:
                goChartact(SystemSettings.CHARTREQUEST_URL+"getggczyssr","公共财政预算收入报表");
                break;
            case R.id.sssrbtn:
                goChartact(SystemSettings.CHARTREQUEST_URL+"getsssr","税收收入报表");
                break;
            case R.id.hyqkbtn:
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
