package com.example.a55014.mytest.geogebra;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.a55014.mytest.R;
import com.example.a55014.mytest.utils.Fglass;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author yy
 * Create by 2020/7/8 10:05
 * to do
 */
public class BlurActivity extends AppCompatActivity {
    @BindView(R.id.picture) ImageView picture;
    @BindView(R.id.iv_blur) ImageView ivBlur;
    @BindView(R.id.main_cb_fastblur) CheckBox mainCbFastblur;
    @BindView(R.id.controls) LinearLayout controls;
    @BindView(R.id.tv_time) TextView tvTime;
    @BindView(R.id.fl_root) FrameLayout flRoot;
    @BindView(R.id.iv_cover) ImageView ivCover;
    @BindView(R.id.nv_scroll) NestedScrollView nvScroll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blur);
        ButterKnife.bind(this);

        mainCbFastblur.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                long startMs = System.currentTimeMillis();
                if (isChecked) {
                    ivBlur.setVisibility(View.VISIBLE);
                    //设置高斯模糊
                    Fglass.blur(BlurActivity.this, flRoot, ivBlur, 25, 2);
                    ivCover.setVisibility(View.VISIBLE);
                } else {
                    ivBlur.setVisibility(View.INVISIBLE);
                    ivCover.setVisibility(View.INVISIBLE);

                }
                tvTime.setText((System.currentTimeMillis() - startMs + "ms"));
            }
        });
        nvScroll.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                ivBlur.invalidate();
            }
        });
    }
}
