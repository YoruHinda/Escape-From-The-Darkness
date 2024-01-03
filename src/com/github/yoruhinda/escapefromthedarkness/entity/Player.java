package com.github.yoruhinda.escapefromthedarkness.entity;

import com.github.yoruhinda.escapefromthedarkness.animation.Animation;
import com.github.yoruhinda.escapefromthedarkness.game.ui.GamePanel;
import com.github.yoruhinda.escapefromthedarkness.sprite.Sprite;
import com.github.yoruhinda.escapefromthedarkness.sprite.SpriteSheet;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.image.BufferedImage;

public class Player extends Entity {
    private GamePanel gamePanel;
    private int playerSpeed = 3;
    private boolean left, right;

    public Player(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void render(Graphics graphics) {
    }

    @Override
    public void update() {
        if (left) {
            setX(getX() - playerSpeed);
        }
        if (right) {
            setX(getX() + playerSpeed);
        }
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public void setRight(boolean right) {
        this.right = right;
    }
}
