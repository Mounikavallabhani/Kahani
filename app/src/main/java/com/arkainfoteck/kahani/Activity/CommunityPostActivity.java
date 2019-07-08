package com.arkainfoteck.kahani.Activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.arkainfoteck.kahani.Fragments.CommunityAbout;
import com.arkainfoteck.kahani.Fragments.CommunityPost;
import com.arkainfoteck.kahani.Fragments.CommunityTopPost;
import com.arkainfoteck.kahani.Fragments.Updates;
import com.arkainfoteck.kahani.Fragments.Writers;
import com.arkainfoteck.kahani.R;

import java.util.ArrayList;
import java.util.List;

public class CommunityPostActivity extends AppCompatActivity {
    ViewPager viewPager;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community_post);
        viewPager = (ViewPager)findViewById(R.id.communityviewpager);

        setupViewPager(viewPager);

        tabLayout = (TabLayout)findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);


        // get position value
       // int score = getApplicationContext().getIntent().getIntExtra("value", 0);

        // set fragment perticular position
       // viewPager.setCurrentItem(score);
    }
    private void setupViewPager(ViewPager viewPager) {
        CommunityPostActivity.ViewPagerAdapter adapter = new CommunityPostActivity.ViewPagerAdapter(CommunityPostActivity.this.getSupportFragmentManager());
        adapter.addFragment(new CommunityAbout(), "ABOUT");
        adapter.addFragment(new CommunityPost(), "POST");
        adapter.addFragment(new CommunityTopPost(),"TOP POST");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
    }

