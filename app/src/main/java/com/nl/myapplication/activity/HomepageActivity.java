package com.nl.myapplication.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.common.collect.Lists;
import com.nl.myapplication.R;
import com.nl.myapplication.tools.UnitUtil;
import com.nl.myapplication.view.HomepagePagerAdapter;
import com.nl.myapplication.view.InfinitePagerAdapter;
import com.nl.myapplication.view.InfiniteViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by benzistanbul on 2015/11/7.
 */
public class HomepageActivity extends BaseActivity {

    @InjectView(R.id.image_view_pager)
    FrameLayout imageViewPager;

    @InjectView(R.id.view_pager)
    InfiniteViewPager viewPager;

    @InjectView(R.id.dots_layout)
    protected LinearLayout dotsLayout;

    protected PagerAdapter photoAdapter;
    protected int imageNum;
    protected List<ImageView> imageViews;
    protected List<View> dots = new ArrayList<>();
    protected int currentItem = 0;
    protected List<Integer> imagePaths = new ArrayList<>();
    protected List<Integer> pictureIds;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage_activity);
        ButterKnife.inject(this);
        pictureIds = Lists.newArrayList(R.mipmap.homepage_pic1, R.mipmap.homepage_pic2, R.mipmap.homepage_pic3, R.mipmap.homepage_pic4);
        setPagerImage(pictureIds, this);
    }

    protected void setPagerImage(List<Integer> pictureIds, Activity currentActivity) {
        imageViews = new ArrayList<>();
        dots.clear();
        dotsLayout.removeAllViews();
        imageNum = pictureIds.size();

        imagePaths.clear();
        for(int i = 0; i < pictureIds.size(); i++) {
            View view =
                    LayoutInflater.from(this).inflate(R.layout.viewpager_dots, null);
            ImageView imageView = new ImageView(this);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setImageResource(pictureIds.get(i));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageViews.add(imageView);
            dots.add(view);
            LinearLayout.LayoutParams lp =
                    new LinearLayout.LayoutParams(UnitUtil.dip2px(5), UnitUtil.dip2px(5));
            lp.setMargins(UnitUtil.dip2px(3), UnitUtil.dip2px(10), UnitUtil.dip2px(3),
                    UnitUtil.dip2px(10));
            dotsLayout.addView(view, lp);
            imagePaths.add(pictureIds.get(i));
        }

        photoAdapter = new InfinitePagerAdapter(new HomepagePagerAdapter(imageViews, imagePaths, currentActivity, imageNum));
        viewPager.setAdapter(photoAdapter);
        viewPager.setOnPageChangeListener(new MyPageChangeListener());

        viewPager.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });
    }

    class MyPageChangeListener implements ViewPager.OnPageChangeListener {
        private int oldPosition = 0;

        public void onPageSelected(int position) {
            int pos = ((InfinitePagerAdapter)photoAdapter).getVirtualPosition(position);
            currentItem = pos;
            dots.get(oldPosition).setBackgroundResource(R.drawable.dot_normal);
            dots.get(currentItem).setBackgroundResource(R.drawable.dot_focused);
            oldPosition = pos;
        }

        public void onPageScrollStateChanged(int arg0) {
            viewPager.getParent().requestDisallowInterceptTouchEvent(true);
        }

        public void onPageScrolled(int arg0, float arg1, int arg2) {}
    }
}
