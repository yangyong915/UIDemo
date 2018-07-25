package com.example.a55014.mytest.shape;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by yy on 2018/7/12.
 * 描述：
 */

public class myLinearLayout extends LinearLayout {
    public myLinearLayout(Context context) {
        super(context);
    }

    public myLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public myLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.i("test", "viewgroup onInterceptTouchEvent:" + super.onInterceptTouchEvent(ev));
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i("test", "viewgroup onTouchEvent:" + super.onTouchEvent(event));
        return super.onTouchEvent(event);
    }
}
