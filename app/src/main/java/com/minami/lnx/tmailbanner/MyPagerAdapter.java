package com.minami.lnx.tmailbanner;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by lnx on 2018/4/4.
 */

public class MyPagerAdapter extends FragmentPagerAdapter {


    private List<Fragment> fragmentList ;
    public MyPagerAdapter(FragmentManager fm , List<Fragment> fragmentList) {
        super(fm);
        this.fragmentList =fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }


}
