package com.example.a55014.mytest.game.view;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.a55014.mytest.R;
import com.example.a55014.mytest.game.util.RotatableHelper;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author yy
 * Create by 2019/12/23 11:42
 * to do 卡牌翻转视图
 */
public class CardRotateView extends FrameLayout {
    @BindView(R.id.imageView_back) ImageView imageViewBack;
    @BindView(R.id.imageView_front) ImageView imageViewFront;
    @BindView(R.id.fl_front) FrameLayout flFront;
    @BindView(R.id.rl_card_root) RelativeLayout rlCardRoot;

    public CardRotateView(@NonNull Context context) {
        super(context);
        initView(context);

    }

    public CardRotateView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public CardRotateView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CardRotateView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context);
    }

    private void initView(Context context) {
        View view = View.inflate(context, R.layout.card_rotate_view, this);
        ButterKnife.bind(this, view);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        setLayoutParams(layoutParams);

        setCameraDistance();
        initData();
    }

    /**
     * 改变视角距离, 贴近屏幕
     */
    private void setCameraDistance() {
        int distance = 10000;
        float scale = getResources().getDisplayMetrics().density * distance;
        rlCardRoot.setCameraDistance(scale);
    }

    /**
     * 设置数据
     */
    public void initData() {
        imageViewBack.setImageResource(R.drawable.card_one_back);
        imageViewBack.setVisibility(View.VISIBLE);
        flFront.setVisibility(View.INVISIBLE);
    }

    /**
     * 修改卡片内容
     * R.mipmap.blue_front
     */
    public void refreshFront(int id) {
        imageViewFront.setImageResource(id);
    }

    /**
     * 翻牌
     */
    public void cardTurnover() {
        if (View.VISIBLE == imageViewBack.getVisibility()) {
            rotateView();
            RotatableHelper rotatable = new RotatableHelper.Builder(rlCardRoot)
                    .sides(R.id.imageView_back, R.id.fl_front)
                    .direction(RotatableHelper.ROTATE_Y)
                    .rotationCount(1)
                    .build();
            rotatable.setTouchEnable(false);
            rotatable.rotate(RotatableHelper.ROTATE_Y, -180, 1500);
        } else if (View.VISIBLE == flFront.getVisibility()) {
            RotatableHelper rotatable = new RotatableHelper.Builder(rlCardRoot)
                    .sides(R.id.imageView_back, R.id.fl_front)
                    .direction(RotatableHelper.ROTATE_Y)
                    .rotationCount(1)
                    .build();
            rotatable.setTouchEnable(false);
            rotatable.rotate(RotatableHelper.ROTATE_Y, 0, 1500);
        }
    }

    /**
     * 旋转视图 先翻转180，转回来时就不是反转的了
     */
    private void rotateView() {
        final ObjectAnimator anim = ObjectAnimator.ofFloat(flFront, "rotationY", 180f);
        anim.setDuration(50);
        //释放资源
        anim.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                anim.cancel();
            }

            @Override
            public void onAnimationCancel(Animator animation) {
            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        anim.start();
    }

    @OnClick({R.id.imageView_back, R.id.imageView_front})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.imageView_back:
            case R.id.imageView_front:
                cardTurnover();
                break;
        }
    }
}
