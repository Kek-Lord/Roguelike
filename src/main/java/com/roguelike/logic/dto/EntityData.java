package com.roguelike.logic.dto;

public class EntityData {
    public String name;
    public HealthData health;
    public AttackData attack;

    public static class HealthData {
        public int current;
        public int max;
    }

    public static class AttackData {
        public int power;
    }
}
