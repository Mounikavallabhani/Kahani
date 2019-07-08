package com.arkainfoteck.kahani.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.arkainfoteck.kahani.Activity.CommunityPostActivity;
import com.arkainfoteck.kahani.Model.CommunityModel;
import com.arkainfoteck.kahani.R;

import java.util.ArrayList;

public class CommunityAdapter  extends RecyclerView.Adapter<CommunityAdapter.ViewHolder> {
    Context context;
    ArrayList<CommunityModel>communityModels;
    View view;

    public CommunityAdapter(Context context, ArrayList<CommunityModel> communityModels) {
        this.context = context;
        this.communityModels = communityModels;
    }

    @NonNull
    @Override
    public CommunityAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        view =layoutInflater.inflate(R.layout.communityadapter,viewGroup,false);
        return new ViewHolder(view,context);
    }

    @Override
    public void onBindViewHolder(@NonNull CommunityAdapter.ViewHolder viewHolder, int i) {
        CommunityModel communityModel=communityModels.get(i);
        viewHolder.communityimage.setImageResource(communityModel.getImage());
        viewHolder.communityname.setText(communityModel.getName());

    }

    @Override
    public int getItemCount() {
        return communityModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView communityname;
        ImageView communityimage;
        Button join;
        Context context;
        public ViewHolder(@NonNull View itemView, final Context context) {
            super(itemView);
            this.context=context;
            itemView.setClickable(true);
            itemView.setOnClickListener(this);
            communityname=itemView.findViewById(R.id.communityname);
            communityimage=itemView.findViewById(R.id.communityimage);
            join=itemView.findViewById(R.id.join);
            join.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(context, CommunityPostActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);

                }
            });
        }

        @Override
        public void onClick(View v) {
            Intent intent=new Intent(context, CommunityPostActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);

        }
    }
}
