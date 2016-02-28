import rxtxrobot.*;

public class Main {
	private static RXTXRobot r; 
	
	public static void main(String[] args) 
	{
		r = new ArduinoUno(); 
		r.setPort("/dev/tty.usbmodem1421");
		//r.setVerbose(true); // Turn on debugging messages 
		r.connect();
		r.attachServo(RXTXRobot.SERVO1, 9);
		r.moveServo(RXTXRobot.SERVO1, 30); // Move Servo 1 to location 30 

	    //Get the average thermistor reading
	    double thermistorReading = getThermistorReading();
	    
	    System.out.println("The probe read the value: " + thermistorReading);
	   System.out.println("In volts: " + (thermistorReading * (5.0/1023.0)));
	    
		r.close();
	}
	
	/** Reads the voltage coming into analog pin 0 ten times
		takes the average, then returns the result.
		@return the average of the 10 results 
	*/ 
	public static double getThermistorReading() 
	{
		double sum = 0;
		double readingCount = 10;
			    
		//Read the analog pin values ten times, adding to sum each time
		for (int i = 0; i < readingCount; i++) 
		{
			//Refresh the analog pins so we get new readings
			r.refreshAnalogPins();
			double reading = r.getAnalogPin(1).getValue();
			sum += reading;
		}
		
		//Return the average reading
		return sum / readingCount;
	}
}
