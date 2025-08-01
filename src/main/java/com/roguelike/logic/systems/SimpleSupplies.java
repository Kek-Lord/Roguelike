package com.roguelike.logic.systems;

public class SimpleSupplies implements SuppliesComponent {
    private int amount;

    public SimpleSupplies(int initialAmount) {
        this.amount = initialAmount;
    }

    @Override
    public boolean canRest() {
        if (amount >= 10){
            amount -= 10;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean consumeForRest() {
        return false;
    }

    public void addSupplies(int value) {
        if (value > 0) amount += value;
    }

    public int getAmount() {
        return amount;
    }
}
