package com.arkainfoteck.kahani.Model;

public class nanoStoryModel {
    private String image;
    private String name;
    private String viewCount;
    private String likeCount;

    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getViewCount() {
        return viewCount;
    }

    public String getLikeCount() {
        return likeCount;
    }

    public nanoStoryModel(String image, String name, String viewCount, String likeCount) {
        this.image = image;
        this.name = name;
        this.viewCount = viewCount;
        this.likeCount = likeCount;
    }

}
