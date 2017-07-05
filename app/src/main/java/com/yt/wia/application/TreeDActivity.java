package com.yt.wia.application;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.yt.wia.utils.SdcardUtil;

import org.xwalk.core.XWalkPreferences;
import org.xwalk.core.XWalkView;

public class  TreeDActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView text_center;
    private ImageView image_left;
    private XWalkView xwalk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tree_d);

        initView();
        initData();
    }

    private void initData() {
        //添加对javascript支持
        XWalkPreferences.setValue("enable-javascript", true);
        //开启调式,支持谷歌浏览器调式
        XWalkPreferences.setValue(XWalkPreferences.REMOTE_DEBUGGING, true);
        //置是否允许通过file url加载的Javascript可以访问其他的源,包括其他的文件和http,https等其他的源
        XWalkPreferences.setValue(XWalkPreferences.ALLOW_UNIVERSAL_ACCESS_FROM_FILE, true);
        //JAVASCRIPT_CAN_OPEN_WINDOW
        XWalkPreferences.setValue(XWalkPreferences.JAVASCRIPT_CAN_OPEN_WINDOW, true);
        // enable multiple windows.
        XWalkPreferences.setValue(XWalkPreferences.SUPPORT_MULTIPLE_WINDOWS, true);

        String shpPath = SdcardUtil.getSDPath() + "/load_remote.html";
        xwalk.load(shpPath,null);
    }

    private void initView() {
        /**
         * 初始胡标题
         */
        text_center= (TextView) findViewById(R.id.text_center);
        text_center.setText("三维地图");
        image_left= (ImageView) findViewById(R.id.image_left);
        image_left.setImageResource(R.mipmap.title_back);
        image_left.setOnClickListener(this);

        xwalk= (XWalkView)findViewById(R.id.xwalk);
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
        }
    }
}
