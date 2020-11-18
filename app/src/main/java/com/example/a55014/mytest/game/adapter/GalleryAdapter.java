package com.example.a55014.mytest.game.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.example.a55014.mytest.R;
import com.example.a55014.mytest.baseadapter.CommonAdapter;
import com.example.a55014.mytest.baseadapter.ViewHolder;
import com.example.a55014.mytest.game.entiy.GalleryEntity;

import java.util.List;

/**
 * @author yy
 * Create by 2019/12/26 9:39
 * to do
 */
public class GalleryAdapter extends CommonAdapter<GalleryEntity> {
    public GalleryAdapter(Context context, int layoutId, List<GalleryEntity> datas) {
        super(context, layoutId, datas);
    }

    @Override
    protected void convert(ViewHolder holder, GalleryEntity galleryEntity, int position) {
        holder.setText(R.id.tv_word_bottom, galleryEntity.word);

        ImageView iv_light = holder.getView(R.id.iv_light);
        if (galleryEntity.isLight) {
            iv_light.setVisibility(View.VISIBLE);
        } else {
            iv_light.setVisibility(View.INVISIBLE);
        }

        ImageView iv_frame = holder.getView(R.id.iv_frame);
        ImageView iv_frame_light = holder.getView(R.id.iv_frame_light);
        ImageView iv_word_bg_light = holder.getView(R.id.iv_word_bg_light);
        if (galleryEntity.isOpen) {
            iv_frame.setVisibility(View.INVISIBLE);
            iv_frame_light.setVisibility(View.VISIBLE);
            iv_word_bg_light.setVisibility(View.VISIBLE);
        } else {
            iv_frame.setVisibility(View.VISIBLE);
            iv_frame_light.setVisibility(View.INVISIBLE);
            iv_word_bg_light.setVisibility(View.INVISIBLE);
        }
    }
}
