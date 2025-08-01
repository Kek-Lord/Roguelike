package com.roguelike.logic.systems;

public class SimpleGold implements GoldComponent {
    private int gold;
    @Override
    public int getGold() {
        return gold;
    }

    @Override
    public void addGold(int amount) {
        gold += amount;
    }

    @Override
    public void removeGold(int amount) {
        gold -= amount;
    }
}
