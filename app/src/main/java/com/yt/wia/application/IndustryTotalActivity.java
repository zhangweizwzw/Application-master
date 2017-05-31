package com.yt.wia.application;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.yt.wia.commons.ThreadToast;
import com.yt.wia.config.SystemSettings;
import com.yt.wia.model.IndustryTotalzBean;
import com.yt.wia.utils.ProcessUtil;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;

import okhttp3.Call;

/**
 * 工业总产值堆积柱状图
 */

public class IndustryTotalActivity extends AppCompatActivity {
    private String TAG="IndustryTotalActivity";
    String[] rightYLabels;
    String[] rightYLabels1;
    boolean change = true;
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            initView();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_industry_total);
        initView();
//        initData();
    }

    private void initView() {
    }

    private void initData() {
        ProcessUtil.showProcess(this,"正在加载，请稍后...");
        OkHttpUtils
                .post()
                .url(SystemSettings.NEWREQUEST_URL+"report/getgyzczzzReportData")
                .addParams("begin_time","2011")
                .addParams("end_time", "2016")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e) {
                        ProcessUtil.dismiss();
                        ThreadToast.backThreadLongToast(getApplicationContext(),"");
                    }

                    @Override
                    public void onResponse(String response) {
                        ProcessUtil.dismiss();
                        Log.i(TAG,"工业总产值="+response);
                        Gson gson=new Gson();
                        IndustryTotalzBean iBean=gson.fromJson(response, IndustryTotalzBean.class);
                        if(iBean.isResult()){
                            ArrayList<IndustryTotalzBean.Result1Bean> list1 = new ArrayList<IndustryTotalzBean.Result1Bean>();//工业总产值
                            ArrayList<IndustryTotalzBean.Result2Bean> list2 = new ArrayList<IndustryTotalzBean.Result2Bean>();//工业总产值（当年价格）
                            list1.addAll(iBean.getResult1());
                            list2.addAll(iBean.getResult2());


                         handler.sendEmptyMessage(0);




//                            ArrayList<String> nianfen = new ArrayList<String>();//年份
//
//                            ArrayList<BarEntry> e1 = new ArrayList<BarEntry>();//工业总产值
//
//                            ArrayList<IndustryTotalzBean.Result1Bean> list1 = new ArrayList<IndustryTotalzBean.Result1Bean>();//工业总产值
//                            ArrayList<IndustryTotalzBean.Result2Bean> list2 = new ArrayList<IndustryTotalzBean.Result2Bean>();//工业总产值（当年价格）
//                            list1.addAll(iBean.getResult1());
//                            list2.addAll(iBean.getResult2());
//
//                            for (int i=0;i<list2.size();i++){
//                                nianfen.add(list1.get(i).getLRYF()+"年");
//                                e1.add(new BarEntry(new float[] {(float)list2.get(i).getFIRSTQUART(),( (float)(list2.get(i).getSECONDQUART()-list2.get(i).getFIRSTQUART())),(float)(list2.get(i).getTHIRDQUART()-list2.get(i).getSECONDQUART()),(float)list2.get(i).getFOURTHQUART()}, i));
//                            }
//                            BarDataSet set1 = new BarDataSet(e1, "");
//                            set1.setColors(ColorTemplate.FOUR_COLORS);
//                            set1.setStackLabels(new String[] {"第一季度", "第二季度","第三季度","第四季度"});
//
//                            ArrayList<IBarDataSet> dataSets = new ArrayList<IBarDataSet>();
//                            dataSets.add(set1);
//                            BarData data = new BarData(nianfen, dataSets);
//
//                            data.setGroupSpace(110f);

//                            list.add(new BarChartItem(data,IndustryTotalActivity.this));
//                            ChartDataAdapter cda = new ChartDataAdapter(IndustryTotalActivity.this, list);
//                            linlv.setAdapter(cda);
                        }
                    }

                });
    }

}
