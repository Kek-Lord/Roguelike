package com.roguelike.logic.systems;

public class BasicLevel implements LevelComponent {
    private int level;

    public BasicLevel(int startingLevel) {
        this.level = startingLevel;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public void levelUp() {
        level++;
    }

    @Override
    public void setLevel(int level) {
        this.level = level;
    }
}
