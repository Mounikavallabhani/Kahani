package com.arkainfoteck.kahani.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPopupHelper;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListPopupWindow;
import android.widget.PopupWindow;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.arkainfoteck.kahani.Adapter.ReviewsAdapter;
import com.arkainfoteck.kahani.Model.ReviewsModel;
import com.arkainfoteck.kahani.R;
import java.util.ArrayList;

public class SeriesCardDescription extends AppCompatActivity {
    RecyclerView recyclerView;
    ReviewsAdapter reviewsAdapter;
    ArrayList<ReviewsModel>reviewsModels;
    GridLayoutManager gridLayoutManager;
    TextView cancel,storyTitle,toolBarText,textSize;
    RatingBar rtbProductRating1;
    LinearLayout linearLayout,image,linearLayoutone,linearLayouttwo,parentseries;
    TextView read,introduction,fullContent;
    ImageView moreSeries,tick;
    NestedScrollView scrollView;
    String introFull;
    Button submit,readbn;
    RelativeLayout readlater_series_layout;
    Boolean readStatus;
    ImageView close,plusSize,left_series;

    private PopupWindow popupWindow;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        readStatus =false;
        setContentView(R.layout.activity_series_card_description);
        recyclerView=findViewById(R.id.reviews);
        introduction = findViewById(R.id.intropassage);
        moreSeries= findViewById(R.id.more_series);
        tick = findViewById(R.id.tickseries);
        storyTitle = findViewById(R.id.storyTitle_seriesCard);
        toolBarText = findViewById(R.id.toolBarText);
        scrollView = findViewById(R.id.scrollViewSeriesCard);
        parentseries = findViewById(R.id.parentseries);
        submit=findViewById(R.id.submit);
        image = findViewById(R.id.image);
        readlater_series_layout = findViewById(R.id.readlater_series_layout);
        linearLayout = findViewById(R.id.titleLayout);
        readbn = findViewById(R.id.readbn);
        left_series= findViewById(R.id.left_series);

        /*plusSize = findViewById(R.id.increasesize);
        minusSize  =findViewById(R.id.decreasesize);
        textSize = findViewById(R.id.textsize);*/
        toolBarText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(readStatus==false){
                    tick.setImageResource(R.drawable.tickblue);
                    toolBarText.setTextColor(getResources().getColor(R.color.blue));
                    readStatus = true;
                }else if(readStatus== true){
                    tick.setImageResource(R.drawable.added);
                    toolBarText.setTextColor(getResources().getColor(R.color.black));
                    readStatus = false;
                }

            }
        });
        left_series.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        /*plusSize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.parseInt(textSize.getText().toString())<48){
                    int temp = (Integer.parseInt(textSize.getText().toString()))+1;
                    textSize.setText(Integer.toString(temp));
                    introduction.setTextSize(temp);
                }
            }
        });
        minusSize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.parseInt(textSize.getText().toString())>4){
                    int temp = (Integer.parseInt(textSize.getText().toString()))-1;
                    textSize.setText(Integer.toString(temp));
                    introduction.setTextSize(temp);
                }
            }
        });*/
        //checkViewAndUpdate();



       /* View popup = LayoutInflater.from(getApplicationContext()).inflate(R.layout.activity_writer_options,null);
        final PopupWindow popupWindow = new PopupWindow(popup,popup.getWidth(),popup.getHeight(),true);
        popupWindow.showAtLocation(getCurrentFocus(), Gravity.CENTER,0,0);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });*/
        //read=findViewById(R.id.read);
        /*String g= "... Read More";
        introFull = (String)introduction.getText();
        introduction.setText(introduction.getText().subSequence(0,80)+g);
        SpannableString spannableString = new SpannableString(introduction.getText());
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick( View widget) {
                System.out.println(widget.getId()+"fvsv");
                introduction.setVisibility(View.GONE);
                fullContent.setText(introFull);
                fullContent.setVisibility(View.VISIBLE);

            }
        };
        spannableString.setSpan(clickableSpan,84,93,0);
        introduction.setMovementMethod(LinkMovementMethod.getInstance());
        introduction.setText(spannableString,TextView.BufferType.NORMAL);
        introduction.setSelected(true);*/
        moreSeries.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onClick(View v) {
                /*PopupMenu menu = new PopupMenu(getBaseContext(),v);
                menu.getMenuInflater().inflate(R.menu.threedots,menu.getMenu());
                menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        Toast.makeText(SeriesCardDescription.this, "cliked is "+menuItem.getItemId(), Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });
                 menu.show();*/
                 /*MenuPopupHelper helper = new MenuPopupHelper(getBaseContext(),(MenuBuilder)menu.getMenu(),moreSeries);
                 helper.setForceShowIcon(true);
                 helper.show();*/
                String editoptions []={"Edit","Delete"};
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getBaseContext(),R.layout.listpopupwindow,editoptions);
                ListPopupWindow listPopupWindow = new ListPopupWindow(getBaseContext());
                listPopupWindow.setAdapter(arrayAdapter);
                listPopupWindow.setAnchorView(v);
                listPopupWindow.setModal(true);
                listPopupWindow.setHeight(300);
                listPopupWindow.setWidth(300);
                listPopupWindow.show();

            }
        });

        scrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView nestedScrollView, int i, int i1, int i2, int i3) {
                System.out.println(nestedScrollView.getScrollY()+"vddv"+image.getHeight());

                if(nestedScrollView.getScrollY()>(image.getHeight()+linearLayout.getHeight())){
                    toolBarText.setText("Story Title");
                    tick.setVisibility(View.GONE);
                    toolBarText.setTextColor(getResources().getColor(R.color.black));
                    readlater_series_layout.setBackground(null);
                } else if(nestedScrollView.getScrollY()<(image.getHeight())){
                    if(readStatus==true){
                        toolBarText.setTextColor(getResources().getColor(R.color.blue));
                    } else if (readStatus==false){
                        toolBarText.setTextColor(getResources().getColor(R.color.black));
                    }
                    toolBarText.setText("Read later");
                    tick.setVisibility(View.VISIBLE);
                    readlater_series_layout.setBackground(getResources().getDrawable(R.drawable.outbox_specific_bordercolor));
                }
            }
        });











        /*gridLayoutManager=new GridLayoutManager(getApplicationContext(),1);
        recyclerView.setLayoutManager(gridLayoutManager);*/
        reviewsModels=new ArrayList<>();
        reviewsModels.add(new ReviewsModel("mounika"));
        reviewsModels.add(new ReviewsModel("mounika"));
        reviewsModels.add(new ReviewsModel("mounika"));
        reviewsModels.add(new ReviewsModel("mounika"));
        reviewsModels.add(new ReviewsModel("mounika"));
        reviewsAdapter=new ReviewsAdapter(getApplicationContext(),reviewsModels);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(reviewsAdapter);



        /*rtbProductRating1.setOnTouchListener(new View.OnTouchListener() {
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
        });*/
        /*submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearLayoutone.setVisibility(View.GONE);
                linearLayouttwo.setVisibility(View.VISIBLE);

            }
        });*/
        /*read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),FullContent.class);
                startActivity(intent);

            }
        });*/



    }

}
