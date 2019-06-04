package com.sim.entities;

import com.sim.config.SimConfig;
import com.sim.util.Utils;

public class Vehicle extends PolygonShape {

    private float ySpeed;
    private float xSpeed;
    private float lightPosition;

    public Vehicle(){
        super(SimConfig.AVERAGE_VEHICLE_HEIGHT, SimConfig.AVERAGE_VEHICLE_WIDTH);
    }

    public void update() {
        setX(x + xSpeed);
        setY(y + ySpeed);
        updateBounds();
    }

    public void setSpeedInKM(float xSpeed,float ySpeed){
        this.xSpeed = Utils.convertSpeed(xSpeed);
        this.ySpeed = Utils.convertSpeed(ySpeed);
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
            setSpeedInKM(0f, -SimConfig.AVERAGE_VEHICLE_SPEED);
        }
        if (angle== 180f){ // UP
            originX = x+width/2;
            originY = y;
            rearX =  x+width/2;
            rearY = y-height;
            setSpeedInKM(0f, SimConfig.AVERAGE_VEHICLE_SPEED);
        }
        if (angle== 90f){ // RIGHT
            originX = x+width/2;
            originY = y;
            rearX =  x-width;
            rearY = y;
            setSpeedInKM(SimConfig.AVERAGE_VEHICLE_SPEED, 0f);
        }
        if (angle== -90f){ // LEFT
            originX = x+width/2;
            originY = y;
            rearX =  x+2*width;
            rearY = y;
            setSpeedInKM(-SimConfig.AVERAGE_VEHICLE_SPEED, 0f);
        }
    }
    public void setLightPosition(float lightPosition){
        this.lightPosition = lightPosition;
    }
}
