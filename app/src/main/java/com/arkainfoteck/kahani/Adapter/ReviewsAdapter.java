package com.arkainfoteck.kahani.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.arkainfoteck.kahani.Model.ReviewsModel;
import com.arkainfoteck.kahani.R;

import java.util.ArrayList;

public class ReviewsAdapter extends RecyclerView.Adapter<ReviewsAdapter.ViewHolder> {
    View view;
    Context context;
    ArrayList<ReviewsModel>reviewsModels;

    public ReviewsAdapter(Context context, ArrayList<ReviewsModel> reviewsModels) {
        this.context = context;
        this.reviewsModels = reviewsModels;
    }

    @NonNull
    @Override
    public ReviewsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        view=layoutInflater.inflate(R.layout.reviewscontent,viewGroup,false);
        return new ViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull final ReviewsAdapter.ViewHolder viewHolder, int i) {
        ReviewsModel reviewsModel=reviewsModels.get(i);
        viewHolder.reply_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewHolder.reply_layout.setVisibility(View.VISIBLE);
            }
        });
        viewHolder.reply_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewHolder.reply_layout.setVisibility(View.GONE);
            }
        });

    }

    @Override
    public int getItemCount() {
        return reviewsModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView reviewname,reply_click,reply_cancel;
        LinearLayout reply_layout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            reply_click= itemView.findViewById(R.id.reply_click);
            reviewname=itemView.findViewById(R.id.reviewname);
            reply_cancel= itemView.findViewById(R.id.reply_cancel);
            reply_layout = itemView.findViewById(R.id.reply_layout);

        }
    }
}
