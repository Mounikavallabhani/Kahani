package com.arkainfoteck.kahani.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import android.widget.TextView;

import com.arkainfoteck.kahani.Activity.MoreDescriptionActivity;
import com.arkainfoteck.kahani.Activity.nanoStory;
import com.arkainfoteck.kahani.Model.ShortFilmModel;
import com.arkainfoteck.kahani.R;

import java.util.ArrayList;

public class ShortFilmAdapter extends RecyclerView.Adapter<ShortFilmAdapter.ViewHolder> {
    Context context;
    ArrayList<ShortFilmModel>shortFilmModels;
    View view;
    LinearLayout storiesreplacementpage;


    public ShortFilmAdapter(Context context, ArrayList<ShortFilmModel> shortFilmModels) {
        this.context = context;
        this.shortFilmModels = shortFilmModels;
    }

    @NonNull
    @Override
    public ShortFilmAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        view=layoutInflater.inflate(R.layout.list_single_card_three,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShortFilmAdapter.ViewHolder viewHolder, int i) {
        ShortFilmModel shortFilmModel=shortFilmModels.get(i);
         viewHolder.cardtitle.setText(shortFilmModel.getTitle());
         viewHolder.carddescription.setText(shortFilmModel.getDescription());
         if(viewHolder.getAdapterPosition()==4){
             viewHolder.layoutshortfilmcard.setVisibility(View.GONE);
             viewHolder.lastcardshortfilm.setText("View More");
             viewHolder.carddescription.setGravity(Gravity.CENTER);
             viewHolder.carddescription.setHeight(300);
             viewHolder.lastcardshortfilm.setVisibility(View.VISIBLE);
             viewHolder.lastcardshortfilm.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     Intent intent=new Intent(context, MoreDescriptionActivity.class);
                     context.startActivity(intent);
                 }
             });

         }
         viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent((AppCompatActivity)context, nanoStory.class);
                 context.startActivity(intent);


             }
         });
    }



    @Override
    public int getItemCount() {
        return 5;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView cardtitle,carddescription,lastcardshortfilm;
        LinearLayout layoutshortfilmcard;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardtitle=itemView.findViewById(R.id.cardtitle);
            layoutshortfilmcard = itemView.findViewById(R.id.layoutshortfilmcard);
            lastcardshortfilm = itemView.findViewById(R.id.lastcardshortfilm);
            carddescription=itemView.findViewById(R.id.carddescriptipon);
        }
    }
}
