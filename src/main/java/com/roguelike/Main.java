package com.roguelike;

import com.roguelike.logic.PlayerCharacter;
import com.roguelike.logic.factories.CharacterFactory;
import com.roguelike.logic.gamestates.GameStateManager;
import com.roguelike.logic.gamestates.IntroState;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CharacterFactory factory = new CharacterFactory();
        PlayerCharacter player = factory.createFromConsoleInput(scanner);

        GameStateManager stateManager = new GameStateManager(new IntroState(scanner, player));

        run(stateManager); // start the game loop

        scanner.close();
    }

    private static void run(GameStateManager stateManager) {
        while (true) {
            stateManager.getState().update(stateManager);
        }
    }
}
