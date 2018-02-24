package com.example.a55014.mytest.refresh;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.example.a55014.mytest.R;
import com.example.a55014.mytest.baseadapter.CommonAdapter;
import com.example.a55014.mytest.baseadapter.ViewHolder;

import java.util.List;

/**
 * Created by yy on 2018/2/23.
 * 描述：
 */

public class RecycleAdapter extends CommonAdapter<String> {
    public RecycleAdapter(Context context, int layoutId, List<String> datas) {
        super(context, layoutId, datas);
    }

    @Override
    protected void convert(ViewHolder holder, String s, int position) {
        holder.setText(R.id.name, s);
        holder.setImageResource(R.id.head, R.mipmap.headportrait);
    }
}
