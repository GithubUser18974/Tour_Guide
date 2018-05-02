package com.example.android.tourguide;


import java.io.Serializable;

/**
 * Created by Mohamed_Araby on 3/23/2018.
 */

public class ResourcesDetails implements Serializable {

    private String name;
    private String description;
    private int image;


    public ResourcesDetails(String name, String description, int image) {
        this.name = name;
        this.description = description;
        this.image = image;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
