package com.example.greenroutes.domain;

public class Route {
    private long id;
    private String name;
    private int length;
    private boolean completed;

    public Route(long id, String name, int length, boolean completed) {
        this.id = id;
        this.name = name;
        this.length = length;
        this.completed = completed;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getLength() {
        return length;
    }

    public boolean isCompleted() {
        return completed;
    }
}
