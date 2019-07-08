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

import com.arkainfoteck.kahani.Adapter.CommunityPostAdapter;
import com.arkainfoteck.kahani.Model.CommunityPostModel;
import com.arkainfoteck.kahani.R;

import java.util.ArrayList;

public class YourPost extends Fragment{

 View view;
    RecyclerView yourpost;
    GridLayoutManager gridLayoutManager;
    CommunityPostAdapter communityPostAdapter;
    ArrayList<CommunityPostModel> communityPostModels;
@Nullable
@Override
public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    view = inflater.inflate(R.layout.fragment_yourpost, container, false);
    yourpost=view.findViewById(R.id.yourpost);
    gridLayoutManager=new GridLayoutManager(getActivity(),1);
    yourpost.setLayoutManager(gridLayoutManager);
    communityPostModels=new ArrayList<>();
    communityPostModels.add(new CommunityPostModel("mounika","1 day ago"));
    communityPostModels.add(new CommunityPostModel("mounika","1 day ago"));
    communityPostModels.add(new CommunityPostModel("mounika","1 day ago"));
    communityPostModels.add(new CommunityPostModel("mounika","1 day ago"));

    communityPostAdapter=new CommunityPostAdapter(getActivity(),communityPostModels);
    yourpost.setAdapter(communityPostAdapter);
    return view;
}

}
