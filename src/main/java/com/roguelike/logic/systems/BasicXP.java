package com.roguelike.logic.systems;

public class BasicXP implements XPComponent {
    private int xp;

    public BasicXP(int startingXP) {
        this.xp = startingXP;
    }

    @Override
    public int getXP() {
        return xp;
    }

    @Override
    public void addXP(int amount) {
        this.xp += amount;
    }

    @Override
    public void setXP(int xp) {
        this.xp = xp;
    }
}
