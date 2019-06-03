package com.sim.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.sim.TrafficSim;
import com.sim.config.SimConfig;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = (int) SimConfig.WIDTH;
		config.height = (int) SimConfig.HEIGHT;
		config.resizable = false;
		new LwjglApplication(new TrafficSim(), config);
	}
}
