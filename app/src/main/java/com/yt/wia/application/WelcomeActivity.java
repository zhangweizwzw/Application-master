package com.yt.wia.application;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

import com.yt.wia.commons.ThreadToast;
import com.yt.wia.config.Strings;
import com.yt.wia.config.SystemSettings;
import com.yt.wia.view.MaterialDialog;

import org.xutils.http.annotation.HttpResponse;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 *
 * Created by YU on 2016/5/23.
 */
@ContentView(value = R.layout.welcome)
public class WelcomeActivity extends Activity {

    @ViewInject(value = R.id.welcome)
    private ImageView welcomeImg;
    private MaterialDialog mMaterialDialog;
    private static final int ConnectionFail=0;
    private OkHttpClient mOkHttpClient;

    private Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case ConnectionFail:
                    ConnFail();
                    break;
                default:
                    break;
            }
        };
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SystemSettings.mOkHttpClient = new OkHttpClient();
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);//隐藏标题
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//设置全屏
        x.view().inject(this);

        mMaterialDialog = new MaterialDialog(this);

        AlphaAnimation anima = new AlphaAnimation(0.3f, 1.0f);
        anima.setDuration(1000);// 设置动画显示时间
        welcomeImg.startAnimation(anima);
        anima.setAnimationListener(new AnimationImpl());

        //下载补丁文件
//        GoDownloadapatch();
    }

    private void GoDownloadapatch() {
        Request request = new Request.Builder().url("http://h-bolin.imwork.net:14572/androiddownloadfile/111.pdf").build();
        mOkHttpClient.newCall(request).enqueue(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                InputStream is = null;
                byte[] buf = new byte[2048];
                int len = 0;
                FileOutputStream fos = null;
                String SDPath = Environment.getExternalStorageDirectory().getAbsolutePath();
                try {
                    is = response.body().byteStream();
                    long total = response.body().contentLength();
                    File file = new File(SDPath, "test.log");
                    fos = new FileOutputStream(file);
                    long sum = 0;
                    while ((len = is.read(buf)) != -1) {
                        fos.write(buf, 0, len);
                        sum += len;
                        int progress = (int) (sum * 1.0f / total * 100);
                        Log.d("h_bl", "progress=" + progress);
                        Message msg = mHandler.obtainMessage();
                        msg.what = 1;
                        msg.arg1 = progress;
                        mHandler.sendMessage(msg);
                    }
                    fos.flush();
                    Log.d("h_bl", "文件下载成功");
                } catch (Exception e) {
                    Log.d("h_bl", "文件下载失败");
                } finally {
                    try {
                        if (is != null)
                            is.close();
                    } catch (IOException e) {
                    }
                    try {
                        if (fos != null)
                            fos.close();
                    } catch (IOException e) {
                    }
                }
            }

        });
    }

    private class AnimationImpl implements AnimationListener {

        @Override
        public void onAnimationStart(Animation animation) {
            welcomeImg.setBackgroundResource(R.drawable.welcomebg);
        }

        @Override
        public void onAnimationEnd(Animation animation) {
            CheckConnection(); // 动画结束后检查网络设置
        }

        @Override
        public void onAnimationRepeat(Animation animation) {}

    }


    /**
     * 验证是否可以与服务器建立连接
     */
    public void CheckConnection(){
        Request request = new Request.Builder().url(SystemSettings.NEWREQUEST_URL).build();
        Call call = SystemSettings.mOkHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                mHandler.sendEmptyMessage(ConnectionFail);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String strResponse = response.body().string();
                if(response.code()==200){
                    ThreadToast.backThreadLongToast(getApplicationContext(), Strings.connect_success);
                    startActivity(new Intent(WelcomeActivity.this, IndexActivity.class));//如果是最新版本跳转到登录界面
                    finish();
                }else{
                    mHandler.sendEmptyMessage(ConnectionFail);
                }

            }
        });
    }

    public void ConnFail(){
        mMaterialDialog.setTitle(R.string.hint)
                .setMessage(Strings.connect_fail)
                .setCanceledOnTouchOutside(false)
                .setPositiveButton(R.string.sure, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.exit(0);
                    }
                })
                .setCanceledOnTouchOutside(false)
                .show();
    }


}
