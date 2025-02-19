package no.hvl.dat110.iotsystem;

import no.hvl.dat110.client.Client;
import no.hvl.dat110.messages.Message;
import no.hvl.dat110.messages.PublishMsg;
import no.hvl.dat110.common.TODO;

public class DisplayDevice {
	
	private static final int COUNT = 10;
		
	public static void main (String[] args) {
		
		System.out.println("Display starting ...");
		
		// TODO - START
				
		// create a client object and use it to
		Client display = new Client("display", "localhost", 8080);
		// - connect to the broker - use "display" as the username
		display.connect();
		// - create the temperature topic on the broker
		display.createTopic("temperature");
		// - subscribe to the topic
		display.subscribe("temperature");
		// - receive messages on the topic
		for(int i = 0; i < COUNT; i++) {
			display.receive();
		}
		// - unsubscribe from the topic
		display.unsubscribe("temperature");
		// - disconnect from the broker
		display.disconnect();
		
		// TODO - END
		
		System.out.println("Display stopping ... ");
		
		
		
	}
}
