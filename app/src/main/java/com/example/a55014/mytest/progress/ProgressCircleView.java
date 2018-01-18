package com.example.a55014.mytest.progress;


import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;

/**
 * Created on 2017/9/14.
 * Author：yy
 * Description:自定义渐变颜色圆环
 */


public class ProgressCircleView extends View {
    //View默认最小宽度
    private static final int DEFAULT_MIN_WIDTH = 400;
    int color_yello = Color.parseColor("#ffb78a");
    int color_red = Color.parseColor("#ef527d");
    //圆环颜色
    private int[] doughnutColors = new int[]{Color.parseColor("#ffb78a"), Color.parseColor("#fb9e86"),
            Color.parseColor("#f26980"), Color.parseColor("#ef527d"),
            Color.parseColor("#ffb78a")};

    private int width;
    private int height;
    private float currentValue = 0f;
    private Paint paint = new Paint();

    public ProgressCircleView(Context context) {
        super(context);
    }

    public ProgressCircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ProgressCircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void resetParams() {
        width = getWidth();
        height = getHeight();
    }

    private void initPaint() {
        paint.reset();
        paint.setAntiAlias(true);
    }

    public void setCurrentValue() {
        currentValue = 0f;
    }

    public void setValue(float value) {
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(currentValue, value);
        valueAnimator.setDuration(1000);
        valueAnimator.setInterpolator(new Interpolator() {
            @Override
            public float getInterpolation(float v) {
                return 1 - (1 - v) * (1 - v) * (1 - v);
            }
        });
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                currentValue = (float) valueAnimator.getAnimatedValue();
                invalidate();
            }
        });
        valueAnimator.start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        resetParams();
        //画背景灰色圆环
        initPaint();
        float doughnutWidth = Math.min(width, height) / 2 * 0.1f;
        paint.setStrokeWidth(doughnutWidth);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.parseColor("#f5f5f5"));
        paint.setAntiAlias(true);
        RectF rectF = new RectF((width > height ? Math.abs(width - height) / 2 : 0) + doughnutWidth / 2, (height > width ? Math.abs(height - width) / 2 : 0) + doughnutWidth / 2, width - (width > height ? Math.abs(width - height) / 2 : 0) - doughnutWidth / 2, height - (height > width ? Math.abs(height - width) / 2 : 0) - doughnutWidth / 2);
        canvas.drawArc(rectF, 0, 360, false, paint);

        //画彩色圆环
        initPaint();
        canvas.rotate(-90, width / 2, height / 2);
        paint.setStrokeWidth(doughnutWidth);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        if (doughnutColors.length > 1) {
            paint.setShader(new SweepGradient(width / 2, height / 2, doughnutColors, null));
        } else {
            paint.setColor(doughnutColors[0]);
        }
        canvas.drawArc(rectF, 0, currentValue, false, paint);

//        //画中间数值的背景
//        int fontSize = 50;
//        initPaint();
//        paint.setStyle(Paint.Style.FILL);
//        paint.setColor(Color.WHITE);
//        canvas.drawCircle(width / 2, height / 2, fontSize * 2, paint);
//
//        //画中间数值
//        canvas.rotate(90, width / 2, height / 2);
//        initPaint();
//        paint.setColor(ColorUtils.getCurrentColor(currentValue / 360f, doughnutColors));
//        paint.setTextSize(fontSize);
//        paint.setTextAlign(Paint.Align.CENTER);
//        float baseLine = height / 2 - (paint.getFontMetrics().descent + paint.getFontMetrics().ascent) / 2;
//        canvas.drawText((int) (currentValue / 360f * 100) + "%", width / 2, baseLine, paint);
    }

    /**
     * 当布局为wrap_content时设置默认长宽
     *
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(measure(widthMeasureSpec), measure(heightMeasureSpec));
    }

    private int measure(int origin) {
        int result = DEFAULT_MIN_WIDTH;
        int specMode = MeasureSpec.getMode(origin);
        int specSize = MeasureSpec.getSize(origin);
        if (specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        } else {
            if (specMode == MeasureSpec.AT_MOST) {
                result = Math.min(result, specSize);
            }
        }
        return result;
    }
}
