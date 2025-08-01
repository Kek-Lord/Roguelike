package com.roguelike.logic.factories;

import java.util.Scanner;

import com.roguelike.logic.PlayerCharacter;
import com.roguelike.logic.systems.*;
import com.roguelike.ui.ConsoleOutputService;
import com.roguelike.ui.OutputService;

public class CharacterFactory {

    public PlayerCharacter createFromConsoleInput(Scanner scanner) {

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.println("Choose your class: ");
        System.out.println("1 - Warrior");
        System.out.println("2 - Wizard");
        System.out.println("3 - Hunter");

        int classChoice = scanner.nextInt();
        scanner.nextLine();

        int startingHealth = switch(classChoice) {
            case 1 -> 150;
            case 2 -> 100;
            case 3 -> 125;
            default -> {
                System.out.println("invalid value. Defaulting to Warrior.");
                yield 150;
            }
        };

        SuppliesComponent suppliesComponent = new SimpleSupplies(20);
        GoldComponent goldComponent = new SimpleGold() {};
        OutputService output = new ConsoleOutputService();
        HealthComponent healthComponent = new SimpleHealth(startingHealth, startingHealth);
        XPComponent xpComponent = new BasicXP(0);
        LevelComponent levelComponent = new BasicLevel(1);
        return new PlayerCharacter(
                name,
                healthComponent,
                suppliesComponent,
                output,
                goldComponent,
                xpComponent,
                levelComponent);
    }
}
