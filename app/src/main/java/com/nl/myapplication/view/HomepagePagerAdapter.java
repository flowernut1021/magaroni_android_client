package com.nl.myapplication.view;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by benzistanbul on 2015/11/8.
 */
public class HomepagePagerAdapter extends PagerAdapter {

    public static final int KEY_PUBLISH_REQUST = 0;

    private List<ImageView> imageViews;
    private List<Integer> imagePaths;
    private Activity currentActivity;
    private int imageNum;

    public HomepagePagerAdapter(List<ImageView> imageViews,
        List<Integer> imagePaths, Activity currentActivity, int imageNum) {
        this.imageViews = imageViews;
        this.imagePaths = imagePaths;
        this.currentActivity = currentActivity;
        this.imageNum = imageNum;
    }

    @Override
    public int getCount() {
        return imageNum;
    }

    @Override
    public Object instantiateItem(View arg0, final int position) {
        View view = imageViews.get(position);
        view.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // do nothing temporary
                /*Bundle bd = new Bundle();
                bd.putStringArrayList(ImageViewActivity.KEY_PHOTOLIST, imagePaths);
                bd.putInt(ImageViewActivity.KEY_CUURENT_POSITION, position);
                bd.putInt(ImageViewActivity.KEY_CONTROL_TYPE, ImageViewActivity.PUBLISH);
                bd.putSerializable(ImageViewActivity.KEY_IMAGE_RESOURCES,
                        (Serializable)imageResource);
                ActivityUtil.jump(currentActivity, ImageViewActivity.class, KEY_PUBLISH_REQUST, bd);*/
            }
        });
        if (imageViews.get(position).getParent() == null) {
            ((ViewPager) arg0).addView(imageViews.get(position));
        }
        return imageViews.get(position);
    }

    @Override
    public void destroyItem(View arg0, int arg1, Object arg2) {
        ((ViewPager) arg0).removeView((View) arg2);
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == arg1;
    }

    @Override
    public void restoreState(Parcelable arg0, ClassLoader arg1) {

    }

    @Override
    public Parcelable saveState() {
        return null;
    }

    @Override
    public void startUpdate(View arg0) {

    }

    @Override
    public void finishUpdate(View arg0) {

    }
}
