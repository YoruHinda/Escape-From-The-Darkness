package com.github.yoruhinda.escapefromthedarkness.entity;

import java.awt.*;

public abstract class Entity {
    private int x, y;
    private int width, height;

    public Entity(){

    }

    public void render(Graphics graphics){

    }

    public void update(){
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}