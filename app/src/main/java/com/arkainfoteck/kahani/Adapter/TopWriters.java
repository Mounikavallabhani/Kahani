package com.arkainfoteck.kahani.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.arkainfoteck.kahani.Activity.MoreDescriptionActivity;
import com.arkainfoteck.kahani.Model.TopWritersModel;
import com.arkainfoteck.kahani.R;

import java.util.ArrayList;

public class TopWriters  extends RecyclerView.Adapter<TopWriters.ViewHolder> {
    View view ;
    Context context;
    ArrayList<TopWritersModel>topWritersModels;

    public TopWriters(Context context, ArrayList<TopWritersModel> topWritersModels) {
        this.context = context;
        this.topWritersModels = topWritersModels;
    }

    @NonNull
    @Override
    public TopWriters.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        view=layoutInflater.inflate(R.layout.topwriters,viewGroup,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull TopWriters.ViewHolder viewHolder, int i) {
        TopWritersModel topWritersModel=topWritersModels.get(i);
        /*viewHolder.cardimage.setImageResource(topWritersModel.getImage());
        viewHolder.cardtitle.setText(topWritersModel.getName());
        viewHolder.cardepisodes.setText(topWritersModel.getWritings());
        viewHolder.cardsubscribes.setText(topWritersModel.getFallowers());
        viewHolder.follow.setText("FOLLOW");*/
        if(viewHolder.getAdapterPosition()==(topWritersModels.size()-1)){
            viewHolder.topwritercardlayout.setVisibility(View.GONE);
            viewHolder.lastcardtopwriter.setVisibility(View.VISIBLE);
            viewHolder.lastcardtopwriter.setText("View More");
            viewHolder.lastcardtopwriter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, MoreDescriptionActivity.class);
                    context.startActivity(intent);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return topWritersModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView cardimage;
        TextView cardtitle,cardepisodes,cardsubscribes,follow,lastcardtopwriter;
        LinearLayout topwritercardlayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardimage=itemView.findViewById(R.id.topmage);
            cardtitle=itemView.findViewById(R.id.topTitle);
            topwritercardlayout = itemView.findViewById(R.id.topwritercardlayout);
            lastcardtopwriter = itemView.findViewById(R.id.lastcardtopwriter);
            cardepisodes=itemView.findViewById(R.id.topepisodes);
            cardsubscribes=itemView.findViewById(R.id.topsubscribes);
            follow = itemView.findViewById(R.id.follow_top_writers);

        }
    }
}
