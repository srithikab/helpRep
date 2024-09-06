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
       int counter = 0;
       public void setUpProgram() {
		   Scanner scanner = FileUtils.openToRead("cities.txt");
		   			StdDraw.setPenColor(StdDraw.GRAY);
		   			String[] arr = new String[1112];
			while (scanner.hasNextLine())
			{
				double firstVal = Double.parseDouble(scanner.next());
				double secondVal = Double.parseDouble(scanner.next());
				String cityName = "";
				cityName = scanner.next();
				String cityHelp = scanner.next();
				if (cityHelp != ",") {
					cityName = cityName + " " + cityHelp;
				}
				StdDraw.point(firstVal, secondVal);
				arr[counter] = cityName;
				counter++;
				scanner.nextLine();
			}
			
			Scanner scanner2 = FileUtils.openToRead("bigCities.txt");
			String [] Barr = new String[276];
			int counter = 0;
			while (scanner2.hasNextLine()) {
				String bCityName = "";
				scanner2.next();
				bCityName = scanner2.next();
				String bCityHelp = scanner2.next();
				if (bCityHelp != ",") {
					bCityName = bCityName + " " + bCityHelp;
					System.out.print(bCityName + " ");
				}
				Barr[counter] = bCityName;
			}
				
				
				
			
			
			
	   }
}
