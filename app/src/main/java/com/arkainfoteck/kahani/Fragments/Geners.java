package com.arkainfoteck.kahani.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arkainfoteck.kahani.Adapter.GenersAdapter;
import com.arkainfoteck.kahani.Model.GenersModel;
import com.arkainfoteck.kahani.R;

import java.util.ArrayList;

public class Geners extends Fragment {
    View view;
    RecyclerView geners;
    GridLayoutManager gridLayoutManager;
    GenersAdapter genersAdapter;
    ArrayList<GenersModel>genersModels;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       view=inflater.inflate(R.layout.fragment_geners,container,false);
       geners=view.findViewById(R.id.geners);
       gridLayoutManager=new GridLayoutManager(getActivity(),1);
       geners.setLayoutManager(gridLayoutManager);
       genersModels=new ArrayList<>();
       genersModels.add(new GenersModel(R.drawable.dammy,"love"));
        genersModels.add(new GenersModel(R.drawable.dammy,"love"));
        genersModels.add(new GenersModel(R.drawable.dammy,"love"));
        genersModels.add(new GenersModel(R.drawable.dammy,"love"));
        genersModels.add(new GenersModel(R.drawable.dammy,"love"));
        genersAdapter=new GenersAdapter(getActivity(),genersModels);
        geners.setAdapter(genersAdapter);

       return view;
    }
}
