package com.zhuoxin.gitdroid.guide.pager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.zhuoxin.gitdroid.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by user on 2016/6/29.
 */
public class Pager2 extends FrameLayout {
    @Bind(R.id.ivBubble1)
    ImageView ivbuddle1;
    @Bind(R.id.ivBubble2)
    ImageView ivbuddle2;
    @Bind(R.id.ivBubble3)
    ImageView ivbuddle3;

    public Pager2(Context context) {
        super(context);
        init();
    }

    public Pager2(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Pager2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.content_pager_2, this, true);
        ButterKnife.bind(this);
        ivbuddle1.setVisibility(View.GONE);
        ivbuddle2.setVisibility(View.GONE);
        ivbuddle3.setVisibility(View.GONE);


    }

    public void showAnimator() {
        //imageview不可见状态才进行动画,  view.post()  yoyo动画左侧淡入
        if (ivbuddle1.getVisibility() != View.VISIBLE) {
            postDelayed(new Runnable() {
                @Override
                public void run() {
                    ivbuddle1.setVisibility(View.VISIBLE);
                    YoYo.with(Techniques.FadeInLeft).duration(300).playOn(ivbuddle1);
                }
            }, 50);
            postDelayed(new Runnable() {
                @Override
                public void run() {
                    ivbuddle2.setVisibility(View.VISIBLE);
                    YoYo.with(Techniques.FadeInLeft).duration(300).playOn(ivbuddle2);
                }
            }, 550);
            postDelayed(new Runnable() {
                @Override
                public void run() {
                    ivbuddle3.setVisibility(View.VISIBLE);
                    YoYo.with(Techniques.FadeInLeft).duration(300).playOn(ivbuddle3);
                }
            }, 1050);


        }

    }
}
