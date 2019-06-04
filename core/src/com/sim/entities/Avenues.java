package com.sim.entities;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Array;
import com.sim.config.SimConfig;
import com.sim.util.Direction;
import sun.security.ssl.Debug;

public class Avenues {

    private Lane carriquirySright;
    private Lane carriquirySleft;
    private Lane carriquiryNright;
    private Lane carriquiryNleft;
    private Lane moreyraEleft;
    private Lane moreyraEmiddle;
    private Lane moreyraEright;
    private Lane moreyraWleft;
    private Lane moreyraWmiddle;
    private Lane moreyraWright;
    private Array<Lane> Carriqury;
    private Array<Lane> Moreyra;
    private RectangleShape intersection;
    private Array<RectangleShape> destinations;
    private Array<TrafficLight> trafficLights;
    TrafficLight TLcarriquirySouth;
    TrafficLight TLcarriquiryNorth;
    TrafficLight TLmoreyraWest;
    TrafficLight TLmoreyraEast;


    public Avenues() {
        init();
    }

    public void init() {


        intersection = new RectangleShape(SimConfig.VERTICAL_INTERSECTION, SimConfig.HORIZONTAL_INTERSECTION);
        intersection.setX(SimConfig.MOREY_WEST_SIDE);
        intersection.setY(SimConfig.CARRI_SOUTH_SIDE);
        Carriqury = new Array<Lane>();
        Moreyra = new Array<Lane>();

        carriquirySright = new Lane(
                SimConfig.WORLD_HEIGHT, SimConfig.CARRI_LANE_WIDTH,
                SimConfig.MOREY_WEST_SIDE, 0, Direction.DOWN, SimConfig.SPAWN_TIME_CARRI_SOUTH_RIGHT);
        carriquirySleft = new Lane(
                SimConfig.WORLD_HEIGHT, SimConfig.CARRI_LANE_WIDTH,
                SimConfig.MOREY_WEST_SIDE + SimConfig.CARRI_LANE_WIDTH, 0, Direction.DOWN, SimConfig.SPAWN_TIME_CARRI_SOUTH_LEFT);
        carriquiryNleft = new Lane(
                SimConfig.WORLD_HEIGHT, SimConfig.CARRI_LANE_WIDTH,
                SimConfig.MOREY_WEST_SIDE + SimConfig.CARRI_LANE_WIDTH * 2 + SimConfig.SEPARATION_HOR_INT, 0, Direction.UP, SimConfig.SPAWN_TIME_CARRI_NORTH_RIGHT);
        carriquiryNright = new Lane(
                SimConfig.WORLD_HEIGHT, SimConfig.CARRI_LANE_WIDTH,
                SimConfig.MOREY_WEST_SIDE + SimConfig.CARRI_LANE_WIDTH * 3 + SimConfig.SEPARATION_HOR_INT, 0, Direction.UP, SimConfig.SPAWN_TIME_CARRI_NORTH_LEFT);
        moreyraEright = new Lane(
                SimConfig.MOREY_LANE_WIDTH, SimConfig.WORLD_WIDTH,
                0, SimConfig.CARRI_SOUTH_SIDE, Direction.RIGHT, SimConfig.SPAWN_TIME_MOREY_EAST_LEFT);
        moreyraEmiddle = new Lane(
                SimConfig.MOREY_LANE_WIDTH, SimConfig.WORLD_WIDTH,
                0, SimConfig.CARRI_SOUTH_SIDE + SimConfig.MOREY_LANE_WIDTH, Direction.RIGHT, SimConfig.SPAWN_TIME_MOREY_EAST_MIDDLE);
        moreyraEleft = new Lane(
                SimConfig.MOREY_LANE_WIDTH, SimConfig.WORLD_WIDTH,
                0, SimConfig.CARRI_SOUTH_SIDE + SimConfig.MOREY_LANE_WIDTH * 2, Direction.RIGHT, SimConfig.SPAWN_TIME_MOREY_EAST_RIGHT);
        moreyraWleft = new Lane(
                SimConfig.MOREY_LANE_WIDTH, SimConfig.WORLD_WIDTH,
                0, SimConfig.CARRI_SOUTH_SIDE + SimConfig.MOREY_LANE_WIDTH * 3 + SimConfig.SEPARATION_VER_INT, Direction.LEFT, SimConfig.SPAWN_TIME_MOREY_WEST_LEFT);
        moreyraWmiddle = new Lane(
                SimConfig.MOREY_LANE_WIDTH, SimConfig.WORLD_WIDTH,
                0, SimConfig.CARRI_SOUTH_SIDE + SimConfig.MOREY_LANE_WIDTH * 4 + SimConfig.SEPARATION_VER_INT, Direction.LEFT, SimConfig.SPAWN_TIME_MOREY_WEST_MIDDLE);
        moreyraWright = new Lane(
                SimConfig.MOREY_LANE_WIDTH, SimConfig.WORLD_WIDTH,
                0, SimConfig.CARRI_SOUTH_SIDE + SimConfig.MOREY_LANE_WIDTH * 5 + SimConfig.SEPARATION_VER_INT, Direction.LEFT, SimConfig.SPAWN_TIME_MOREY_WEST_RIGHT);

        Carriqury.add(carriquiryNleft);
        Carriqury.add(carriquiryNright);
        Carriqury.add(carriquirySleft);
        Carriqury.add(carriquirySright);
        Moreyra.add(moreyraEleft);
        Moreyra.add(moreyraEmiddle);
        Moreyra.add(moreyraEright);
        Moreyra.add(moreyraWleft);
        Moreyra.add(moreyraWmiddle);
        Moreyra.add(moreyraWright);

        destinations = new Array<RectangleShape>();

        for (Lane lane : Carriqury) {
            RectangleShape destination = new RectangleShape(SimConfig.DESTINATION_GIRTH, SimConfig.CARRI_LANE_WIDTH);
            destination.setX(lane.getX());
            if (lane.getVehiclesDirection() == Direction.UP)
                destination.setY(lane.getHeight() - SimConfig.DESTINATION_GIRTH);
            else destination.setY(lane.getY());
            destination.setColor_bounds(Color.RED);
            destination.setColor_filling(Color.RED);
            destination.create_collision_bounds();
            destinations.add(destination);
        }
        for (Lane lane : Moreyra) {
            RectangleShape destination = new RectangleShape(SimConfig.MOREY_LANE_WIDTH, SimConfig.DESTINATION_GIRTH);
            if (lane.getVehiclesDirection() == Direction.RIGHT) {
                destination.setX(lane.getWidth() - SimConfig.DESTINATION_GIRTH);
            } else {
                destination.setX(lane.getX());
            }
            destination.setY(lane.getY());
            destination.setColor_bounds(Color.RED);
            destination.setColor_filling(Color.RED);
            destination.create_collision_bounds();
            destinations.add(destination);
        }

        // Develop more
        trafficLights = new Array<TrafficLight>();
        float length = SimConfig.TRAFFIC_LIGHT_LENGTH;

        float[] timingCarriquiryNorth = {SimConfig.TIME_CARRI_NORTH_RED,SimConfig.TIME_CARRI_NORTH_YELLOW,SimConfig.TIME_CARRI_NORTH_GREEN, SimConfig.TIME_CARRI_NORTH_YELLOW};
        float[] timingCarriquirySouth = {SimConfig.TIME_CARRI_SOUTH_RED,SimConfig.TIME_CARRI_SOUTH_YELLOW,SimConfig.TIME_CARRI_SOUTH_GREEN, SimConfig.TIME_CARRI_NORTH_YELLOW};
        float[] timingMoreyraWest = {SimConfig.TIME_MOREY_WEST_RED,SimConfig.TIME_MOREY_WEST_YELLOW,SimConfig.TIME_MOREY_WEST_GREEN, SimConfig.TIME_CARRI_NORTH_YELLOW};
        float[] timingMoreyraEast = {SimConfig.TIME_MOREY_EAST_RED,SimConfig.TIME_MOREY_EAST_YELLOW,SimConfig.TIME_MOREY_EAST_GREEN, SimConfig.TIME_CARRI_NORTH_YELLOW};
        TLcarriquiryNorth = new TrafficLight(length, length, carriquiryNright.getX() + carriquiryNright.getWidth(),
                moreyraWright.getY() + moreyraWright.getHeight(),timingCarriquiryNorth);
        TLcarriquirySouth = new TrafficLight(length, length, carriquirySright.getX() - length,
                moreyraEright.getY() - length,timingCarriquirySouth);
        TLmoreyraEast = new TrafficLight(length, length, carriquiryNright.getX() + carriquiryNright.getWidth(),
                moreyraEright.getY() - length,timingMoreyraEast);
        TLmoreyraWest = new TrafficLight(length, length, carriquirySright.getX()-length,
                moreyraWright.getY() + moreyraWright.getHeight(),timingMoreyraWest);

        TLcarriquiryNorth.startTiming(0);
        TLcarriquirySouth.startTiming(0);
        TLmoreyraEast.startTiming(2);
        TLmoreyraWest.startTiming(2);

        trafficLights.add(TLcarriquiryNorth, TLcarriquirySouth, TLmoreyraEast, TLmoreyraWest);

    }

