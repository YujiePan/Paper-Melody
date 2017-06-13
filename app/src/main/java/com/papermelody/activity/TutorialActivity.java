package com.papermelody.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.papermelody.R;
import com.papermelody.widget.TutorialViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by HgS_1217_ on 2017/4/10.
 */

public class TutorialActivity extends BaseActivity implements ViewPager.OnPageChangeListener {
    /**
     * 用例：浏览教程
     * 教程页面，页面由ViewPager控制的4个layout页面组成，通过滑动来实现页面跳转；第一次进入应用时也会跳出此页面
     */

    @BindView(R.id.tutorial_viewpager)
    ViewPager viewPager;
    @BindView(R.id.tutorial_dots)
    LinearLayout layoutDots;


    private TutorialViewPagerAdapter viewPagerAdapter;
    private List<View> views;

    // 底部小点图片
    private ImageView[] dots;

    // 记录当前选中位置
    private int currentIndex;
    Boolean isFirst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initViews();
        initDots();
    }

    private void initViews() {

        SharedPreferences pref = getSharedPreferences("firstStart", Activity.MODE_PRIVATE);
        isFirst = pref.getBoolean("firstStart", true);

        if (!isFirst) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }

        LayoutInflater inflater = LayoutInflater.from(this);
        LinearLayout guideFour = (LinearLayout) inflater.inflate(R.layout.tutorial_four, null);
        guideFour.findViewById(R.id.btn_to_main).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = pref.edit();
                editor.putBoolean("firstStart", false);
                editor.apply();
                Intent intent = new Intent(TutorialActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        views = new ArrayList<>();
        // 初始化引导图片列表
        views.add(inflater.inflate(R.layout.tutorial_one, null));
        views.add(inflater.inflate(R.layout.tutorial_two, null));
        views.add(inflater.inflate(R.layout.tutorial_three, null));
        views.add(guideFour);
        // 初始化Adapter
        viewPagerAdapter = new TutorialViewPagerAdapter(views);

        viewPager.setAdapter(viewPagerAdapter);
        viewPager.addOnPageChangeListener(this);
    }

    private void initDots() {

        dots = new ImageView[views.size()];

        // 循环取得小点图片
        for (int i = 0; i < views.size(); i++) {
            dots[i] = (ImageView) layoutDots.getChildAt(i);
            dots[i].setImageDrawable(getDrawable(R.drawable.shape_cycle_indicator_unselected));// 都设为灰色
        }

        currentIndex = 0;
        dots[currentIndex].setImageDrawable(getDrawable(R.drawable.shape_cycle_indicator_selected));// 设置为白色，即选中状态
    }

    private void setCurrentDot(int position) {
        if (position < 0 || position > views.size() - 1
                || currentIndex == position) {
            return;
        }

        dots[position].setImageDrawable(getDrawable(R.drawable.shape_cycle_indicator_selected));
        dots[currentIndex].setImageDrawable(getDrawable(R.drawable.shape_cycle_indicator_unselected));

        currentIndex = position;
    }

    // 当滑动状态改变时调用
    @Override
    public void onPageScrollStateChanged(int arg0) {
    }

    // 当当前页面被滑动时调用
    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2) {
    }

    // 当新的页面被选中时调用
    @Override
    public void onPageSelected(int arg0) {
        // 设置底部小点选中状态
        setCurrentDot(arg0);
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_tutorial;
    }
}
