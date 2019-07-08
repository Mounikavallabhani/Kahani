package com.arkainfoteck.kahani.Model;

public class TopWritersModel {
    int image;
    String name;
    String writings;
    String fallowers;

    public TopWritersModel(int image, String name, String writings, String fallowers) {
        this.image = image;
        this.name = name;
        this.writings = writings;
        this.fallowers = fallowers;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWritings() {
        return writings;
    }

    public void setWritings(String writings) {
        this.writings = writings;
    }

    public String getFallowers() {
        return fallowers;
    }

    public void setFallowers(String fallowers) {
        this.fallowers = fallowers;
    }
}
