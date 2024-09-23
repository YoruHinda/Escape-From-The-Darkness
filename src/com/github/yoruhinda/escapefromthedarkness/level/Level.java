package com.github.yoruhinda.escapefromthedarkness.level;

import com.github.yoruhinda.escapefromthedarkness.sprite.Sprite;

import java.awt.*;

public class Level {
    private Sprite sprite;
    private int[][] platform;

    public Level() {
        CreateLevel();
    }

    private void CreateLevel() {
        sprite = new Sprite("terrain/level");
        sprite.withSpriteSize(16, 16);
        sprite.setSpriteCount(10);
    }

    public void render(Graphics graphics) {
        graphics.drawImage(sprite.sprites().get(5), 0, 0, null);
    }
}
