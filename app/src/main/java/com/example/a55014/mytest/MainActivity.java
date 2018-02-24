package com.example.a55014.mytest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.a55014.mytest.expand.ExpandActivity;
import com.example.a55014.mytest.progress.ProgressActivity;
import com.example.a55014.mytest.refresh.RefreshActivity;
import com.example.a55014.mytest.water.WaterActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * crate by yy on 2018-1-18
 * describle:UI特效集合管理器
 */
public class MainActivity extends AppCompatActivity {


    @BindView(R.id.water_tv)
    TextView waterTv;
    @BindView(R.id.expand_tv)
    TextView expandTv;
    @BindView(R.id.progress_tv)
    TextView progressTv;
    @BindView(R.id.refresh_layout)
    TextView refreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @OnClick({R.id.water_tv, R.id.expand_tv, R.id.progress_tv, R.id.refresh_layout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.water_tv:
                startActivity(new Intent(this, WaterActivity.class));
                break;
            case R.id.expand_tv:
                startActivity(new Intent(this, ExpandActivity.class));
                break;
            case R.id.progress_tv:
                startActivity(new Intent(this, ProgressActivity.class));
                break;
            case R.id.refresh_layout:
                startActivity(new Intent(this, RefreshActivity.class));
                break;
        }
    }
}
