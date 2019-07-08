package com.arkainfoteck.kahani.Adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.drm.DrmStore;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.view.PagerAdapter;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPopupHelper;
import android.support.v7.widget.ListPopupWindow;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.arkainfoteck.kahani.Activity.SeriesActivity;
import com.arkainfoteck.kahani.Activity.nanoStory;
import com.arkainfoteck.kahani.Fragments.StoriesReplacement;
import com.arkainfoteck.kahani.Model.nanoStoryModel;
import com.arkainfoteck.kahani.Model.nanopopupMenu;
import com.arkainfoteck.kahani.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class nanoStoryOnClickAdapter extends PagerAdapter {
    private Context mcontext;
    private ArrayList<nanoStoryModel> listItem;
    private ImageView writerimage,shareImage,heart;
    private TextView writerName,viewCount,likeCount;
    LinearLayout nanofragstorylayout;
    Boolean likestatus;
    RelativeLayout socialnanostory,share_card,suggest_card,community_card;
    NestedScrollView contentscroll;
    TextView cancel_nano_popup,text_one,share_nano;
    ImageView cancel_2_nano_popup;
    FrameLayout frame_nano_onclick_layout;
    Drawable  layer;


    public nanoStoryOnClickAdapter(Context mcontext, ArrayList<nanoStoryModel> listItem) {
        this.mcontext = mcontext;
        this.listItem = listItem;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull final ViewGroup container, int position) {
        likestatus = false;
        final ViewGroup layout = (ViewGroup)LayoutInflater.from(mcontext).inflate(R.layout.nano_storyfragment,container,false);
        writerimage = layout.findViewById(R.id.nanostorywriterimage);
        shareImage = layout.findViewById(R.id.nanostoryshare);
        heart = layout.findViewById(R.id.nanoStorylove);
        TextView writerName = (TextView) layout.findViewById(R.id.nanoStorywritername);
        writerName.setText(listItem.get(position).getName());
        nanofragstorylayout = layout.findViewById(R.id.nanofragstorylayout);
        contentscroll = layout.findViewById(R.id.contentscroll);
        viewCount = layout.findViewById(R.id.viewcountnanostory);
        frame_nano_onclick_layout = layout.findViewById(R.id.frame_nano_onclick_layout);
        viewCount.setText(listItem.get(position).getViewCount());
        likeCount = layout.findViewById(R.id.likecountnanostory);
        socialnanostory= layout.findViewById(R.id.nameandimage);
        likeCount.setText(listItem.get(position).getLikeCount());
        heart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView  t = (ImageView) v;
                if(likestatus==false){
                    t.setImageResource(R.drawable.heartchecked);
                    likestatus =true;
                } else if(likestatus == true){
                    t.setImageResource(R.drawable.heart);
                    likestatus=false;
                }
            }
        });
        LayoutInflater layoutInflater = (LayoutInflater)(mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE));
        View customView = layoutInflater.inflate(R.layout.nanopop_window,null);
        final PopupWindow popupWindow= new PopupWindow(customView, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT,false);
        community_card = customView.findViewById(R.id.community_card);
        suggest_card = customView.findViewById(R.id.suggest_card);
        share_card= customView.findViewById(R.id.share_card);
        //LayoutInflater innerlayoutInflater = (LayoutInflater)(mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE));
        //inflating second inner popupwindow
        View innerView = layoutInflater.inflate(R.layout.popuptemp,null);
        final PopupWindow popupWindow1 = new PopupWindow(innerView,LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        cancel_nano_popup = innerView.findViewById(R.id.cancel_nano_popup);
        cancel_2_nano_popup = innerView.findViewById(R.id.cancel_2_nano_popup);
        text_one= innerView.findViewById(R.id.textone);

        //click for first popup window
        shareImage.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            public void onClick(View v) {
                if(!popupWindow.isShowing()){
                    popupWindow.setAnimationStyle(R.style.PopupAnimation);
                    popupWindow.showAtLocation(v, Gravity.BOTTOM,0,0);
                    frame_nano_onclick_layout.getRootView().setAlpha(0.4f);
                }else if(popupWindow.isShowing()){
                    popupWindow.dismiss();
                }
            }
        });

        suggest_card.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
                text_one.setText("you are suggesting a story to ");
                frame_nano_onclick_layout.getRootView().setAlpha(0.4f);
                popupWindow1.showAtLocation(frame_nano_onclick_layout,Gravity.CENTER,0,0);
                popupWindow1.setFocusable(true);
                popupWindow1.update();
            }
        });
        community_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
                text_one.setText("Community share");
                frame_nano_onclick_layout.getRootView().setAlpha(0.4f);
                popupWindow1.showAtLocation(frame_nano_onclick_layout,Gravity.CENTER,0,0);
                popupWindow1.setFocusable(true);
                popupWindow1.update();
            }
        });
        share_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
                frame_nano_onclick_layout.getRootView().setAlpha(1);
                String text = "hello!!! this is content";
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT,text);
                mcontext.startActivity(Intent.createChooser(intent,"share this story"));
            }
        });
        cancel_nano_popup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow1.dismiss();
                frame_nano_onclick_layout.getRootView().setAlpha(1);

            }
        });
        cancel_2_nano_popup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow1.dismiss();
                frame_nano_onclick_layout.getRootView().setAlpha(1);
            }
        });
        nanofragstorylayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if(popupWindow.isShowing()){
                    popupWindow.dismiss();
                    frame_nano_onclick_layout.getRootView().setAlpha(1);
                }
                return false;
            }
        });
        contentscroll.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(popupWindow.isShowing()){
                    popupWindow.dismiss();
                    frame_nano_onclick_layout.getRootView().setAlpha(1);
                }
                return false;
            }
        });


        container.addView(layout);
        return layout;
    }

    @Override
    public int getCount() {
        return listItem.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view==o;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
       container.removeView((View) object);
    }


}
