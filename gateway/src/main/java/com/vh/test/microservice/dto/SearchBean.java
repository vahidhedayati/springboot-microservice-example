package com.vh.test.microservice.dto;

public class SearchBean {
    String text="Some random string";
    int entries=1000000;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getEntries() {
        return entries;
    }

    public void setEntries(int entries) {
        this.entries = entries;
    }
}
