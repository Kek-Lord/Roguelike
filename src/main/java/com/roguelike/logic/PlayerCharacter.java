package com.roguelike.logic;

import com.roguelike.logic.systems.*;
import com.roguelike.ui.OutputService;

public class PlayerCharacter {
    private final String name;
    private final HealthComponent healthComponent;
    private final SuppliesComponent suppliesComponent;
    private final GoldComponent goldComponent;
    private final XPComponent xpComponent;
    private final LevelComponent levelComponent;
    private final int attack = 5;

    private final OutputService output;

    public PlayerCharacter(
            String name,
            HealthComponent healthComponent,
            SuppliesComponent suppliesComponent,
            OutputService output,
            GoldComponent goldComponent,
            XPComponent xpComponent,
            LevelComponent levelComponent
            ) {
        this.name = name;
        this.healthComponent = healthComponent;
        this.suppliesComponent = suppliesComponent;
        this.output = output;
        this.goldComponent = goldComponent;
        this.xpComponent = xpComponent;
        this.levelComponent = levelComponent;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return healthComponent.getHealth();
    }

    public int getAttack(){
        return attack;
    }

    public boolean isAlive(){
        return healthComponent.isAlive();
    }

    public void setHealth(){};

    public void takeDamage(int amount) {
        healthComponent.takeDamage(amount);
    }

    public void rest(){
        int restHealAmount = 5;

        if(suppliesComponent.canRest()) {
            healthComponent.heal(restHealAmount);
            output.println("You rest and recover " + restHealAmount + " hp!");
        } else {
            output.println("You do not have enough supplies to rest");
        }
    }

    public void getGold(){
        int gold = goldComponent.getGold();
        output.println("Gold: " + gold);
    }

    public void addGold(int amount){
        goldComponent.addGold(3);

    }

    public void heal(int amount) {
        healthComponent.heal(amount);
        output.println("Healed " + amount + ". Health is now " + healthComponent.getHealth());
    }

}
