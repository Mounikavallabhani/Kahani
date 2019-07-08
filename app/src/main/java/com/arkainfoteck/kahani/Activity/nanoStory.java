package com.arkainfoteck.kahani.Activity;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.arkainfoteck.kahani.Adapter.nanoStoryOnClickAdapter;
import com.arkainfoteck.kahani.Model.nanoStoryModel;
import com.arkainfoteck.kahani.R;

import java.util.ArrayList;

public class nanoStory extends AppCompatActivity {
    ImageView cross;
    ArrayList<nanoStoryModel> list;
    nanoStoryModel model,model1,model2,model3,model4,model5,model6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nano_story);
        model = new nanoStoryModel("https://www.gstatic.com/webp/gallery/2.jpg","kapali","5","6");
        model1 = new nanoStoryModel("https://www.gstatic.com/webp/gallery/2.jpg","kapali1","50","60");
        model2 = new nanoStoryModel("https://www.gstatic.com/webp/gallery/2.jpg","kapali2","51","61");
        model3 = new nanoStoryModel("https://www.gstatic.com/webp/gallery/2.jpg","kapali3","52","62");
        model4 = new nanoStoryModel("https://www.gstatic.com/webp/gallery/2.jpg","kapali4","53","63");
        model5 = new nanoStoryModel("https://www.gstatic.com/webp/gallery/2.jpg","kapali5","54","64");
        model6 = new nanoStoryModel("https://www.gstatic.com/webp/gallery/2.jpg","kapali6","55","65");
        list = new ArrayList<>();
        list.add(model);
        list.add(model1);
        list.add(model2);
        list.add(model3);
        list.add(model4);
        list.add(model5);
        list.add(model6);
        /*Fragment fragment = new nanoStoryfragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.nanoframecontent,fragment).addToBackStack(null).commit();*/
        ViewPager viewPager = findViewById(R.id.pagernanostorycontent);
        viewPager.setAdapter(new nanoStoryOnClickAdapter(this,list));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
