package com.arkainfoteck.kahani.Activity;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPopupHelper;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.support.v7.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.arkainfoteck.kahani.Fragments.Content;
import com.arkainfoteck.kahani.R;

public class addingEpisodeStoryPage extends AppCompatActivity {

    ImageView addtext,left_series,menuStoryEpisode,episode_more;
    LinearLayout addExtraStory;
    DrawerLayout drawerLayout;
    Drawable image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding_episode_story_page);
        menuStoryEpisode = findViewById(R.id.menuStoryEpisode);
        drawerLayout = findViewById(R.id.drawerLayout);
        episode_more = findViewById(R.id.episode_more);
        left_series= findViewById(R.id.left_series);
        menuStoryEpisode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(drawerLayout.isDrawerOpen(Gravity.END)){
                    drawerLayout.closeDrawers();
                }else{
                    drawerLayout.openDrawer(Gravity.END);
                }
            }
        });
        episode_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(addingEpisodeStoryPage.this, "touched", Toast.LENGTH_SHORT).show();
                PopupMenu menu = new PopupMenu(getBaseContext(),episode_more);
                menu.getMenuInflater().inflate(R.menu.episodemenu,menu.getMenu());
                menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(addingEpisodeStoryPage.this, "click"+item.getItemId(), Toast.LENGTH_SHORT).show();
                        return true;
                    }

                });

                menu.show();
;            }
        });
        /*addtext = findViewById(R.id.addContent);
        addimage = findViewById(R.id.addepisodeimage);
        addExtraStory = findViewById(R.id.addView);
        addtext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addExtraStory.addView(addText());
                System.out.println(addText().getText()+"dhbdjhfdhf");
            }
        });
        addimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addExtraStory.addView(addImage());
                System.out.println(addImage()+"dhbdjhfdhf");
            }
        });
*/
    }
    public EditText addText(){
        EditText newTextView = new EditText(this);
        newTextView.setHint("Continue.....");
        newTextView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        return newTextView;
    }
    public ImageView addImage(){
        ImageView newImageView = new ImageView(this);
        image = getResources().getDrawable(R.drawable.dammy);
        newImageView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,280));
        newImageView.setImageDrawable(image);
        return newImageView;
    }
}
