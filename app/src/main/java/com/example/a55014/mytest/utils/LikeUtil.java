package com.example.a55014.mytest.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.example.a55014.mytest.R;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 *
 */

public class LikeUtil {

    /**
     * 显示点赞动画
     *
     * @param locationView 需要定位的view，动画将显示在其左下方
     * @param xOffset      x轴的偏移量
     * @param yOffset      y轴的偏移量
     */
    public static void showLike(View locationView, int xOffset, int yOffset) {
        if (locationView == null) {
            return;
        }
        Context context = locationView.getContext();
        if (!(context instanceof Activity)) {
            return;
        }
        //1.获取Activity最外层的DecorView
        Activity activity = (Activity) context;
        View decorView = activity.getWindow().getDecorView();
        FrameLayout frameLayout = null;
        if (decorView != null && decorView instanceof FrameLayout) {
            frameLayout = (FrameLayout) decorView;
        }
        if (frameLayout == null) {
            return;
        }
        //2.通过getLocationInWindow 获取需要显示的位置
        final ImageView likeView = new ImageView(context);
        //注意不能使用warp_content 在实际的代码运行中。高度会比GIF的高度高。因此这里直接使用GIF的大小作为ImageView的大小
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(172, 219);
        int[] outLocation = new int[2];
        locationView.getLocationInWindow(outLocation);
        // 80 和 100 是一点点测试出来的。不同的需求可以自己测出需要的偏移量
        layoutParams.leftMargin = outLocation[0] + xOffset - 80;
        layoutParams.topMargin = outLocation[1] + yOffset - 100;
        layoutParams.gravity = Gravity.LEFT | Gravity.TOP;
        likeView.setLayoutParams(layoutParams);
        frameLayout.addView(likeView);

        //3.创建消失动画
        final Animation dismissAnimation = new AlphaAnimation(1.0f, 0.0f);
        dismissAnimation.setDuration(500);
        dismissAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                ViewGroup parent = (ViewGroup) likeView.getParent();
                if (parent != null) {
                    parent.removeView(likeView);
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        //4.监听GIF消失事件
        loadOneTimeGif(context, R.mipmap.agree, likeView, new GifListener() {
            @Override
            public void gifPlayComplete() {
                likeView.post(new Runnable() {
                    @Override
                    public void run() {
                        int[] location = new int[2];
                        likeView.getLocationOnScreen(location);

                        likeView.startAnimation(dismissAnimation);
                    }
                });
            }
        });


    }
    public static void showNormalGif(Context context,ImageView gifView){

    }

    @SuppressLint("CheckResult")
    public static void loadOneTimeGif(Context context, Object model, final ImageView imageView, final GifListener gifListener) {
        RequestOptions option = new RequestOptions();
        //关闭缓存，在连续播放多个相同的Gif时，会出现第二个Gif是从最后一帧开始播放的。
        option.diskCacheStrategy(DiskCacheStrategy.NONE);
        option.skipMemoryCache(true);
        Glide.with(context).asGif().load(model).apply(option).listener(new RequestListener<GifDrawable>() {
            @Override
            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<GifDrawable> target, boolean isFirstResource) {
                return false;
            }

            @Override
            public boolean onResourceReady(GifDrawable resource, Object model, Target<GifDrawable> target, com.bumptech.glide.load.DataSource dataSource, boolean isFirstResource) {
                try {
                    Field gifStateField = GifDrawable.class.getDeclaredField("state");
                    gifStateField.setAccessible(true);
                    Class gifStateClass = Class.forName("com.bumptech.glide.load.resource.gif.GifDrawable$GifState");
                    Field gifFrameLoaderField = gifStateClass.getDeclaredField("frameLoader");
                    gifFrameLoaderField.setAccessible(true);
                    Class gifFrameLoaderClass = Class.forName("com.bumptech.glide.load.resource.gif.GifFrameLoader");
                    Field gifDecoderField = gifFrameLoaderClass.getDeclaredField("gifDecoder");
                    gifDecoderField.setAccessible(true);
                    Class gifDecoderClass = Class.forName("com.bumptech.glide.gifdecoder.GifDecoder");
                    Object gifDecoder = gifDecoderField.get(gifFrameLoaderField.get(gifStateField.get(resource)));
                    Method getDelayMethod = gifDecoderClass.getDeclaredMethod("getDelay", int.class);
                    getDelayMethod.setAccessible(true);
                    //设置只播放一次
                    resource.setLoopCount(1);
                    //获得总帧数
                    int count = resource.getFrameCount();
                    int delay = 0;
                    for (int i = 0; i < count; i++) {
                        //计算每一帧所需要的时间进行累加
                        delay += (int) getDelayMethod.invoke(gifDecoder, i);
                    }
                    imageView.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if (gifListener != null) {
                                gifListener.gifPlayComplete();
                            }
                        }
                    }, delay);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return false;
            }
        }).into(imageView);
    }

    /**
     * Gif播放完毕回调
     */
    public interface GifListener {
        void gifPlayComplete();
    }
}
