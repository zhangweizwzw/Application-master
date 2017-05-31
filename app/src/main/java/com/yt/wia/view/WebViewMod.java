package com.yt.wia.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.webkit.WebView;
import android.widget.EditText;

/**
 * Created by admin on 2017/4/28.
 */

public class WebViewMod extends WebView {
    public EditText mFocusDistraction;
    public Context mContext;
    public WebViewMod(Context context) {
        super(context);
        init(context);
    }

    public WebViewMod(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public WebViewMod(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    @SuppressLint("NewApi")
    public WebViewMod(Context context, AttributeSet attrs, int defStyle, boolean privateBrowsing) {
        super(context, attrs, defStyle, privateBrowsing);
        init(context);
    }

    public void init(Context context) {
        // This lets the layout editor display the view.
        if (isInEditMode()) return;

        mContext = context;

        mFocusDistraction = new EditText(context);
        mFocusDistraction.setBackgroundResource(android.R.color.transparent);
        this.addView(mFocusDistraction);
        mFocusDistraction.getLayoutParams().width = 1;
        mFocusDistraction.getLayoutParams().height = 1;
    }
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        invalidate();
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    public boolean overScrollBy(int deltaX, int deltaY, int scrollX, int scrollY,
                                int scrollRangeX, int scrollRangeY, int maxOverScrollX,
                                int maxOverScrollY, boolean isTouchEvent) {
        return false;
    }
    /**
     * 使WebView不可滚动
     * */
    @Override
    public void scrollTo(int x, int y){
        super.scrollTo(0,0);
    }


    long last_time = 0;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                long current_time = System.currentTimeMillis();
                long d_time = current_time - last_time;
                System.out.println(d_time);
                ;
                if (d_time < 300) {
                    last_time = current_time;
                    return true;
                } else {
                    last_time = current_time;
                }
                break;
        }
        return super.onTouchEvent(event);
    }
}
