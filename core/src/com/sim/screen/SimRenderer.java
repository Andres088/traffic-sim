package com.sim.screen;

import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.sim.config.SimConfig;
import com.sim.entities.Avenues;
import com.sim.util.Utils;
import com.sim.entities.Vehicle;
import com.sim.entities.Lane;

public class SimRenderer implements Disposable {

    private OrthographicCamera camera;
    private Viewport viewport;
    private ShapeRenderer renderer;
    private final SimController controller;

    public SimRenderer(SimController controller) {
        this.controller = controller;
        init();
    }

    private void init() {
        camera = new OrthographicCamera();
        viewport = new FitViewport(SimConfig.WORLD_WIDTH, SimConfig.WORLD_HEIGHT, camera);
        renderer = new ShapeRenderer();
    }

    public void render(float delta){
        Utils.clearScreen();

        renderer.setProjectionMatrix(camera.combined);
        viewport.apply();
        Avenues avenues = controller.getAvenues();

        // Rend Lanes
        avenues.drawLanes(renderer);

        // Rend Vehicles
        avenues.drawVehicles(renderer);
    }

    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void dispose(){
        renderer.dispose();
    }

}
