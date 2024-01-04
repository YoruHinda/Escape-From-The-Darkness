package com.github.yoruhinda.escapefromthedarkness.entity;

import com.github.yoruhinda.escapefromthedarkness.animation.Animation;
import com.github.yoruhinda.escapefromthedarkness.game.ui.GamePanel;
import com.github.yoruhinda.escapefromthedarkness.sprite.Sprite;

import java.awt.*;

public class Player extends Entity {
    private GamePanel gamePanel;
    private int playerSpeed = 3;
    private boolean left, right;
    private Sprite idleSprite;
    private Sprite walkLeftSprite;
    private Sprite walkRightSprite;
    private Animation idle;
    private Animation walkLeft;
    private Animation walkRight;
    private Animation animation;

    public Player(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        idleSprite = new Sprite("entitys/Player/idle/Soul_idle");
        walkRightSprite = new Sprite("entitys/Player/move/Soul_move_right");
        walkLeftSprite = new Sprite("entitys/Player/move/Soul_move_left");
        idleSprite.withSpriteSize(96,96);
        idleSprite.setSpriteCount(5);
        walkRightSprite.withSpriteSize(96,96);
        walkRightSprite.setSpriteCount(8);
        walkLeftSprite.withSpriteSize(96,96);
        walkLeftSprite.setSpriteCount(8);
        idle = new Animation(idleSprite.sprites(), 10);
        walkRight = new Animation(walkRightSprite.sprites(), 10);
        walkLeft = new Animation(walkLeftSprite.sprites(), 10);
        animation = idle;
        animation.start();
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(animation.getSprite(), getX(), getY() + 256, null);
    }

    @Override
    public void update() {
        animation.update();
        if (!left || !right){
            animation = idle;
            animation.start();
        }
        if (left) {
            setX(getX() - playerSpeed);
            animation = walkLeft;
            animation.start();
        }
        if (right) {
            setX(getX() + playerSpeed);
            animation = walkRight;
            animation.start();
        }
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public void setRight(boolean right) {
        this.right = right;
    }
}
