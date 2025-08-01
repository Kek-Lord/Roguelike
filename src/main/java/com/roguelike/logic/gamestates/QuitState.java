package com.roguelike.logic.gamestates;

public class QuitState implements GameState{
    private final String exitMessage;

    public QuitState(String exitMessage){
        this.exitMessage = exitMessage;
    }
    @Override
    public void update(GameStateManager stateManager) {
        System.out.println("\n=== GAME OVER ===");
        System.out.println(exitMessage);
        System.out.println("Thanks for playing!");
    }
}
