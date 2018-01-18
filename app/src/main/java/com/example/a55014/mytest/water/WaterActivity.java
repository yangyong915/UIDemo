package com.example.a55014.mytest.water;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;

import com.example.a55014.mytest.R;
import com.example.a55014.mytest.utils.DeviceUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * crate by yy on 2018-1-18
 * describle:仿蚂蚁森林水滴效果
 */
public class WaterActivity extends AppCompatActivity {
    @BindView(R.id.relative)
    WaterContainer relative;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water);
        ButterKnife.bind(this);
    }
    @Override
    protected void onStart() {
        super.onStart();
        int posx = (int) DeviceUtils.dpToPixel(this, 70);
        int posy = (int) DeviceUtils.dpToPixel(this, 70);
        addChildView(this, relative, 1, posx, posy);
        addChildView(this, relative, 2, 2 * posx, 2 * posy);
        addChildView(this, relative, 3, 3 * posx, posy);
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
}
