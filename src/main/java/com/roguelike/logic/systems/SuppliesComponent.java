package com.roguelike.logic.systems;

public interface SuppliesComponent extends Component {
    public boolean canRest();
    public boolean consumeForRest();

    public void addSupplies(int value);
    public int getAmount();
}
