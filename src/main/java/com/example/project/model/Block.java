package com.example.project.model;

import java.io.Serializable;

public class Block implements Serializable {

    public String getName() {
        return name;
    }

    public Block() {
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public Block(String name) {
        this.name = name;
    }
}

