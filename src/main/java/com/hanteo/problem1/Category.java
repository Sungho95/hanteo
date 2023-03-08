package com.hanteo.problem1;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private final int id;
    private final String name;
    private final List<Category> child = new ArrayList<>();

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Category> getChildren() {
        return child;
    }

    public void addChild(Category category) {
        child.add(category);
    }
}