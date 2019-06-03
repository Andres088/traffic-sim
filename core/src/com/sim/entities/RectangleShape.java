package com.sim.entities;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

public class RectangleShape extends BaseShape{

    private Rectangle rectangle;

    public RectangleShape(float height, float width){
        super(height,width);
        rectangle = new Rectangle(x,y,width,height);
    }

    public void drawDebug(ShapeRenderer renderer) {
        renderer.begin(ShapeRenderer.ShapeType.Filled);
        renderer.setColor(Color.DARK_GRAY);
        renderer.rect(x,y,width,height);
        renderer.end();
    }

    public void adjustPosition(){
        x = x - width/2;
    }

    public void DebugPrintShape(){
        System.out.println("Drawing a rectangle");
        System.out.println(x);
        System.out.println(y);
        System.out.println(width);
        System.out.println(height);
    }

}
