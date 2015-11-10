package com.nl.myapplication.activity;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.nl.myapplication.R;
import com.nl.myapplication.view.TabTextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by benzistanbul on 2015/11/10.
 */
public class PostpartumRehabilitationActivity extends BaseTitleActivity {

    @InjectView(R.id.main_tab_layout)
    LinearLayout mainTabLayout;

    @InjectView(R.id.item_text)
    TabTextView itemText;

    @InjectView(R.id.technician_text)
    TabTextView technicianText;

    @InjectView(R.id.activity_container)
    LinearLayout activityContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.postpartum_rehablilitation_activity);
        ButterKnife.inject(this);
        itemText.performClick();
    }

    @OnClick({R.id.item_text, R.id.technician_text})
    protected void clickTab(TabTextView view) {
        setButtonSelected(view);
        //loadActivity(HomepageActivity.class, activityContainer);
    }

    private void setButtonSelected(TabTextView view) {
        int count = mainTabLayout.getChildCount();
        for(int i = 0; i < count; i++) {
            TabTextView tabButton = (TabTextView)((RelativeLayout)mainTabLayout.getChildAt(i)).getChildAt(0);
            tabButton.setTabUnselected();
        }
        view.setTabSelected();
    }
}
