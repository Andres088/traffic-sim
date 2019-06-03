package com.sim.screen;

import com.badlogic.gdx.Screen;


public class SimScreen implements Screen {

    private SimController controller;
    private SimRenderer renderer;

    @Override
    public void show() {
        controller = new SimController();
        renderer = new SimRenderer(controller);
    }

    @Override
    public void render(float delta) {
        controller.update(delta);
        renderer.render(delta);
    }

    @Override
    public void resize(int width, int height) {
        renderer.resize(width, height);
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
        dispose();
    }

    @Override
    public void dispose() {
        renderer.dispose();
    }
}
