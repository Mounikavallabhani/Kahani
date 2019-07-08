package com.arkainfoteck.kahani.Model;

public class StorieReplacemrntModel {
    int image;
    String title;
    String views;
    String subscribes;

    public StorieReplacemrntModel(int image, String title, String views, String subscribes) {
        this.image = image;
        this.title = title;
        this.views = views;
        this.subscribes = subscribes;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getViews() {
        return views;
    }

    public void setViews(String views) {
        this.views = views;
    }

    public String getSubscribes() {
        return subscribes;
    }

    public void setSubscribes(String subscribes) {
        this.subscribes = subscribes;
    }
}
