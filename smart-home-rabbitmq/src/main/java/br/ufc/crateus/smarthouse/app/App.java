package br.ufc.crateus.smarthouse.app;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import br.ufc.crateus.smarthouse.connection.RabbitMQConnection;
import br.ufc.crateus.smarthouse.objects.AirConditioning;
import br.ufc.crateus.smarthouse.objects.DigitalLock;
import br.ufc.crateus.smarthouse.objects.LightBulb;
import br.ufc.crateus.smarthouse.objects.VacuumCleaner;
import br.ufc.crateus.smarthouse.sensors.LightSensor;
import br.ufc.crateus.smarthouse.sensors.LocationSensor;
import br.ufc.crateus.smarthouse.sensors.RemoteControl;
import br.ufc.crateus.smarthouse.sensors.TemperatureSensor;

public class App {

	private static final String AIR_CONDITIONING = "air_conditioning";
	private static final String DIGITAL_LOCK = "digital_lock";
	private static final String LIGHT_BULB = "light_bulb";
	private static final String VACUUM_CLEANER = "vacuum_cleaner";

	public static void main(String[] args) throws IOException, TimeoutException {
		RabbitMQConnection rmqc = new RabbitMQConnection();

		rmqc.consume(new AirConditioning(), AIR_CONDITIONING);
		rmqc.toProduce(TemperatureSensor.verifyTemperature(20f, 39f), AIR_CONDITIONING);
//		rmqc.toProduce(TemperatureSensor.verifyTemperature(20f, 19f), AIR_CONDITIONING);

		rmqc.consume(new DigitalLock(), DIGITAL_LOCK);
		rmqc.toProduce(LocationSensor.userArrived(), DIGITAL_LOCK);
//		rmqc.toProduce(LocationSensor.userExited(), DIGITAL_LOCK);

		rmqc.consume(new LightBulb(), LIGHT_BULB);
//		rmqc.toProduce(LightSensor.checkBrightness(1000, 20000), LIGHT_BULB);
		rmqc.toProduce(LightSensor.checkBrightness(1000, 200), LIGHT_BULB);

		rmqc.consume(new VacuumCleaner(), VACUUM_CLEANER);
		rmqc.toProduce(RemoteControl.turnOn(), VACUUM_CLEANER);
//		rmqc.toProduce(RemoteControl.turnOff(), VACUUM_CLEANER);

	}
}
