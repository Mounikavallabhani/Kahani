package com.arkainfoteck.kahani.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arkainfoteck.kahani.Adapter.notifyTabOneAdapter;
import com.arkainfoteck.kahani.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class notificationTabOne extends Fragment {
    RecyclerView recyclerView;


    public notificationTabOne() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view  = inflater.inflate(R.layout.fragment_notification_tab_one, container, false);
       recyclerView = view.findViewById(R.id.recycle_tabone_notify);
       recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
       notifyTabOneAdapter notifyTabOneAdapter = new notifyTabOneAdapter(getContext());
       recyclerView.setAdapter(notifyTabOneAdapter);
       return view;
    }

}
