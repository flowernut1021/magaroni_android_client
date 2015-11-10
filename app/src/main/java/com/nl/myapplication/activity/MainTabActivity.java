package com.nl.myapplication.activity;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.nl.myapplication.R;
import com.nl.myapplication.tools.ViewUtil;
import com.nl.myapplication.view.TabTextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by benzistanbul on 2015/11/7.
 */
public class MainTabActivity extends BaseTitleActivity {

    @InjectView(R.id.activity_container)
    LinearLayout activityContainer;

    @InjectView(R.id.main_tab_layout)
    LinearLayout mainTabLayout;

    @InjectView(R.id.homepage_button)
    TabTextView homepageButton;

    @InjectView(R.id.order_button)
    TabTextView orderButton;

    @InjectView(R.id.mine_button)
    TabTextView mineButton;

    @InjectView(R.id.more_button)
    TabTextView moreButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_tab_activity);
        ButterKnife.inject(this);
        //setButtonSelected(homepageButton);
        homepageButton.performClick();
    }

    @Override
    protected void setTitleBar() {
        ViewUtil.setInvisible(leftTitleIcon);
        leftTitleText.setTextColor(getColorByResId(R.color.green_88));
        leftTitleText.setText("上海");
        middleTitleText.setText("middle title");
        rightTitleText.setText("联系我们");
        ViewUtil.setVisible(rightTitleLayout);
    }

    @OnClick({R.id.homepage_button, R.id.order_button, R.id.mine_button, R.id.more_button})
    protected void clickTab(TabTextView view) {
        setButtonSelected(view);
        loadActivity(HomepageActivity.class, activityContainer);
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
