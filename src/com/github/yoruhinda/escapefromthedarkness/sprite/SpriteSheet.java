package com.github.yoruhinda.escapefromthedarkness.sprite;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class SpriteSheet {
    private BufferedImage spriteSheet;
    private int rows, cols;
    private int spriteWidth, spriteHeight;
    private int spriteCount;

    public SpriteSheet(BufferedImage spriteSheet) {
        this.spriteSheet = spriteSheet;
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

    public void setRows(int rows) {
        this.rows = rows;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public void setSpriteWidth(int spriteWidth) {
        this.spriteWidth = spriteWidth;
    }

    public void setSpriteHeight(int spriteHeight) {
        this.spriteHeight = spriteHeight;
    }

    public void setSpriteCount(int spriteCount) {
        this.spriteCount = spriteCount;
    }
}
