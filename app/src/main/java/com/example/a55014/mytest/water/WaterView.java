package com.example.a55014.mytest.water;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.a55014.mytest.utils.DeviceUtils;
import com.example.a55014.mytest.R;

/**
 * Created by yy on 2018/1/5.
 * 描述：有动画的水滴
 */

public class WaterView extends View {
    Paint mPaint;
    Paint mTextPaint;
    String text = "3g";
    private int mMWidth;
    private int mHeight;
    Context context;
    int startWidth, startHeight, endWidth, endHeight;
    int padding = 0;
    int index = 1;
    boolean isCollect = false;

    /**
     * @param context
     */
    public WaterView(Context context) {
        super(context);
        this.context = context;
        endWidth = (int) DeviceUtils.dpToPixel(context, 160);
        endHeight = (int) DeviceUtils.dpToPixel(context, 300);
        padding = (int) DeviceUtils.dpToPixel(context, 10);
        startWidth = 0;
        startHeight = 0;
    }

    /**
     * @param index
     * @param startWidth  开始坐标 X
     * @param startHeight 开始坐标 Y
     */
    public void setPosition(int index, int startWidth, int startHeight) {
        this.index = index;
        endWidth = endWidth - startWidth;
        endHeight = endHeight - startHeight;
    }

    public WaterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    public WaterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mMWidth = getMeasuredWidth();
        mHeight = getMeasuredHeight();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(getResources().getColor(R.color.color_87d1ab));
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(mMWidth / 2, (float) mHeight / 2, DeviceUtils.dpToPixel(context, 30), mPaint);

        mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setColor(Color.WHITE);
        mTextPaint.setTextSize(DeviceUtils.dpToPixel(context, 30));
        mTextPaint.setColor(getResources().getColor(R.color.text_color_fc));
        mTextPaint.setStyle(Paint.Style.FILL);
        float width = mTextPaint.measureText(text);
        canvas.drawText(text, mMWidth / 2 - width / 2, (float) mHeight * 0.65f, mTextPaint);

        doRepeatAnim();
        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                doSetAnim();
            }
        });
    }

    private void doSetAnim() {
        if (isCollect) return;
        isCollect = true;
        ObjectAnimator move1 = ObjectAnimator.ofFloat(this, "translationX", startWidth, endWidth);
        ObjectAnimator move2 = ObjectAnimator.ofFloat(this, "translationY", startHeight, endHeight);
        ObjectAnimator move3 = ObjectAnimator.ofFloat(this, "alpha", 1, 0);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(move1, move2, move3);
        animatorSet.setDuration(1500);
        animatorSet.start();
    }

    private void doRepeatAnim() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(this, "translationY", -padding, padding, -padding);
        animator.setRepeatMode(ObjectAnimator.REVERSE);
        animator.setRepeatCount(ObjectAnimator.INFINITE);
        animator.setDuration(1500);
        animator.start();
    }

}
