package com.arkainfoteck.kahani.Activity;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPopupHelper;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListPopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.arkainfoteck.kahani.Adapter.lifeEventTagAdapter;
import com.arkainfoteck.kahani.R;

import java.util.ArrayList;

public class LifeEventDescription extends AppCompatActivity {

    lifeEventTagAdapter lifeEventTagAdapter;
    ArrayList<String> tags;
    ImageView moreled,plusSymbol;
    TextView readtitle;
    RecyclerView recyclerView;
    Boolean readStatus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_event_description);
        recyclerView = findViewById(R.id.tagRecycler);
        readtitle = findViewById(R.id.ledreadtitle);
        plusSymbol = findViewById(R.id.plussymbolled);
        readStatus =false;
        moreled = findViewById(R.id.more_led);
        tags = new ArrayList<>();
        tags.add("jhgukghj");
        tags.add("hfgkjbkjbnj");
        tags.add("fhgfhjgvjhvbjhbjh");
        tags.add("hdhg");
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false));
        lifeEventTagAdapter = new lifeEventTagAdapter(getApplicationContext(),tags);
        recyclerView.setAdapter(lifeEventTagAdapter);
        readtitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(readStatus==false){
                    plusSymbol.setImageResource(R.drawable.tick);
                    readStatus = true;
                }else if(readStatus== true){
                    plusSymbol.setImageResource(R.drawable.added);
                    readStatus = false;
                }
            }
        });

        moreled.setOnClickListener(new View.OnClickListener() {
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
    }

}
