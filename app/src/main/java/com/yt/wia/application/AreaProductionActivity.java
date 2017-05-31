package com.yt.wia.application;

import android.graphics.Color;
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

import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.google.gson.Gson;
import com.yt.wia.adapter.ChartDataAdapter;
import com.yt.wia.commons.ThreadToast;
import com.yt.wia.config.SystemSettings;
import com.yt.wia.model.AreaProductionBean;
import com.yt.wia.model.HightNewBean;
import com.yt.wia.utils.ProcessUtil;
import com.yt.wia.view.ChartItem;
import com.yt.wia.view.LineChartItem;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

/**
 * 地区生产总值
 */

public class AreaProductionActivity extends AppCompatActivity implements View.OnClickListener {
    private final String TAG="ChartActivity";
    private ListView linlv;
    private ArrayList<ChartItem> list = new ArrayList<ChartItem>();
    private Spinner begin,end;
    private ImageView query,close;
    private String sbegin,send;
    private TextView text_center;
    private RelativeLayout largerela,smallrela;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_production);

        initView();
        initData("2011","2016");
    }

    private void initView() {
        text_center= (TextView) findViewById(R.id.text_center);
        text_center.setText("地区生产总值报表");

        linlv = (ListView) findViewById(R.id.linlv);
        begin= (Spinner) findViewById(R.id.area_sp1);
        end= (Spinner) findViewById(R.id.area_sp2);
        query= (ImageView) findViewById(R.id.area_query);
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
                    Toast.makeText(AreaProductionActivity.this,"开始年份需小于结束年份",Toast.LENGTH_SHORT).show();
                }



            }
        });
    }


    public void initData(String begintime,String endtime) {
        ProcessUtil.showProcess(this,"正在加载，请稍后...");
        OkHttpUtils
                .post()
                .url(SystemSettings.NEWREQUEST_URL+"report/getdqsczzReportData")
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
                        ArrayList<Entry> e1 = new ArrayList<Entry>();//第三产业
                        ArrayList<Entry> e2 = new ArrayList<Entry>();//工业
                        ArrayList<Entry> e3 = new ArrayList<Entry>();//地区生产总值

                        ArrayList<String> array=new ArrayList<String>();//年
                        String str1="";//第三产业
                        String str2="";//工业
                        String str3="";//地区生产总值

                        Log.i(TAG,"地区生产总值返回="+response);
                        ProcessUtil.dismiss();
                        Gson gson=new Gson();
                        AreaProductionBean abean=gson.fromJson(response,AreaProductionBean.class);
                        if(abean.isResult()){
                            Log.i(TAG,"图表数据获取成功");
                            //第三产业
                            List<AreaProductionBean.Result1Bean> list1=new ArrayList<AreaProductionBean.Result1Bean>();
                            list1.addAll(abean.getResult1());
                            for (int i=0;i<list1.size();i++){
                                e1.add(new Entry((float)list1.get(i).getBNSJZ(),i));
                                array.add(list1.get(i).getLRYF()+"年");
                                str1=list1.get(i).getQUOTA();
                            }
                            LineDataSet d1 = new LineDataSet(e1, "第三产业");
                            d1.setLineWidth(2.5f);
                            d1.setCircleRadius(4.5f);
                            d1.setHighLightColor(Color.rgb(213, 113, 111));
                            d1.setFillColor(Color.rgb(213, 113, 111));
                            d1.setColor(Color.rgb(213, 113, 111));
                            d1.setCircleColor(Color.rgb(213, 113, 111));
                            d1.setDrawValues(false);
                            d1.setDrawFilled(true);


                            //工业
                            List<AreaProductionBean.Result2Bean> list2=new ArrayList<AreaProductionBean.Result2Bean>();
                            list2.addAll(abean.getResult2());
                            for (int i=0;i<list2.size();i++){
                                e2.add(new Entry((float)list2.get(i).getBNSJZ(),i));
                                str2=list2.get(i).getQUOTA();
                            }
                            LineDataSet d2 = new LineDataSet(e2,"工业");
                            d2.setLineWidth(2.5f);
                            d2.setCircleRadius(4.5f);
                            d2.setHighLightColor(Color.rgb(111, 125, 136));
                            d2.setFillColor(Color.rgb(111, 125, 136));
                            d2.setColor(Color.rgb(111, 125, 136));
                            d2.setCircleColor(Color.rgb(111, 125, 136));
                            d2.setDrawValues(false);
                            d2.setDrawFilled(true);

                            //地区生产总值
                            List<AreaProductionBean.Result3Bean> list3=new ArrayList<AreaProductionBean.Result3Bean>();
                            list3.addAll(abean.getResult3());
                            for (int i=0;i<list3.size();i++){
                                e3.add(new Entry((float)list3.get(i).getBNSJZ(),i));
                                str3=list3.get(i).getQUOTA();
                            }
                            LineDataSet d3 = new LineDataSet(e3, "地区生产总值");
                            d3.setLineWidth(2.5f);
                            d3.setCircleRadius(4.5f);
                            d3.setHighLightColor(Color.rgb(144, 188, 194));
                            d3.setFillColor(Color.rgb(144, 188, 194));
                            d3.setColor(Color.rgb(144, 188, 194));
                            d3.setCircleColor(Color.rgb(144, 188, 194));
                            d3.setDrawValues(false);
                            d3.setDrawFilled(true);

                            ArrayList<ILineDataSet> sets = new ArrayList<ILineDataSet>();
                            sets.add(d1);
                            sets.add(d2);
                            sets.add(d3);
                            LineData cd = new LineData(array, sets);

                            list.add(new LineChartItem(cd,AreaProductionActivity.this));
                            ChartDataAdapter cda = new ChartDataAdapter(AreaProductionActivity.this, list);
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
