package com.roguelike.logic.systems;

public interface AttackComponent extends Component{
    public void setAttack(int power);
    public int getAttackPower();
    public void attack();
}
