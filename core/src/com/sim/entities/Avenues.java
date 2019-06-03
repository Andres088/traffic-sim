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
                SimConfig.MOREY_WEST_SIDE, 0, Direction.DOWN);
        carriquirySleft = new Lane(
                SimConfig.WORLD_HEIGHT, SimConfig.CARRI_LANE_WIDTH,
                SimConfig.MOREY_WEST_SIDE + SimConfig.CARRI_LANE_WIDTH, 0, Direction.DOWN);
        carriquiryNright = new Lane(
                SimConfig.WORLD_HEIGHT, SimConfig.CARRI_LANE_WIDTH,
                SimConfig.MOREY_WEST_SIDE + SimConfig.CARRI_LANE_WIDTH * 2 + SimConfig.SEPARATION_HOR_INT, 0, Direction.UP);
        carriquiryNleft = new Lane(
                SimConfig.WORLD_HEIGHT, SimConfig.CARRI_LANE_WIDTH,
                SimConfig.MOREY_WEST_SIDE + SimConfig.CARRI_LANE_WIDTH * 3 + SimConfig.SEPARATION_HOR_INT, 0, Direction.UP);
        moreyraEleft = new Lane(
                SimConfig.MOREY_LANE_WIDTH, SimConfig.WORLD_WIDTH,
                0, SimConfig.CARRI_SOUTH_SIDE, Direction.RIGHT);
        moreyraEmiddle = new Lane(
                SimConfig.MOREY_LANE_WIDTH, SimConfig.WORLD_WIDTH,
                0, SimConfig.CARRI_SOUTH_SIDE + SimConfig.MOREY_LANE_WIDTH, Direction.RIGHT);
        moreyraEright = new Lane(
                SimConfig.MOREY_LANE_WIDTH, SimConfig.WORLD_WIDTH,
                0, SimConfig.CARRI_SOUTH_SIDE + SimConfig.MOREY_LANE_WIDTH * 2, Direction.RIGHT);
        moreyraWleft = new Lane(
                SimConfig.MOREY_LANE_WIDTH, SimConfig.WORLD_WIDTH,
                0, SimConfig.CARRI_SOUTH_SIDE + SimConfig.MOREY_LANE_WIDTH * 3 + SimConfig.SEPARATION_VER_INT, Direction.LEFT);
        moreyraWmiddle = new Lane(
                SimConfig.MOREY_LANE_WIDTH, SimConfig.WORLD_WIDTH,
                0, SimConfig.CARRI_SOUTH_SIDE + SimConfig.MOREY_LANE_WIDTH * 4 + SimConfig.SEPARATION_VER_INT, Direction.LEFT);
        moreyraWright = new Lane(
                SimConfig.MOREY_LANE_WIDTH, SimConfig.WORLD_WIDTH,
                0, SimConfig.CARRI_SOUTH_SIDE + SimConfig.MOREY_LANE_WIDTH * 5 + SimConfig.SEPARATION_VER_INT, Direction.LEFT);

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
    }
}
