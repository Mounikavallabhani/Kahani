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
import android.widget.LinearLayout;
import android.widget.TextView;

import com.arkainfoteck.kahani.Adapter.CommunityPostAdapter;
import com.arkainfoteck.kahani.Model.CommunityPostModel;
import com.arkainfoteck.kahani.R;

import java.util.ArrayList;

public class CommunityPost extends Fragment {
    View view;
    LinearLayout linear_links,linear_quotes,linear_text;
    LinearLayout linear_links_data,linear_quotes_data,linear_text_data;
    TextView text_links,text_quotes,text_text;
    RecyclerView communitypost;
    GridLayoutManager gridLayoutManager;
    CommunityPostAdapter communityPostAdapter;
    ArrayList<CommunityPostModel>communityPostModels;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_communitypost,container,false);
        communitypost=view.findViewById(R.id.communitypost);
        gridLayoutManager=new GridLayoutManager(getActivity(),1);
        communitypost.setLayoutManager(gridLayoutManager);
        communityPostModels=new ArrayList<>();
        communityPostModels.add(new CommunityPostModel("mounika","1 day ago"));
        communityPostModels.add(new CommunityPostModel("mounika","1 day ago"));
        communityPostModels.add(new CommunityPostModel("mounika","1 day ago"));
        communityPostModels.add(new CommunityPostModel("mounika","1 day ago"));

        communityPostAdapter=new CommunityPostAdapter(getActivity(),communityPostModels);
        communitypost.setAdapter(communityPostAdapter);

        linear_links=(LinearLayout)view.findViewById(R.id.liner_links);
        linear_quotes=(LinearLayout)view.findViewById(R.id.liner_quotes);
        linear_text=(LinearLayout)view.findViewById(R.id.liner_text);

        // content visuble data
        linear_links_data=(LinearLayout)view.findViewById(R.id.linear_links_data);
        linear_quotes_data=(LinearLayout)view.findViewById(R.id.linear_quotes_data);
        linear_text_data=(LinearLayout)view.findViewById(R.id.linear_text_data);

        text_links=(TextView) view.findViewById(R.id.text_links);
        text_quotes=(TextView) view.findViewById(R.id.text_quotes);
        text_text=(TextView) view.findViewById(R.id.text_text);

        linear_links.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                text_links.setTextColor(getResources().getColor(R.color.button2));// @color/button2
                text_text.setTextColor(getResources().getColor(R.color.black));// @color/button2
                text_quotes.setTextColor(getResources().getColor(R.color.black));// @color/button2

                linear_links_data.setVisibility(View.VISIBLE);
                linear_quotes_data.setVisibility(View.GONE);
                linear_text_data.setVisibility(View.GONE);

            }
        });
        linear_quotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                text_quotes.setTextColor(getResources().getColor(R.color.button2));// @color/button2
                text_text.setTextColor(getResources().getColor(R.color.black));// @color/button2
                text_links.setTextColor(getResources().getColor(R.color.black));// @color/button2

                linear_links_data.setVisibility(View.GONE);
                linear_quotes_data.setVisibility(View.VISIBLE);
                linear_text_data.setVisibility(View.GONE);

            }
        });
        linear_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_text.setTextColor(getResources().getColor(R.color.button2));// @color/button2
                text_links.setTextColor(getResources().getColor(R.color.black));// @color/button2
                text_quotes.setTextColor(getResources().getColor(R.color.black));// @color/button2

                linear_links_data.setVisibility(View.GONE);
                linear_quotes_data.setVisibility(View.GONE);
                linear_text_data.setVisibility(View.VISIBLE);

            }
        });

        return view;

    }
}
