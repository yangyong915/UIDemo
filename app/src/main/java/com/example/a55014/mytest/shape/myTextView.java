package com.example.a55014.mytest.shape;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

/**
 * Created by yy on 2018/7/12.
 * 描述：
 */

public class myTextView extends android.support.v7.widget.AppCompatTextView {
    public myTextView(Context context) {
        super(context);
    }

    public myTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public myTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i("test", "textview onTouchEvent:"+super.onTouchEvent(event));
        return super.onTouchEvent(event);
    }

}
