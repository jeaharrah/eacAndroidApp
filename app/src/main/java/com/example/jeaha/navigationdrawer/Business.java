package com.example.jeaha.navigationdrawer;

public class Business {
    private String title, shortDesc, location, time, month, date, weekDay;

    public Business(String title, String shortDesc, String location, String time, String month, String date, String weekDay) {
        this.title = title;
        this.shortDesc = shortDesc;
        this.location = location;
        this.time = time;
        this.month = month;
        this.date = date;
        this.weekDay = weekDay;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(String weekDay) {
        this.weekDay = weekDay;
    }


}
