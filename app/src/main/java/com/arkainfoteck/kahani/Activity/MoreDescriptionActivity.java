package com.arkainfoteck.kahani.Activity;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.arkainfoteck.kahani.Adapter.MoreDescriptionAdapter;
import com.arkainfoteck.kahani.Model.MoreDescriptionModel;
import com.arkainfoteck.kahani.Model.StorieReplacemrntModel;
import com.arkainfoteck.kahani.R;

import java.util.ArrayList;

public class MoreDescriptionActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    MoreDescriptionAdapter moreDescriptionAdapter;
    ArrayList<MoreDescriptionModel>moreDescriptionModels;
    LinearLayoutManager linearLayoutManager;
    private boolean loading;
    int pastVisiblesItems, visibleItemCount, totalItemCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_description);
        recyclerView=findViewById(R.id.moredescription);
        loading = false;
        linearLayoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        moreDescriptionModels=new ArrayList<>();
        moreDescriptionModels.add(new MoreDescriptionModel(R.drawable.dammy,"Abhiram parinayam akitham","100 episodes","99 subscribes"));
        moreDescriptionModels.add(new MoreDescriptionModel(R.drawable.dammy,"Abhiram parinayam akitham","100 episodes","99 subscribes"));
        moreDescriptionModels.add(new MoreDescriptionModel(R.drawable.dammy,"Abhiram parinayam akitham","100 episodes","99 subscribes"));
        moreDescriptionModels.add(new MoreDescriptionModel(R.drawable.dammy,"Abhiram parinayam akitham","100 episodes","99 subscribes"));
        moreDescriptionModels.add(new MoreDescriptionModel(R.drawable.dammy,"Abhiram parinayam akitham","100 episodes","99 subscribes"));
        moreDescriptionModels.add(new MoreDescriptionModel(R.drawable.dammy,"Abhiram parinayam akitham","100 episodes","99 subscribes"));
        moreDescriptionModels.add(new MoreDescriptionModel(R.drawable.dammy,"Abhiram parinayam akitham","100 episodes","99 subscribes"));
        moreDescriptionModels.add(new MoreDescriptionModel(R.drawable.dammy,"Abhiram parinayam akitham","100 episodes","99 subscribes"));
        moreDescriptionModels.add(new MoreDescriptionModel(R.drawable.dammy,"Abhiram parinayam akitham","100 episodes","99 subscribes"));
        moreDescriptionModels.add(new MoreDescriptionModel(R.drawable.dammy,"Abhiram parinayam akitham","100 episodes","99 subscribes"));
        moreDescriptionModels.add(new MoreDescriptionModel(R.drawable.dammy,"Abhiram parinayam akitham","100 episodes","99 subscribes"));
        moreDescriptionAdapter=new MoreDescriptionAdapter(getApplicationContext(),moreDescriptionModels);
        recyclerView.setAdapter(moreDescriptionAdapter);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                System.out.println(dy+" dsbdhhdgfh "+linearLayoutManager.getChildCount()+"  "+linearLayoutManager.getItemCount());
                if(dy > 0) //check for scroll down
                {
                    visibleItemCount = linearLayoutManager.getChildCount();
                    totalItemCount = linearLayoutManager.getItemCount();
                    pastVisiblesItems = linearLayoutManager.findFirstVisibleItemPosition();

                    if (loading)
                    {
                        if ( (visibleItemCount + pastVisiblesItems) >= totalItemCount)
                        {
                            loading = false;
                            Log.v("...", "Last Item Wow !");
                            //Do pagination.. i.e. fetch new data
                        }
                    }
                }
            }
        });
    }

}
