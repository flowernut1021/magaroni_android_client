package com.nl.myapplication.activity;

import android.app.Activity;
import android.app.ActivityGroup;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.nl.myapplication.R;
import com.nl.myapplication.tools.ActivityJumper;

/**
 * Created by benzistanbul on 2015/11/1.
 */
public class BaseActivity extends ActivityGroup {

    protected ActivityJumper getActivityJumper() {
        return ActivityJumper.of(this);
    }

    protected void jumpTo(Class<? extends Activity> targetClass) {
        getActivityJumper().to(targetClass).jump();
    }

    protected void loadActivity(Class<? extends Activity> clazz, ViewGroup viewGroup) {
        Intent intent = new Intent();
        intent.setFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
        intent.setClass(getApplicationContext(), clazz);
        Window win = getLocalActivityManager().startActivity(clazz.getSimpleName(), intent);
        View root = win.getDecorView();
        root.setBackgroundColor(getResources().getColor(R.color.theme_color));
        viewGroup.removeAllViews();
        viewGroup.addView(root, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
    }
}
