package com.cookandroid.and_0803_cuslistcar;

import android.graphics.drawable.Drawable;

public class Car {
    private Drawable image;
    private String carname;

    public Car(Drawable image, String carname) {

        this.image = image;
        this.carname = carname;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }

    public String getTitle() {
        return carname;
    }

    public void setTitle(String title) {
        this.carname = carname;
    }

}