    public void drawDestinations(ShapeRenderer renderer) {
        for (RectangleShape destination : destinations) {
            destination.drawDebug(renderer);
        }
    }

    public void drawTrafficLights(ShapeRenderer renderer) {
        for (TrafficLight TL : trafficLights) {
            TL.drawDebug(renderer);
        }
    }

    public void drawLanes(ShapeRenderer renderer) {

        for (Lane lane : Carriqury) {
            lane.drawDebug(renderer);

        }
        for (Lane lane : Moreyra) {
            lane.drawDebug(renderer);
        }
        intersection.drawDebug(renderer);
    }

    public void drawVehicles(ShapeRenderer renderer) {
        for (Lane lane : Carriqury) {
            for (Vehicle vehicle : lane.getVehicles()) {
                vehicle.drawDebug(renderer);
            }
        }
        for (Lane lane : Moreyra) {
            for (Vehicle vehicle : lane.getVehicles()) {
                vehicle.drawDebug(renderer);
            }
        }
    }

    public void update(float delta) {
        for (Lane lane : Carriqury) {
            lane.updateVehicles(delta);
        }
        for (Lane lane : Moreyra) {
            lane.updateVehicles(delta);
        }
        for (TrafficLight light: trafficLights){
            light.update(delta);
        }
    }

}
