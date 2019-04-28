package com.example.and_1;

public class Topic
{
    private String name;
    private String imageURL;
    private String description;

    public Topic(String name, String imageURL, String description) {
        this.name = name;
        this.imageURL = imageURL;
        this.description=description;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public  String getDescription(){return  description;}

    public  void  setDescription(String description){this.description=description;}
}
