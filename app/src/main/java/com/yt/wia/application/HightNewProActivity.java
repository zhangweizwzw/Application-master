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
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.gson.Gson;
import com.yt.wia.adapter.ChartDataAdapter;
import com.yt.wia.commons.ThreadToast;
import com.yt.wia.config.SystemSettings;
import com.yt.wia.model.AreaValueBean;
import com.yt.wia.model.FixedFundBean;
import com.yt.wia.utils.ProcessUtil;
import com.yt.wia.view.BarChartItem;
import com.yt.wia.view.ChartItem;
import com.yt.wia.view.PieChartItem;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;

import okhttp3.Call;


/**
 * 税收收入占比
 */
public class HightNewProActivity extends AppCompatActivity implements View.OnClickListener {
    private String TAG="HightNewProActivity";
    private ListView linlv;
    ArrayList<ChartItem> list = new ArrayList<ChartItem>();
    private Spinner sp;
    private ImageView query,close;
    private String ssp;
    private TextView text_center;
    private RelativeLayout largerela,smallrela;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hight_new_pro);

        initView();
        initData("2015");
    }

    private void initView() {
        text_center= (TextView) findViewById(R.id.text_center);
        text_center.setText("高新技术占比报表");

        linlv= (ListView) findViewById(R.id.linlv);
        sp= (Spinner) findViewById(R.id.hightnew_sp);
        query= (ImageView) findViewById(R.id.hightnew_iv);
        close= (ImageView) findViewById(R.id.close);
        close.setOnClickListener(this);

        largerela= (RelativeLayout) findViewById(R.id.largerela);
        largerela.setOnClickListener(this);
        smallrela= (RelativeLayout) findViewById(R.id.smallrela);
        smallrela.setOnClickListener(this);

        queryChart();
    }

    private void queryChart() {
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ssp= (String) sp.getSelectedItem();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        query.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initData(ssp);
            }
        });
    }

    private void initData(String time) {
        ProcessUtil.showProcess(this,"正在加载，请稍后...");
        OkHttpUtils
                .post()
                .url(SystemSettings.NEWREQUEST_URL+"report/getdqsczzzbReportData")
                .addParams("search_time",time)
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
                        Log.i(TAG,"高新技术制造产值占比="+response);
                        Gson gson=new Gson();
                        AreaValueBean abean=gson.fromJson(response, AreaValueBean.class);
                        if(abean.isResult()){
                            ArrayList<String> zhushi = new ArrayList<String>();//注释

                            ArrayList<Entry> e1 = new ArrayList<Entry>();//高新技术占比

                            ArrayList<AreaValueBean.Result1Bean> list1 = new ArrayList<AreaValueBean.Result1Bean>();//规模以上高技术制造业产值
                            ArrayList<AreaValueBean.Result2Bean> list2 = new ArrayList<AreaValueBean.Result2Bean>();//所在地级市高新技术制造产值
                                list1.addAll(abean.getResult1());
                                list2.addAll(abean.getResult2());

                                zhushi.add("规模以上高技术制造业产值");
                                zhushi.add("所在地级市高新技术制造产值");
                                if (list1.size()!=0l&&list2.size()!=0){
//                            for (int i=0;i<list1.size();i++){
                                e1.add(new Entry(Float.parseFloat(list1.get(0).getBQSJZ()), 0));
                                e1.add(new Entry(Float.parseFloat(list2.get(0).getBQSJZ())-Float.parseFloat(list1.get(0).getBQSJZ()), 0));
//                            }

                                PieDataSet d = new PieDataSet(e1, "");

                                // space between slices
                                d.setSliceSpace(5f);
                                d.setColors(ColorTemplate.DQSCZZ_COLORS);

                                PieData cd = new PieData(zhushi, d);

                                ArrayList<ChartItem> list = new ArrayList<ChartItem>();
                                list.add(new PieChartItem(cd,HightNewProActivity.this));
                                ChartDataAdapter cda = new ChartDataAdapter(HightNewProActivity.this, list);
                                linlv.setAdapter(cda);
                            }else{
                                Toast.makeText(HightNewProActivity.this,"暂无该年份报表",Toast.LENGTH_SHORT).show();
                            }

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
