package com.example.a55014.mytest.game;

import android.view.animation.Interpolator;

import com.example.a55014.mytest.utils.LogUtil;

/**
 * @author yy
 * Create by 2020/1/15 18:28
 * to do 先加速后匀速的差值器 时间分配比0-0.2加速 x^2加速 0.2-1.0匀速
 */
public class AccelerateLinearInterpolator implements Interpolator {
    @Override
    public float getInterpolation(float input) {
        float result;
        if (input <= 0.2) {
            result = input * input * 10.0f;
            LogUtil.d("result pow:" + result + "\t input:" + input);
        } else {
            //数学公式推理出来的结果
            result = ((10 + 3 * input * 10) / 4.0f) / 10.0f;
            LogUtil.d("result Linear:" + result + "\t input:" + input);
        }
        return result;
    }
}
