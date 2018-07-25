package com.example.a55014.mytest.progress;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.a55014.mytest.R;
import com.example.a55014.mytest.utils.DeviceUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * crate by yy on 2018-1-18
 * describle:漂亮的进度条
 */
public class ProgressActivity extends AppCompatActivity {

    @BindView(R.id.progress_normal)
    MinProgressBar progressNormal;
    @BindView(R.id.progress_value)
    MyProgressBar progressValue;
    @BindView(R.id.progress_circle)
    ProgressCircleView progressCircle;
    @BindView(R.id.refresh)
    TextView refresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DeviceUtils.setCustomDensity(this, getApplication());
        setContentView(R.layout.activity_progress);
        ButterKnife.bind(this);

        progressNormal.setProgress(50);
        progressValue.setProgress(70);
        progressCircle.setValue(280);

    }

    @OnClick(R.id.refresh)
    public void onViewClicked() {
        progressNormal.setProgress(50);
        progressValue.setProgress(70);
        progressCircle.setCurrentValue();
        progressCircle.setValue(280);
    }
}
