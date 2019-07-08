package com.arkainfoteck.kahani.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.arkainfoteck.kahani.Adapter.LanguageAdapter;
import com.arkainfoteck.kahani.Model.LanguageModel;
import com.arkainfoteck.kahani.R;

import java.util.ArrayList;

public class LanguageSelection extends AppCompatActivity {
    RecyclerView recyclerView;
    GridLayoutManager gridLayoutManager;
    ArrayList<LanguageModel>languageModels;
    LanguageAdapter languageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language_selection);
        recyclerView=(RecyclerView)findViewById(R.id.language);
        gridLayoutManager=new GridLayoutManager(getApplicationContext(),3);
        recyclerView.setLayoutManager(gridLayoutManager);
        languageModels=new ArrayList<>();
        languageModels.add(new LanguageModel("TELUGU"));
        languageModels.add(new LanguageModel("ENGLISH"));
        languageModels.add(new LanguageModel("HINDI"));
        languageModels.add(new LanguageModel("TAMIL"));
        languageModels.add(new LanguageModel("TELUGU"));
        languageModels.add(new LanguageModel("TELUGU"));
        languageAdapter=new LanguageAdapter(getApplicationContext(),languageModels);
        recyclerView.setAdapter(languageAdapter);


    }
}
