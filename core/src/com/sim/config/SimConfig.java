package com.sim.config;

public class SimConfig {

    public static final float PIXELS_PER_METER = 6f;

    // Meters
    public static final float CARRI_LANE_WIDTH = 4.0f;
    public static final float MOREY_LANE_WIDTH = 3.2f;
    public static final float CARRI_NORTH_SIDE = 75.0f;
    public static final float CARRI_SOUTH_SIDE = 71.0f;
    public static final float MOREY_WEST_SIDE = 100.0f;
    public static final float MOREY_EAST_SIDE = 68.0f;
    public static final float HORIZONTAL_INTERSECTION = 23.0f;
    public static final float VERTICAL_INTERSECTION = 20.0f;
    public static final float SEPARATION_VER_INT = VERTICAL_INTERSECTION-MOREY_LANE_WIDTH*6;
    public static final float SEPARATION_HOR_INT = HORIZONTAL_INTERSECTION-CARRI_LANE_WIDTH*4;
    public static final float WORLD_WIDTH = MOREY_WEST_SIDE + HORIZONTAL_INTERSECTION + MOREY_EAST_SIDE;
    public static final float WORLD_HEIGHT = CARRI_NORTH_SIDE + VERTICAL_INTERSECTION + CARRI_SOUTH_SIDE;
    public static final float AVERAGE_VEHICLE_HEIGHT = 3f;
    public static final float AVERAGE_VEHICLE_WIDTH = 2f;
    public static final float CARRI_LANE_SPACE = (CARRI_LANE_WIDTH-AVERAGE_VEHICLE_WIDTH)/2f;
    public static final float MOREY_LANE_SPACE = (MOREY_LANE_WIDTH-AVERAGE_VEHICLE_WIDTH)/2f;


    // Pixels
    public static final float WIDTH = WORLD_WIDTH * PIXELS_PER_METER;
    public static final float HEIGHT = WORLD_HEIGHT * PIXELS_PER_METER;

    // Units

    public static final int LANE_CAPACITY = 50;


    private SimConfig() {
    }
}
