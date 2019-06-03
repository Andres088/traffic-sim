package com.sim.entities;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class PolygonShape extends BaseShape{

    public Polygon polygon;
    public float angle;

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
        renderer.x(x, y, 0.1f);
        renderer.setColor(Color.WHITE);
        polygon.setRotation(angle);
        renderer.polygon(polygon.getTransformedVertices());
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
        polygon.setPosition(x-width/2, y);
        polygon.setRotation(angle);
    }
}
