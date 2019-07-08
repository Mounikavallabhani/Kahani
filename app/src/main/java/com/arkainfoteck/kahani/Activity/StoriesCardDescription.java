package com.arkainfoteck.kahani.Activity;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPopupHelper;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListPopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.arkainfoteck.kahani.R;

public class StoriesCardDescription extends AppCompatActivity {

    ImageView morestories,tickstories,left_stories;
    TextView readtitle;
    boolean readStatus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stories_card_description);
        morestories = findViewById(R.id.more_stories);
        readtitle = findViewById(R.id.readtitle);
        readStatus=false;
        tickstories= findViewById(R.id.tickstories);
        left_stories = findViewById(R.id.left_stories);

        morestories.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onClick(View v) {
                String editoptions []={"Edit","Delete"};
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getBaseContext(),R.layout.listpopupwindow,editoptions);
                ListPopupWindow listPopupWindow = new ListPopupWindow(getBaseContext());
                listPopupWindow.setAdapter(arrayAdapter);
                listPopupWindow.setAnchorView(v);
                listPopupWindow.setModal(true);
                listPopupWindow.setHeight(300);
                listPopupWindow.setWidth(300);
                listPopupWindow.show();
            }
        });
        readtitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(readStatus==false){
                    tickstories.setImageResource(R.drawable.tick);
                    readStatus = true;
                }else if(readStatus== true){
                    tickstories.setImageResource(R.drawable.added);
                    readStatus = false;
                }
            }
        });
        left_stories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

}
