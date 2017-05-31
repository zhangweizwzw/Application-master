package com.yt.wia.commons;

import android.support.v7.app.AppCompatActivity;
import android.view.Menu;

import com.yt.wia.application.R;

/**
 * 项目activity基类
 * 实现内容:
 *      1.title
 *      2.title菜单
 *      3.自定义长按显示功能菜单
 *
 */
public class BaseActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
}
