package com.yt.wia.application;

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
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.gson.Gson;
import com.yt.wia.adapter.ChartDataAdapter;
import com.yt.wia.commons.ThreadToast;
import com.yt.wia.config.SystemSettings;
import com.yt.wia.model.FixedFundBean;
import com.yt.wia.utils.ProcessUtil;
import com.yt.wia.view.BarChartItem;
import com.yt.wia.view.ChartItem;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;

import okhttp3.Call;

/**
 * 固定资产投资
 */
public class FixedFundActivity extends AppCompatActivity implements View.OnClickListener {
    private String TAG="FixedFundActivity";
    private ListView linlv;
    ArrayList<ChartItem> list;
    private ImageView query,close;
    private Spinner begin,end;
    private String sbegin,send;
    private TextView text_center;
    private RelativeLayout largerela,smallrela;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fixed_fund);


        initView();
        initData("2011","2016");
    }

    private void initView() {
        text_center= (TextView) findViewById(R.id.text_center);
        text_center.setText("固定资产投资报表");

        linlv= (ListView) findViewById(R.id.linlv);
        begin= (Spinner) findViewById(R.id.fixed_sp1);
        end= (Spinner) findViewById(R.id.fixed_sp2);
        query= (ImageView) findViewById(R.id.fixed_query);
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
                    Toast.makeText(FixedFundActivity.this,"开始年份需小于结束年份",Toast.LENGTH_SHORT).show();
                }



            }
        });
    }

    private void initData(String bengintime,String endtime) {
        list = new ArrayList<ChartItem>();
        ProcessUtil.showProcess(this,"正在加载，请稍后...");
        OkHttpUtils
                .post()
                .url(SystemSettings.NEWREQUEST_URL+"report/getgdzctzzbReportData")
                .addParams("begin_time",bengintime)
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
                        Log.i(TAG,"固定资产投资="+response);
                        Gson gson=new Gson();
                        FixedFundBean fBean=gson.fromJson(response, FixedFundBean.class);
                        if(fBean.isResult()){
                            ArrayList<String> nianfen = new ArrayList<String>();//年份

                            ArrayList<BarEntry> e1 = new ArrayList<BarEntry>();//固定资产投资

                            ArrayList<FixedFundBean.Result1Bean> list1 = new ArrayList<FixedFundBean.Result1Bean>();
                            ArrayList<FixedFundBean.Result2Bean> list2 = new ArrayList<FixedFundBean.Result2Bean>();

                            list1.addAll(fBean.getResult1());
                            list2.addAll(fBean.getResult2());

                            String str1="";//标题1
                            String str2="";//标题2

                            if(list1.size()!=0){
                                str1=list1.get(0).getQUOTA();
                                str2=list2.get(0).getQUOTA();
                            }

                            for (int i=0;i<list1.size();i++){
                                nianfen.add(list1.get(i).getLRYF()+"年");
                                e1.add(new BarEntry(new float[] {(float)list1.get(i).getBNSJZ(), (float)list2.get(i).getBNSJZ()}, i));
                            }
                            BarDataSet set1 = new BarDataSet(e1, "");
                            set1.setColors(ColorTemplate.DQSCZZ_COLORS);
                            set1.setStackLabels(new String[] {str1, str2});

                            ArrayList<IBarDataSet> dataSets = new ArrayList<IBarDataSet>();
                            dataSets.add(set1);

                            BarData data = new BarData(nianfen, dataSets);

                            data.setGroupSpace(110f);

                            list.add(new BarChartItem(data,FixedFundActivity.this));
                            ChartDataAdapter cda = new ChartDataAdapter(FixedFundActivity.this, list);
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
