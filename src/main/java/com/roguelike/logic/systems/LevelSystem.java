package com.roguelike.logic.systems;

import com.roguelike.logic.Entity;

public class LevelSystem {

    private static final int BASE_XP = 100;
    private static final double SCALE = 1.5;

    public void gainXP(Entity entity, int amount) {
        XPComponent xp = entity.getComponent(XPComponent.class);
        LevelComponent level = entity.getComponent(LevelComponent.class);

        if (xp == null || level == null) return;

        xp.addXP(amount);

        while (xp.getXP() >= requiredXPForLevel(level.getLevel())) {
            xp.setXP(xp.getXP() - requiredXPForLevel(level.getLevel()));
            level.levelUp();
            System.out.println(entity.getName() + " leveled up to " + level.getLevel() + "!");
        }
    }

    public int requiredXPForLevel(int level) {
        return (int)(BASE_XP * Math.pow(SCALE, level - 1));
    }
}
