package no.hvl.dat110.iotsystem;

import no.hvl.dat110.client.Client;
import no.hvl.dat110.common.TODO;
import no.hvl.dat110.messages.ConnectMsg;

public class TemperatureDevice {

	private static final int COUNT = 10;

	public static void main(String[] args) {

		// simulated / virtual temperature sensor
		TemperatureSensor sn = new TemperatureSensor();

		// TODO - start

		// create a client object and use it to
		Client sensor = new Client("sensor", "localhost", 8080);
		// - connect to the broker - user "sensor" as the user name
		sensor.connect();
		
		// - publish the temperature(s)
		for(int i = 0; i < COUNT; i++) {
			int temp = sn.read();
			String tempString = "" + temp;
			sensor.publish("temperature", tempString);
		}
		
		sensor.disconnect();
		// - disconnect from the broker

		// TODO - end

		System.out.println("Temperature device stopping ... ");


	}
}
