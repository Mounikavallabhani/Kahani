package com.arkainfoteck.kahani.Model;

public class GenersModel {
    int GenersModelimage;
    String GenersModeltext;

    public GenersModel(int genersModelimage, String genersModeltext) {
        GenersModelimage = genersModelimage;
        GenersModeltext = genersModeltext;
    }

    public int getGenersModelimage() {
        return GenersModelimage;
    }

    public void setGenersModelimage(int genersModelimage) {
        GenersModelimage = genersModelimage;
    }

    public String getGenersModeltext() {
        return GenersModeltext;
    }

    public void setGenersModeltext(String genersModeltext) {
        GenersModeltext = genersModeltext;
    }
}
