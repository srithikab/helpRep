import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *	Plots a US Map
 *	
 *	@author Srithika Barakam
 *	@since September 4th, 2024
 */

public class USMap {
	
		/** Set up the canvas size and scale */
		public void setupCanvas() {
		StdDraw.setTitle("USMap");
		StdDraw.setCanvasSize(900, 512);
		StdDraw.setXscale(128.0, 65.0);
		StdDraw.setYscale(22.0, 52.0);
	
		
			 
	}
	public static void main (String[] args) {
			USMap BLE = new USMap();
			BLE.setupCanvas();
			BLE.setUpProgram();
       }
       public void setUpProgram() {
		   Scanner scanner = FileUtils.openToRead("cities.txt");
		   			StdDraw.setPenColor(StdDraw.GRAY);
			while (scanner.hasNextLine())
			{
				double firstVal = Double.parseDouble(scanner.next());
				double secondVal = Double.parseDouble(scanner.next());
				StdDraw.circle(firstVal, secondVal, 0.006);
				scanner.nextLine();
			}
	   }
}
