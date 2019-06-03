package com.sim.screen;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Logger;
import com.badlogic.gdx.utils.Pool;
import com.sim.config.SimConfig;
import com.sim.entities.Avenues;
import com.sim.entities.Vehicle;


public class SimController {

    private static final Logger log = new Logger(SimController.class.getName(), Logger.DEBUG);

    Avenues avenues;

    public SimController() {
        init();
    }

    private void init() {
        avenues = new Avenues();
    }

    public void update(float delta) {
        avenues.update(delta);
    }

    public Avenues getAvenues(){
        return avenues;
    }

}
