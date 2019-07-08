package com.arkainfoteck.kahani.Adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.arkainfoteck.kahani.Model.TopSeries;
import com.arkainfoteck.kahani.R;

import java.util.ArrayList;

public class TopStoriesAdapter extends RecyclerView.Adapter<TopStoriesAdapter.ViewHolder> {
    Context context;
    ArrayList<TopSeries>topSeries;
    View view;
    AlertDialog.Builder alert;
    AlertDialog dialog;


    public TopStoriesAdapter(Context context, ArrayList<TopSeries> topSeries) {
        this.context = context;
        this.topSeries = topSeries;
    }

    @NonNull
    @Override
    public TopStoriesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        view=layoutInflater.inflate(R.layout.topstories,viewGroup,false);
        return new ViewHolder(view,context,topSeries);

    }

    @Override
    public void onBindViewHolder(@NonNull final TopStoriesAdapter.ViewHolder viewHolder, int i) {
        TopSeries topSeries1=topSeries.get(i);
        viewHolder.topstoriesimage.setImageResource(topSeries1.getTopstoriesimage());
        viewHolder.topstoriesTitle.setText(topSeries1.getTopstoriesheadding());
        viewHolder.topstoriespersonname.setText(topSeries1.getTopstoriesname());
        viewHolder.topstoriestime.setText(topSeries1.getTopstoriestime());
        viewHolder.topstoriesviews.setText(topSeries1.getTopstoriesviews());
        viewHolder.topstoriessubscribes.setText(topSeries1.getTopstoriessubsribe());


    }

    @Override
    public int getItemCount() {
        return topSeries.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView topstoriesimage;
        TextView topstoriesTitle, topstoriespersonname, topstoriestime, topstoriesviews, topstoriessubscribes;
        Button plusbutton;

        Context context;
        ArrayList<TopSeries> topSeries;

        public ViewHolder(@NonNull View itemView, final Context context, ArrayList<TopSeries> topSeries) {
            super(itemView);
            this.context = context;
            this.topSeries = topSeries;

          /*  itemView.setClickable(true);
            itemView.setOnClickListener(this);*/
            topstoriesimage = itemView.findViewById(R.id.topstoriesimage);
            topstoriesTitle = itemView.findViewById(R.id.topstoriesTitle);
            topstoriespersonname = itemView.findViewById(R.id.topstoriespersonname);
            topstoriestime = itemView.findViewById(R.id.topstoriestime);
            topstoriesviews = itemView.findViewById(R.id.topstoriesviews);
            topstoriessubscribes = itemView.findViewById(R.id.topstoriessubscribes);


        }
    }
}
