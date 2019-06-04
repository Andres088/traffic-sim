package com.sim.entities;

public class BaseShape {

    public float x;
    public float y;
    public float height;
    public float width;

    public BaseShape(float height, float width){
        this.height = height;
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public float getWidth() {
        return width;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}
