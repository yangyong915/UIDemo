package com.example.a55014.mytest.expand;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

import com.example.a55014.mytest.utils.DeviceUtils;

/**
 * @author yy
 * Create by 2019/7/23 17:40
 * to do viewpager嵌套内部可折叠滑动控件，解决滑动冲突
 */
public class FoldTextView extends AppCompatTextView {
    /**
     * 触摸位置起点
     */
    private int starX;
    /**
     * 移动距离
     */
    private int moveX;
    /**
     * 上一次传递的moveX
     */
    float historyX = 0;
    /**
     * 中间过渡位置 控件展开初始位置为0
     */
    float tempX = 0;
    /**
     * 关闭位置 控件展开初始位置为0
     */
    float endX = 0;
    /**
     * 移动完成位置
     */
    float moveLocation = 0;
    RelativeLayout rlMove;

    public FoldTextView(Context context) {
        super(context);
        init(context);
    }

    public FoldTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public FoldTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        endX = DeviceUtils.dpToPixel(context, 100);
    }

    /**
     * 父容器，必须设置，不然动画无效
     *
     * @param parent
     */
    public void setParentView(RelativeLayout parent) {
        rlMove = parent;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                starX = (int) event.getRawX();
                break;
            case MotionEvent.ACTION_MOVE:
                moveX = (int) (event.getRawX() - starX);
                Log.d("yy--", "moveX:" + moveX);
                //移动同步
                startMoveAnim(moveX - historyX);
                historyX = moveX;
                break;
            case MotionEvent.ACTION_UP:
                historyX = 0;
                break;
            default:
                break;
        }

        return true;
    }

    private void startMoveAnim(float moveX) {
        if (rlMove == null) {
            return;
        }
        tempX = moveLocation; //上次的移动距离就是本次的初始点坐标
        if (moveX > 0) {
            moveLocation = moveX > (endX - tempX) ? endX : (tempX + moveX);
        } else {
            moveLocation = Math.abs(moveX) > tempX ? 0 : (tempX - Math.abs(moveX));
        }
        ObjectAnimator moveAnim = ObjectAnimator.ofFloat(rlMove, "translationX", tempX, moveLocation);
        moveAnim.setDuration(100);
        moveAnim.start();
    }
}
