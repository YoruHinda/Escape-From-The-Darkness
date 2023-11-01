package com.github.yoruhinda.escapefromthedarkness.entity;

import com.github.yoruhinda.escapefromthedarkness.game.ui.GamePanel;

import java.awt.*;

public class Player extends Entity {
    private GamePanel gamePanel;
    private boolean left, right;

    public Player(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void render(Graphics graphics) {
        graphics.fillRect(getX(), 350, 50, 50);
    }

    @Override
    public void update() {
        if(left){
            setX(getX() - 5);
        }
        if(right){
            setX(getX() + 5);
        }
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public void setRight(boolean right) {
        this.right = right;
    }
}
