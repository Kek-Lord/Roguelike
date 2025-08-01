package com.roguelike.logic.systems;

public interface GoldComponent extends Component {
    int getGold();
    void addGold(int amount);
    void removeGold(int amount);
}
