package com.arkainfoteck.kahani.Model;

public class CommunityPostModel {

    String coomunitypostname;
    String communityposttime;

    public CommunityPostModel(String coomunitypostname, String communityposttime) {
        this.coomunitypostname = coomunitypostname;
        this.communityposttime = communityposttime;
    }

    public String getCoomunitypostname() {
        return coomunitypostname;
    }

    public void setCoomunitypostname(String coomunitypostname) {
        this.coomunitypostname = coomunitypostname;
    }

    public String getCommunityposttime() {
        return communityposttime;
    }

    public void setCommunityposttime(String communityposttime) {
        this.communityposttime = communityposttime;
    }
}
 /*int image;
    String day;
    String text;

    public CommunityPostModel(int image, String day, String text) {
        this.image = image;
        this.day = day;
        this.text = text;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }*/
