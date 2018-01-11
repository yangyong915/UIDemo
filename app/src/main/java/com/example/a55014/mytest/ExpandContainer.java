package com.example.a55014.mytest;

import android.animation.ValueAnimator;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by yy on 2018/1/11.
 * 描述：拍照选项调节容器
 */

public class ExpandContainer extends FrameLayout {
    Context mContext;
    TextView auto, open, exit;
    LinearLayout autoLayout;
    ImageView start;
    boolean show = false;
    int shortX, longX;

    public ExpandContainer(@NonNull Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    public ExpandContainer(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        init();
    }

    public ExpandContainer(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        init();
    }

    private void init() {
        shortX = (int) DeviceUtils.dpToPixel(mContext, 45);
        longX = (int) DeviceUtils.dpToPixel(mContext, 270);
        View mview = LayoutInflater.from(mContext).inflate(R.layout.camera_expand, null);
        auto = mview.findViewById(R.id.auto);
        open = mview.findViewById(R.id.open);
        exit = mview.findViewById(R.id.exit);
        start = mview.findViewById(R.id.start);
        autoLayout = mview.findViewById(R.id.auto_layout);
        addView(mview);
        auto.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                start.setBackgroundResource(R.mipmap.start_auto);
                clear();
                auto.setTextColor(getResources().getColor(R.color.color_87d1ab));
                show = true;
                expandAnimator();
                if (onClickBack != null)
                    onClickBack.auto();
            }
        });
        open.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                start.setBackgroundResource(R.mipmap.start_open);
                clear();
                open.setTextColor(getResources().getColor(R.color.color_87d1ab));
                show = true;
                expandAnimator();
                if (onClickBack != null)
                    onClickBack.open();
            }
        });
        exit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                start.setBackgroundResource(R.mipmap.start_close);
                clear();
                exit.setTextColor(getResources().getColor(R.color.color_87d1ab));
                show = true;
                expandAnimator();
                if (onClickBack != null)
                    onClickBack.close();
            }
        });
        start.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                expandAnimator();
                if (onClickBack != null)
                    onClickBack.start();
            }
        });
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

    private void clear() {
        auto.setTextColor(getResources().getColor(R.color.color_white));
        open.setTextColor(getResources().getColor(R.color.color_white));
        exit.setTextColor(getResources().getColor(R.color.color_white));
    }

    interface OnClickBack {
        void auto();

        void open();

        void close();

        void start();
    }

    OnClickBack onClickBack;

    public void setOnClickBack(OnClickBack onClickBack) {
        this.onClickBack = onClickBack;
    }
}
