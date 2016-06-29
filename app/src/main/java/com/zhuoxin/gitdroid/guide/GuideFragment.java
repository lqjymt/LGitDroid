package com.zhuoxin.gitdroid.guide;


import android.animation.ArgbEvaluator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.zhuoxin.gitdroid.R;
import com.zhuoxin.gitdroid.guide.pager.Pager2;

import butterknife.Bind;
import butterknife.BindColor;
import butterknife.ButterKnife;
import me.relex.circleindicator.CircleIndicator;

/**
 * Created by user on 2016/6/29.
 */
public class GuideFragment extends Fragment implements ViewPager.OnPageChangeListener {
    @Bind(R.id.viewPager)
    ViewPager viewPager;
    //三方指示器
    @Bind(R.id.indicator)
    CircleIndicator indicator;
    @Bind(R.id.content)
    FrameLayout fraglayout;
    @BindColor(R.color.colorGreen) int colorGreen;   // ViewPager页面对应背景色
    @BindColor(R.color.colorRed) int colorRed;  // ViewPager页面对应背景色
    @BindColor(R.color.colorYellow) int colorYellow;    // ViewPager页面对应背景色

    private  GuideAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_splash_pager, container, false);
        return inflate;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        //设置适配器
        adapter=new GuideAdapter(getContext());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(this);
        //将viewpager设置给指示器
        indicator.setViewPager(viewPager);
    }

    //估值器
    private ArgbEvaluator evalutor = new ArgbEvaluator();

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        if (position == 0) {
            int color = (int) evalutor.evaluate(positionOffset, colorGreen, colorRed);
           fraglayout.setBackgroundColor(color);
        }
        if (position == 1) {
            int color = (int) evalutor.evaluate(positionOffset, colorRed, colorYellow);
           fraglayout.setBackgroundColor(color);
        }
    }

    @Override
    public void onPageSelected(int position) {
        if (position==2) {
            Pager2 pager2= (Pager2) adapter.getView(position);
            pager2.showAnimator();

        }

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
