package br.ufc.crateus.smarthouse.sensors;

public class LightSensor {

	public static String checkBrightness(float idealLuminosity, float collectedLuminosity) {
		return collectedLuminosity < idealLuminosity ? "activate" : "";
	}
}
