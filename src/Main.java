import rxtxrobot.*;

public class Main {
	private static RXTXRobot r; 
	
	public static void main(String[] args) 
	{
		r = new ArduinoUno(); 
		r.setPort("COM3");
		r.connect();

	    //Get the average thermistor reading
	    int thermistorReading = getThermistorReading();
	    
	    System.out.println("The probe read the value: " + thermistorReading);
	    System.out.println("In volts: " + (thermistorReading * (5.0/1023.0)));
	    
		r.close();
	}
	
	/** Reads the voltage coming into analog pin 0 ten times
		takes the average, then returns the result.
		@return the average of the 10 results 
	*/ 
	public static int getThermistorReading() 
	{
		int sum = 0;
		int readingCount = 10;
			    
		//Read the analog pin values ten times, adding to sum each time
		for (int i = 0; i < readingCount; i++) 
		{
			//Refresh the analog pins so we get new readings
			r.refreshAnalogPins();
			int reading = r.getAnalogPin(0).getValue();
			sum += reading;
		}
		
		//Return the average reading
		return sum / readingCount;
	}
}
