package com.example.a55014.mytest.game.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.a55014.mytest.R;

import butterknife.ButterKnife;

/**
 * 卡牌游戏模型
 */
public class CardGameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_game);
        ButterKnife.bind(this);

    }


}
