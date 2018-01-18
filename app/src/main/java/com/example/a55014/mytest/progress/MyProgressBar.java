package com.example.a55014.mytest.progress;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.widget.ProgressBar;


import com.example.a55014.mytest.utils.DeviceUtils;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;

/**
 * Created on 2017/8/30.
 * Author：yy
 * Description:自定义带文字有动画的进度条
 */

public class MyProgressBar extends ProgressBar {
    String text;
    Paint mPaint;
    int span;
    Rect rect;

    int timeline;   //时间间隔

    public MyProgressBar(Context context) {
        super(context);
        initText(context);
    }

    public MyProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        initText(context);
    }

    public MyProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initText(context);
    }

    //初始化，画笔
    private void initText(Context context) {
        this.mPaint = new Paint();
        this.mPaint.setColor(Color.WHITE);
        this.mPaint.setTextSize(DeviceUtils.dpToPixel(context, 10));
        span = (int) DeviceUtils.dpToPixel(context, 20);
        rect = new Rect();
        timeline = 0;
        text = "0%";
    }

    @Override
    public synchronized void setProgress(int progress) {
        timeline = 2000 / 100;
        Observable.interval(0, timeline, TimeUnit.MILLISECONDS)
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<Long, Integer>() {
                         @Override
                         public Integer apply(@NonNull Long increaseTime) throws Exception {
                             return increaseTime.intValue();
                         }
                     }
                )
                .take(progress + 1)
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Integer integer) {
                        setText(integer.intValue());
                        MyProgressBar.super.setProgress(integer.intValue());
                        invalidate();
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mPaint.getTextBounds(this.text, 0, this.text.length(), rect);
        //绘制文字
        int i = (getProgress() * 100) / this.getMax();
        int x = i * (getWidth() - rect.centerX()) / 100 - span;
        int y = (getHeight() / 2) - rect.centerY();
        if (i > 7)  //大于百分之7才显示
            canvas.drawText(this.text, x, y, this.mPaint);
    }

    //设置文字内容
    private void setText(int progress) {
        int i = (progress * 100) / this.getMax();
        this.text = String.valueOf(i) + "%";
    }

    public interface OnProgressChangeLisenter {
        /**
         * 进度变化，以最大值100为单位
         *
         * @param progress
         */
        void progressChange(int progress);
    }

    MyProgressBar.OnProgressChangeLisenter progressChangeLisenter;

    public void setOnProgressChangeLisenter(MyProgressBar.OnProgressChangeLisenter onProgressChangeLisenter) {
        this.progressChangeLisenter = onProgressChangeLisenter;
    }

}
