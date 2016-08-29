package com.zzz.white.demo_tabpage.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by wc on 2016/8/22.
 */
public class MyAdapter extends FragmentStatePagerAdapter {
    private String[] titleArray;
    private List<Fragment> fragmentList;

    public MyAdapter(FragmentManager ff , String[] titles, List<Fragment> fragments) {
        super(ff);
        this.titleArray = titles;
        this.fragmentList = fragments;
    }

    @Override public CharSequence getPageTitle(int position) {
        return titleArray[position];
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
