package com.arkainfoteck.kahani.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.arkainfoteck.kahani.Activity.DashBoard;
import com.arkainfoteck.kahani.Model.LanguageModel;
import com.arkainfoteck.kahani.R;

import java.util.ArrayList;

public class LanguageAdapter extends RecyclerView.Adapter<LanguageAdapter.ViewHolder> {
    View view;
    Context context;
    ArrayList<LanguageModel>languageModels;

    public LanguageAdapter(Context context, ArrayList<LanguageModel> languageModels) {
        this.context = context;
        this.languageModels = languageModels;
    }

    @NonNull
    @Override
    public LanguageAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        view=layoutInflater.inflate(R.layout.languageadapter,viewGroup,false);

        return new ViewHolder(view,context,languageModels);
    }

    @Override
    public void onBindViewHolder(@NonNull LanguageAdapter.ViewHolder viewHolder, int i) {
        LanguageModel languageModel=languageModels.get(i);
        viewHolder.languagetext.setText(languageModel.getName());

    }
    @Override
    public int getItemCount() {
        return languageModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView languagetext;
        Context context;
        ArrayList<LanguageModel>languageModels;
        public ViewHolder(@NonNull View itemView,Context context,ArrayList<LanguageModel>languageModels) {
            super(itemView);
            this.context=context;
            this.languageModels=languageModels;
            itemView.setClickable(true);
            itemView.setOnClickListener(this);
            languagetext=(TextView) itemView.findViewById(R.id.languagetext);
        }

        @Override
        public void onClick(View v) {
            Intent  intent=new Intent(this.context, DashBoard.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            this.context.startActivity(intent);

        }
    }
}
