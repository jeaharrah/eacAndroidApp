package com.example.jeaha.navigationdrawer;

public class NavDrawerItem {

    private int icon;
    private String title;
    private String caption;

    public NavDrawerItem() {

    }

    public NavDrawerItem(String title) {
        this.title = title;
    }

    public NavDrawerItem(String title, String caption) {
        this.title = title;
        this.caption = caption;
    }

    public NavDrawerItem(String title, String caption, int icon) {
        this.title = title;
        this.caption = caption;
        this.icon = icon;
    }

    public int getIcon() {
        return this.icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCaption() {
        return this.caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

}
