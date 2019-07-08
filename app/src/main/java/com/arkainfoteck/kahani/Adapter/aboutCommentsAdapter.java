package com.arkainfoteck.kahani.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.arkainfoteck.kahani.R;

public class aboutCommentsAdapter  extends RecyclerView.Adapter<aboutCommentsAdapter.ViewHolder> {
    Context mcontext;
    public aboutCommentsAdapter(Context mcontext) {
        this.mcontext=mcontext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mcontext).inflate(R.layout.about_comments,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
        viewHolder.reply_button_about_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewHolder.reply_layout_about_page.setVisibility(View.VISIBLE);
            }
        });
        viewHolder.reply_cancel_about_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewHolder.reply_layout_about_page.setVisibility(View.GONE);
            }
        });

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView reply_button_about_page,reply_cancel_about_page;
        LinearLayout reply_layout_about_page;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            reply_button_about_page = itemView.findViewById(R.id.reply_button_about_page);
            reply_cancel_about_page= itemView.findViewById(R.id.reply_cancel_about_page);
            reply_layout_about_page = itemView.findViewById(R.id.reply_layout_about_page);

        }
    }
}
