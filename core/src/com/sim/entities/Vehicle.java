package com.sim.entities;

import com.sim.config.SimConfig;
import com.sim.util.Utils;

public class Vehicle extends PolygonShape {

    private float ySpeed;
    private float xSpeed;

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


}
