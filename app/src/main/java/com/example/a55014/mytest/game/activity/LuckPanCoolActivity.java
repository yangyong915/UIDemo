package com.example.a55014.mytest.game.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.a55014.mytest.R;
import com.example.a55014.mytest.game.view.LuckPanCoolLayout;
import com.example.a55014.mytest.game.view.RotatePan;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LuckPanCoolActivity extends AppCompatActivity {

    @BindView(R.id.rotatePan) RotatePan rotatePan;
    @BindView(R.id.go) ImageView go;
    @BindView(R.id.luckpan_layout) LuckPanCoolLayout luckpanCoolLayout;
    private String[] strs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luck_pan_cool);
        ButterKnife.bind(this);
        strs = getResources().getStringArray(R.array.names);
        luckpanCoolLayout.setAnimationEndListener(new LuckPanCoolLayout.AnimationEndListener() {
            @Override
            public void endAnimation(int position) {
                Toast.makeText(LuckPanCoolActivity.this, "Position = " + position + "," + strs[position], Toast.LENGTH_SHORT).show();
            }
        });
    }

    @OnClick({R.id.rotatePan, R.id.go, R.id.tv_luck_simple})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rotatePan:
                break;
            case R.id.go:
                luckpanCoolLayout.rotate(-1, 100);
                break;
            case R.id.tv_luck_simple:
                startActivity(new Intent(this, LuckPanActivity.class));
                break;
        }
    }
}
