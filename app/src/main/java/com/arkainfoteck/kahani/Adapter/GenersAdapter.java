package com.arkainfoteck.kahani.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.arkainfoteck.kahani.Activity.GenersDescriptionActivity;
import com.arkainfoteck.kahani.Model.GenersModel;
import com.arkainfoteck.kahani.R;

import java.util.ArrayList;

public class GenersAdapter extends RecyclerView.Adapter<GenersAdapter.ViewHolder> {
    Context context;
    ArrayList<GenersModel>genersModels;
    View view;

    public GenersAdapter(Context context, ArrayList<GenersModel> genersModels) {
        this.context = context;
        this.genersModels = genersModels;
    }

    @NonNull
    @Override
    public GenersAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        view=layoutInflater.inflate(R.layout.genersadapter,viewGroup,false);
        return new ViewHolder(view,context);

    }

    @Override
    public void onBindViewHolder(@NonNull GenersAdapter.ViewHolder viewHolder, int i) {
        GenersModel genersModel=genersModels.get(i);
        viewHolder.genersimage.setImageResource(genersModel.getGenersModelimage());
        viewHolder.generstext.setText(genersModel.getGenersModeltext());

    }

    @Override
    public int getItemCount() {
        return genersModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView genersimage;
        TextView generstext;
        Context context;
        public ViewHolder(@NonNull View itemView,Context context) {
            super(itemView);
            this.context=context;
            itemView.setClickable(true);
            itemView.setOnClickListener(this);
            genersimage=itemView.findViewById(R.id.genersimage);
            generstext=itemView.findViewById(R.id.generstext);

        }

        @Override
        public void onClick(View v) {
            Intent intent=new Intent(context, GenersDescriptionActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);

        }
    }
}
