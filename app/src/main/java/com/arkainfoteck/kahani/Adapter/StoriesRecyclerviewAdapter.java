package com.arkainfoteck.kahani.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.arkainfoteck.kahani.Activity.MoreDescriptionActivity;
import com.arkainfoteck.kahani.Activity.StoriesCardDescription;
import com.arkainfoteck.kahani.Activity.WriterOnlyStory;
import com.arkainfoteck.kahani.Model.StoriesRecyclerviewModel;
import com.arkainfoteck.kahani.R;

import java.util.ArrayList;

public class StoriesRecyclerviewAdapter extends RecyclerView.Adapter<StoriesRecyclerviewAdapter.ViewHolder> {
    View view;
    Context context;

    ArrayList<StoriesRecyclerviewModel>storiesRecyclerviewModels;

    public StoriesRecyclerviewAdapter(Context context, ArrayList<StoriesRecyclerviewModel> storiesRecyclerviewModels) {
        this.context = context;
        this.storiesRecyclerviewModels = storiesRecyclerviewModels;
    }

    @NonNull
    @Override
    public StoriesRecyclerviewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        view=layoutInflater.inflate(R.layout.list_single_card_one,viewGroup,false);

        return new ViewHolder(view,context);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        StoriesRecyclerviewModel storiesRecyclerviewModel=storiesRecyclerviewModels.get(i);
        viewHolder.cardimage.setImageResource(storiesRecyclerviewModel.getImage());
        viewHolder.cardtitle.setText(storiesRecyclerviewModel.getTitle()+"....");
        viewHolder.cardepisodes.setText(storiesRecyclerviewModel.getViews());
        viewHolder.cardsubscribes.setText(storiesRecyclerviewModel.getSubscribes());
        System.out.println(view.getHeight()+"  "+view.getWidth()+" adapter no. ");
        if (viewHolder.getAdapterPosition()==4){
            viewHolder.cardimage.setVisibility(View.GONE);
            viewHolder.cardepisodes.setVisibility(View.GONE);
            viewHolder.list_series_card_one.setVisibility(View.GONE);
            viewHolder.lastcardstories.setVisibility(View.VISIBLE);
            viewHolder.lastcardstories.setText("View More");
            viewHolder.lastcardstories.setOnClickListener(new View.OnClickListener() {
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

    public class ViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener{
        Context context;
        ImageView cardimage;
        LinearLayout list_series_card_one;
        TextView cardtitle,cardepisodes,cardsubscribes,lastcardstories;
        public ViewHolder(@NonNull View itemView,Context context) {
            super(itemView);
            this.context=context;

            itemView.setClickable(true);
            itemView.setOnClickListener(this);
            list_series_card_one = itemView.findViewById(R.id.list_series_card_one);
            lastcardstories =itemView.findViewById(R.id.lastcardstories);
            cardimage=itemView.findViewById(R.id.cardImageone);
            cardtitle=itemView.findViewById(R.id.cardTitleone);
            cardepisodes=itemView.findViewById(R.id.cardepisodesone);
            cardsubscribes=itemView.findViewById(R.id.cardsubscribesone);

        }

        @Override
        public void onClick(View v) {
            Intent intent=new Intent(context, WriterOnlyStory.class);// change class here if user is not writer
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);

        }
    }
}
