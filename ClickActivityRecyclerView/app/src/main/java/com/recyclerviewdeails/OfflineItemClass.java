package com.recyclerviewdeails;

public class OfflineItemClass {

    private int img;
    private String name;
    private String email;

    public OfflineItemClass(int img, String name, String email) {
        this.img = img;
        this.name = name;
        this.email = email;
    }

    public int getImg() {
        return img;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

}
