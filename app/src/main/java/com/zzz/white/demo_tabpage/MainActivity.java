package com.zzz.white.demo_tabpage;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.zzz.white.demo_tabpage.adapter.MyAdapter;

import java.util.ArrayList;
import java.util.List;
import static android.support.design.widget.TabLayout.MODE_SCROLLABLE;

public class MainActivity extends AppCompatActivity implements
        ViewPager.OnPageChangeListener
{

    private String[] titles = new String[]{"第1","第2","第3","第4"}; // TabLayout中的標籤標題
    private ViewPager viewPager;
    private List<Fragment> fragmentList;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private MyAdapter myAdapter; // ViewPager的分配器



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        initComponnent();
        initData();
    }


    private void initComponnent(){
        tabLayout = (TabLayout) findViewById(R.id.id_tablayout);
        viewPager = (ViewPager) findViewById(R.id.id_viewpager);
        toolbar = (Toolbar) findViewById(R.id.id_toolbar);
    }


    private void initData(){
        fragmentList = new ArrayList<>();
        for (int i = 0; i < titles.length; i++) { //將Fragment 填入ViewPager中
            Bundle bundle = new Bundle();
            bundle.putInt("idx", i);
            MyFragment myFmt = new MyFragment();
            myFmt.setArguments(bundle);
            fragmentList.add(i, myFmt);
        }

        // 初始化ViewPager分配器，Title, Fragment
        myAdapter = new MyAdapter(getSupportFragmentManager(), titles, fragmentList);
        viewPager.setAdapter(myAdapter);

        viewPager.setOffscreenPageLimit(10); // 設置ViewPager最大頁面個數
        viewPager.addOnPageChangeListener(this); // 設定Listener,切換頁面時,換title

        tabLayout.setTabMode(MODE_SCROLLABLE); //MODE_SCROLLABLE模式 :Tab標籤會無限滾
        tabLayout.setTabMode(TabLayout.MODE_FIXED); //MODE_FIXED模式 :Tab標籤會固定住


        tabLayout.setupWithViewPager(viewPager);
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        toolbar.setTitle(titles[position]); //切換頁面時,換title

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
