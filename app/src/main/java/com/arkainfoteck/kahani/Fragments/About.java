package com.arkainfoteck.kahani.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.arkainfoteck.kahani.Adapter.aboutCommentsAdapter;
import com.arkainfoteck.kahani.R;

public class About extends Fragment {
    View view;
    RecyclerView recyclerView;
    aboutCommentsAdapter aboutCommentsAdapter;
    LinearLayoutManager linearLayoutManager ;
    EditText comment_about_page;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_about,container,false);
        comment_about_page = view.findViewById(R.id.comment_about_page);

        recyclerView = view.findViewById(R.id.recyclerAbout);
        linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        aboutCommentsAdapter = new aboutCommentsAdapter(getContext());
        recyclerView.setAdapter(aboutCommentsAdapter);

        return view;
    }
    
}
