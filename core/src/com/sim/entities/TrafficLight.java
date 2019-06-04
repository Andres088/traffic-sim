package com.sim.entities;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class TrafficLight extends RectangleShape {

    private int lightStatus;
    private final float[] timing;
    private float timer;

    public TrafficLight(float height, float width, float x, float y, float[] timing) {
        super(height, width);
        this.lightStatus = lightStatus;
        color_filling = Color.BLACK;
        color_bounds = Color.WHITE;
        this.x = x;
        this.y = y;
        this.timing = timing;
    }

    @Override
    public void drawDebug(ShapeRenderer renderer) {
        super.drawDebug(renderer);
        renderer.begin(ShapeRenderer.ShapeType.Filled);
        switch (lightStatus) {
            case 3:
                renderer.setColor(Color.YELLOW);
                break;
            case 2:
                renderer.setColor(Color.GREEN);
                break;
            case 1:
                renderer.setColor(Color.YELLOW);
                break;
            case 0:
                renderer.setColor(Color.RED);
                break;
        }
        renderer.circle(x + width / 2, y + width / 2, width / 3);
        renderer.end();
    }

    public void update(float delta) {
        timer -= delta;
        if (timer <= 0) {
            lightStatus = nextLightStatus();
            timer = timing[lightStatus];
        }
    }

    private int nextLightStatus() {
        int nextStatus = lightStatus + 1;
        if (nextStatus > timing.length - 1) nextStatus = 0;
        return nextStatus;
    }

    public void startTiming(int lightStatus) {
        this.lightStatus = lightStatus;
        timer = timing[lightStatus];
    }
}
