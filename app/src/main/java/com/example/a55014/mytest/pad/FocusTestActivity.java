package com.example.a55014.mytest.pad;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.a55014.mytest.R;
import com.example.a55014.mytest.utils.DeviceUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author yy
 * Create by 2020/10/22 9:25
 * to do
 */
public class FocusTestActivity extends AppCompatActivity {
    @BindView(R.id.rb_teach_book) RadioButton rbTeachBook;
    @BindView(R.id.rb_teach_help) RadioButton rbTeachHelp;
    @BindView(R.id.rg_teach_group) RadioGroup rgTeachGroup;
    @BindView(R.id.rb_me) RadioButton rbMe;
    @BindView(R.id.rb_all) RadioButton rbAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DeviceUtils.setCustomDensity(this, getApplication());
        setContentView(R.layout.activity_focus);
        ButterKnife.bind(this);
        rbTeachBook.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked && rbTeachBook.hasFocus()) {
                    rbTeachBook.setBackgroundResource(R.drawable.teach_btn_focusable);
                    rbTeachBook.setTextColor(getResources().getColor(R.color.color_white));
                }
            }
        });
        rbTeachHelp.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked && rbTeachHelp.hasFocus()) {
                    rbTeachHelp.setBackgroundResource(R.drawable.teach_btn_focusable);
                    rbTeachHelp.setTextColor(getResources().getColor(R.color.color_white));
                }
            }
        });
    }
}
