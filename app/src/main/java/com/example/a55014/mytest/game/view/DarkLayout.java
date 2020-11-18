package com.example.a55014.mytest.game.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.a55014.mytest.R;
import com.example.a55014.mytest.game.entiy.RandomLocationEntity;
import com.example.a55014.mytest.utils.DeviceUtils;
import com.example.a55014.mytest.utils.LogUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author yy
 * Create by 2019/12/24 17:40
 * to do 小鸭子模型
 */
public class DarkLayout extends FrameLayout {

    DraggingImageView ivTouch;
    @BindView(R.id.fl_words) FrameLayout flWords;
    @BindView(R.id.ll_words_context) LinearLayout llWordsContent;
    private Context mContext;
    List<RandomLocationEntity> randomLocationEntityList;
    String[] words = {"a", "b", "c", "d", "e", "f", "g"};
    List<String> wordlist = new ArrayList<>();

    public DarkLayout(@NonNull Context context) {
        super(context);
        initView(context);

    }

    public DarkLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public DarkLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public DarkLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context);
    }

    private void initView(Context context) {
        View view = View.inflate(context, R.layout.dark_layout, this);
        ButterKnife.bind(this, view);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        setLayoutParams(layoutParams);
        mContext = context;

        addContentView();
    }

    /**
     * 添加动态的内容
     */
    private void addContentView() {
        addWords();

        addRandomWord();

        addDragImageView();
    }

    /**
     * 添加单词
     */
    private void addWords() {
        wordlist.clear();
        for (int j = 0; j < 4; j++) {
            TextView word = (TextView) LayoutInflater.from(mContext).inflate(R.layout.move_word_textview, null);
            switch (j) {
                case 0:
                    wordlist.add("h");
                    break;
                case 1:
                    wordlist.add("o");
                    break;
                case 2:
                    wordlist.add("l");
                    break;
                case 3:
                    wordlist.add("y");
                    break;

            }
            word.setText(wordlist.get(j));

            llWordsContent.addView(word);
        }
    }

    List<TextView> textViews = new ArrayList<>();

    /**
     * 添加随机字母
     */
    private void addRandomWord() {
        textViews.clear();
        getRandomLocation(7, DeviceUtils.dip2px(mContext, 450), DeviceUtils.dip2px(mContext, 300)
                , DeviceUtils.dip2px(mContext, 30), DeviceUtils.dip2px(mContext, 40));

        for (int i = 0; i < randomLocationEntityList.size(); i++) {
            TextView textView = (TextView) LayoutInflater.from(mContext).inflate(R.layout.word_textview, null);
            LayoutParams mLayoutParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            mLayoutParams.setMargins(randomLocationEntityList.get(i).locationX,
                    randomLocationEntityList.get(i).locationY, 0, 0);//4个参数按顺序分别是左上右下
            textView.setLayoutParams(mLayoutParams);
            textView.setText(words[i]);
            flWords.addView(textView);
            textViews.add(textView);

            if (i > 3) {
                randomLocationEntityList.get(i).isDistractor = true;
            }
        }
    }

    LineView lineView;

    /**
     * 添加小鸭子
     */
    private void addDragImageView() {
        ivTouch = (DraggingImageView) LayoutInflater.from(mContext).inflate(R.layout.dark_view, null);
        LayoutParams mLayoutParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mLayoutParams.gravity = Gravity.RIGHT | Gravity.BOTTOM;
        int magin = DeviceUtils.dip2px(mContext, 10);
        mLayoutParams.setMargins(magin, magin, magin, magin);
        ivTouch.setLayoutParams(mLayoutParams);
        flWords.addView(ivTouch);

        ivTouch.setLocationChangedListener(new DraggingImageView.LocationChangedListener() {
            @Override
            public void getLocation(float dx, float dy) {
                int x = (int) dx + ivTouch.getWidth() / 2;
                int y = (int) dy + ivTouch.getHeight() / 2;
                lineView.setPoint(100, 100, x, y);
                LayoutParams vParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                lineView.setLayoutParams(vParams);
                lineView.requestLayout();
                lineView.invalidate();
            }
        });

        lineView = (LineView) LayoutInflater.from(mContext).inflate(R.layout.dark_line_view, null);
        LayoutParams vParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        lineView.setLayoutParams(vParams);
        flWords.addView(lineView);

//        scaleAnimation();
    }

    int last = 0;

    int startX = 100;
    int startY = 600;
    int endX = 1000;
    int endY = 100;
    int index = 0;
    TextView word;

    private void scaleAnimation() {
        word = (TextView) llWordsContent.getChildAt(index);
        index = index + 1;
        endX = (int) llWordsContent.getX() ;
        endY = (int) llWordsContent.getY() + word.getHeight();
        LogUtil.d("yy---current:endX" + endX + "endY:" + endY);
        ValueAnimator valueAnimator = ValueAnimator.ofInt(0, 50, 0);
        valueAnimator.setDuration(3000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int current = (int) animation.getAnimatedValue();
                float x = (endX - startX) * (current / 50f) + startX;
                float y = (endY - startY) * (current / 50f) + startY;
                lineView.setPoint(startX, startY, (int) x, (int) y);
                lineView.invalidate();
                LogUtil.d("yy---current:" + current + "last:" + last + "\tx:" + x + "\ty:" + y);
                if (current < last) {
                    //字母被吃回
                    word.setX(x - llWordsContent.getX());
                    word.setY(y - llWordsContent.getY() - word.getHeight());
                    last = current;
                } else {
                    last = current;
                }
            }
        });
        valueAnimator.start();
    }


    /**
     * 获得随机数组的坐标，坐标不重叠
     *
     * @param listSize 列表大小
     * @param lengthX  父X轴长度
     * @param lengthY  父Y轴长度
     * @param weight   控件宽
     * @param height   控件高
     */
    public void getRandomLocation(int listSize, int lengthX, int lengthY, int weight, int height) {
        if (randomLocationEntityList == null) {
            randomLocationEntityList = new ArrayList<>();
        } else {
            randomLocationEntityList.clear();
        }

        for (int i = 0; i < listSize; i++) {
            setIntersectStatus(lengthX, lengthY, weight, height);
        }
    }

    /**
     * 取矩形不相交的点加入数组,加入一个新的点
     * int temp=m+(int)(Math.random()*(n+1-m)); //生成从m到n的随机整数[m,n]
     * <p>
     * m=1/6lengthX   n=5/6lengthX
     */
    private void setIntersectStatus(int lengthX, int lengthY, int weight, int height) {
        Boolean isIntersect = false;
        int mX = lengthX / 8;
        int nX = lengthX / 8 * 6;
        int mY = lengthY / 8;
        int nY = lengthY / 8 * 6;
        int randomX = mX + (int) (Math.random() * (nX + 1 - mX));
        int randomY = mY + (int) (Math.random() * (nY + 1 - mY));
        for (int i = 0; i < randomLocationEntityList.size(); i++) {
            int valueX = Math.abs(randomLocationEntityList.get(i).locationX - randomX);
            int valueY = Math.abs(randomLocationEntityList.get(i).locationY - randomY);
            if (valueX < weight && valueY < height) {
                //和其中一个相交
                isIntersect = true;
            }
        }

        if (!isIntersect) {
            //不相交，把该点加入数组,结束方法
            RandomLocationEntity locationEntity = new RandomLocationEntity();
            locationEntity.locationX = randomX;
            locationEntity.locationY = randomY;
            randomLocationEntityList.add(locationEntity);
        } else {
            //相交，重新走一遍该方法
            setIntersectStatus(lengthX, lengthY, weight, height);
        }
    }

    @OnClick({R.id.tv_alpha, R.id.tv_move, R.id.tv_close})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_alpha:
                int wordSize = llWordsContent.getChildCount();
                for (int i = 1; i < wordSize; i++) {
                    TextView word = (TextView) llWordsContent.getChildAt(i);
                    wordAnimation(word);
                }
                break;
            case R.id.tv_move:
                LogUtil.d("move---before:getX-" + llWordsContent.getX() + "\tgetY-" + llWordsContent.getY());
