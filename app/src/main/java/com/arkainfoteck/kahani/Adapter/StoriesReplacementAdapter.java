package com.arkainfoteck.kahani.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.arkainfoteck.kahani.Activity.CardDescription;
import com.arkainfoteck.kahani.Activity.MoreDescriptionActivity;
import com.arkainfoteck.kahani.Activity.SeriesCardDescription;

import com.arkainfoteck.kahani.Activity.writerOnlyOptions;
import com.arkainfoteck.kahani.Fragments.StoriesReplacement;
import com.arkainfoteck.kahani.Model.StorieReplacemrntModel;
import com.arkainfoteck.kahani.R;

import java.util.ArrayList;

public class StoriesReplacementAdapter extends RecyclerView.Adapter<StoriesReplacementAdapter.ViewHolder> {
    View view;
    Context context;
    int color = R.color.colorAccent;
    ArrayList<StorieReplacemrntModel>storieReplacemrntModels;

    public StoriesReplacementAdapter(Context context, ArrayList<StorieReplacemrntModel> storieReplacemrntModels) {
        this.context = context;
        this.storieReplacemrntModels = storieReplacemrntModels;
    }

    @NonNull
    @Override
    public StoriesReplacementAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        view=layoutInflater.inflate(R.layout.list_single_card,viewGroup,false);
        return new ViewHolder(view,context);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull StoriesReplacementAdapter.ViewHolder viewHolder, int i) {
        StorieReplacemrntModel storieReplacemrntModel=storieReplacemrntModels.get(i);
        viewHolder.cardimage.setImageResource(storieReplacemrntModel.getImage());
        viewHolder.cardtitle.setText(storieReplacemrntModel.getTitle());
        viewHolder.cardepisodes.setText(storieReplacemrntModel.getViews());
        viewHolder.cardsubscribes.setText(storieReplacemrntModel.getSubscribes());
        if(viewHolder.getAdapterPosition()==4){
            viewHolder.cardimage.setVisibility(View.GONE);
            viewHolder.cardepisodes.setVisibility(View.GONE);
            viewHolder.cardsubscribes.setVisibility(View.GONE);
            viewHolder.lastcardseries.setVisibility(View.GONE);
            viewHolder.cardtitle.setVisibility(View.GONE);
            viewHolder.lastcardseries.setVisibility(View.VISIBLE);
            viewHolder.lastcardseries.setText("View More");
            viewHolder.lastcardseries.setGravity(Gravity.CENTER);
            viewHolder.lastcardseries.setOnClickListener(new View.OnClickListener() {
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

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        Context context;
        ImageView cardimage;
        TextView cardtitle,cardepisodes,cardsubscribes,lastcardseries;
        public ViewHolder(@NonNull View itemView,Context context) {

            super(itemView);
            this.context=context;
            itemView.setClickable(true);
            itemView.setOnClickListener(this);
            lastcardseries = itemView.findViewById(R.id.lastcardseries);
            cardimage=itemView.findViewById(R.id.cardImage);
            cardtitle=itemView.findViewById(R.id.cardTitle);
            cardepisodes=itemView.findViewById(R.id.cardepisodes);
            cardsubscribes=itemView.findViewById(R.id.cardsubscribes);

        }

        @Override
        public void onClick(View v) {
            Intent intent=new Intent(this.context,writerOnlyOptions.class);// have to change class name if it is not author..
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);

           /* writerOnlyOptions fragment = new writerOnlyOptions();
            ((AppCompatActivity)context).getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).addToBackStack(null).commit();
*/
        }
    }
}
