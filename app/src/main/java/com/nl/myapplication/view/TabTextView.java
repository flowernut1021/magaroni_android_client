package com.nl.myapplication.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import com.nl.myapplication.R;

/**
 * Created by benzistanbul on 2015/11/10.
 */
public class TabTextView extends TextView {

    private Context context;

    public TabTextView(Context context) {
        this(context, null);
    }

    public TabTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TabTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
    }

    public void setTabSelected() {
        this.setSelected(true);
        this.setTextColor(context.getResources().getColor(R.color.green_88));
    }

    public void setTabUnselected() {
        this.setSelected(false);
        this.setTextColor(context.getResources().getColor(R.color.text_color));
    }
}
