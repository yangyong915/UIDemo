package com.example.a55014.mytest.expand;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.a55014.mytest.R;


/**
 * @author yy
 * Create by 2019/7/23 16:41
 * to do  viewpager嵌套内部可折叠控件，解决滑动冲突
 */
public class BookAnimFragment extends Fragment {

    TextView tvContext;
    FoldTextView tvMove;
    TextView tvLabel;
    RelativeLayout rlMove;
    String title = "";

    public static BookAnimFragment getInstance(String title) {
        BookAnimFragment fragment = new BookAnimFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        fragment.setArguments(args);
        return fragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_book_anim, container, false);
        title = getArguments().getString("title");
        tvContext = (view).findViewById(R.id.tv_context);
        tvLabel = (view).findViewById(R.id.tv_label);
        tvMove = (view).findViewById(R.id.tv_move);
        rlMove = (view).findViewById(R.id.rl_move);
        tvContext.setText(title);
        tvLabel.setText(title + "作业讲评");
        tvMove.setParentView(rlMove);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
