package com.example.a55014.mytest.game.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.a55014.mytest.R;

import butterknife.ButterKnife;

/**
 * 小鸭子模型
 */
public class DarkActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dark);
        ButterKnife.bind(this);

    }


}
