package com.roguelike.logic.factories;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.roguelike.logic.Entity;
import com.roguelike.logic.dto.EntityData;
import com.roguelike.logic.systems.SimpleAttack;
import com.roguelike.logic.systems.SimpleHealth;
import com.roguelike.logic.systems.SimpleName;

import com.google.gson.Gson;

import java.io.*;

public class EntityFactory {
    private final Gson gson = new Gson();

    public Entity loadEntityFromJson(String resourcePath) {
        try {
            // Load file from classpath
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(resourcePath);

            if (inputStream == null) {
                throw new FileNotFoundException("Resource not found: " + resourcePath);
            }

            // Read JSON from resource stream
            Reader reader = new InputStreamReader(inputStream);
            EntityData data = gson.fromJson(reader, EntityData.class);

            Entity entity = new Entity();
            entity.addComponent(new SimpleName(data.name));
            entity.addComponent(new SimpleHealth(data.health.current, data.health.max));
            entity.addComponent(new SimpleAttack(data.attack.power));

            return entity;

        } catch (Exception e) {
            throw new RuntimeException("Failed to load entity from JSON: " + resourcePath, e);
        }
    }

}
