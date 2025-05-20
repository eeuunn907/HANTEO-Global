package org.example.domain;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private int id;
    private String name;
    private Integer boardId;
    private List<Category> children;

    public Category(int id, String name, Integer boardId) {
        this.id = id;
        this.name = name;
        this.boardId = boardId;
        this.children = new ArrayList<>();
    }

    public void addChild(Category child) {
        this.children.add(child);
    }

    public int getId() {
        return id;
    }

    public Integer getBoardId() {
        return boardId;
    }
}