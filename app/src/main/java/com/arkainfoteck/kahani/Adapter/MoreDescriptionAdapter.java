package com.arkainfoteck.kahani.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.arkainfoteck.kahani.Model.MoreDescriptionModel;
import com.arkainfoteck.kahani.R;

import java.util.ArrayList;

public class MoreDescriptionAdapter extends RecyclerView.Adapter<MoreDescriptionAdapter.ViewHolder> {
    Context mcontext;
    ArrayList<MoreDescriptionModel>moreDescriptionModels;


    public MoreDescriptionAdapter(Context mcontext, ArrayList<MoreDescriptionModel> moreDescriptionModels) {
        this.mcontext = mcontext;
        this.moreDescriptionModels = moreDescriptionModels;
    }

    @NonNull
    @Override
    public MoreDescriptionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mcontext).inflate(R.layout.moredescription,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MoreDescriptionAdapter.ViewHolder viewHolder, int i) {
        MoreDescriptionModel moreDescriptionModel=moreDescriptionModels.get(i);
        viewHolder.cardimage.setImageResource(moreDescriptionModel.getImage());
        viewHolder.cardtitle.setText(moreDescriptionModel.getTitle());
        viewHolder.cardepisodes.setText(moreDescriptionModel.getViews());
        viewHolder.cardsubscribes.setText(moreDescriptionModel.getSubscribes());

    }

    @Override
    public int getItemCount() {
        return moreDescriptionModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView cardimage;
        TextView cardtitle,cardepisodes,cardsubscribes;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardimage=itemView.findViewById(R.id.moreImage);
            cardtitle=itemView.findViewById(R.id.moreTitle);
            cardepisodes=itemView.findViewById(R.id.moreepisodes);
            cardsubscribes=itemView.findViewById(R.id.moresubscribes);

        }
    }
}
