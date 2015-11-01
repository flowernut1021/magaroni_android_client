package com.nl.myapplication.activity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.nl.myapplication.R;
import com.nl.myapplication.tools.UnitUtil;
import com.nl.myapplication.tools.ViewUtil;

/**
 * Created by benzistanbul on 2015/11/1.
 */
public class BaseTitleActivity extends BaseActivity {

    protected LinearLayout contextView;

    protected RelativeLayout titleLayout;
    protected LinearLayout mainContentLayout;
    protected LinearLayout leftTitleLayout;
    protected LinearLayout middleTitleLayout;
    protected LinearLayout rightTitleLayout;
    protected ImageView leftTitleIcon;
    protected ImageView rightTitleIcon;
    protected TextView leftTitleText;
    protected TextView rightTitleText;
    protected TextView middleTitleText;
    protected View lineBelowTitleBar;

    private int rightButtonTextDefaultColor = 0;
    private int leftButtonTextDefaultColor = 0;

    private static final String EMPTY_PLACE_HOLDER = "　　";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contextView = (LinearLayout)View.inflate(this, R.layout.titled_base_activity, null);
        super.setContentView(contextView);

        titleLayout = (RelativeLayout)findViewById(R.id.lib_title_layout);
        mainContentLayout =
                (LinearLayout)findViewById(R.id.lib_title_main_content_layout);
        leftTitleLayout = (LinearLayout)findViewById(R.id.lib_title_left_layout);
        middleTitleLayout = (LinearLayout)findViewById(R.id.lib_title_middle_layout);
        rightTitleLayout = (LinearLayout)findViewById(R.id.lib_title_right_layout);

        leftTitleIcon = (ImageView)findViewById(R.id.lib_title_left_icon);
        rightTitleIcon = (ImageView)findViewById(R.id.lib_title_right_icon);
        leftTitleText = (TextView)findViewById(R.id.lib_title_left_text);
        rightTitleText = (TextView)findViewById(R.id.lib_title_right_text);
        middleTitleText = (TextView)findViewById(R.id.lib_title_middle_text);

        lineBelowTitleBar = findViewById(R.id.lib_title_line);

        rightTitleLayout.setVisibility(View.INVISIBLE);
        rightTitleIcon.setVisibility(View.GONE);
        setMiddleTitleText(EMPTY_PLACE_HOLDER);

        setTitleBar();
    }

    protected void setTitleBar() {

    }

    @Override
    public void setContentView(int layoutResID) {
        this.setContentView(View.inflate(this, layoutResID, null), null);
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        mainContentLayout.addView(view, new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
    }

    @Override
    public void setContentView(View view) {
        this.setContentView(view, null);
    }

    public void makeLeftButtonToIconButton(int iconResId) {
        makeTitleButtonToIconButton(leftTitleLayout, leftTitleText,
                leftTitleIcon, iconResId);
    }

    public void makeRightButtonToIconButton(int iconResId) {
        makeTitleButtonToIconButton(rightTitleLayout, rightTitleText,
                rightTitleIcon, iconResId);
    }

    private void makeTitleButtonToIconButton(ViewGroup theLayout, TextView theText, View theButton,
                                             int iconResId) {
        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams)theButton.getLayoutParams();
        lp.height = UnitUtil.dip2px(40);
        lp.width = UnitUtil.dip2px(40);
        lp.leftMargin = 0;
        theText.setVisibility(View.GONE);
        theLayout.setVisibility(View.VISIBLE);
        theButton.setVisibility(View.VISIBLE);
        theButton.setBackgroundResource(iconResId);
        theButton.setLayoutParams(lp);
        int top = theLayout.getPaddingTop();
        int bottom = theLayout.getPaddingBottom();
        int left = 0;
        int right = 0;
        theLayout.setPadding(left, top, right, bottom);
    }

    protected View makeRightButtonToView(int viewResId) {
        return ViewUtil.changeViewGroupContent(rightTitleLayout, viewResId);
    }

    public void setRightButtonEnabled(boolean enabled) {
        if(rightButtonTextDefaultColor == 0) {
            rightButtonTextDefaultColor = rightTitleText.getTextColors().getDefaultColor();
        }
        //
        int color = rightButtonTextDefaultColor;
        if(!enabled) {
            color = getResources().getColor(R.color.text_hint);
        }
        rightTitleText.setTextColor(color);
        rightTitleLayout.setClickable(enabled);
        rightTitleIcon.setBackgroundResource(enabled
                ? R.mipmap.right_blue_arrow
                : R.mipmap.right_gray_arrow);
    }

    public void setLeftButtonEnabled(boolean enabled) {
        if(leftButtonTextDefaultColor == 0) {
            leftButtonTextDefaultColor = leftTitleText.getTextColors().getDefaultColor();
        }
        //
        int color = getColorByResId(R.color.text_color);
        if(!enabled) {
            color = getColorByResId(R.color.text_hint);
        }
        leftTitleText.setTextColor(color);
        leftTitleLayout.setClickable(enabled);
        leftTitleIcon.setBackgroundResource(enabled
                ? R.mipmap.right_blue_arrow
                : R.mipmap.right_gray_arrow);
    }

    protected int getColorByResId(int resId) {
        return getResources().getColor(resId);
    }

    protected void hideLeftTitle() {
        ViewUtil.setInvisible(leftTitleLayout);
    }

    protected void hideMiddleTitle() {
        ViewUtil.setInvisible(middleTitleLayout);
    }

    protected void hideRightTitle() {
        ViewUtil.setInvisible(rightTitleLayout);
    }

    protected void showLeftTitle() {
        ViewUtil.setVisible(leftTitleLayout);
    }

    protected void showMiddleTitle() {
        ViewUtil.setVisible(middleTitleLayout);
    }

    protected void showRightTitle() {
        ViewUtil.setVisible(rightTitleLayout);
    }

    protected void setMiddleTitleText(int resId) {
        middleTitleText.setText(resId);
    }

    protected void setMiddleTitleText(String text) {
        middleTitleText.setText(text);
    }
}
