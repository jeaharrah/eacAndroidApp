package com.example.jeaha.navigationdrawer;

public class Item {
    private String title, shortDesc, location, time, month, date, weekDay, year;

    public Item(String title, String shortDesc, String location, String time, String month,
                String date, String weekDay, String year) {
        this.title = title;
        this.shortDesc = shortDesc;
        this.location = location;
        this.time = time;
        this.month = month;
        this.date = date;
        this.weekDay = weekDay;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    String getLocation() {
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

    String getMonth() {
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

    public String getYear() { return year; }

    public void setYear(String year) {
        this.year = year;
    }

}
