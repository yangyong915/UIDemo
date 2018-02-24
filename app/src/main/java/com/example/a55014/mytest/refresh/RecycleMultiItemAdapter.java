package com.example.a55014.mytest.refresh;

import android.content.Context;

import com.example.a55014.mytest.baseadapter.ItemViewDelegate;
import com.example.a55014.mytest.baseadapter.MultiItemTypeAdapter;
import com.example.a55014.mytest.baseadapter.ViewHolder;

import java.util.List;

/**
 * Created by yy on 2018/2/24.
 * 描述：
 */

public class RecycleMultiItemAdapter extends MultiItemTypeAdapter<String> {
    public RecycleMultiItemAdapter(Context context, List datas) {
        super(context, datas);
        addItemViewDelegate(new Item1Delegate());
        addItemViewDelegate(new Item2Delegate());
    }

    public class Item1Delegate implements ItemViewDelegate<String> {

        @Override
        public int getItemViewLayoutId() {
            return 0;
        }

        @Override
        public boolean isForViewType(String item, int position) {
            return false;
        }

        @Override
        public void convert(ViewHolder holder, String s, int position) {

        }
    }

    public class Item2Delegate implements ItemViewDelegate<String> {

        @Override
        public int getItemViewLayoutId() {
            return 0;
        }

        @Override
        public boolean isForViewType(String item, int position) {
            return false;
        }

        @Override
        public void convert(ViewHolder holder, String s, int position) {

        }
    }
}
