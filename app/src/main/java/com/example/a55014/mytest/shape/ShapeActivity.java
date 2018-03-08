package com.example.a55014.mytest.shape;

import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.a55014.mytest.R;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shape);
        ButterKnife.bind(this);
    }

}
