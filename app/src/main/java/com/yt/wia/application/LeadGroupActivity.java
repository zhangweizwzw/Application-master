package com.yt.wia.application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class LeadGroupActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView text_center;
    private ImageView image_left;
    private Button hightnew,unitarea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lead_group);

        initView();
    }

    private void initView() {
        //初始胡标题
        text_center= (TextView) findViewById(R.id.text_center);
        text_center.setText("领导小组");
        image_left= (ImageView) findViewById(R.id.image_left);
        image_left.setImageResource(R.mipmap.title_back);
        image_left.setOnClickListener(this);

        hightnew= (Button) findViewById(R.id.hightnew);
        hightnew.setOnClickListener(this);
        unitarea= (Button) findViewById(R.id.unitarea);
        unitarea.setOnClickListener(this);
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.image_left:
                finish();
                break;
            case R.id.hightnew:
                startActivity(new Intent(this,HightNewActivity.class));
                break;
            case R.id.unitarea:
                startActivity(new Intent(this,UnitAreaActivity.class));
                break;
        }
    }
}
