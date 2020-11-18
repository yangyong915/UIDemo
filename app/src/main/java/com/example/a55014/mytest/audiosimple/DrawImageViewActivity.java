package com.example.a55014.mytest.audiosimple;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.example.a55014.mytest.R;
import com.example.a55014.mytest.utils.DeviceUtils;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author yy
 * Create by 2019/7/15 11:41
 * to do
 */
public class DrawImageViewActivity extends AppCompatActivity {
    @BindView(R.id.surfaceView)
    SurfaceView surfaceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DeviceUtils.setCustomDensity(this, getApplication());
        setContentView(R.layout.activity_draw);
        ButterKnife.bind(this);

        initView();
    }

    private void initView() {
        surfaceView.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                if (surfaceHolder == null) return;

                Paint paint = new Paint();
                paint.setAntiAlias(true);
                paint.setStyle(Paint.Style.STROKE);
                Bitmap bitmap = BitmapFactory.decodeFile(getSDPath() + "/yy.jpg");
                Canvas canvas = surfaceHolder.lockCanvas();
                canvas.drawBitmap(bitmap, 0, 0, paint);
                bitmap.recycle();
                surfaceHolder.unlockCanvasAndPost(canvas);
            }

            @Override
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

            }
        });
    }
    /**
     * 取SD卡路径
     **/
    public static String getSDPath() {
        File sdDir = null;
        boolean sdCardExist = isSdCardExist();
        if (sdCardExist) {
            sdDir = Environment.getExternalStorageDirectory(); // 获取根目录
        }
        if (sdDir != null) {
            return sdDir.toString();
        } else {
            return "";
        }
    }
    /**
     * 判断sd卡是否存在
     **/
    public static boolean isSdCardExist() {
        return android.os.Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState());
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
