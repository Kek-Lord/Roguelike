package com.roguelike.logic.systems;

public class SimpleAttack implements AttackComponent{
    private int attack;

    public SimpleAttack(int power){
        this.attack = power;
    }
    @Override
    public void setAttack(int power) {
        this.attack = power;
    }

    @Override
    public int getAttackPower() {
        return attack;
    }

    @Override
    public void attack() {
        System.out.println("you attack");
    }
}
