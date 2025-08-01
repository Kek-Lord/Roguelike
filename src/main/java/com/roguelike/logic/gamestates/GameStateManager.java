package com.roguelike.logic.gamestates;

public final class GameStateManager {
    private GameState currentState;

    public GameStateManager(final GameState initialState) {
        this.currentState = initialState;
    }

    public void setState(GameState newState) {
        this.currentState = newState;
    }

    public GameState getState() {
        return currentState;
    }
}
