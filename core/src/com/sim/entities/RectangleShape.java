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
        renderer.begin(ShapeRenderer.ShapeType.Line);
        renderer.setColor(Color.WHITE);
        renderer.rect(x,y,width,height);
        renderer.end();
    }
}
