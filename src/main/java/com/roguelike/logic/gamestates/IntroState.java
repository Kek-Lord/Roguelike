package com.roguelike.logic.gamestates;

import com.roguelike.logic.PlayerCharacter;

import java.util.Scanner;

public class IntroState implements GameState {
    private final Scanner scanner;
    private final PlayerCharacter player;

    public IntroState(Scanner scanner, PlayerCharacter player) {
        this.scanner = scanner;
        this.player = player;
    }

    @Override
    public void update(GameStateManager stateManager) {
        System.out.println("Welcome to the dungeon, " + player.getName() + ". You will not survive.");
        stateManager.setState(new PlayState(scanner, player));
    }
}
