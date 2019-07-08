package com.arkainfoteck.kahani.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.arkainfoteck.kahani.Activity.addingEpisodeStoryPage;
import com.arkainfoteck.kahani.Model.DraftModel;
import com.arkainfoteck.kahani.Model.WriteModel;
import com.arkainfoteck.kahani.R;

import java.util.ArrayList;

public class draftAdapter extends RecyclerView.Adapter<draftAdapter.ViewHolder> {
    Context context;
    ArrayList<DraftModel> draftModels;
    View view;

    public draftAdapter(Context context,ArrayList<DraftModel> draftModels) {
        this.context = context;
        this.draftModels = draftModels;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @NonNull
    @Override
    public draftAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        view=layoutInflater.inflate(R.layout.draftadapter,viewGroup,false);
        return new draftAdapter.ViewHolder(view,context,draftModels);
    }

    @Override
    public void onBindViewHolder(@NonNull final draftAdapter.ViewHolder viewHolder, int i) {
        DraftModel draftModel = draftModels.get(i);
        viewHolder.content.setText(draftModel.getContent());
        viewHolder.title.setText(draftModel.getTitle());
        viewHolder.drafteradapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final PopupMenu popupMenu = new PopupMenu(context,viewHolder.drafteradapter);
                popupMenu.getMenuInflater().inflate(R.menu.threedots,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if(item.getItemId()==popupMenu.getMenu().getItem(1).getItemId()){
                            Toast.makeText(context, "set life", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(context, addingEpisodeStoryPage.class);
                            context.startActivity(intent);
                        }
                        return false;
                    }
                });
                popupMenu.show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return draftModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        Context context;
        EditText title;
        EditText content;
        ImageView drafteradapter;
        ArrayList<DraftModel> draftModels;
        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
        public ViewHolder(@NonNull View itemView, Context context, ArrayList<DraftModel>draftModels) {
            super(itemView);
            this.context=context;
            this.draftModels=draftModels;
            title = itemView.findViewById(R.id.titledrafter);
            title.setBackground(null);
            drafteradapter= itemView.findViewById(R.id.drafterdots);
            content = itemView.findViewById(R.id.contentdrafter);
            content.setBackground(null);

        }
    }
}
