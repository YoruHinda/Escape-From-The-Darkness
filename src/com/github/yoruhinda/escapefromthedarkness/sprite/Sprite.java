package com.github.yoruhinda.escapefromthedarkness.sprite;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Sprite {
    private BufferedImage spriteSheet;
    private int rows, cols;
    private int spriteWidth, spriteHeight;
    private int spriteCount;

    public Sprite(String file) {
        BufferedImage sprite = null;
        try {
            sprite = ImageIO.read(this.getClass().getResource("/resources/" + file + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.spriteSheet = sprite;
    }

    public List<BufferedImage> sprites(){
        int row = this.rows;
        int cols = this.cols;
        int count = spriteCount;
        if(spriteCount == 0){
            spriteCount = rows * cols;
        }

        BufferedImage sheet = spriteSheet;
        int width = spriteWidth;
        int height = spriteHeight;
        if(width == 0){
            width = sheet.getWidth() / cols;
        }
        if(height == 0){
            height = sheet.getHeight() / rows;
        }
        int x = 0;
        int y = 0;

        List<BufferedImage> sprites = new ArrayList<>(count);
        for(int i = 0; i < count;i++){
            sprites.add(sheet.getSubimage(x,y,width,height));
            x += width;
            if(x >= width * cols){
                x = 0;
                y += height;
            }
        }
        return sprites;
    }

    public void withRowsAndCols(int rows, int cols){
        this.rows = rows;
        this.cols = cols;
    }

    public void withSpriteSize(int spriteWidth, int spriteHeight){
        this.spriteWidth = spriteWidth;
        this.spriteHeight = spriteHeight;
    }

    public void setSpriteCount(int spriteCount) {
        this.spriteCount = spriteCount;
    }
}
