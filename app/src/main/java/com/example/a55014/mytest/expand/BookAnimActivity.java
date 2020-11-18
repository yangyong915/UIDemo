package com.example.a55014.mytest.expand;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;

import com.example.a55014.mytest.R;
import com.example.a55014.mytest.utils.DeviceUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author yy
 * Create by 2019/7/23 15:12
 * to do 绘本页面动画
 */
public class BookAnimActivity extends AppCompatActivity {
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    private TabFragmentPagerAdapter adapter;
    private List<Fragment> fragments=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DeviceUtils.setCustomDensity(this, getApplication());
        setContentView(R.layout.activity_book);
        ButterKnife.bind(this);

        initPager();

    }

    private void initPager() {
        fragments.add(BookAnimFragment.getInstance("第一页"));
        fragments.add(BookAnimFragment.getInstance("第二页"));
        fragments.add(BookAnimFragment.getInstance("第三页"));
        fragments.add(BookAnimFragment.getInstance("第四页"));
        adapter = new TabFragmentPagerAdapter(getSupportFragmentManager(), fragments);
        viewpager.setAdapter(adapter);
        viewpager.setCurrentItem(1);
    }



    public class TabFragmentPagerAdapter extends FragmentPagerAdapter {
        private FragmentManager mfragmentManager;
        private List<Fragment> mlist;


        public TabFragmentPagerAdapter(FragmentManager fm, List<Fragment> list) {
            super(fm);
            this.mlist = list;
        }

        @Override
        public void setPrimaryItem(ViewGroup container, int position, Object object) {
            super.setPrimaryItem(container, position, object);
        }

        @Override
        public Fragment getItem(int arg0) {
            return mlist.get(arg0);//显示第几个页面
        }

        @Override
        public int getCount() {
            return mlist.size();//有几个页面
        }
    }

}
