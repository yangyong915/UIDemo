package com.example.a55014.mytest;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.relative)
    WaterContainer relative;
    @BindView(R.id.auto)
    TextView auto;
    @BindView(R.id.open)
    TextView open;
    @BindView(R.id.exit)
    TextView exit;
    @BindView(R.id.auto_layout)
    LinearLayout autoLayout;
    @BindView(R.id.start)
    ImageView start;
    int shortX, longX;
    boolean show = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        shortX = (int) DeviceUtils.dpToPixel(this, 45);
        longX = (int) DeviceUtils.dpToPixel(this, 270);
        int posx = (int) DeviceUtils.dpToPixel(this, 70);
        int posy = (int) DeviceUtils.dpToPixel(this, 70);
        addChildView(this, relative, 1, posx, posy);
        addChildView(this, relative, 2, 2 * posx, 2 * posy);
        addChildView(this, relative, 3, 3 * posx, posy);
    }


    private void expandAnimator() {
        ValueAnimator animator;
        if (show) {
            show = false;
            animator = ValueAnimator.ofInt(longX, shortX);
        } else {
            show = true;
            animator = ValueAnimator.ofInt(shortX, longX);
        }
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int width = (Integer) valueAnimator.getAnimatedValue();
                autoLayout.getLayoutParams().width = width;
                autoLayout.requestLayout();
            }
        });
        animator.setDuration(500);
        animator.start();
    }

    /**
     * 添加子水滴
     *
     * @param relative
     * @param index    第几个
     * @param posx     子控件初始位置x
     * @param posy     子控件初始位置y
     */
    private void addChildView(final Context context, final WaterContainer relative, final int index, final int posx, final int posy) {
        relative.postDelayed(new Runnable() {
            @Override
            public void run() {
                int width = (int) DeviceUtils.dpToPixel(context, 60);
                int height = (int) DeviceUtils.dpToPixel(context, 60);
                ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(width, height);
                WaterView waterView = new WaterView(context);
                waterView.setPosition(index, posx, posy);
                waterView.setLayoutParams(layoutParams);
                relative.setChildPosition(posx, posy);
                relative.addView(waterView);
            }
        }, (index - 1) * 300);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @OnClick({R.id.auto, R.id.open, R.id.exit, R.id.start})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.auto:
                start.setBackgroundResource(R.mipmap.start_auto);
                clear();
                auto.setTextColor(getResources().getColor(R.color.color_87d1ab));
                show = true;
                expandAnimator();
                break;
            case R.id.open:
                start.setBackgroundResource(R.mipmap.start_open);
                clear();
                open.setTextColor(getResources().getColor(R.color.color_87d1ab));
                show = true;
                expandAnimator();
                break;
            case R.id.exit:
                start.setBackgroundResource(R.mipmap.start_close);
                clear();
                exit.setTextColor(getResources().getColor(R.color.color_87d1ab));
                show = true;
                expandAnimator();
                break;
            case R.id.start:
                expandAnimator();
                break;
        }
    }

    private void clear() {
        auto.setTextColor(getResources().getColor(R.color.color_white));
        open.setTextColor(getResources().getColor(R.color.color_white));
        exit.setTextColor(getResources().getColor(R.color.color_white));
    }
}
