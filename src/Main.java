import rxtxrobot.*;

public class Main {
	private static RXTXRobot r; 
	
	public static void main(String[] args) 
	{
		r = new ArduinoUno(); 
		r.setPort("/dev/tty.usbmodem1421");
		r.setVerbose(true); // Turn on debugging messages 
		r.connect();
		
		// this moves the servo to a specified angle
		r.attachServo(RXTXRobot.SERVO1, 9);
		r.moveServo(RXTXRobot.SERVO1, 30); // Move Servo 1 to location 30 
		
		
		//r.refreshAnalogPins(); // Cache the Analog pin information 
		 
	//	for (int x=0; x < 5; ++x) 
	//	{ 
	//		AnalogPin temp = r.getAnalogPin(x); 
	//		System.out.println("Sensor " + x + " has value: " + temp.getValue()); 
	//	} 
		//r.attachMotor(RXTXRobot.MOTOR1, 5);
		//r.attachMotor(RXTXRobot.MOTOR3, 7);
		
		//r.runMotor(RXTXRobot.MOTOR1, 255, 5000);
		
		//r.runMotor(RXTXRobot.MOTOR3, 255, 5000);
		//r.runEncodedMotor(RXTXRobot.MOTOR1, 255, 10, RXTXRobot.MOTOR2, 255, 10);
		
		// Run both motors forward, one for 50,000 ticks and one for 50,000 
		//for(int k =0; k < 1000; k++)
		//{
		//	System.out.println("Pin Value:" + r.getAnalogPin(1).getValue());
			//if(r.getAnalogPin(1).getValue() == 5)
				//break;
		//}

	    //Get the average thermistor reading
	   // double thermistorReading = getThermistorReading();
	    
	   // System.out.println("The probe read the value: " + thermistorReading);
	  // System.out.println("In volts: " + (thermistorReading * (5.0/1023.0)));
	    
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
