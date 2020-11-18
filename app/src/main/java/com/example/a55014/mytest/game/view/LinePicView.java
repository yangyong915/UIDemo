package com.example.a55014.mytest.game.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.a55014.mytest.R;

/**
 * @author yy
 * Create by 2020/1/16 18:20
 * to do
 */
@SuppressLint("AppCompatCustomView")
public class LinePicView extends ImageView {
    /**
     * 开始点的x,y坐标
     */
    private int startX = 0;
    private int startY = 0;
    /**
     * 结束点的x,y坐标
     */
    private int endX = 0;
    private int endY = 0;

    public LinePicView(Context context) {
        super(context);
        initView(context);
    }

    public LinePicView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public LinePicView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        setBackgroundResource(R.mipmap.bottle_chameleon_tongue);
    }

    /**
     * 设置开始点、结束点
     */
    public void setPoint(int dx1, int dy1, int dx2, int dy2) {
        this.startX = dx1;
        this.startY = dy1;
        this.endX = dx2;
        this.endY = dy2;


        setLayout();
        //旋转view
        rotateView(getScale());
    }

    private void setLayout() {
        int length = getDistanceBetween2Points(startX, startY, endX, endY);
        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.setMargins(startX, startY, 0, 0);
        lp.width = length;
        lp.height = getHeight();
        setLayoutParams(lp);
    }

    /**
     * 旋转视图
     *
     * @param scale 角度 45f
     */
    private void rotateView(float scale) {
        setPivotX(0);
        setPivotY(0);
        setRotation(scale);
    }

    private float getScale() {
        double tan = Math.atan2(endY - startY, endX - startX);
        float angleA = (float) (180 * tan / Math.PI);
        return angleA;
    }

    /**
     * 两点间的距离
     *
     * @param dx1
     * @param dy1
     * @param dx2
     * @param dy2
     * @return
     */
    public static int getDistanceBetween2Points(int dx1, int dy1, int dx2, int dy2) {
        int distance = (int) Math.sqrt(Math.pow(dy1 - dy2, 2) + Math.pow(dx1 - dx2, 2));
        return distance;
    }
}
