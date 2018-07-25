package com.example.a55014.mytest.shape;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.example.a55014.mytest.R;
import com.example.a55014.mytest.utils.DeviceUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * crate by yy on 2018-3-8
 * describle:一些通用的背景形状，不用切图的偷懒必备神器
 */
public class ShapeActivity extends AppCompatActivity {

    @BindView(R.id.song)
    TextView song;
    @BindView(R.id.tv_normal)
    myTextView normal;
    @BindView(R.id.tv_circle)
    TextView circle;
    @BindView(R.id.layout)
    myLinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DeviceUtils.setCustomDensity(this, getApplication());
        setContentView(R.layout.activity_shape);
        ButterKnife.bind(this);
        normal.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Log.i("test", "activity setOnTouchListener:");
                return false;
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i("test", "activity onTouchEvent:" + super.onTouchEvent(event));
        return super.onTouchEvent(event);
    }

}
