package com.example.a55014.mytest.refresh;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.a55014.mytest.R;
import com.example.a55014.mytest.refresh.xRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * crate by yy on 2018-2-23
 * describle:测试下拉刷新与上拉加载
 */
public class RefreshActivity extends AppCompatActivity implements xRecyclerView.OnRefreshListener {

    @BindView(R.id.xrecyclerView)
    xRecyclerView xrecyclerView;
    RecycleAdapter recycleAdapter;
    List<String> rankList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refresh);
        ButterKnife.bind(this);

        for (int i = 0; i < 20; i++) {
            rankList.add("正常内容" + i);
        }

        recycleAdapter = new RecycleAdapter(this, R.layout.energy_item, rankList);
        xrecyclerView.setAdapter(this, recycleAdapter, new LinearLayoutManager(this));
        xrecyclerView.setOnRefreshListener(this);
    }

    @Override
    public void refresh(SwipeRefreshLayout refreshLayout) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                rankList.clear();
                for (int i = 0; i < 20; i++) {
                    rankList.add(0, "下拉刷新" + i);
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        recycleAdapter.notifyDataSetChanged();
                        xrecyclerView.refreshComplete(LoadingFooter.State.Normal, "");
                    }
                });
            }
        }).start();

    }

    @Override
    public void loadMore(RecyclerView recyclerView) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (rankList.size() > 40) {
                            xrecyclerView.refreshComplete(LoadingFooter.State.TheEnd, "");
                        } else {
                            for (int i = 0; i < 5; i++) {
                                rankList.add("加载更多" + i);
                            }
                            recycleAdapter.notifyDataSetChanged();
                            xrecyclerView.refreshComplete(LoadingFooter.State.Normal, "");
                        }
                    }
                });
            }
        }).start();

    }
}
