package com.example.a55014.mytest.game.view;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.a55014.mytest.R;
import com.example.a55014.mytest.baseadapter.MultiItemTypeAdapter;
import com.example.a55014.mytest.game.adapter.GalleryAdapter;
import com.example.a55014.mytest.game.entiy.GalleryEntity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author yy
 * Create by 2019/12/25 15:05
 * to do 艺术馆模型
 */
public class GalleryLayout extends FrameLayout {

    @BindView(R.id.tv_current_word) TextView tvCurrentWord;
    @BindView(R.id.ll_content) LinearLayout llContent;
    @BindView(R.id.rv_content) RecyclerView rvContent;
    @BindView(R.id.iv_boly) ImageView ivBoly;
    private Context mContext;
    private int currentPosition = 0;
    private GalleryAdapter galleryAdapter;
    private List<GalleryEntity> galleryEntityList;

    public GalleryLayout(@NonNull Context context) {
        super(context);
        initView(context);

    }

    public GalleryLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public GalleryLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public GalleryLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context);
    }

    private void initView(Context context) {
        mContext = context;
        View view = View.inflate(context, R.layout.gallery_layout, this);
        ButterKnife.bind(this, view);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        setLayoutParams(layoutParams);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rvContent.setLayoutManager(linearLayoutManager);

        initData();
    }

    private void initData() {
        if (galleryEntityList == null) {
            galleryEntityList = new ArrayList<>();
        }
        tvCurrentWord.setText("watch");
        for (int i = 0; i < 4; i++) {
            GalleryEntity galleryEntity = new GalleryEntity();
            galleryEntity.id = i;
            switch (i) {
                case 0:
                    galleryEntity.word = "watch";
                    break;
                case 1:
                    galleryEntity.word = "boy";
                    break;
                case 2:
                    galleryEntity.word = "girl";
                    break;
                case 3:
                    galleryEntity.word = "hello";
                    break;
            }

            galleryEntityList.add(galleryEntity);

            tvCurrentWord.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    float toX = ivBoly.getX() - tvCurrentWord.getX();
                    float toY = ivBoly.getY() - tvCurrentWord.getY();
                    TranslateAnimation animation = new TranslateAnimation(0, toX, 0, toY);
                    animation.setDuration(3000);
                    tvCurrentWord.startAnimation(animation);
                }
            });
        }

        galleryAdapter = new GalleryAdapter(mContext, R.layout.gallery_item_layout, galleryEntityList);
        rvContent.setAdapter(galleryAdapter);

        galleryAdapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
                if (galleryEntityList.size() > position) {
                    clearLight();
                    GalleryEntity entity = galleryEntityList.get(position);
                    if (entity.isOpen) {
                        entity.isOpen = false;
                    } else {
                        entity.isLight = true;
                        entity.isOpen = true;
                    }
                    galleryAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
                return false;
            }
        });
    }

    /**
     * 清空亮灯
     */
    private void clearLight() {
        for (int i = 0; i < galleryEntityList.size(); i++) {
            galleryEntityList.get(i).isLight = false;
        }
    }

}

