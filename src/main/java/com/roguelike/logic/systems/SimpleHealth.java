package com.roguelike.logic.systems;

public class SimpleHealth implements HealthComponent {
    private int health;
    private int maxHealth;

    public SimpleHealth(int startingHealth, int maxHealth){
        this.health = startingHealth;
        this.maxHealth = maxHealth;
    }

    @Override
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public void takeDamage(int amount) {
        health -= amount;
    }

    @Override
    public void heal(int amount) {
        health += amount;
    }

    @Override
    public boolean isAlive(){
        return health > 0;
    }
}
