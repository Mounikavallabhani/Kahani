package com.arkainfoteck.kahani.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.arkainfoteck.kahani.Activity.LifeEventDescription;
import com.arkainfoteck.kahani.Activity.MoreDescriptionActivity;
import com.arkainfoteck.kahani.Activity.writerOnlyLifeEvents;
import com.arkainfoteck.kahani.Model.LiveEventsModel;
import com.arkainfoteck.kahani.R;

import java.util.ArrayList;

public class LiveEventsAdapter extends RecyclerView.Adapter<LiveEventsAdapter.ViewHolder>  {
    Context context;
    ArrayList<LiveEventsModel>liveEventsModels;
    View view;

    public LiveEventsAdapter(Context context, ArrayList<LiveEventsModel> liveEventsModels) {
        this.context = context;
        this.liveEventsModels = liveEventsModels;
    }

    @NonNull
    @Override
    public LiveEventsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        view=layoutInflater.inflate(R.layout.list_single_card_two,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LiveEventsAdapter.ViewHolder viewHolder, int i) {
        LiveEventsModel liveEventsModel=liveEventsModels.get(i);
        viewHolder.cardimage.setImageResource(liveEventsModel.getImage());
        viewHolder.cardtitle.setText(liveEventsModel.getTitle()+"....");
        viewHolder.cardepisodes.setText(liveEventsModel.getViews());
        viewHolder.cardsubscribes.setText(liveEventsModel.getSubscribes());
        viewHolder.personname.setText(liveEventsModel.getPersonname());
        if(viewHolder.getAdapterPosition()==4){
            viewHolder.cardimage.setVisibility(View.GONE);
            viewHolder.cardsubscribes.setVisibility(View.GONE);
            viewHolder.cardimage.setVisibility(View.GONE);
            viewHolder.personname.setVisibility(View.GONE);
            viewHolder.cardepisodes.setVisibility(View.GONE);
            viewHolder.layoutlifeeventcard.setVisibility(View.GONE);
            viewHolder.lastcardlifeevent.setVisibility(View.VISIBLE);
            viewHolder.lastcardlifeevent.setText("View More");
            viewHolder.lastcardlifeevent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(context, MoreDescriptionActivity.class);
                    context.startActivity(intent);
                }
            });

        }
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView cardimage;
        TextView cardtitle,cardepisodes,cardsubscribes,personname,by,lastcardlifeevent;
        LinearLayout layoutlifeeventcard;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener((View.OnClickListener) this);
            cardimage=itemView.findViewById(R.id.cardImagetwo);
            lastcardlifeevent = itemView.findViewById(R.id.lastcardlifeevent);
            layoutlifeeventcard = itemView.findViewById(R.id.layoutlifeeventcard);
            cardtitle=itemView.findViewById(R.id.cardTitletwo);
            by = itemView.findViewById(R.id.by);
            personname=itemView.findViewById(R.id.personname);
            cardepisodes=itemView.findViewById(R.id.cardepisodestwo);
            cardsubscribes=itemView.findViewById(R.id.cardsubscribestwo);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, writerOnlyLifeEvents.class);// change class name if user is not writer
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);

        }
    }
}
