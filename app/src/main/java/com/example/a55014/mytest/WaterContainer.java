package com.example.a55014.mytest;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yy on 2018/1/8.
 * 描述：浮动控件父容器，用于设定子控件初始位置
 */

public class WaterContainer extends RelativeLayout {
    List<Integer> listX = new ArrayList<>();
    List<Integer> listY = new ArrayList<>();

    public void setChildPosition(int posx, int posy) {
        listX.add(posx);
        listY.add(posy);
    }

    public WaterContainer(Context context) {
        super(context);
    }

    public WaterContainer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public WaterContainer(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        measureChildren(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        final int count = getChildCount();

        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);
            int childWidth = child.getMeasuredWidth();
            int childHeight = child.getMeasuredHeight();
            if (child.getVisibility() != GONE) {
                child.layout(listX.get(i), listY.get(i), childWidth + listX.get(i), childHeight + listY.get(i));
            }
        }
    }
}
