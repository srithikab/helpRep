import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
/**
 *	MVCipher - Add your description here
 *	Requires Prompt and FileUtils classes.
 *	
 *	@author Srithika Barakam	
 *	@since	09/23/24
 */
public class MVCipher {
	
	// fields go here
	
	String keyWord = ""; // used for keyword to encrypt/decrypt
	String outputF = ""; // used for output File name
	int counter = 0; // used for iterating through the array when de/encyrpting
	int[] keyWordArr;
	private final int ALPHABET_LENGTH = 26;
	
	
		
	/** Constructor */
	public MVCipher() { }
	
	public static void main(String[] args) {
		MVCipher mvc = new MVCipher();
		mvc.run();
	}
	
	/**
	 *	Method he
	 */
	public void run() {
		System.out.println("\n Welcome to the MV Cipher machine!\n");
		String userChoice = "";
		/* Prompt for a key and change to uppercase
		   Do not let the key contain anything but alpha
		   Use the Prompt class to get user input */
		   boolean checker = false;
		   do {
		   userChoice = Prompt.getString("Please input a word to use as" +
								"key (letters only) "	);
			for (int i = 0; i < keyWord.length(); i++) {
				if (((int)(keyWord.charAt(i)) >= 65 && (int)(keyWord.charAt(i)) 
				<= 90 ) || ((int)(keyWord.charAt(i)) >= 65 && (int)
				(keyWord.charAt(i)) <= 90 )); {
					keyWord = userChoice;
				}
				keyWordArr = new int[keyword.length()];
				for (int i = 0; i < keyWord.length(); i++) {
					keywWordArr[i] = ((int)(keyWord.charAt(i));
				}
								
		
		/* Prompt for encrypt or decrypt */
		
		int choiceP = Prompt.getInt("Encrypt or decrypt? (1, 2) ");
		
			
		/* Prompt for an input file name */
		if (choiceP == 1) {
			String inputF = Prompt.getString("Name of file to ecrypt ");
			encryptFile(inputF);
		}
		else {
			String inputF = Prompt.getString("Name of file to decrypt ");
		}
		
		
		
		/* Prompt for an output file name */
		
		outputF = Prompt.getString("Name of output file ");
		
		
		/* Read input file, encrypt or decrypt, and print to output file */
		
		
		/* Don't forget to close your output file */
	}
	
	// other methods go here
	
	public void encryptFile(String enFile) {
		Scanner scanner = FileUtils.openToRead(enFile);
		PrintWriter pw = FileUtils.openToWrite(outputF);
		while (scanner.hasNext()) {
			String str = scanner.next();
			for (int i = 0; i < str.length; i++) {
				if (!(str.charAt(i).toUpperCase() < 97 || str.charAt(i).toUpperCase() > 122)) {
					
				}
			}
			
			
		} 
		
		
	}
	
}
