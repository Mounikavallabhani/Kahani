package com.arkainfoteck.kahani.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.arkainfoteck.kahani.Model.EpisodeModel;
import com.arkainfoteck.kahani.R;

import java.util.ArrayList;

public class EpisodeAdapter extends RecyclerView.Adapter<EpisodeAdapter.ViewHolder> {
    View view;
    Context context;
    ArrayList<EpisodeModel>episodeModels;

    public EpisodeAdapter(Context context, ArrayList<EpisodeModel> episodeModels) {
        this.context = context;
        this.episodeModels = episodeModels;
    }

    @NonNull
    @Override
    public EpisodeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        view=layoutInflater.inflate(R.layout.episodeadapter,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EpisodeAdapter.ViewHolder viewHolder, int i) {
        EpisodeModel episodeModel=episodeModels.get(i);
        viewHolder.heading.setText(episodeModel.getEpisodename());


    }

    @Override
    public int getItemCount() {
        return episodeModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView heading;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            heading=itemView.findViewById(R.id.heading);
        }
    }
}
