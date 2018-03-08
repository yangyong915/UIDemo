package com.example.a55014.mytest.shape;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
 * Created by yy on 2018/3/8.
 * 描述：
 */

public class ColorTextView extends AppCompatTextView {
    private int mViewWidth;
    private Paint mPaint;
    private LinearGradient mLinearGradient;
    private Matrix mMatrix;
    private int mTranslate;

    public ColorTextView(Context context) {
        super(context);
    }

    public ColorTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ColorTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * LinearGradient有两个构造函数： public LinearGradient(floatx0,float y0, float x1, float y1, int[] colors, float[] positions,Shader.TileMode tile)
     * 参数:float x0: 渐变起始点x坐标
     * float y0:渐变起始点y坐标
     * float x1:渐变结束点x坐标
     * float y1:渐变结束点y坐标
     * int[] colors:颜色 的int 数组
     * float[] positions: 相对位置的颜色数组,可为null,若为null,可为null,颜色沿渐变线均匀分布
     * Shader.TileMode tile: 渲染器平铺模式
     */

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        // TODO Auto-generated method stub
        super.onSizeChanged(w, h, oldw, oldh);
        if (mViewWidth == 0) {
            mViewWidth = getMeasuredWidth();
        }
        if (mViewWidth > 0) {
            mPaint = getPaint();
            mLinearGradient = new LinearGradient(
                    0,
                    0,
                    mViewWidth,
                    0,
                    new int[]{Color.BLUE, Color.BLACK, Color.RED, Color.YELLOW},
                    null, Shader.TileMode.MIRROR);
            mPaint.setShader(mLinearGradient);
            mMatrix = new Matrix();
        }

    }

    @Override
    protected void onDraw(Canvas canvas) {
        // TODO Auto-generated method stub
        super.onDraw(canvas);
        if (mMatrix != null) {
            mTranslate += mViewWidth / 5;
            if (mTranslate > 2 * mViewWidth) {
                mTranslate = -mViewWidth;
            }
            mMatrix.setTranslate(mTranslate, 0);
            mLinearGradient.setLocalMatrix(mMatrix);
            postInvalidateDelayed(100);
        }
    }

}
