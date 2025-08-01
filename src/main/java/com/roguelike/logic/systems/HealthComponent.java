package com.roguelike.logic.systems;

public interface HealthComponent extends Component {
    void takeDamage(int amount);
    void heal(int amount);

    boolean isAlive();

    int getHealth();
}
