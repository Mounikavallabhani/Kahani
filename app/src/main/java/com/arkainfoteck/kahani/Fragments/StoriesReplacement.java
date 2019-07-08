package com.arkainfoteck.kahani.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.arkainfoteck.kahani.Activity.MoreDescriptionActivity;
import com.arkainfoteck.kahani.Adapter.LiveEventsAdapter;
import com.arkainfoteck.kahani.Adapter.MainPageImageSlideAdapter;
import com.arkainfoteck.kahani.Adapter.ShortFilmAdapter;
import com.arkainfoteck.kahani.Adapter.StoriesRecyclerviewAdapter;
import com.arkainfoteck.kahani.Adapter.StoriesReplacementAdapter;
import com.arkainfoteck.kahani.Adapter.TopWriters;
import com.arkainfoteck.kahani.Model.LiveEventsModel;
import com.arkainfoteck.kahani.Model.ShortFilmModel;
import com.arkainfoteck.kahani.Model.StorieReplacemrntModel;
import com.arkainfoteck.kahani.Model.StoriesRecyclerviewModel;
import com.arkainfoteck.kahani.Model.TopWritersModel;
import com.arkainfoteck.kahani.R;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class StoriesReplacement extends Fragment {
    RecyclerView recycler_view_listsecond,storiesrecyclerview,LiveEventsrecyclerview,ShortFilmsrecyclerview,Topwritersrecyclerview;
    LinearLayoutManager layoutManager,layoutManagerone,layoutManagertwo,layoutManagerthree,layoutManagerfour;
    StoriesReplacementAdapter storiesReplacementAdapter;

    ArrayList<StorieReplacemrntModel>storieReplacemrntModels;
    ViewPager viewPager;
    MainPageImageSlideAdapter mainPageImageSlideAdapter;

     /*2nd grid*/
    StoriesRecyclerviewAdapter storiesRecyclerviewAdapter;
    ArrayList<StoriesRecyclerviewModel>storiesRecyclerviewModels;

    /*3rd grid*/
    LiveEventsAdapter liveEventsAdapter;
    ArrayList<LiveEventsModel>liveEventsModels;

    /*4th grid*/
    ShortFilmAdapter shortFilmAdapter;
    ArrayList<ShortFilmModel>shortFilmModels;

    /*5 th grid*/
    TopWriters topWriters;
    ArrayList<TopWritersModel>topWritersModels;

    /*more onclicks*/
    TextView serialsmore,storiesmore,LiveEventsmore,ShortFilmsmore;

    int currentPage = 0;
    Timer timer;
    final long DELAY_MS = 0;//delay in milliseconds before task is to be executed
    final long PERIOD_MS = 3500; // time in milliseconds between successive task executions.


   View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.storiesreplecement, container, false);
        serialsmore=view.findViewById(R.id.serialsmore);
        storiesmore=view.findViewById(R.id.storiesmore);
        LiveEventsmore=view.findViewById(R.id.LiveEventsmore);
        ShortFilmsmore=view.findViewById(R.id.ShortFilmsmore);
        viewPager = view.findViewById(R.id.imageslide);


        mainPageImageSlideAdapter = new MainPageImageSlideAdapter(getContext());
        viewPager.setAdapter(mainPageImageSlideAdapter);
        viewPager.setClipToPadding(false);
        viewPager.setPadding(50,0,50,0);
        viewPager.setPageMargin(-1);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
                System.out.println(i+"   "+v+" sdfsfsdf "+i1);

            }

            @Override
            public void onPageSelected(int i) {
                System.out.println(viewPager.getCurrentItem()+" sdjskhdf" );

            }

            @Override
            public void onPageScrollStateChanged(int i) {
                if (i == ViewPager.SCROLL_STATE_IDLE) {
                    int curr = viewPager.getCurrentItem();
                    int lastReal = viewPager.getAdapter().getCount() - 2;
                    if (curr == 0) {
                        viewPager.setCurrentItem(lastReal, false);
                    } else if (curr > lastReal) {
                        viewPager.setCurrentItem(1, false);
                    }
                    System.out.println(viewPager.getAdapter().getCount()+" countingraj  "+lastReal+"  "+curr);
                }

            }
        });

        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == viewPager.getAdapter().getCount()) {
                    currentPage = 1;
                    //viewPager.setCurrentItem(0, false);
                }
                viewPager.setCurrentItem(currentPage++, true);
            }
        };

        timer = new Timer(); // This will create a new Thread
        timer.schedule(new TimerTask() { // task to be scheduled
            @Override
            public void run() {
                handler.post(Update);
            }
        }, DELAY_MS, PERIOD_MS);











        /*1st grid*/


        recycler_view_listsecond = view.findViewById(R.id.serialsrecycler);
        layoutManager=new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        recycler_view_listsecond.setLayoutManager(layoutManager);
        storieReplacemrntModels=new ArrayList<>();
        storieReplacemrntModels.add(new StorieReplacemrntModel(R.drawable.dammy,"Abhiram parinayam akitham","100 episodes","99 subscribes"));
        storieReplacemrntModels.add(new StorieReplacemrntModel(R.drawable.dammy,"Abhiram parinayam akitham","100 episodes","99 subscribes"));
        storieReplacemrntModels.add(new StorieReplacemrntModel(R.drawable.dammy,"Abhiram parinayam akitham","100 episodes","99 subscribes"));
        storieReplacemrntModels.add(new StorieReplacemrntModel(R.drawable.dammy,"Abhiram parinayam akitham","100 episodes","99 subscribes"));
        storieReplacemrntModels.add(new StorieReplacemrntModel(R.drawable.dammy,"Abhiram parinayam akitham","100 episodes","99 subscribes"));
         //storieReplacemrntModels.add(new StorieReplacemrntModel(R.drawable.more,"","",""));
        storiesReplacementAdapter=new StoriesReplacementAdapter(getActivity(),storieReplacemrntModels);
         recycler_view_listsecond.setAdapter(storiesReplacementAdapter);



         /*2nd grid*/

        storiesrecyclerview = view.findViewById(R.id.storiesrecyclerview);
        layoutManagerone=new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        storiesrecyclerview.setLayoutManager(layoutManagerone);
        storiesRecyclerviewModels=new ArrayList<>();
        storiesRecyclerviewModels.add(new StoriesRecyclerviewModel(R.drawable.dammy,"Abhiram parinayam akitham","10.5K","5.5"));
        storiesRecyclerviewModels.add(new StoriesRecyclerviewModel(R.drawable.dammy,"Abhiram parinayam akitham","10.5K","5.5"));
        storiesRecyclerviewModels.add(new StoriesRecyclerviewModel(R.drawable.dammy,"Abhiram parinayam akitham","10.5K","5.5"));
        storiesRecyclerviewModels.add(new StoriesRecyclerviewModel(R.drawable.dammy,"Abhiram parinayam akitham","10.5K","5.5"));
        storiesRecyclerviewModels.add(new StoriesRecyclerviewModel(R.drawable.dammy,"Abhiram parinayam akitham","10.5K","5.5"));
        //storiesRecyclerviewModels.add(new StoriesRecyclerviewModel(R.drawable.more,"","",""));
        storiesRecyclerviewAdapter=new StoriesRecyclerviewAdapter(getActivity(),storiesRecyclerviewModels);
        storiesrecyclerview.setAdapter(storiesRecyclerviewAdapter);

        /*3rd grid*/

        LiveEventsrecyclerview = view.findViewById(R.id.LiveEventsrecyclerview);
        layoutManagertwo=new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        LiveEventsrecyclerview.setLayoutManager(layoutManagertwo);
        liveEventsModels=new ArrayList<>();
        liveEventsModels.add(new LiveEventsModel(R.drawable.dammy,"Abhiram parinayam akitham","NIKITH","10.5K","5.5"));
        liveEventsModels.add(new LiveEventsModel(R.drawable.dammy,"Abhiram parinayam akitham","NIKITH","10.5K","5.5"));
        liveEventsModels.add(new LiveEventsModel(R.drawable.dammy,"Abhiram parinayam akitham","NIKITH","10.5K","5.5"));
        liveEventsModels.add(new LiveEventsModel(R.drawable.dammy,"Abhiram parinayam akitham","NIKITH","10.5K","5.5"));
        liveEventsModels.add(new LiveEventsModel(R.drawable.dammy,"Abhiram parinayam akitham","NIKITH","10.5K","5.5"));
        liveEventsModels.add(new LiveEventsModel(R.drawable.dammy,"Abhiram parinayam akitham","NIKITH","10.5K","5.5"));
        liveEventsModels.add(new LiveEventsModel(R.drawable.dammy,"Abhiram parinayam akitham","NIKITH","10.5K","5.5"));
       // liveEventsModels.add(new LiveEventsModel(R.drawable.more,"","","",""));
        liveEventsAdapter=new LiveEventsAdapter(getActivity(),liveEventsModels);
        LiveEventsrecyclerview.setAdapter(liveEventsAdapter);

        /*4th grid*/

        ShortFilmsrecyclerview = view.findViewById(R.id.ShortFilmsrecyclerview);
        layoutManagerthree=new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        ShortFilmsrecyclerview.setLayoutManager(layoutManagerthree);
        shortFilmModels=new ArrayList<>();
        shortFilmModels.add(new ShortFilmModel("Content Should be Matched",getResources().getString(R.string.storie)));
        shortFilmModels.add(new ShortFilmModel("Content Should be Matched",getResources().getString(R.string.storie)));
        shortFilmModels.add(new ShortFilmModel("Content Should be Matched",getResources().getString(R.string.storie)));
        shortFilmModels.add(new ShortFilmModel("Content Should be Matched",getResources().getString(R.string.storie)));
        shortFilmModels.add(new ShortFilmModel("Content Should be Matched",getResources().getString(R.string.storie)));
        shortFilmModels.add(new ShortFilmModel("Content Should be Matched",getResources().getString(R.string.storie)));
       // shortFilmModels.add(new ShortFilmModel("Content Should be Matched","qewrtyuiophgfdsadfghjkl;'ljnvcxzbnmvcxcvbnm,zxcvbnm,nmbbvcxzvbnm,.mnbvcxvbnm,.mnbvcvbnm,"));
        shortFilmAdapter=new ShortFilmAdapter(getActivity(),shortFilmModels);
        ShortFilmsrecyclerview.setAdapter(shortFilmAdapter);








        /*5 th grid*/
        Topwritersrecyclerview=view.findViewById(R.id.Topwritersrecyclerview);
        layoutManagerfour=new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        Topwritersrecyclerview.setLayoutManager(layoutManagerfour);
        topWritersModels=new ArrayList<>();
        topWritersModels.add(new TopWritersModel(R.drawable.person,"mounika","142 WRITINGS", "1 FOLLOWERS"));
        topWritersModels.add(new TopWritersModel(R.drawable.person,"mounika","142 WRITINGS", "1 FOLLOWERS"));
        topWritersModels.add(new TopWritersModel(R.drawable.person,"mounika","142 WRITINGS", "1 FOLLOWERS"));
        topWritersModels.add(new TopWritersModel(R.drawable.person,"mounika","142 WRITINGS", "1 FOLLOWERS"));
        topWritersModels.add(new TopWritersModel(R.drawable.person,"mounika","142 WRITINGS", "1 FOLLOWERS"));
        topWriters=new TopWriters(getActivity(),topWritersModels);
        Topwritersrecyclerview.setAdapter(topWriters);




        serialsmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), MoreDescriptionActivity.class);
                startActivity(intent);

            }
        });
        storiesmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), MoreDescriptionActivity.class);
                startActivity(intent);

            }
        });
        LiveEventsmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), MoreDescriptionActivity.class);
                startActivity(intent);

            }
        });
        ShortFilmsmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), MoreDescriptionActivity.class);
                startActivity(intent);

            }
        });



        return view;
    }

}
