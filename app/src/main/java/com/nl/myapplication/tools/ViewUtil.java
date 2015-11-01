package com.nl.myapplication.tools;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.nl.myapplication.application.BaseApplication;

import java.util.Timer;
import java.util.TimerTask;


public class ViewUtil {

    private static Context context = BaseApplication.getContext();

    public static void preventViewMultipleClick(final View v, int protectionMilliseconds) {
        v.setClickable(false);
        Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                v.setClickable(true);
            }
        }, protectionMilliseconds);

    }

    public static void setInvisible(final View... views) {
        for (View view : views) {
            view.setVisibility(View.INVISIBLE);
        }
    }

    public static void setInvisible(final View view) {
        view.setVisibility(View.INVISIBLE);
    }

    public static boolean isVisible(View view) {
        return view.getVisibility() == View.VISIBLE;
    }

    public static void setVisible(View view) {
        view.setVisibility(View.VISIBLE);
    }

    public static void setGone(View view) {
        view.setVisibility(View.GONE);
    }

    public static View changeViewGroupContent(ViewGroup targetView, int viewResId) {
        targetView.removeAllViews();
        View insertView = View.inflate(context, viewResId, null);
        RelativeLayout.LayoutParams params =
                new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT);
        targetView.addView(insertView, params);
        return insertView;
    }

}
