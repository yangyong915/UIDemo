package com.example.a55014.mytest.game.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.a55014.mytest.utils.DeviceUtils;

/**
 * @author yy
 * Create by 2020/1/4 18:13
 * to do 两点间的线
 */
public class LineView extends View {
    /**
     * 线条的画笔
     */
    private Paint paint;
    /**
     * 开始点的x,y坐标
     */
    private int startX = 100;
    private int startY = 100;
    /**
     * 结束点的x,y坐标
     */
    private int endX = 100;
    private int endY = 100;
    /**
     * 画笔宽度
     */
    private int width = 0;

    public LineView(Context context) {
        super(context);
        initView(context);
    }

    public LineView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public LineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        width = DeviceUtils.dip2px(context, 10);
        paint = new Paint();
        paint.setColor(Color.YELLOW);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(width);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawLine(startX, startY, endX, endY, paint);
    }

    /**
     * 设置开始点、结束点
     */
    public void setPoint(int dx1, int dy1, int dx2, int dy2) {
        this.startX = dx1;
        this.startY = dy1;
        this.endX = dx2;
        this.endY = dy2;
    }
}
