package com.sim.entities;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class PolygonShape extends BaseShape{

    public Polygon polygon;
    public float angle;
    public float originX;
    public float originY;
    public float rearX;
    public float rearY;


    public PolygonShape(float height, float width) {
        super(height,width);
        polygon = new Polygon(new float[]{
                x,y,
                width,x,
                width,height,
                y,height});
        polygon.setOrigin(width/2f, 0);
    }

    public void drawDebug(ShapeRenderer renderer) {

        renderer.begin(ShapeRenderer.ShapeType.Line);
        renderer.setColor(Color.WHITE);
        renderer.x(originX, originY, 0.3f);
        renderer.polygon(polygon.getTransformedVertices());
        renderer.setColor(Color.GREEN);
        renderer.x(rearX, rearY, 0.3f);
        renderer.end();
    }

    public void setX(float x) {
        super.setX(x);
        updateBounds();
    }

    @Override
    public void setY(float y) {
        super.setY(y);
        updateBounds();
    }

    public void setAngle(float angle){
        this.angle = angle;
        updateBounds();
    }

    public void updateBounds() {
        polygon.setPosition(x, y);
        polygon.setRotation(angle);

        if (angle== 0f){ // DOWN
            originX = x+width/2;
            originY = y;
            rearX =  x+width/2;
            rearY = y+height;
        }
        if (angle== 180f){ // UP
            originX = x+width/2;
            originY = y;
            rearX =  x+width/2;
            rearY = y-height;
        }
        if (angle== 90f){ // RIGHT
            originX = x+width/2;
            originY = y;
            rearX =  x-width;
            rearY = y;
        }
        if (angle== -90f){ // LEFT
            originX = x+width/2;
            originY = y;
            rearX =  x+2*width;
            rearY = y;
        }
    }
}
