package com.example.a55014.mytest.game.view;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.a55014.mytest.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author yy
 * Create by 2019/12/25 15:13
 * to do 小汽车模型
 */
public class CarLayout extends FrameLayout {
    @BindView(R.id.iv_touch) DraggingImageView ivTouch;
    private Context mContext;

    public CarLayout(@NonNull Context context) {
        super(context);
        initView(context);

    }

    public CarLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public CarLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CarLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context);
    }

    private void initView(Context context) {
        View view = View.inflate(context, R.layout.car_layout, this);
        ButterKnife.bind(this, view);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        setLayoutParams(layoutParams);
        mContext = context;

    }
}
