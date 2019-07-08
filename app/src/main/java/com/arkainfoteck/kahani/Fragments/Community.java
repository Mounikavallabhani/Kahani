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

import com.arkainfoteck.kahani.Adapter.CommunityAdapter;
import com.arkainfoteck.kahani.Model.CommunityModel;
import com.arkainfoteck.kahani.R;

import java.util.ArrayList;

public class Community extends Fragment {
    RecyclerView community;
    CommunityAdapter communityAdapter;
    ArrayList<CommunityModel> communityModels;
    GridLayoutManager gridLayoutManager;
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_coomunity, container, false);

           community=view.findViewById(R.id.idcommunity);
        gridLayoutManager=new GridLayoutManager(getActivity(),2);
        community.setLayoutManager(gridLayoutManager);
        communityModels=new ArrayList<>();
        communityModels.add(new CommunityModel(R.drawable.communityimage,"mounika"));
        communityModels.add(new CommunityModel(R.drawable.communityimage,"mounika"));
        communityModels.add(new CommunityModel(R.drawable.communityimage,"mounika"));
        communityModels.add(new CommunityModel(R.drawable.communityimage,"mounika"));
        communityModels.add(new CommunityModel(R.drawable.communityimage,"mounika"));
        communityModels.add(new CommunityModel(R.drawable.communityimage,"mounika"));
        communityAdapter=new CommunityAdapter(getActivity(),communityModels);
        community.setAdapter(communityAdapter);
        return view;
    }
}
