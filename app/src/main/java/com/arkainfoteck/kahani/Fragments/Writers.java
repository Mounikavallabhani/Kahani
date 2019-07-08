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

import com.arkainfoteck.kahani.Adapter.WriteAdapter;
import com.arkainfoteck.kahani.Model.WriteModel;
import com.arkainfoteck.kahani.R;

import java.util.ArrayList;

public class Writers extends Fragment {
    RecyclerView recyclerView;
    GridLayoutManager gridLayoutManager;
    WriteAdapter writeAdapter;
    ArrayList<WriteModel> writeModels;
    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_writers, container, false);
        recyclerView=view.findViewById(R.id.writerecyclerview);
        gridLayoutManager=new GridLayoutManager(getActivity(),1);
        recyclerView.setLayoutManager(gridLayoutManager);
        writeModels=new ArrayList<>();
        writeModels.add(new WriteModel("SERIES"));
        writeModels.add(new WriteModel("STORY"));
        writeModels.add(new WriteModel("NANO STORY"));
        writeModels.add(new WriteModel("LIFE EVENTS"));
        writeAdapter=new WriteAdapter(getActivity(),writeModels);
        recyclerView.setAdapter(writeAdapter);

        return view;
    }
}
