package com.example.a55014.mytest.progress;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.widget.ProgressBar;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;

/**
 * Created on 2017/8/31.
 * Author：yy
 * Description:小的progressbar
 */


public class MinProgressBar extends ProgressBar {

    public MinProgressBar(Context context) {
        super(context);
    }

    public MinProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MinProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public synchronized void setProgress(int progress) {
        int timeline = 2000 / 100;
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
                        MinProgressBar.super.setProgress(integer);
                        if (progressChangeLisenter != null) {
                            progressChangeLisenter.progressChange(integer);
                        }
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

    public interface OnProgressChangeLisenter {
        /**
         * 进度变化，以最大值100为单位
         *
         * @param progress
         */
        void progressChange(int progress);
    }

    OnProgressChangeLisenter progressChangeLisenter;

    public void setOnProgressChangeLisenter(OnProgressChangeLisenter onProgressChangeLisenter) {
        this.progressChangeLisenter = onProgressChangeLisenter;
    }
}
