package com.arkainfoteck.kahani.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.arkainfoteck.kahani.Activity.notificationHomePage;
import com.arkainfoteck.kahani.Activity.translation;
import com.arkainfoteck.kahani.R;

import java.util.ArrayList;
import java.util.List;

public class Home extends Fragment {
    View view;
    ViewPager viewPager;
    TabLayout tabLayout;
    Toolbar toolbar;
    LinearLayout searchlinearlayout;
    ImageView bell_home,translate;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.home_fragnment, container, false);
        searchlinearlayout=view.findViewById(R.id.searchlinearlayout);
        bell_home =view.findViewById(R.id.bell_home);
        translate= view.findViewById(R.id.translate);
        translate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), translation.class);
                startActivity(intent);
            }
        });
        bell_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), notificationHomePage.class);
                startActivity(intent);

            }
        });
        searchlinearlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

        viewPager = (ViewPager)view.findViewById(R.id.viewpager);

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
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        adapter.addFragment(new StoriesReplacement(), "STORIES");
        adapter.addFragment(new StoriesReplacement(), "SERIES");
        adapter.addFragment(new StoriesReplacement(), "LIFE EVENTS");
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
