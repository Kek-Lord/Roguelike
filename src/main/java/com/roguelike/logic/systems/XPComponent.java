package com.roguelike.logic.systems;

public interface XPComponent extends Component {
    int getXP();
    void addXP(int amount);
    void setXP(int xp);
}
