package com.example.a55014.mytest.expand;

import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a55014.mytest.R;
import com.example.a55014.mytest.expand.library.GetWordTextView;
import com.example.a55014.mytest.utils.DeviceUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author yy
 * Create by 2019/7/24 11:45
 * to do 取词
 */
public class BookGetWordActivity extends AppCompatActivity {
    @BindView(R.id.english_get_word_text_view)
    GetWordTextView englishGetWordTextView;
    @BindView(R.id.parent)
    RelativeLayout parent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DeviceUtils.setCustomDensity(this, getApplication());
        setContentView(R.layout.activity_get_word);
        ButterKnife.bind(this);
        englishGetWordTextView.setText("\"Oh, yes,\" she said, \"would you please show me how to use the TV?\"Oh, yes," +
                "\" she said, \"would you please show me how to use the TV? 我要去学校，你要和我一起去吗？ 去清华哈是北大");
        englishGetWordTextView.setOnWordClickListener(new GetWordTextView.OnWordClickListener() {
            @Override
            public void onClick(String word, int dx, int dy) {
                showPopWindow(word, dx, dy);
            }
        });
    }

    private void showPopWindow(String word, int dx, int dy) {
        View popup_view = getLayoutInflater().inflate(R.layout.pop_copy, null);
        TextView pop_text = (popup_view).findViewById(R.id.pop_text);
        pop_text.setText("获取内容：" + word);
        PopupWindow popupWindow = new PopupWindow(popup_view, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setOutsideTouchable(true);// 点击其他区域popupwindow消失，上面一句必不可少
        popupWindow.showAtLocation(parent, Gravity.LEFT | Gravity.TOP, dx,
                dy+(int)DeviceUtils.dpToPixel(BookGetWordActivity.this, 10));
    }

    Toast toast;

    public void showToast(String msg) {
        if (toast == null) {
            toast = Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT);
        }
        toast.setText(msg);
        toast.show();
    }
}
