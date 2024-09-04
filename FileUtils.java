import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;

/**
 *	File Utilities for reading and writing
 *	
 *	@author Srithika Barakam
 *	@since August 23, 2024
 */
public class FileUtils {
	
	/**
	 * 	Opens a file to read using the Scanner class.
	 * 	@param fileName		name of the file to open
	 * 	@return 			the Scanner object to the file
	 */
	 public static java.util.Scanner openToRead(String fileName) {
		 java.util.Scanner input = null;
		 try {
			  input = new java.util.Scanner(new java.io.File(fileName));
		  }
		  catch (java.io.FileNotFoundException e) {
			  System.err.println("ERROR: Cannot open " + fileName + " for reading.");
			  System.exit(72);
		  }
		 
		 return input;
	 }
	 /**
	  * Opens File to write using the PrintWriter Class.
	  * @param fileName 	name of the file open
	  * @return 			the PrintWriter object to the file
	  */
	  public static PrintWriter openToWrite(String fileName) {
		  PrintWriter output = null;
		  try {
			  output = new PrintWriter(new File(fileName));
		  }
		  catch (FileNotFoundException e) {
			  System.err.println("Error: Cannot open " + fileName + " for writing.");
			  System.exit(73);
		  }
		  return output;
	
	  }
}
