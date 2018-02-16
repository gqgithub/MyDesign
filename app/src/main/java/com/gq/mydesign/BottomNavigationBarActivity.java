package com.gq.mydesign;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.gq.mydesign.fragment.HomeFragment;
import com.gq.mydesign.fragment.LikeFragment;
import com.gq.mydesign.fragment.LocationFragment;
import com.gq.mydesign.fragment.PersonFragment;

/**
 * 底部导航栏之--BottomNavigationBar
 * author:gangqiang
 */
public class BottomNavigationBarActivity extends AppCompatActivity implements BottomNavigationBar
        .OnTabSelectedListener {

    private HomeFragment mHomeFragment;
    private LikeFragment mLikeFragment;
    private LocationFragment mLocationFragment;
    private PersonFragment mPersonFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom);

        initBottomNavigationBar();

    }

    private void initBottomNavigationBar() {
        BottomNavigationBar bottomNavigationBar = (BottomNavigationBar) findViewById(R.id
                .bottom_navigation_bar);
        //1.设置导航栏模式：setMode（）Values：MODE_FIXED(没有水波纹效果), MODE_SHIFTING（有水波纹）
        bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        //2.设置导航栏背景模式：setBackgroundStyle（）BACKGROUND_STYLE_STATIC, BACKGROUND_STYLE_RIPPLE
        bottomNavigationBar.setBackgroundStyle(
                BottomNavigationBar.BACKGROUND_STYLE_RIPPLE);
        //3.设置BottomNavigationItem颜色  setActiveColor, setInActiveColor, setBarBackgroundColor Value: Color value or resource
        bottomNavigationBar
                .setBarBackgroundColor(R.color.white)//选中时字体颜色和图片颜色
                .setInActiveColor(R.color.white)//没选中时字体颜色和图片颜色
                .setActiveColor(R.color.hui);//bar的背景颜色


        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.home, "home"))
                .addItem(new BottomNavigationItem(R.drawable.location, "location"))
                .addItem(new BottomNavigationItem(R.drawable.like, "like"))
                .addItem(new BottomNavigationItem(R.drawable.person, "person"))
                .setFirstSelectedPosition(0)
                .initialise();
        //设置改变监听
        bottomNavigationBar.setTabSelectedListener(this);

        //设置默认fragment
        setDefaultFragment();

    }

    /** * 设置默认的 */
    private void setDefaultFragment() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.layFrame, new HomeFragment());
        transaction.commit();
    }


    @Override
    public void onTabSelected(int position) {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        switch (position) {
            case 0:
                if (mHomeFragment == null) {
                    mHomeFragment = HomeFragment.newInstance("home");
                }
                beginTransaction.replace(R.id.layFrame, mHomeFragment);
                break;
            case 1:
                if (mLocationFragment == null) {
                    mLocationFragment = LocationFragment.newInstance("location");
                }
                beginTransaction.replace(R.id.layFrame, mLocationFragment);
                break;
            case 2:
                if (mLikeFragment == null) {
                    mLikeFragment = LikeFragment.newInstance("like");
                }
                beginTransaction.replace(R.id.layFrame, mLikeFragment);
                break;
            case 3:
                if (mPersonFragment == null) {
                    mPersonFragment = PersonFragment.newInstance("person");
                }
                beginTransaction.replace(R.id.layFrame, mPersonFragment);
        }
        beginTransaction.commit();

    }

    @Override
    public void onTabUnselected(int position) {

    }


    @Override
    public void onTabReselected(int position) {

    }


}
