package com.example.a55014.mytest.pad;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.a55014.mytest.utils.LogUtil;

/**
 * @author yy
 * Create by 2020/10/21 16:33
 * to do
 */
public class TestReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        LogUtil.e("接收到 test 广播》》》》》 ：TestReceiver" + intent.getAction());
    }
}
