package com.roguelike.logic.systems;

public class SimpleName implements NameComponent {
    private String name;

    public SimpleName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
