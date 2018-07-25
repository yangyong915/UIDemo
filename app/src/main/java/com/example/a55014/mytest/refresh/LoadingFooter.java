package com.example.a55014.mytest.refresh;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewStub;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.a55014.mytest.R;


/**
 * Created by cundong on 2015/10/9.
 * <p/>
 * ListView/GridView/RecyclerView 分页加载时使用到的FooterView
 */
public class LoadingFooter extends RelativeLayout {

    protected State mState = State.Normal;
    private View mLoadingView;
    private View mNetworkErrorView;
    private View mTheEndView;
    private View mNoDataView;
    private ProgressBar mLoadingProgress;
    private TextView mLoadingText;
    private TextView mEndText;
    private TextView mNoDataText;
    private TextView mNetworkText;

    public LoadingFooter(Context context) {
        super(context);
        init(context);
    }

    public LoadingFooter(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public LoadingFooter(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public void init(Context context) {

        inflate(context, R.layout.sample_common_list_footer, this);
        setOnClickListener(null);

        setState(State.Normal, true, "");
    }

    public State getState() {
        return mState;
    }

    public void setState(State status, String content) {
        setState(status, true, content);
    }

    /**
     * 设置状态
     *
     * @param status
     * @param showView 是否展示当前View
     */
    public void setState(State status, boolean showView, String content) {
        if (mState == status) {
            return;
        }
        mState = status;

        switch (status) {
            case Normal:
                setOnClickListener(null);
                if (mLoadingView != null) {
                    mLoadingView.setVisibility(GONE);
                }

                if (mTheEndView != null) {
                    mTheEndView.setVisibility(GONE);
                }

                if (mNetworkErrorView != null) {
                    mNetworkErrorView.setVisibility(GONE);
                }
                if (mNoDataView != null) {
                    mNoDataView.setVisibility(GONE);
                }
                break;
            case Loading:
                setOnClickListener(null);
                if (mTheEndView != null) {
                    mTheEndView.setVisibility(GONE);
                }

                if (mNetworkErrorView != null) {
                    mNetworkErrorView.setVisibility(GONE);
                }

                if (mLoadingView == null) {
                    ViewStub viewStub = (ViewStub) findViewById(R.id.loading_viewstub);
                    mLoadingView = viewStub.inflate();

                    mLoadingProgress = (ProgressBar) mLoadingView.findViewById(R.id.loading_progress);
                    mLoadingText = (TextView) mLoadingView.findViewById(R.id.loading_text);
                } else {
                    mLoadingView.setVisibility(VISIBLE);
                }
                if (mNoDataView != null) {
                    mNoDataView.setVisibility(GONE);
                }
                mLoadingView.setVisibility(showView ? VISIBLE : GONE);
                mLoadingProgress.setVisibility(View.VISIBLE);
                if (!TextUtils.isEmpty(content)) {
                    mLoadingText.setText(content);
                } else {
                    mLoadingText.setText("正在加载...");
                }
                break;
            case TheEnd:
                setOnClickListener(null);
                if (mLoadingView != null) {
                    mLoadingView.setVisibility(GONE);
                }

                if (mNetworkErrorView != null) {
                    mNetworkErrorView.setVisibility(GONE);
                }
                if (mNoDataView != null) {
                    mNoDataView.setVisibility(GONE);
                }
                if (mTheEndView == null) {
                    ViewStub viewStub = (ViewStub) findViewById(R.id.end_viewstub);
                    mTheEndView = viewStub.inflate();
                    mEndText = (TextView) mTheEndView.findViewById(R.id.end_text);
                } else {
                    mTheEndView.setVisibility(VISIBLE);
                }
                mTheEndView.setVisibility(showView ? VISIBLE : GONE);
                if (!TextUtils.isEmpty(content)) {
                    mEndText.setText(content);
                } else {
                    mEndText.setText("人家是有底线的哦~");
                }
                break;
            case NoData:
                setOnClickListener(null);
                if (mLoadingView != null) {
                    mLoadingView.setVisibility(GONE);
                }

                if (mNetworkErrorView != null) {
                    mNetworkErrorView.setVisibility(GONE);
                }
                if (mTheEndView != null) {
                    mTheEndView.setVisibility(GONE);
                }
                if (mNoDataView == null) {
                    ViewStub viewStub = (ViewStub) findViewById(R.id.nodata_viewstub);
                    mNoDataView = viewStub.inflate();

                    mNoDataText = (TextView) mNoDataView.findViewById(R.id.nodata_text);
                } else {
                    mNoDataView.setVisibility(VISIBLE);
                }

                mNoDataView.setVisibility(showView ? VISIBLE : GONE);
                if (!TextUtils.isEmpty(content)) {
                    mNoDataText.setText(content);
                } else {
                    mNoDataText.setText("没有相关数据");
                }
                break;
            case NetWorkError:
                if (mLoadingView != null) {
                    mLoadingView.setVisibility(GONE);
                }

                if (mTheEndView != null) {
                    mTheEndView.setVisibility(GONE);
                }
                if (mNoDataView != null) {
                    mNoDataView.setVisibility(GONE);
                }
                if (mNetworkErrorView == null) {
                    ViewStub viewStub = (ViewStub) findViewById(R.id.network_error_viewstub);
                    mNetworkErrorView = viewStub.inflate();
                    mNetworkText = (TextView) mNetworkErrorView.findViewById(R.id.network_text);
                } else {
                    mNetworkErrorView.setVisibility(VISIBLE);
                }

                mNetworkErrorView.setVisibility(showView ? VISIBLE : GONE);
                if (!TextUtils.isEmpty(content)) {
                    mNetworkText.setText(content);
                } else {
                    mNetworkText.setText("点击重新加载");
                }
                break;
            default:
                break;
        }
    }

    public enum State {
        Normal/**正常*/
        , TheEnd/**加载到最底了*/
        , Loading/**加载中..*/
        , NetWorkError/**网络异常*/
        , NoData/**没有数据*/
    }
}