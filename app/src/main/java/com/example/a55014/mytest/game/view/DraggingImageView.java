package com.example.a55014.mytest.game.view;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.a55014.mytest.utils.LogUtil;


/**
 * @author yy
 * Create by 2019/10/18 10:59
 * to do 可拖动的ImageView
 */
@SuppressLint("AppCompatCustomView")
public class DraggingImageView extends ImageView {
    private int parentHeight;//悬浮的父布局高度
    private int parentWidth;

    private DIRECTION currentDirection = DIRECTION.RIGHT;

    public enum DIRECTION {
        LEFT,
        TOP,
        RIGHT,
        BOTTOM
    }

    public void setCurrentDirection(DIRECTION direction) {
    }

    public DraggingImageView(Context context) {
        super(context);
    }

    public DraggingImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DraggingImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private int lastX;
    private int lastY;

    private boolean isDrag;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int rawX = (int) event.getRawX();
        int rawY = (int) event.getRawY();
        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN:
                setPressed(true);
                isDrag = false;
                getParent().requestDisallowInterceptTouchEvent(true);
                lastX = rawX;
                lastY = rawY;
                ViewGroup parent;
                if (getParent() != null) {
                    parent = (ViewGroup) getParent();
                    parentHeight = parent.getHeight();
                    parentWidth = parent.getWidth();
                }
                break;
            case MotionEvent.ACTION_MOVE:
                isDrag = (parentHeight > 0 && parentWidth > 0);//只有父布局存在你才可以拖动
                if (!isDrag) break;

                int dx = rawX - lastX;
                int dy = rawY - lastY;
                //这里修复一些华为手机无法触发点击事件
                if (isHUAWEI()) {
                    int distance = (int) Math.sqrt(dx * dx + dy * dy);
                    isDrag = distance > 0;//只有位移大于0说明拖动了
                    if (!isDrag) break;
                } else {
                    isDrag = true;
                }

                float x = getX() + dx;
                float y = getY() + dy;
                //检测是否到达边缘 左上右下
                x = x < 0 ? 0 : x > parentWidth - getWidth() ? parentWidth - getWidth() : x;
                y = getY() < 0 ? 0 : getY() + getHeight() > parentHeight ? parentHeight - getHeight() : y;
                setX(x);
                setY(y);
                if (listener != null) {
                    listener.getLocation(x, y);
                }
                lastX = rawX;
                lastY = rawY;
                setViewDirection(dx, dy);
                break;
            case MotionEvent.ACTION_UP:
                //恢复按压效果
                setPressed(!isDrag);
                break;
            default:
                break;
        }
        //如果是拖拽则消s耗事件，否则正常传递即可。
//        return isDrag || super.onTouchEvent(event);
        return true;
    }

    private boolean isHUAWEI() {
        String manufacturer = Build.MANUFACTURER;
        //这个字符串可以自己定义,例如判断华为就填写huawei,魅族就填写meizu
        if ("huawei".equalsIgnoreCase(manufacturer)) {
            return true;
        }
        return false;
    }

    /**
     * 刷新view 的方向
     *
     * @param dx x 轴相对位置
     * @param dx y 轴相对位置
     */
    private void setViewDirection(float dx, float dy) {
        //防止是按下也判断
        if (Math.abs(dx) > 8 || Math.abs(dy) > 8) {
            //通过距离差判断方向
            DIRECTION toDirection = getOrientation(dx, dy);
            if (!currentDirection.equals(toDirection)) {
                float startAngle = getOrientation(currentDirection);
                float endAngle = getOrientation(toDirection);
                String action = "";
                switch (toDirection) {
                    case RIGHT:
                        action = "右";
                        break;
                    case LEFT:
                        action = "左";
                        break;
                    case TOP:
                        action = "上";
                        break;
                    case BOTTOM:
                        action = "下";
                        break;
                }
                rotateView(startAngle, endAngle);
                LogUtil.d("yy-----向" + action + "滑动startAngle:" + startAngle + "\tendAngle:" + endAngle);
                currentDirection = toDirection;
            }

        }
    }

    /**
     * 根据距离差判断 滑动方向
     *
     * @param dx X轴的距离差
     * @param dy Y轴的距离差
     * @return 滑动的方向
     */
    private DIRECTION getOrientation(float dx, float dy) {
        if (Math.abs(dx) > Math.abs(dy)) {
            //X轴移动
            return dx > 0 ? DIRECTION.RIGHT : DIRECTION.LEFT;
        } else {
            //Y轴移动
            return dy > 0 ? DIRECTION.BOTTOM : DIRECTION.TOP;
        }
    }

    /**
     * 将direction转换为度数
     *
     * @param direction
     * @return
     */
    private float getOrientation(DIRECTION direction) {
        float scale = 0;
        switch (direction) {
            case LEFT:
                scale = 180f;
                break;
            case TOP:
                scale = -90f;
                break;
            case RIGHT:
                scale = 0f;
                break;
            case BOTTOM:
                scale = 90f;
                break;
        }

        return scale;
    }

    /**
     * 旋转视图
     *
     * @param startAngle 角度 45f
     * @param startAngle 角度 45f
     */
    private void rotateView(float startAngle, float endAngle) {
        final ObjectAnimator anim = ObjectAnimator.ofFloat(this, "rotation", startAngle, endAngle);
        anim.setDuration(500);
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

    public interface LocationChangedListener {
        void getLocation(float dx, float dy);
    }

    private LocationChangedListener listener;

    public void setLocationChangedListener(LocationChangedListener locationChangedListener) {
        this.listener = locationChangedListener;
    }

}
