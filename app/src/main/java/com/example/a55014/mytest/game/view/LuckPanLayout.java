package com.example.a55014.mytest.game.view;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.a55014.mytest.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author yy
 * Create by 2019/12/24 18:37
 * to do 大转盘模型
 */
public class LuckPanLayout extends FrameLayout {

    @BindView(R.id.iv_luck) ImageView ivLuck;
    @BindView(R.id.iv_go) ImageView ivGo;
    private Context mContext;

    public LuckPanLayout(@NonNull Context context) {
        super(context);
        initView(context);

    }

    public LuckPanLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public LuckPanLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public LuckPanLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context);
    }

    private void initView(Context context) {
        View view = View.inflate(context, R.layout.luck_pan_layout, this);
        ButterKnife.bind(this, view);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        setLayoutParams(layoutParams);
        mContext = context;

    }

    @OnClick({R.id.iv_luck, R.id.iv_go})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_luck:
                break;
            case R.id.iv_go:
                rotateView(360 * 6.3f);
                break;
        }
    }

    /**
     * 旋转视图
     *
     * @param scale 角度 45f
     */
    private void rotateView(float scale) {
        Animation animation = new RotateAnimation(0, scale, Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        animation.setDuration(3000);
        animation.setFillAfter(true);
        ivLuck.startAnimation(animation);
    }
}
