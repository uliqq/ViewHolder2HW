package com.geektech.viewholder2hw.ui;

public class Item {
    private int type;
    private String title;
    private int image;

    public Item(int type, String title, int image) {
        this.type = type;
        this.title = title;
        this.image = image;
    }

    public Item(int type, String title) {
        this.type = type;
        this.title = title;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public int getImage() {
        return image;
    }
}
