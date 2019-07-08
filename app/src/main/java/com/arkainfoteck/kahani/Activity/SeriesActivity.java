package com.arkainfoteck.kahani.Activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.text.style.BackgroundColorSpan;
import android.text.style.StyleSpan;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.arkainfoteck.kahani.R;

import java.util.ArrayList;

public class SeriesActivity extends AppCompatActivity {
    LinearLayout radiobutton;
    String writetype;
    TextView selectlanguage,genre,copyrights;
    NestedScrollView nestedScrollView;
    TextView optionOne,optiontwo,optionthree;
    EditText keywords;
    String s;
    TextWatcher tt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_series);
        radiobutton=findViewById(R.id.radiobutton);
        nestedScrollView = findViewById(R.id.seriesactivityprimelayout);
        selectlanguage = findViewById(R.id.languageSelection);
        optionOne = findViewById(R.id.optionone);
        optiontwo = findViewById(R.id.optiontwo);
        optionthree = findViewById(R.id.optionthree);
        keywords = findViewById(R.id.keywords);
        genre = findViewById(R.id.genre);
        copyrights = findViewById(R.id.copyrights);
        writetype=getIntent().getStringExtra("namevalue");

        if(writetype.equals("LIFE EVENTS"))
        {
            radiobutton.setVisibility(View.VISIBLE);
        }
        keywords.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                System.out.println(s.length()+"   "+start+"ksdmvksdmsd"+count+ "  "+ before);
                if(start==0 && count==1 && before==0){
                    keywords.removeTextChangedListener(this);
                    String ab = "#".concat(Character.toString(s.charAt(s.length()-1)));
                    String temp1 = s.toString();
                    System.out.println("#".concat(Character.toString(s.charAt(s.length()-1)))+"    bgtyhgbgt  "+"  "+ab);
                    String temp = temp1.substring(0,temp1.length()-1)+ab;
                    System.out.println(temp+" uytpopopopqwe");
                    keywords.getText().clear();
                    keywords.setText("");
                    keywords.append(temp);
                    keywords.addTextChangedListener(this);
                }
                if(s.length()>2){
                    if((Character.toString(s.toString().charAt(s.length()-2)).equals(" ") || Character.toString(s.toString().charAt(s.length()-2)).equals(",")  )&& (!Character.toString(s.charAt(s.length()-1)).equals(" ") && count!=0 && before==0 && !Character.toString(s.charAt(s.length()-1)).equals(","))){
                        keywords.removeTextChangedListener(this);
                        String ab = "#".concat(Character.toString(s.charAt(s.length()-1)));
                        String temp1 = s.toString();
                        System.out.println("#".concat(Character.toString(s.charAt(s.length()-1)))+"    sgsfsgsrg  "+temp1.lastIndexOf(temp1.charAt(temp1.length()-1))+"  "+ab);
                        String temp = temp1.substring(0,temp1.length()-1)+ab;
                        System.out.println(temp+" kjhgfdfghj");
                        keywords.getText().clear();
                        keywords.setText("");
                        keywords.append(temp);
                        keywords.addTextChangedListener(this);
                        System.out.println(s.length()+" vjdj");
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        selectlanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflater = (LayoutInflater) SeriesActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View customView = layoutInflater.inflate(R.layout.seriresactivitypopupwindow,null);
                final PopupWindow popupWindow = new PopupWindow(customView, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT,false);
                popupWindow.showAtLocation(nestedScrollView, Gravity.CENTER,0,0);
                selectlanguage.setCursorVisible(false);
                selectlanguage.setInputType(InputType.TYPE_NULL);
                nestedScrollView.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        popupWindow.dismiss();
                        return false;
                    }
                });
                optionOne = customView.findViewById(R.id.optionone);
                optionOne.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        selectlanguage.setText("one");
                        popupWindow.dismiss();
                    }
                });
            }
        });
        genre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflater = (LayoutInflater) SeriesActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View customView = layoutInflater.inflate(R.layout.seriresactivitypopupwindow,null);
                final PopupWindow popupWindow = new PopupWindow(customView, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT,false);
                popupWindow.showAtLocation(nestedScrollView, Gravity.CENTER,0,0);
                selectlanguage.setCursorVisible(false);
                selectlanguage.setInputType(InputType.TYPE_NULL);
                nestedScrollView.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        popupWindow.dismiss();
                        return false;
                    }
                });
                optionOne = customView.findViewById(R.id.optionone);
                optionOne.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        genre.setText("one");
                        popupWindow.dismiss();
                    }
                });
            }
        });
        copyrights.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflater = (LayoutInflater) SeriesActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View customView = layoutInflater.inflate(R.layout.seriresactivitypopupwindow,null);
                final PopupWindow popupWindow = new PopupWindow(customView, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT,false);
                popupWindow.showAtLocation(nestedScrollView, Gravity.CENTER,0,0);

                selectlanguage.setCursorVisible(false);
                selectlanguage.setInputType(InputType.TYPE_NULL);
                nestedScrollView.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        popupWindow.dismiss();
                        return false;
                    }
                });
                optionOne = customView.findViewById(R.id.optionone);
                optionOne.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        copyrights.setText("one");
                        popupWindow.dismiss();
                    }
                });
            }
        });

    }
}
