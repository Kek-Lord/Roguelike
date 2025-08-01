package com.roguelike.logic;

import com.roguelike.logic.systems.AttackComponent;
import com.roguelike.logic.systems.Component;
import com.roguelike.logic.systems.HealthComponent;
import com.roguelike.logic.systems.NameComponent;

import java.util.HashMap;
import java.util.Map;

public class Entity {
    private final Map<Class<? extends Component>, Component> components = new HashMap<>();

    public <T extends Component> void addComponent(T component) {
        for (Class<?> iface : component.getClass().getInterfaces()) {
            if (Component.class.isAssignableFrom(iface)) {
                components.put((Class<? extends Component>) iface, component);
                return;
            }
        }

        components.put(component.getClass(), component);
    }


    public <T extends Component> T getComponent(Class<T> componentType) {
        return componentType.cast(components.get(componentType));
    }

    public boolean isAlive() {
        HealthComponent health = getComponent(HealthComponent.class);
        return health != null && health.isAlive();
    }

    public int getHealth() {
        HealthComponent health = getComponent(HealthComponent.class);
        return health != null ? health.getHealth() : 0;
    }

    public void takeDamage(int amount) {
        HealthComponent health = getComponent(HealthComponent.class);
        if (health != null) {
            health.takeDamage(amount);
        }
    }

    public void heal(int amount) {
        HealthComponent health = getComponent(HealthComponent.class);
        if (health != null) {
            health.heal(amount);
        }
    }

    public String getName() {
        NameComponent name = getComponent(NameComponent.class);
        return name != null ? name.getName() : "Unknown";
    }

    public int getAttack() {
        AttackComponent attack = getComponent(AttackComponent.class);
        return attack != null ? attack.getAttackPower() : 0;
    }
}
