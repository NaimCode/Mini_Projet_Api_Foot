package com.mini_project.foo1.Services.API;

public class Key {

    private String key;
    private int maxRequest=100;
    private int leftRequest;
    private int secondReset=100;

    public Key(String key, int leftRequest, int secondReset) {
        this.key = key;
        this.leftRequest = leftRequest;
        this.secondReset = secondReset;
    }
    public Key(String key) {
        this.key = key;
        this.leftRequest = 100;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getMaxRequest() {
        return maxRequest;
    }

    public void setMaxRequest(int maxRequest) {
        this.maxRequest = maxRequest;
    }

    public int getLeftRequest() {
        return leftRequest;
    }

    public void setLeftRequest(int leftRequest) {
        this.leftRequest = leftRequest;
    }

    public int getSecondReset() {
        return secondReset;
    }

    public void setSecondReset(int secondReset) {
        this.secondReset = secondReset;
    }
}
