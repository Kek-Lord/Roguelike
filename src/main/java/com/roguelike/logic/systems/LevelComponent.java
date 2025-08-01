package com.roguelike.logic.systems;

public interface LevelComponent extends Component {
    int getLevel();
    void levelUp();
    void setLevel(int level);
}
