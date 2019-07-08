package com.arkainfoteck.kahani.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arkainfoteck.kahani.Adapter.WriteAdapter;
import com.arkainfoteck.kahani.Adapter.draftAdapter;
import com.arkainfoteck.kahani.Model.DraftModel;
import com.arkainfoteck.kahani.Model.WriteModel;
import com.arkainfoteck.kahani.R;

import java.util.ArrayList;


public class Drafts extends Fragment {
    RecyclerView recyclerView;
    GridLayoutManager gridLayoutManager;
     draftAdapter draftAdapter;
    ArrayList<DraftModel> DraftModels;


    public Drafts() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_drafts, container, false);
        recyclerView = view.findViewById(R.id.draftecyclerview);
        gridLayoutManager = new GridLayoutManager(getActivity(),1);
        recyclerView.setLayoutManager(gridLayoutManager);
        DraftModels = new ArrayList<>();
        DraftModels.add(new DraftModel("Hello", "ding  dong ding ding  dong ding ding  dong ding ding  dong dingding  dong dingding  dong ding"));
        DraftModels.add(new DraftModel("Hello", "ding  dong ding ding  dong ding ding  dong ding ding  dong dingding  dong dingding  dong ding"));
        DraftModels.add(new DraftModel("Hello", "ding  dong ding ding  dong ding ding  dong ding ding  dong dingding  dong dingding  dong ding"));
        DraftModels.add(new DraftModel("Hello", "ding  dong ding ding  dong ding ding  dong ding ding  dong dingding  dong dingding  dong ding"));
        DraftModels.add(new DraftModel("Hello", "ding  dong ding ding  dong ding ding  dong ding ding  dong dingding  dong dingding  dong ding"));
        draftAdapter = new draftAdapter(getContext(),DraftModels);
        recyclerView.setAdapter(draftAdapter);
        return view;
    }

}
