package com.arkainfoteck.kahani.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.arkainfoteck.kahani.Activity.MainActivity;
import com.arkainfoteck.kahani.R;

import java.util.ArrayList;

public class lifeEventTagAdapter extends RecyclerView.Adapter<lifeEventTagAdapter.ViewHolder>  {
    private Context context;
    private ArrayList<String>  tagList;

    public lifeEventTagAdapter(Context context, ArrayList<String> tagList) {
        this.context = context;
        this.tagList = tagList;
    }

    @NonNull
    @Override
    public lifeEventTagAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.life_event_tag,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull lifeEventTagAdapter.ViewHolder viewHolder, int i) {
        String tagname= tagList.get(i);
        viewHolder.tag.setText(tagname);
    }

    @Override
    public int getItemCount() {
        return tagList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tag;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tag = itemView.findViewById(R.id.tag);
        }
    }
}
