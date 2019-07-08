package com.arkainfoteck.kahani.Adapter;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPopupHelper;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.arkainfoteck.kahani.Fragments.CommunityPost;
import com.arkainfoteck.kahani.Model.CommunityPostModel;
import com.arkainfoteck.kahani.R;

import java.util.ArrayList;
import java.util.Calendar;

public class CommunityPostAdapter extends RecyclerView.Adapter<CommunityPostAdapter.ViewHolder> {
    Context context;
    MenuBuilder menuBuilder;
    AlertDialog.Builder alert;
    AlertDialog dialog;
    Calendar newCalendar1;


    ArrayList<CommunityPostModel>communityPostModels;
    View view;

    public CommunityPostAdapter(Context context, ArrayList<CommunityPostModel> communityPostModels) {
        this.context = context;
        this.communityPostModels = communityPostModels;
    }

    @NonNull
    @Override
    public CommunityPostAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        view=layoutInflater.inflate(R.layout.communitypostadapter,viewGroup,false);
        return new ViewHolder(view,context);
    }

    @Override
    public void onBindViewHolder(@NonNull CommunityPostAdapter.ViewHolder viewHolder, int i) {
        CommunityPostModel communityPostModel=communityPostModels.get(i);
        viewHolder.comunitypostname.setText(communityPostModel.getCoomunitypostname());
        viewHolder.comunityposttime.setText(communityPostModel.getCommunityposttime());

    }

    @Override
    public int getItemCount() {
        return communityPostModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        MenuBuilder menuBuilder;
        ImageView threedots;
        TextView comunityposttime,comunitypostname;
        Context context;
        public ViewHolder(@NonNull View itemView, final Context context) {
            super(itemView);
            this.context=context;
            threedots=itemView.findViewById(R.id.threedots);
            comunityposttime=itemView.findViewById(R.id.comunityposttime);
            comunitypostname=itemView.findViewById(R.id.comunitypostname);

            threedots.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("RestrictedApi")
                @Override
                public void onClick(View v) {
                    PopupMenu popup = new PopupMenu(context, threedots);
                    //Inflating the Popup using xml file
                    popup.getMenuInflater().inflate(R.menu.threedots, popup.getMenu());


                    //registering popup with OnMenuItemClickListener
                    popup.setOnMenuItemClickListener(
                            new PopupMenu.OnMenuItemClickListener() {
                        public boolean onMenuItemClick(MenuItem item) {
                            Toast.makeText(context,"You Clicked : " + item.getTitle(), Toast.LENGTH_SHORT).show();
                            if(item.getTitle().equals("Edit"))
                            {
                                LayoutInflater inflater = LayoutInflater.from(context);
                                View alertLayout = inflater.inflate(R.layout.editscreen, null);
                                Button submit=alertLayout.findViewById(R.id.submit);

                                alert = new AlertDialog.Builder(context);

                                alert.setView(alertLayout);
                                // alert.setCancelable(false);
                                dialog = alert.create();

                                dialog.setCanceledOnTouchOutside(false);
                                dialog.show();
                                submit.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        dialog.dismiss();
                                    }
                                });

                            }

                            return true;
                        }
                    });


                    popup.show();//showing popup menu

                }

            });
        }
    }


    }
