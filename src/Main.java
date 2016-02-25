
import rxtxrobot.*;


public class Main {

	public static void main(String[] args) {
		
		RXTXRobot r = new ArduinoUno(); 
		r.setVerbose(true);
		r.connect();
		r.close();

	}

}
