package com.yt.wia.application;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.yt.wia.commons.BaseActivity;
import com.yt.wia.commons.ThreadToast;
import com.yt.wia.config.Strings;
import com.yt.wia.config.SystemSettings;
import com.yt.wia.config.UpdateBean;
import com.yt.wia.model.ApplyListBean;
import com.yt.wia.utils.ProcessUtil;
import com.yt.zxing.activity.CaptureActivity;

import org.w3c.dom.Text;
import org.xutils.view.annotation.ContentView;
import org.xutils.x;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


/**
 * Created by YU on 2016/5/23.
 */
@ContentView(value = R.layout.main)
public class MainActivity extends BaseActivity implements View.OnClickListener {
    private Button btn01,btn02,btn03,mshape,
            business,leadgroup,twod,treed,lamp_btn,apply_btn;
    private Context mContext;
    private TextView text_center;
    // 定义一个变量，来标识是否退出
    private static boolean isExit = false;
    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    isExit = false;
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//设置全屏
        //移除标题栏
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //移除通知栏
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        x.view().inject(this);
        mContext=this;
//        btn01= (Button) findViewById(R.id.btn01);
//        btn02= (Button) findViewById(R.id.btn02);
//        btn03= (Button) findViewById(R.id.btn03);
//        btn01.setOnClickListener(this);
//        btn02.setOnClickListener(this);
//        btn03.setOnClickListener(this);
        init();

    }

    private void init() {
        text_center= (TextView) findViewById(R.id.text_center);
        text_center.setText("智慧园区移动工作平台");

        business= (Button) findViewById(R.id.btn_business);
        leadgroup= (Button) findViewById(R.id.btn_leadgroup);
        twod= (Button) findViewById(R.id.btn_twod);
        treed= (Button) findViewById(R.id.btn_treed);
        lamp_btn= (Button) findViewById(R.id.lamp_btn);
        apply_btn= (Button) findViewById(R.id.apply_btn);

        business.setOnClickListener(this);
        leadgroup.setOnClickListener(this);
        twod.setOnClickListener(this);
        treed.setOnClickListener(this);
        lamp_btn.setOnClickListener(this);
        apply_btn.setOnClickListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case 0:
                ThreadToast.backThreadLongToast(this,"设置");
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode==1){
           String captureResu=data.getStringExtra("result");
            ThreadToast.backThreadLongToast(this,captureResu);
            goCheck(captureResu);
        }
    }

    /**
     * 联网检验扫描的结果
     */
    public void goCheck(String strcapture) {
        ProcessUtil.showProcess(this,"正在验证结果，请稍后...");
        OkHttpClient client = new OkHttpClient();
        RequestBody body = new FormBody.Builder().build();
        String requesturl= SystemSettings.CAPTURE_URL;
        Request request = new Request.Builder().url(requesturl+"strcapture").post(body).build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                ProcessUtil.dismiss();
                ThreadToast.backThreadLongToast(getApplicationContext(), Strings.soft_newest);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                ProcessUtil.dismiss();
                String r = response.body().string();
                ThreadToast.backThreadLongToast(getApplicationContext(), r);
            }
        });
    }

    /**
     * 点击事件
     * @param v
     */
    @Override
    public void onClick(View v) {
        int id=v.getId();
        switch (id){
            //商务部
            case R.id.btn_business:
                startActivity(new Intent(MainActivity.this,BusinessActivity.class));
                break;
            //领导小组
            case R.id.btn_leadgroup:
                startActivity(new Intent(MainActivity.this,LeadGroupActivity.class));
                break;
            //2D地图
            case R.id.btn_twod:
                startActivity(new Intent(MainActivity.this,TwoDActivity.class));
                break;
            //3D地图
            case R.id.btn_treed:
                startActivity(new Intent(MainActivity.this,TreeDActivity.class));
                break;
            //路灯
            case R.id.lamp_btn:
                startActivity(new Intent(MainActivity.this,LampActivity.class));
                break;
            //路灯
            case R.id.apply_btn:
                startActivity(new Intent(MainActivity.this, ApplyListActivity.class));
                break;
//            case R.id.btn_chart:
//                startActivity(new Intent(MainActivity.this,ChartActivity.class));
//                break;

//            case R.id.btn01:
//                //手写签名
//                startActivity(new Intent(MainActivity.this,SignatureActivity.class));
//                break;
//            case R.id.btn02:
//                //二维码扫描
//                Intent intent=new Intent();
//                intent.setClass(this,CaptureActivity.class);
//                startActivityForResult(intent,1);
//                break;
//            case R.id.btn03:
//                //热修复测试
//                ThreadToast.backThreadLongToast(mContext,"已修复");
//                break;

        }
    }

    //双击退出
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void exit() {
        if (!isExit) {
            isExit = true;
            Toast.makeText(getApplicationContext(), "再按一次退出程序",
                    Toast.LENGTH_SHORT).show();
            // 利用handler延迟发送更改状态信息
            mHandler.sendEmptyMessageDelayed(0, 2000);
        } else {
            finish();
            System.exit(0);
        }
    }
}
