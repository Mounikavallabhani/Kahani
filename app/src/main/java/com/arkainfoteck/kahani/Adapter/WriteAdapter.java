package com.arkainfoteck.kahani.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.arkainfoteck.kahani.Activity.SeriesActivity;
import com.arkainfoteck.kahani.Model.WriteModel;
import com.arkainfoteck.kahani.R;

import java.util.ArrayList;

public class WriteAdapter extends RecyclerView.Adapter<WriteAdapter.ViewHolder> {
    Context context;
    ArrayList<WriteModel>writeModels;
    View view;

    public WriteAdapter(Context context, ArrayList<WriteModel> writeModels) {
        this.context = context;
        this.writeModels = writeModels;
    }

    @NonNull
    @Override
    public WriteAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        view=layoutInflater.inflate(R.layout.writeadapter,viewGroup,false);
        return new ViewHolder(view,context,writeModels);
    }

    @Override
    public void onBindViewHolder(@NonNull WriteAdapter.ViewHolder viewHolder, int i) {
        WriteModel writeModel=writeModels.get(i);
        viewHolder.writetype.setText(writeModel.getWritetext());

    }

    @Override
    public int getItemCount() {
        return writeModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        Context context;
        TextView writetype;
        ArrayList<WriteModel>writeModels;
        public ViewHolder(@NonNull View itemView,Context context,ArrayList<WriteModel>writeModels) {
            super(itemView);
            this.context=context;
            this.writeModels=writeModels;
            itemView.setClickable(true);
            itemView.setOnClickListener(this);
            writetype=itemView.findViewById(R.id.writetype);
        }

        @Override
        public void onClick(View v) {
            int i=getAdapterPosition();
            WriteModel writeModel=writeModels.get(i);
            String name=writeModel.getWritetext();

            Intent intent=new Intent(context, SeriesActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra("namevalue",name);
            context.startActivity(intent);
        }
    }
}
