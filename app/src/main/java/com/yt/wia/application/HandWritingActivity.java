package com.yt.wia.application;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.yt.wia.commons.DialogListener;
import com.yt.wia.extend.WritePadDialog;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by wxixis on 16/7/11.
 */
@ContentView(value = R.layout.handwriting)
public class HandWritingActivity extends Activity implements View.OnClickListener {
    private Bitmap bitmap;
    private String signPath;
    @ViewInject(R.id.handwriting_iv_sign)
    private ImageView ivSign;
    @ViewInject(R.id.hanwriting_tv_sign)
    private TextView tvSign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);//隐藏标题
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//设置全屏
        x.view().inject(this);
        ivSign.setOnClickListener(this);
        tvSign.setOnClickListener(this);
    }

    /**
     * 点击事件监听
     * @param v
     */
    @Override
    public void onClick(View v) {
        WritePadDialog writePadDialog=new WritePadDialog(HandWritingActivity.this, new DialogListener() {
            @Override
            public void refreshActivity(Object object) {
                bitmap= (Bitmap) object;
//                signPath=createFile();
                createFile();
                ivSign.setImageBitmap(bitmap);
                tvSign.setVisibility(View.GONE);
            }
        });
        writePadDialog.show();
    }

    /**
     * 创建手写签名文件
     * @return
     */
    private void createFile() {
        String path=null;
        ByteArrayOutputStream baos=null;
        try {
            baos=new ByteArrayOutputStream();
            path=Environment.getExternalStorageDirectory()+ File.separator
                    +System.currentTimeMillis()+".jpg";
//            bitmap.compress(Bitmap.CompressFormat.JPEG,100,baos);//图片压缩
            byte [] bytes=baos.toByteArray();
            if (bytes!=null){
                new FileOutputStream(new File(path)).write(bytes);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
                try {
                    if (baos!=null)
                        baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

}
