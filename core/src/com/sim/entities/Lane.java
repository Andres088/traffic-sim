package com.sim.entities;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pool;
import com.badlogic.gdx.utils.Pools;
import com.sim.config.SimConfig;
import com.sim.util.Direction;

public class Lane extends RectangleShape {

    private final float vehicleSpawnTime;
    private float vehicleTimer;
    private Array<Vehicle> vehicles;
    private Pool<Vehicle> vehiclePool;
    Direction vehiclesDirection;

    public Lane(float height, float width, float x, float y, Direction direction){
        super(height, width);
        this.x = x;
        this.y = y;
        vehicleSpawnTime = 3f; // Modificar
        vehiclesDirection =  direction;
        init();
    }

    private void init(){
        vehicles = new Array<Vehicle>();
        vehicleTimer = 3f;
        vehiclePool = Pools.get(Vehicle.class, SimConfig.LANE_CAPACITY);
        createNewVehicle(3f);
    }

    public void updateVehicles(float delta) {
        for (Vehicle vehicle : vehicles) {
            vehicle.update();
        }

//        createNewVehicle(delta);
//        removePassedVehicles();
    }

    public void createNewVehicle(float delta){
        //vehicleTimer += delta;

        if (vehicleTimer >= vehicleSpawnTime) {

            Vehicle vehicle = vehiclePool.obtain();

            switch(vehiclesDirection) {
                case UP:
                    // Carriquiry South Spawn
                    vehicle.setAngle(180);
                    vehicle.setX(x+ SimConfig.CARRI_LANE_SPACE);
                    vehicle.setY(y);
                    vehicle.setSpeedInKM(0f, 30f);
                    break;
                case DOWN:
                    // Carriquiry North Spawn
                    vehicle.setAngle(0);
                    vehicle.setX(x+ SimConfig.CARRI_LANE_SPACE);
                    vehicle.setY(height);
                    vehicle.setSpeedInKM(0f, -30f);
                    break;
                case LEFT:
                    // Moreyra East Spawn
                    vehicle.setAngle(-90);
                    vehicle.setX(width);
                    vehicle.setY(y + SimConfig.MOREY_LANE_SPACE*3);
                    vehicle.setSpeedInKM(-30f, 0f);
                    break;
                case RIGHT:
                    // Moreyra West Spawn
                    vehicle.setAngle(90);
                    vehicle.setX(x);
                    vehicle.setY(y + vehicle.getWidth()/2);
                    vehicle.setSpeedInKM(30f, 0f);
                    break;
            }

            // vehicle.setSpeedInKM(0f, 30f); // modificar en base a angulo
            vehicles.add(vehicle);
            vehicleTimer = 0f;
        }

    }

    public void removePassedVehicles(){

    }

    public void restart() {
        vehiclePool.freeAll(vehicles);
        vehicles.clear();
    }

    public void setVehiclesDirection(Direction dir){
        vehiclesDirection = dir;
    }

    public Array<Vehicle> getVehicles(){
        return vehicles;
    }

}
