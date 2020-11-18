package com.example.a55014.mytest.bottomsheet;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a55014.mytest.R;

import java.util.List;

/**
 * @Version:
 * @Author:Guoy
 * @CreateTime:2017/6/1
 * @Descrpiton:
 */
public class BottomDialogAdapter extends RecyclerView.Adapter {
    private List<String> mList;
    private LayoutInflater mInflater;
    private Context mContext;

    public BottomDialogAdapter(Context context, List list) {
        mInflater = LayoutInflater.from(context);
        mList = list;
        mContext = context;
    }

    // 获取条目数量
    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_sample, parent, false);
        return new NormalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        NormalViewHolder vh = (NormalViewHolder) holder;
        vh.text.setText("条目:" + position);
        vh.text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, position + "被点击", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private class NormalViewHolder extends RecyclerView.ViewHolder {
        public TextView text;

        public NormalViewHolder(View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.item_textview);
        }
    }

}
