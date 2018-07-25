package com.example.a55014.mytest.expand;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.a55014.mytest.R;
import com.example.a55014.mytest.utils.DeviceUtils;

/**
 * crate by yy on 2018-1-18
 * describle:动态伸缩按钮
 */
public class ExpandActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DeviceUtils.setCustomDensity(this, getApplication());
        setContentView(R.layout.activity_expand);
    }
}
