package com.zhuoxin.gitdroid.guide;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.zhuoxin.gitdroid.guide.pager.Pager0;
import com.zhuoxin.gitdroid.guide.pager.Pager1;
import com.zhuoxin.gitdroid.guide.pager.Pager2;

/**
 * Created by user on 2016/6/29.
 */
public class GuideAdapter extends PagerAdapter {
 private  final  View[]  views;

    public GuideAdapter(Context context) {
       views=new View[]{new Pager0(context),new Pager1(context),new Pager2(context)};
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view=views[position];
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
         container.removeView(views[position]);
    }

    @Override
    public int getCount() {
        return views.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    public  View   getView(int position){
        if(position<views.length&&views!=null){

        return  views[position];
        }
        return  null;
    }
}
