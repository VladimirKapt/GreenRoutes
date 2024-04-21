package com.example.greenroutes.domain;

public class Route {
    private final long id;
    private final String name;
    private final int length;
    private final boolean completed;

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
