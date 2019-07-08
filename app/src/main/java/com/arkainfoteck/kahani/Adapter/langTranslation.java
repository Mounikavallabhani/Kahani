package com.arkainfoteck.kahani.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.arkainfoteck.kahani.R;

import java.util.ArrayList;

public class langTranslation extends RecyclerView.Adapter<langTranslation.ViewHolder> {
    Context mcontext;

    ArrayList <String> list;
    ArrayList <String> langLocal;
    public langTranslation(Context mcontext,ArrayList <String> list,ArrayList <String> langLocal) {
        this.mcontext = mcontext;
        this.list=list;
        this.langLocal=langLocal;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mcontext).inflate(R.layout.translation_page,viewGroup,false);
        //image = view.findViewById(R.id.translate_img);
        return new ViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        viewHolder.lang_in_eng.setText(list.get(i));
        viewHolder.lang_Local.setText(langLocal.get(i));
        if(langLocal.get(i).equalsIgnoreCase("english") || list.get(i).equalsIgnoreCase("english")){
            viewHolder.lang_Local.setVisibility(View.INVISIBLE);
            viewHolder.lang_in_eng.setTextSize(20);
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView lang_in_eng,lang_Local;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            lang_in_eng = itemView.findViewById(R.id.lang_in_eng);
            lang_Local = itemView.findViewById(R.id.lang_Local);

        }
    }
}
