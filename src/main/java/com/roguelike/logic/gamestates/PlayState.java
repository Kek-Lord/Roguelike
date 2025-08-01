package com.roguelike.logic.gamestates;

import com.roguelike.logic.Entity;
import com.roguelike.logic.PlayerCharacter;
import com.roguelike.logic.combat.CombatSystem;
import com.roguelike.logic.factories.EntityFactory;
import com.roguelike.logic.combat.CombatResult;

import java.util.Scanner;

public class PlayState implements GameState{
    private final Scanner scanner;
    private final PlayerCharacter player;

    public PlayState(Scanner scanner, PlayerCharacter player){
        this.scanner = scanner;
        this.player = player;
    }

    @Override
    public void update(GameStateManager stateManager){
        System.out.println("Game has started. Fight your way through!");
        while(player.isAlive()){
            System.out.println("What do you want to do?");
            System.out.println("Explore / rest / quit");

            String input = scanner.nextLine().trim().toLowerCase();

            switch (input) {
                case "explore":
                    EntityFactory factory = new EntityFactory();
                    Entity enemy = factory.loadEntityFromJson("entities/goblin.json");


                    CombatSystem combat = new CombatSystem(scanner);
                    CombatResult result = combat.startCombat(player, enemy);

                    if (result == CombatResult.LOST){
                        stateManager.setState(new QuitState("You perish into the annuls of history"));
                        return;
                    }
                    player.addGold(3);
                    System.out.println("You find 3 gold on the goblin");
                    break;

                case "rest":
                    player.rest();
                    break;
                case "quit":
                    stateManager.setState(new QuitState("You chose to leave the dungeon."));
                    return;

                default:
                    System.out.println("I don't understand that.");
            }
        }

        stateManager.setState(new QuitState("You collapse from exhaustion"));

        }
    }
