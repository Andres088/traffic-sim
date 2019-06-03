package com.sim.entities;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Array;
import com.sim.config.SimConfig;
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

    public Avenues() {
        init();
    }

    public void init() {

        Carriqury = new Array<Lane>();
        Moreyra = new Array<Lane>();

        carriquirySright = new Lane(
                SimConfig.WORLD_HEIGHT, SimConfig.CARRI_LANE_WIDTH,
                SimConfig.MOREY_EAST_SIDE, 0);
        carriquirySleft = new Lane(
                SimConfig.WORLD_HEIGHT, SimConfig.CARRI_LANE_WIDTH,
                SimConfig.MOREY_EAST_SIDE + SimConfig.CARRI_LANE_WIDTH, 0);
        carriquiryNright = new Lane(
                SimConfig.WORLD_HEIGHT, SimConfig.CARRI_LANE_WIDTH,
                SimConfig.MOREY_EAST_SIDE + SimConfig.CARRI_LANE_WIDTH + SimConfig.SEPARATION_HOR_INT, 0);
        carriquiryNleft = new Lane(
                SimConfig.WORLD_HEIGHT, SimConfig.CARRI_LANE_WIDTH,
                SimConfig.MOREY_EAST_SIDE + SimConfig.CARRI_LANE_WIDTH * 2 + SimConfig.SEPARATION_HOR_INT, 0);
        moreyraEleft = new Lane(
                SimConfig.MOREY_LANE_WIDTH, SimConfig.WORLD_WIDTH,
                0, SimConfig.CARRI_SOUTH_SIDE);
        moreyraEmiddle = new Lane(
                SimConfig.MOREY_LANE_WIDTH, SimConfig.WORLD_WIDTH,
                0, SimConfig.CARRI_SOUTH_SIDE + SimConfig.MOREY_LANE_WIDTH);
        moreyraEright = new Lane(
                SimConfig.MOREY_LANE_WIDTH, SimConfig.WORLD_WIDTH,
                0, SimConfig.CARRI_SOUTH_SIDE + SimConfig.MOREY_LANE_WIDTH * 2);
        moreyraWleft = new Lane(
                SimConfig.MOREY_LANE_WIDTH, SimConfig.WORLD_WIDTH,
                0, SimConfig.CARRI_SOUTH_SIDE + SimConfig.MOREY_LANE_WIDTH * 2 + SimConfig.SEPARATION_VER_INT);
        moreyraWmiddle = new Lane(
                SimConfig.MOREY_LANE_WIDTH, SimConfig.WORLD_WIDTH,
                0, SimConfig.CARRI_SOUTH_SIDE + SimConfig.MOREY_LANE_WIDTH * 3 + SimConfig.SEPARATION_VER_INT);
        moreyraWright = new Lane(
                SimConfig.MOREY_LANE_WIDTH, SimConfig.WORLD_WIDTH,
                0, SimConfig.CARRI_SOUTH_SIDE + SimConfig.MOREY_LANE_WIDTH * 4 + SimConfig.SEPARATION_VER_INT);

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

    public void drawDebug(ShapeRenderer renderer) {

        for (Lane lane : Carriqury){
            lane.drawDebug(renderer);
        }
        for (Lane lane : Moreyra){
            lane.drawDebug(renderer);
        }
    }

    public void drawVehicles(ShapeRenderer renderer) {
//        for (Lane lane : Carriqury) for (Vehicle vehicle : lane.getVehicles()) vehicle.drawDebug(renderer);
//        for (Lane lane : Moreyra) for (Vehicle vehicle : lane.getVehicles()) vehicle.drawDebug(renderer);
    }

    public void update(float delta) {
//        for (Lane lane : Carriqury) {
//            lane.updateVehicles(delta);
//        }
//        for (Lane lane : Moreyra) {
//            lane.updateVehicles(delta);
//        }
    }

    public Lane getCarriquirySright(){
        return carriquirySright;
    }

}
