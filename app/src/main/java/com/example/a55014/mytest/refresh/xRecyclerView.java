package com.example.a55014.mytest.refresh;

import android.app.Activity;
import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.example.a55014.mytest.R;

import static com.example.a55014.mytest.refresh.LoadingFooter.State.Loading;
import static com.example.a55014.mytest.refresh.LoadingFooter.State.NoData;
import static com.example.a55014.mytest.refresh.LoadingFooter.State.TheEnd;

/**
 * @author: YangYong
 * @date: 2018/2/23 15:57
 * @desc: RecyclerView的扩展实现
 */
public class xRecyclerView extends LinearLayout {
    private MySwipeRefreshLayout refreshLayout;
    private RecyclerView recyclerView;
    private HeaderAndFooterRecyclerViewAdapter mHeaderAndFooterAdapter;
    private Activity activity;
    private boolean is_pullrefresh = true;
    private boolean isMore = true;

    public xRecyclerView(Context context) {
        super(context);
        initView(context);
    }

    public xRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public xRecyclerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.refresh_view_layout, this);
        refreshLayout = view.findViewById(R.id.refreshLayout);
        recyclerView = view.findViewById(R.id.recyclerView);
        addListener();
    }

    /**
     * 添加头部
     *
     * @param view
     */
    public void addHeader(final View view) {
        if (recyclerView != null) {
            RecyclerViewUtils.setHeaderView(recyclerView, view);
        }
    }

    /**
     * 添加尾部
     *
     * @param view
     */
    public void addFooter(View view) {
        if (recyclerView != null) {
            RecyclerViewUtils.setFooterView(recyclerView, view);
        }
    }

    /**
     * 设置是否下拉刷新
     *
     * @param b
     */
    public void setRefreshEnble(boolean b) {
        is_pullrefresh = b;
        refreshLayout.setEnabled(b);
    }

    /**
     * 设置是否加载更多
     *
     * @param enable
     */
    public void setLoadMoreEnable(boolean enable) {
        this.isMore = enable;
    }

    public void setAdapter(final Activity context, RecyclerView.Adapter mAdapter, RecyclerView.LayoutManager layoutManager) {
        this.activity = context;
        mHeaderAndFooterAdapter = new HeaderAndFooterRecyclerViewAdapter(mAdapter);
        recyclerView.setAdapter(mHeaderAndFooterAdapter);
        if (layoutManager instanceof LinearLayoutManager) {
            recyclerView.setLayoutManager(layoutManager);
        } else if (layoutManager instanceof ExStaggeredGridLayoutManager) {
            ExStaggeredGridLayoutManager manager = (ExStaggeredGridLayoutManager) layoutManager;
            manager.setSpanSizeLookup(new HeaderSpanSizeLookup((HeaderAndFooterRecyclerViewAdapter) recyclerView.getAdapter(), manager.getSpanCount()));
            recyclerView.setLayoutManager(manager);
        }

    }

    /**
     * 加载完成刷新
     *
     * @param state   Normal正常
     *                TheEnd加载到最底了
     *                Loading加载中..
     *                NetWorkError网络异常
     *                NoData没有数据
     * @param content 提示文字
     */
    public void refreshComplete(LoadingFooter.State state, String content) {
        //设置可下拉刷新
        if (is_pullrefresh) {
            refreshLayout.setEnabled(true);
            refreshLayout.setRefreshing(false);
        } else {
            refreshLayout.setEnabled(false);
            refreshLayout.setRefreshing(false);
        }
        RecyclerViewStateUtils.setFooterViewState(activity, recyclerView, 0, state, content, null);
    }

    private void addListener() {
        EndlessRecyclerOnScrollListener onScrollListener = new EndlessRecyclerOnScrollListener() {
            @Override
            public void onLoadNextPage(View view) {
                super.onLoadNextPage(view);
                if (isMore) {
                    LoadingFooter.State state = RecyclerViewStateUtils.getFooterViewState(recyclerView);
                    if (state == TheEnd || state == Loading || state == NoData) {
                        return;
                    }
                    //加载更多
                    RecyclerViewStateUtils.setFooterViewState(activity, recyclerView, 0, Loading, "", null);
                    if (onRefreshListener != null) {
                        refreshLayout.setEnabled(false);//不能下拉刷新
                        onRefreshListener.loadMore(recyclerView);
                    }
                }
            }

            @Override
            public void onScrollDistance(RecyclerView recyclerView, int distanceY) {
                super.onScrollDistance(recyclerView, distanceY);
                if (((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition() > 0) {
                    distanceY = distanceY + 2000;
                }
                if (onScrollRecyclerListener != null) {
                    onScrollRecyclerListener.onScrollDistance(recyclerView, distanceY);
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (onScrollRecyclerListener != null) {
                    onScrollRecyclerListener.onScrolled(recyclerView, dx, dy);
                }
            }
        };
        recyclerView.addOnScrollListener(onScrollListener);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (onRefreshListener != null) {
                    onRefreshListener.refresh(refreshLayout);
                }
                if (chartRefreshListener != null) {
                    // 普通刷新不用重写，聊天加载特供
                    chartRefreshListener.refresh(refreshLayout, recyclerView);
                }
            }
        });
    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public HeaderAndFooterRecyclerViewAdapter getAdapter() {
        return mHeaderAndFooterAdapter;
    }

    /**
     * 聊天加载接口
     */
    public interface ChartRefreshListener {
        void refresh(SwipeRefreshLayout refreshLayout, RecyclerView recyclerView);
    }

    private ChartRefreshListener chartRefreshListener;

    public void setchartRefreshListener(ChartRefreshListener chartRefreshListener) {
        this.chartRefreshListener = chartRefreshListener;
    }

    /**
     * 滚动监听接口
     */
    public interface OnScrollListener {
        void onScrollDistance(RecyclerView recyclerView, int distanceY);

        void onScrolled(RecyclerView recyclerView, int dx, int dy);
    }

    private OnScrollListener onScrollRecyclerListener;

    public void setOnScrollListener(OnScrollListener onScrollRecyclerListener) {
        this.onScrollRecyclerListener = onScrollRecyclerListener;
    }

    /**
     * 正常刷新接口
     */
    public interface OnRefreshListener {

        void refresh(SwipeRefreshLayout refreshLayout);

        void loadMore(RecyclerView recyclerView);

    }

    private OnRefreshListener onRefreshListener;

    public void setOnRefreshListener(OnRefreshListener onRefreshListener) {
        this.onRefreshListener = onRefreshListener;
    }
}
