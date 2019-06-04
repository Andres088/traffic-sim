package com.sim.entities;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;

public class RectangleShape extends BaseShape{

    private Rectangle rectangle;
    Color color_filling;
    Color color_bounds;
    Polygon collision_bounds;


    public RectangleShape(float height, float width){
        super(height,width);
        rectangle = new Rectangle(x,y,width,height);
        color_filling = Color.DARK_GRAY;
        color_bounds = Color.WHITE;
    }

    public void drawDebug(ShapeRenderer renderer) {
        renderer.begin(ShapeRenderer.ShapeType.Filled);
        renderer.setColor(color_filling);
        renderer.rect(x,y,width,height);
        renderer.end();
        renderer.begin(ShapeRenderer.ShapeType.Line);
        renderer.setColor(color_bounds);
        renderer.rect(x,y,width,height);
        renderer.end();
    }

    public void setColor_filling(Color color){
        this.color_filling = color;
    }

    public void setColor_bounds(Color color){
        this.color_bounds = color;
    }

    public void create_collision_bounds(){
        collision_bounds = new Polygon(new float[]{
                x,y,
                width,x,
                width,height,
                y,height});
    }

    public Rectangle getCollision_bounds(){
        return rectangle;
    }
}
