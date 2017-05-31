package com.yt.wia.application;

import android.graphics.Color;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.google.gson.Gson;
import com.yt.wia.adapter.ChartDataAdapter;
import com.yt.wia.commons.ThreadToast;
import com.yt.wia.config.SystemSettings;
import com.yt.wia.model.UnitAreaBean;
import com.yt.wia.utils.ProcessUtil;
import com.yt.wia.view.BarChartItem;
import com.yt.wia.view.ChartItem;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;


/**
 * 单位面积情况税收情况
 */
public class UnitAreaActivity extends AppCompatActivity implements View.OnClickListener {

    private String TAG="UnitAreaActivity";
    private ListView linlv;
    ArrayList<ChartItem> list = new ArrayList<ChartItem>();
    private ImageView query,close;
    private Spinner begin,end;
    private String sbegin,send;
    private TextView text_center;
    private RelativeLayout largerela,smallrela;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_area);

        initView();
        initData("2011","2016");
    }

    private void initView() {
        text_center= (TextView) findViewById(R.id.text_center);
        text_center.setText("单位面积情况税收情况报表");

        linlv= (ListView) findViewById(R.id.linlv);
        begin= (Spinner) findViewById(R.id.unitarea_sp1);
        end= (Spinner) findViewById(R.id.unitarea_sp2);
        query= (ImageView) findViewById(R.id.unitarea_query);
        close= (ImageView) findViewById(R.id.close);
        close.setOnClickListener(this);


        largerela= (RelativeLayout) findViewById(R.id.largerela);
        largerela.setOnClickListener(this);
        smallrela= (RelativeLayout) findViewById(R.id.smallrela);
        smallrela.setOnClickListener(this);
        queryChart();
    }

    private void queryChart() {
        /**
         * 选择开始年份
         */
        begin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                sbegin= (String) begin.getSelectedItem();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        /**
         * 选择结束年份
         */
        end.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                send= (String) end.getSelectedItem();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        /**
         * 搜索
         */
        query.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //判断开始时间和结束时间
                int a=Integer.parseInt(sbegin);
                int b=Integer.parseInt(send);
                if (a<b){
                    initData(sbegin,send);
                }else {
                    Toast.makeText(UnitAreaActivity.this,"开始年份需小于结束年份",Toast.LENGTH_SHORT).show();
                }



            }
        });
    }

    private void initData(String begintime,String endtime) {
        ProcessUtil.showProcess(this,"正在加载，请稍后...");
        OkHttpUtils
                .post()
                .url(SystemSettings.NEWREQUEST_URL+"report/gettdssReportData")
                .addParams("begin_time",begintime)
                .addParams("end_time", endtime)
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
                        Log.i(TAG,"单位面积情况税收情况返回="+response);
                        Gson gson=new Gson();
                        UnitAreaBean ubean=gson.fromJson(response, UnitAreaBean.class);
                        if(ubean.isResult()){

                            ArrayList<String> years = new ArrayList<String>();//显示年份
                            ArrayList<BarEntry> yVals1 = new ArrayList<BarEntry>();//单位面积土地投资强度
                            ArrayList<BarEntry> yVals2 = new ArrayList<BarEntry>();//单位面积工业增加值产出面积
                            ArrayList<BarEntry> yVals3 = new ArrayList<BarEntry>();//单位面积土地税收产出率
                                //单位面积土地投资强度
                            List<UnitAreaBean.Result1Bean> list1=new ArrayList<UnitAreaBean.Result1Bean>();
                            list1.addAll(ubean.getResult1());
                            for (int i=0;i<list1.size();i++){
                                years.add(list1.get(i).getLRYF()+"年");
                                yVals1.add(new BarEntry((float)list1.get(i).getQN(), i));
                            }
                                //单位面积工业增加值产出面积
                            List<UnitAreaBean.Result2Bean> list2=new ArrayList<UnitAreaBean.Result2Bean>();
                            list2.addAll(ubean.getResult2());
                            for (int i=0;i<list2.size();i++){
                                yVals2.add(new BarEntry((float)list2.get(i).getQN(), i));
                            }
                                //单位面积土地税收产出率
                            List<UnitAreaBean.Result3Bean> list3=new ArrayList<UnitAreaBean.Result3Bean>();
                            List<UnitAreaBean.Result4Bean> list4=new ArrayList<UnitAreaBean.Result4Bean>();
                            list3.addAll(ubean.getResult3());
                            list4.addAll(ubean.getResult4());
                            for (int i=0;i<list3.size();i++){
                                yVals3.add(new BarEntry((float)(list3.get(i).getFOURTHQUART()/list4.get(i).getQN()), i));
                            }

                            BarDataSet set1 = new BarDataSet(yVals1, "单位面积土地投资强度");
                            set1.setColor(Color.rgb(195, 53, 49));
                            BarDataSet set2 = new BarDataSet(yVals2, "单位面积工业增加值产出面积");
                            set2.setColor(Color.rgb(47, 69, 83));
                            BarDataSet set3 = new BarDataSet(yVals3, "单位面积土地税收产出率(万元/亩)");
                            set3.setColor(Color.rgb(99, 159, 169));


                            ArrayList<IBarDataSet> dataSets = new ArrayList<IBarDataSet>();
                            dataSets.add(set1);
                            dataSets.add(set2);
                            dataSets.add(set3);

                            BarData data = new BarData(years,dataSets);

                            data.setGroupSpace(110f);

                            list.add(new BarChartItem(data,UnitAreaActivity.this));
                            ChartDataAdapter cda = new ChartDataAdapter(UnitAreaActivity.this, list);
                            linlv.setAdapter(cda);
                        }
                    }
                });
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.close:
                finish();
                break;
            case R.id.largerela:
                finish();
                break;

        }
    }
}
