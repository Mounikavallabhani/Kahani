package com.arkainfoteck.kahani.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.arkainfoteck.kahani.Adapter.ReviewsAdapter;
import com.arkainfoteck.kahani.Model.ReviewsModel;
import com.arkainfoteck.kahani.R;

import java.util.ArrayList;

public class CardDescription extends AppCompatActivity {
   /* RecyclerView recyclerView;
    ReviewsAdapter reviewsAdapter;
    ArrayList<ReviewsModel>reviewsModels;
    GridLayoutManager gridLayoutManager;
    TextView cancel,submit;
    RatingBar rtbProductRating1;
    LinearLayout linearLayoutone,linearLayouttwo;
    Button read;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_description);
       /* recyclerView=findViewById(R.id.reviews);
        rtbProductRating1=findViewById(R.id.rtbProductRating1);
        linearLayoutone=findViewById(R.id.layoutone);
        linearLayouttwo=findViewById(R.id.layouttwo);
        cancel=findViewById(R.id.cancel);
        submit=findViewById(R.id.submit);
        read=findViewById(R.id.read);

        gridLayoutManager=new GridLayoutManager(getApplicationContext(),1);
        recyclerView.setLayoutManager(gridLayoutManager);
        reviewsModels=new ArrayList<>();
        reviewsModels.add(new ReviewsModel("mounika"));
        reviewsModels.add(new ReviewsModel("mounika"));
        reviewsModels.add(new ReviewsModel("mounika"));
        reviewsModels.add(new ReviewsModel("mounika"));
        reviewsModels.add(new ReviewsModel("mounika"));
        reviewsAdapter=new ReviewsAdapter(getApplicationContext(),reviewsModels);
        recyclerView.setAdapter(reviewsAdapter);
        rtbProductRating1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                linearLayoutone.setVisibility(View.VISIBLE);
                linearLayouttwo.setVisibility(View.GONE);
                return false;
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearLayoutone.setVisibility(View.GONE);
                linearLayouttwo.setVisibility(View.VISIBLE);

            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearLayoutone.setVisibility(View.GONE);
                linearLayouttwo.setVisibility(View.VISIBLE);

            }
        });
        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),FullContent.class);
                startActivity(intent);

            }
        });

*/

    }
}
