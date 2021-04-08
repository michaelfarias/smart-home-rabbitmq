package br.ufc.crateus.smarthouse.sensors;

public class TemperatureSensor {

	public static String verifyTemperature(float idealTemperature, float collectedTemperature) {

		return idealTemperature < collectedTemperature ? "ative" : "desative";
	}

}
