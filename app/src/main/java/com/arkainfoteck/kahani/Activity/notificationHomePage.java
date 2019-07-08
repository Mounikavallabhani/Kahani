package com.arkainfoteck.kahani.Activity;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.arkainfoteck.kahani.Adapter.ViewPagerAdapter;
import com.arkainfoteck.kahani.Fragments.notificationTabOne;
import com.arkainfoteck.kahani.R;

import java.util.ArrayList;
import java.util.List;

public class notificationHomePage extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_home_page);



        tabLayout = findViewById(R.id.tabsnotification);
        viewPager = findViewById(R.id.notificationviewpager);
        tabLayout.setupWithViewPager(viewPager);
        setviewpagerdisplay();




    }

    public void setviewpagerdisplay(){
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new notificationTabOne(),"GENERAL");
        viewPagerAdapter.addFragment(new notificationTabOne(),"COMMUNITY");
        viewPagerAdapter.addFragment(new notificationTabOne(),"SUGGESTIONS");
        viewPager.setAdapter(viewPagerAdapter);
    }




    class ViewPagerAdapter extends FragmentPagerAdapter {
        private List<Fragment> fragmentArrayList = new ArrayList<>();
        private List<String> fragmentTitlelist = new ArrayList<>();

        @Override
        public Fragment getItem(int i) {
            return fragmentArrayList.get(i);
        }

        @Override
        public int getCount() {
            return fragmentArrayList.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return fragmentTitlelist.get(position);
        }
        public void addFragment(Fragment fragment, String title){
            fragmentArrayList.add(fragment);
            fragmentTitlelist.add(title);
        }

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }
    }

}

