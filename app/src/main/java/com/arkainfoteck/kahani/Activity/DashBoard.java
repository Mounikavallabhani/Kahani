package com.arkainfoteck.kahani.Activity;

import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;

import com.arkainfoteck.kahani.Fragments.Content;
import com.arkainfoteck.kahani.Fragments.Geners;
import com.arkainfoteck.kahani.Fragments.Home;
import com.arkainfoteck.kahani.Fragments.Library;
import com.arkainfoteck.kahani.Fragments.Profile;
import com.arkainfoteck.kahani.Fragments.Updates;
import com.arkainfoteck.kahani.R;

public class DashBoard extends AppCompatActivity {
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            System.out.println(item+" id of bottom activity");

            Fragment fragment=null;
            switch (item.getItemId()) {
                case R.id.navigation_store:

                    fragment=new Home();
                    break;

                case R.id.navigation_delivary:

                    fragment=new Geners();
                    break;

                case R.id.navigation_wallet:

                    fragment=new Library();
                    break;
                case R.id.navigation_delivary1:

                    fragment=new Updates();
                    break;
                case R.id.navigation_wallet1:
                    fragment=new Profile();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).commit();
            return true;
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,new Home()).commit();
    }
}