//                moveAnimation();
                if (index < 4) {
                    scaleAnimation();
                }
                break;
            case R.id.tv_close:
                switch (index) {
                    case 0:
                        index++;
                        moveAnimationTo((TextView) flWords.getChildAt(2), (TextView) llWordsContent.getChildAt(1));
                        break;
                    case 1:
                        index++;
                        moveAnimationTo((TextView) flWords.getChildAt(3), (TextView) llWordsContent.getChildAt(2));
                        break;
                    case 2:
                        index++;
                        moveAnimationTo((TextView) flWords.getChildAt(4), (TextView) llWordsContent.getChildAt(3));
                        break;
                }
                break;
        }
    }

    private void wordAnimation(final TextView word) {
        final ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(word, "alpha", 1.0f, 0f);
        objectAnimator.setDuration(2000);
        objectAnimator.start();
        objectAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                objectAnimator.cancel();
                word.setText(" ");
                word.setAlpha(1.0f);
                setBottomLine(word, true);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

    /**
     * 设置下划线显示、隐藏
     *
     * @param textView
     * @param open     开关
     */
    private void setBottomLine(TextView textView, boolean open) {
        if (open) {
            Drawable bootom = getResources().getDrawable(R.drawable.word_bottom_line);
            bootom.setBounds(0, 0, bootom.getMinimumWidth(), bootom.getMinimumHeight());
            textView.setCompoundDrawables(null, null, null, bootom);
        } else {
            textView.setCompoundDrawables(null, null, null, null);
        }
    }

    /**
     * 把单词移到底部
     */
    private void moveAnimation() {
        float dy = flWords.getHeight() / 2 - llWordsContent.getHeight();
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(llWordsContent, "translationY", 0f, dy);
        objectAnimator.setDuration(2000);
        objectAnimator.start();
    }

    /**
     * 把控件1 移动到控件 2的位置
     *
     * @param tvFrom
     * @param tvTo
     */
    private void moveAnimationTo(final TextView tvFrom, final TextView tvTo) {
        float dx = llWordsContent.getX() + tvTo.getX() - tvFrom.getX();
        float dy = llWordsContent.getY() + tvTo.getY() - tvFrom.getY();
        ObjectAnimator objX = ObjectAnimator.ofFloat(tvFrom, "translationX", 0f, dx);
        ObjectAnimator objY = ObjectAnimator.ofFloat(tvFrom, "translationY", 0f, dy);
        AnimatorSet set = new AnimatorSet();
        set.playTogether(objX, objY);
        set.setDuration(2000);
        set.start();
        set.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                tvTo.setText(tvFrom.getText().toString());
                tvFrom.setText("");
                setBottomLine(tvTo, false);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
}
