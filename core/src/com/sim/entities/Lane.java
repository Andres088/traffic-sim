package com.sim.entities;

import com.badlogic.gdx.math.Intersector;
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

    public Lane(float height, float width, float x, float y, Direction direction, Float vehicleSpawnTime ){
        super(height, width);
        this.x = x;
        this.y = y;
        this.vehicleSpawnTime = vehicleSpawnTime;
        vehiclesDirection =  direction;
        init();
    }

    private void init(){
        vehicles = new Array<Vehicle>();
        vehicleTimer = 3f;
        vehiclePool = Pools.get(Vehicle.class, SimConfig.LANE_CAPACITY);
        createNewVehicle(0f);
    }

    public void updateVehicles(float delta) {
        Array<Vehicle> vehiclesToRemove = new Array<Vehicle>();
        for (Vehicle vehicle : vehicles) {
            vehicle.update();
            boolean outsideNorth = vehicle.getY()>SimConfig.WORLD_HEIGHT;
            boolean outsideSouth = vehicle.getY()<0;
            boolean outsideWest = vehicle.getX()<0;
            boolean outsideEast = vehicle.getX()>SimConfig.WORLD_WIDTH;
            if (outsideNorth||outsideSouth||outsideWest||outsideEast){
                vehiclesToRemove.add(vehicle);
            }
        }
        removePassedVehicles(vehiclesToRemove);
        createNewVehicle(delta);
    }

    private void removePassedVehicles(Array<Vehicle> vehiclesToRemove){
        for(Vehicle vehicle: vehiclesToRemove){
            vehicles.removeValue(vehicle, true);
            vehiclePool.free(vehicle);
        }
    }

    public void createNewVehicle(float delta){
        vehicleTimer += delta;

        if (vehicleTimer >= vehicleSpawnTime) {

            Vehicle vehicle = vehiclePool.obtain();

            switch(vehiclesDirection) {
                case UP:
                    // Carriquiry South Spawn
                    vehicle.setAngle(180);
                    vehicle.setX(x+ SimConfig.CARRI_LANE_SPACE);
                    vehicle.setY(y);
                    vehicle.setLightPosition(123f);
                    break;
                case DOWN:
                    // Carriquiry North Spawn
                    vehicle.setAngle(0);
                    vehicle.setX(x+ SimConfig.CARRI_LANE_SPACE);
                    vehicle.setY(height);
                    vehicle.setLightPosition(91f); // Continue
                    break;
                case LEFT:
                    // Moreyra East Spawn
                    vehicle.setAngle(-90);
                    vehicle.setX(width);
                    vehicle.setY(y+SimConfig.MOREY_LANE_SPACE+vehicle.getWidth()/2);
                    break;
                case RIGHT:
                    // Moreyra West Spawn
                    vehicle.setAngle(90);
                    vehicle.setX(x);
                    vehicle.setY(y+SimConfig.MOREY_LANE_SPACE+vehicle.getWidth()/2);
                    break;
            }

            vehicles.add(vehicle);
            vehicleTimer = 0f;
        }
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

    public Direction getVehiclesDirection(){
        return vehiclesDirection;
    }

}
