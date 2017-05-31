package com.yt.wia.extend;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;

import com.yt.wia.application.R;
import com.yt.wia.commons.DialogListener;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;


/**
 * Created by wxixis on 16/7/11.
 */
public class WritePadDialog extends Dialog implements View.OnClickListener {

    private Context context;
    private WindowManager.LayoutParams p;
    private DialogListener dialogListener;
    private PaintView mView;
    private Button ok,clear,cancel;

    public WritePadDialog(Context context,DialogListener dialogListener){
        super(context);
        this.context=context;
        this.dialogListener=dialogListener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//无标题
        requestWindowFeature(Window.FEATURE_PROGRESS);//进度指示功能
        setContentView(R.layout.writedialog);
        ok= (Button) findViewById(R.id.writepaddialog_ok);
        clear= (Button) findViewById(R.id.writepaddialog_clear);
        cancel= (Button) findViewById(R.id.writepaddialog_canel);
        setLayoutParams();
        setView();

    }

    private void setView() {
        mView=new PaintView(context);
        FrameLayout frameLayout= (FrameLayout) findViewById(R.id.writepaddialog_framelayout);
        frameLayout.addView(mView);
        mView.requestFocus();
        ok.setOnClickListener(this);
        clear.setOnClickListener(this);
        cancel.setOnClickListener(this);
    }
    /**
     * 按钮点击事件(确定\取消\清除)
     * @param v
     */
    @Override
    public void onClick(View v) {
        int id=v.getId();
        switch (id){
            case R.id.writepaddialog_ok://确定
                dialogListener.refreshActivity(mView.getBitmap());
                WritePadDialog.this.dismiss();
                break;
            case R.id.writepaddialog_clear://清除
                mView.clear();
                break;
            case R.id.writepaddialog_canel://取消
                cancel();
                break;
        }
    }

    /**
     * 设置宽高
     */
    private void setLayoutParams() {
        WindowManager windowManager= (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        int width=windowManager.getDefaultDisplay().getWidth();//获取屏幕的宽度
        int height=windowManager.getDefaultDisplay().getHeight();//获取屏幕的高度
        p=getWindow().getAttributes();//获取当前对话框的参数值
        p.height= (int) (height*0.6);
        p.width= (int) (width*0.8);
        getWindow().setAttributes(p);//设置生效
    }


    /**
     * 处理输入事件和绘图功能
     */
    private class PaintView extends View {
        private Paint paint;
        private Canvas canvas;
        private Bitmap bitmap;
        private Path path;
        public Bitmap getBitmap(){
            return bitmap;
        }
        public PaintView(Context context) {
            super(context);
            init();
        }

        /**
         * 自定义画笔\画布
         */
        private void init() {
            paint=new Paint();
            paint.setAntiAlias(true);
            paint.setStrokeWidth(3);
            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(Color.BLACK);
            path=new Path();
            bitmap=Bitmap.createBitmap(p.width,(int)(p.height*0.8), Bitmap.Config.ARGB_8888);
            canvas=new Canvas(bitmap);
            canvas.drawColor(Color.WHITE);
        }

        /**
         * 清除
         */
        public void clear() {
            if (canvas!=null){
                canvas.drawPaint(paint);
                paint.setColor(Color.BLACK);
                canvas.drawColor(Color.WHITE);
                invalidate();//刷新 清屏
            }
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawBitmap(bitmap, 0, 0, null);
            canvas.drawPath(path, paint);
        }

        @Override
        protected void onSizeChanged(int w, int h, int oldw, int oldh) {
            int curW=bitmap!=null?getBitmap().getWidth():0;
            int curH=bitmap!=null?bitmap.getHeight():0;
            if (curW>=w&&curH>=h){
                return;
            }
            if (curW<w){
                curW=w;
            }
            if (curH<h){
                curH=h;
            }
            Bitmap newBitmap=Bitmap.createBitmap(curW,curH,Bitmap.Config.ARGB_8888);
            Canvas newCavas=new Canvas(newBitmap);
            if (bitmap!=null){
                newCavas.drawBitmap(bitmap,0,0,null);
            }
            bitmap=newBitmap;
            canvas=newCavas;

        }


        private float cur_x,cur_y;
        /**
         * 手势识别绘制签名
         * @param event
         * @return
         */
        @Override
        public boolean onTouchEvent(MotionEvent event) {
            float x=event.getX();
            float y=event.getY();
            switch (event.getAction()){
                case MotionEvent.ACTION_DOWN:
                    cur_x=x;
                    cur_y=y;
                    path.moveTo(cur_x,cur_y);
                    break;
                case MotionEvent.ACTION_MOVE:
                    path.quadTo(cur_x,cur_y,x,y);
                    cur_x=x;
                    cur_y=y;
                    break;
                case MotionEvent.ACTION_UP:
                    canvas.drawPath(path,paint);
                    path.reset();
                    break;
            }
            invalidate();
//            return super.onTouchEvent(event);
            return true;
        }

    }
}
