package com.example.a55014.mytest.game.view;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.DynamicDrawableSpan;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.a55014.mytest.R;
import com.example.a55014.mytest.utils.DeviceUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author yy
 * Create by 2019/12/24 15:44
 * to do 卡牌游戏模型
 */
public class CardRotateLayout extends FrameLayout {

    @BindView(R.id.tv_open) TextView tvOpen;
    @BindView(R.id.tv_close) TextView tvClose;
    @BindView(R.id.tv_content) TextView tvContent;
    @BindView(R.id.ll_card_content) LinearLayout llCardContent;
    private boolean openCard = true;
    private int[] img_content = {R.mipmap.blue_front, R.mipmap.blue_front_a, R.mipmap.blue_front_b,
            R.mipmap.blue_front_c, R.mipmap.blue_front_d};
    private Context mContext;
    private CardRotateView crv1, crv2, crv3;
    private float crv1_left, crv2_left, crv3_left;

    public CardRotateLayout(@NonNull Context context) {
        super(context);
        initView(context);

    }

    public CardRotateLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public CardRotateLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CardRotateLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context);
    }

    private void initView(Context context) {
        View view = View.inflate(context, R.layout.card_rotate_layout, this);
        ButterKnife.bind(this, view);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        setLayoutParams(layoutParams);
        mContext = context;

        setContent("");

        initData();
    }

    private void initData() {

        llCardContent.removeAllViews();
        for (int i = 0; i < 3; i++) {
            View view = View.inflate(mContext, R.layout.card_rotate_item_layout, null);
            llCardContent.addView(view);
        }
        crv1 = llCardContent.getChildAt(0).findViewById(R.id.crv);
        crv2 = llCardContent.getChildAt(1).findViewById(R.id.crv);
        crv3 = llCardContent.getChildAt(2).findViewById(R.id.crv);

    }

    @OnClick({R.id.tv_open, R.id.tv_close})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_open:
                if (!openCard) {
                    openCardView();
                    openCard = true;
                }
                break;
            case R.id.tv_close:
                if (openCard) {
                    closeCardView();
                    openCard = false;
                }
                break;
        }
    }

    /**
     * 设置内容
     *
     * @param text 内容
     */
    public void setContent(String text) {
        SpannableString span3 = new SpannableString("it is a ball ?");
        ImageSpan image = new ImageSpan(mContext, R.drawable.ball, DynamicDrawableSpan.ALIGN_BOTTOM);
        span3.setSpan(image, 8, 12, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        tvContent.setText(span3);
    }

    /**
     * 打开视图
     */
    private void openCardView() {
        if (llCardContent.getChildCount() > 0) {
            float itemWidth = llCardContent.getChildAt(0).getWidth() + DeviceUtils.dpToPixel(mContext, 10);
            float centerX = (llCardContent.getWidth() - itemWidth) / 2;
            AnimatorSet animatorSet = new AnimatorSet();
            ObjectAnimator move1 = ObjectAnimator.ofFloat(crv1, "translationX", centerX - crv1_left, 0);
            ObjectAnimator move2 = ObjectAnimator.ofFloat(crv2, "translationX", centerX - crv2_left, 0);
            ObjectAnimator move3 = ObjectAnimator.ofFloat(crv3, "translationX", centerX - crv3_left, 0);
            animatorSet.playTogether(move1, move2, move3);
            animatorSet.setDuration(1000);
            animatorSet.start();
        }
    }

    /**
     * 关闭视图
     */
    private void closeCardView() {
        if (llCardContent.getChildCount() > 0) {
            int[] num = getRandomNumber(img_content.length);
            crv1.refreshFront(img_content[num[0]]);
            crv2.refreshFront(img_content[num[1]]);
            crv3.refreshFront(img_content[num[2]]);
            float itemWidth = crv1.getWidth() + DeviceUtils.dpToPixel(mContext, 10);
            float centerX = (llCardContent.getWidth() - itemWidth) / 2;
            crv1_left = llCardContent.getChildAt(0).getLeft();
            crv2_left = llCardContent.getChildAt(1).getLeft();
            crv3_left = llCardContent.getChildAt(2).getLeft();
            ObjectAnimator move1 = ObjectAnimator.ofFloat(crv1, "translationX", 0, centerX - crv1_left);
            ObjectAnimator move2 = ObjectAnimator.ofFloat(crv2, "translationX", 0, centerX - crv2_left);
            ObjectAnimator move3 = ObjectAnimator.ofFloat(crv3, "translationX", 0, centerX - crv3_left);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(move1, move2, move3);
            animatorSet.setDuration(1000);
            animatorSet.start();
        }
    }

    /**
     * 生成随机卡片内容
     *
     * @param size 长度
     * @return
     */
    private int[] getRandomNumber(int size) {
        int[] intRandom = new int[size];
        List mylist = new ArrayList(); //生成数据集，用来保存随即生成数，并用于判断
        Random rd = new Random();
        while (mylist.size() < size) {
            int num = rd.nextInt(size);
            if (!mylist.contains(num)) {
                mylist.add(num); //往集合里面添加数据。
            }
        }
        for (int i = 0; i < mylist.size(); i++) {
            intRandom[i] = (Integer) (mylist.get(i));
        }
        return intRandom;
    }
}
