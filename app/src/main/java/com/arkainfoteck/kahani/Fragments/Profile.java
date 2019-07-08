package com.arkainfoteck.kahani.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout.OnTabSelectedListener;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arkainfoteck.kahani.R;

import java.util.ArrayList;
import java.util.List;

public class Profile extends Fragment {
    View view;
    ViewPager viewPager;
    TabLayout tabLayout;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       view=inflater.inflate(R.layout.fragment_profile,container,false);
        viewPager = (ViewPager)view.findViewById(R.id.profileViewpager);

        setupViewPager(viewPager);


        tabLayout = (TabLayout)view.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);



        // get position value
        int score = getActivity().getIntent().getIntExtra("value", 0);


        // set fragment perticular position
        viewPager.setCurrentItem(score);
        return view;
    }
    private void setupViewPager(ViewPager viewPager) {
        Profile.ViewPagerAdapter adapter = new Profile.ViewPagerAdapter(getChildFragmentManager());
        adapter.addFragment(new About(), "ABOUT");
        adapter.addFragment(new Content(), "CONTENTS");
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
            System.out.println(mFragmentList.get(position).toString()+"pagename");
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
