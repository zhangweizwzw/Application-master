package com.yt.wia.application;

import android.content.Intent;
import android.net.Uri;
import android.net.http.SslError;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.yt.wia.view.WebViewMod;

public class ChartWebviewActivity extends AppCompatActivity implements View.OnClickListener {
    private WebViewMod webview;
    private WebSettings mWebSettings;
    private ImageView close;
    private TextView text_center;
    private  String chartUrl;
    private RelativeLayout largerela,smallrela;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart_webview);

        initView();
        setUpViews();
    }

    private void initView() {
        chartUrl=getIntent().getStringExtra("chartUrl");
        String titleText=getIntent().getStringExtra("titleText");

        text_center= (TextView) findViewById(R.id.text_center);
        text_center.setText(titleText);
        close= (ImageView) findViewById(R.id.close);
        close.setOnClickListener(this);
        webview= (WebViewMod) findViewById(R.id.webview);

        largerela= (RelativeLayout) findViewById(R.id.largerela);
        largerela.setOnClickListener(this);
        smallrela= (RelativeLayout) findViewById(R.id.smallrela);
        smallrela.setOnClickListener(this);

    }

    private void setUpViews() {
        webview.setWebChromeClient(new WebChromeClient());

        mWebSettings = webview.getSettings();
        mWebSettings.setJavaScriptEnabled(true); // 允许加载javascript
        mWebSettings.setSupportZoom(false); // 允许缩放
        mWebSettings.setBuiltInZoomControls(true); // 原网页基础上缩放
        mWebSettings.setUseWideViewPort(true); // 任意比例缩放
        mWebSettings.setJavaScriptCanOpenWindowsAutomatically(true);//设置js可以直接打开窗口，如window.open()，默认为false
        mWebSettings.setAppCacheEnabled(false);//是否使用缓存
        mWebSettings.setDomStorageEnabled(false);//DOM Storage
        mWebSettings.setDisplayZoomControls(false);
        /**
         * 在点击请求的是链接时才会调用，
         * 重写此方法返回true表明点击网页里
         * 面的链接还是在当前的WebView里跳转，
         * 不会跳到浏览器上运行。
         */
        webview.setWebViewClient(new WebViewClient() {
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error){
                handler.proceed();  // 接受所有网站的证书
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (url.startsWith("tel")) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(intent);

                    return true;
                } else {
                    view.loadUrl(url);
                }
                return super.shouldOverrideUrlLoading(view, url);
            }
        });
        webview.loadUrl(chartUrl);
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
