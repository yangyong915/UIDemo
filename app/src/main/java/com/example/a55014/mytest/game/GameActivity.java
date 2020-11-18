package com.example.a55014.mytest.game;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.a55014.mytest.R;
import com.example.a55014.mytest.game.activity.CardGameActivity;
import com.example.a55014.mytest.game.activity.DarkActivity;
import com.example.a55014.mytest.game.activity.GalleryActivity;
import com.example.a55014.mytest.game.activity.LuckPanActivity;
import com.example.a55014.mytest.game.activity.RankActivity;
import com.example.a55014.mytest.game.view.LinePicView;
import com.example.a55014.mytest.utils.DeviceUtils;
import com.example.a55014.mytest.utils.LogUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GameActivity extends AppCompatActivity {

    @BindView(R.id.tv_cards_game) TextView tvCardsGame;
    @BindView(R.id.tv_luck_pan) TextView tvLuckPan;
    @BindView(R.id.ll_content) LinearLayout llContent;
    @BindView(R.id.pic_view) LinePicView picView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        ButterKnife.bind(this);


        llContent.postDelayed(new Runnable() {
            @Override
            public void run() {
                LogUtil.d("yy---moveDy:" + llContent.getHeight() + "\tx:" + llContent.getX() + "\ty:" + llContent.getY());

                float moveDy = llContent.getHeight();
                long time = 5000;
                //比率
                float scale = 0.1f;
                ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(llContent, "translationY", 0, -scale * moveDy);
                objectAnimator.setDuration((long) (scale * time));
                objectAnimator.setInterpolator(new AccelerateInterpolator());
                ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(llContent, "translationY", -scale * moveDy,
                        -moveDy);
                objectAnimator1.setDuration((long) ((1 - scale) * time));
                objectAnimator1.setInterpolator(new LinearInterpolator());
                objectAnimator1.start();
                AnimatorSet set = new AnimatorSet();
                set.play(objectAnimator1).after(objectAnimator);
                set.start();
            }
        }, 1000);

        String temp1 = "I am happy.\n it is a dark";
        LogUtil.d("yy---result before:" + temp1);

        String[] result = splitSentence(temp1);

        LogUtil.d("yy---result:1" + result[0] + "\t 2:" + result[1] + "\t lenth:" + result.length);
    }

    /**
     * 根据\n把句子拆分成问句和答句
     *
     * @param sentence
     * @return
     */
    public static String[] splitSentence(String sentence) {
        return sentence.split("\n");

//        StringTokenizer st = new StringTokenizer(sentence, " \\n");
//        List<String> wordList = new ArrayList<>();
//        while (st.hasMoreElements()) {
//            wordList.add(st.nextToken().toLowerCase());
//        }
//
//        return wordList;
    }

    @OnClick({R.id.tv_cards_game, R.id.tv_luck_pan, R.id.tv_dark, R.id.tv_gallery, R.id.tv_rank, R.id.tv_car})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_dark:
                startActivity(new Intent(this, DarkActivity.class));
                break;
            case R.id.tv_cards_game:
                startActivity(new Intent(this, CardGameActivity.class));
                break;
            case R.id.tv_luck_pan:
                startActivity(new Intent(this, LuckPanActivity.class));
                break;
            case R.id.tv_gallery:
                startActivity(new Intent(this, GalleryActivity.class));
                break;
            case R.id.tv_rank:
                startActivity(new Intent(this, RankActivity.class));
                break;
            case R.id.tv_car:
//                startActivity(new Intent(this, CarActivity.class));
                int point1 = DeviceUtils.dip2px(this, 50);
                int point2 = DeviceUtils.dip2px(this, 200);
                clickTime = clickTime + 1;
                picView.setPoint(point1, point1, point2 + clickTime * 20, point2+ clickTime * 20);
                break;
        }
    }

    int clickTime = 0;
}
