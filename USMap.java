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
			StdDraw.setTitle("USMap");
			StdDraw.setCanvasSize(900, 512);
			StdDraw.setXscale(128.0, 65.0);
			StdDraw.setYscale(22.0, 52.0);
			FileUtils.openToRead("cities.txt");
			 StdDraw.setPenColor(StdDraw.GRAY);
			StdDraw.circle(200.0,30.0,100.0);
       }
}
