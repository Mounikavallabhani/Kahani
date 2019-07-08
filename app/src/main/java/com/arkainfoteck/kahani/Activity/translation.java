package com.arkainfoteck.kahani.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.arkainfoteck.kahani.Adapter.langTranslation;
import com.arkainfoteck.kahani.R;

import java.util.ArrayList;

public class translation extends AppCompatActivity {
    RecyclerView recyclerView;
    GridLayoutManager gridLayoutManager;
    ArrayList<String> languages;
    ArrayList<String> langinLocal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translation);
        recyclerView = findViewById(R.id.languagetranslation);
        languages = new ArrayList<>();
        langinLocal= new ArrayList<>();
        languages.add("telugu");
        languages.add("hindi");
        languages.add("Malyalam");
        languages.add("Tamil");
        languages.add("English");
        languages.add("Kannada");
        languages.add("bengali");
        langinLocal.add("తెలుగు");
        langinLocal.add("हिंदी");
        langinLocal.add("മലയാളം");
        langinLocal.add("தமிழ்");
        langinLocal.add("English");
        langinLocal.add("ಕನ್ನಡ");
        langinLocal.add("বাঙালি");

        langTranslation langTranslation = new langTranslation(getApplicationContext(),languages,langinLocal);
        gridLayoutManager = new GridLayoutManager(getApplicationContext(),2, GridLayoutManager.VERTICAL,false);

        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(langTranslation);


    }
}
