package com.roguelike.logic.combat;

import com.roguelike.logic.Entity;
import com.roguelike.logic.PlayerCharacter;

import java.util.Scanner;

public class CombatSystem {
    private final Scanner scanner;

    public CombatSystem(Scanner scanner) {
        this.scanner = scanner;
    }

    public CombatResult startCombat(PlayerCharacter player, Entity enemy) {
        System.out.println("\n⚔️ Combat starts! The " + enemy.getName() + " approaches!\n");

        while (player.isAlive() && enemy.isAlive()) {
            System.out.println("Your HP: " + player.getHealth() + " | " + enemy.getName() + "'s HP: " + enemy.getHealth());
            System.out.println("Choose an action:");
            System.out.println("1 - Attack");
            System.out.println("2 - Flee");
            System.out.print("> ");

            String input = scanner.nextLine().trim();

            switch (input) {
                case "1":
                    int damage = player.getAttack();
                    enemy.takeDamage(damage);
                    System.out.println("You strike the " + enemy.getName() + " for " + damage + " damage.");
                    break;

                case "2":
                    System.out.println("You fled the battle!");
                    return CombatResult.FLED;

                default:
                    System.out.println("Invalid input! Please choose 1 or 2.\n");
                    continue;
            }

            // Enemy attacks back if still alive
            if (enemy.isAlive()) {
                int enemyDamage = enemy.getAttack();
                player.takeDamage(enemyDamage);
                System.out.println("The " + enemy.getName() + " hits you for " + enemyDamage + " damage.\n");
            }
        }

        // Determine result
        if (!player.isAlive()) {
            System.out.println("You were defeated by the " + enemy.getName() + "...");
            return CombatResult.LOST;
        } else {
            System.out.println("✅ You defeated the " + enemy.getName() + "!\n");
            return CombatResult.WON;
        }
    }
}
