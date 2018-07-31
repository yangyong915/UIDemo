package com.example.a55014.mytest.selectcity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.a55014.mytest.R;
import com.example.a55014.mytest.refresh.xRecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A-Z 字母索引列表
 */
public class SelectCityActivity extends AppCompatActivity {

    @BindView(R.id.dialog)
    TextView dialog;
    @BindView(R.id.sidebar)
    SideBar sidebar;
    @BindView(R.id.mRecyclerView)
    xRecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_city);
        ButterKnife.bind(this);

        initView();
        initListener();
    }

    private void initView() {
        sidebar.setTextView(dialog);
    }

    private void initListener() {
    }
}
