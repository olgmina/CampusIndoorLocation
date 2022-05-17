package com.WorkLess.WorkLess.parse;

import java.util.ArrayList;

public class DayWrapper {
    private String title;
    private ArrayList<String> list;

    public DayWrapper(String title) {
        this.title = title;
        this.list = new ArrayList<>();
    }

    public void addToList(String item) {
        this.list.add(item);
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<String> getList() {
        return list;
    }
}
