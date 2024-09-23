
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
	
	
		
	/** Constructor */
	public MVCipher() { }
	
	public static void main(String[] args) {
		MVCipher mvc = new MVCipher();
		mvc.run();
	}
	
	/**
	 *	Method header goes here
	 */
	public void run() {
		System.out.println("\n Welcome to the MV Cipher machine!\n");
		
		/* Prompt for a key and change to uppercase
		   Do not let the key contain anything but alpha
		   Use the Prompt class to get user input */
		   boolean checker = false;
		   do {
		   keyWord = Prompt.getString("Please input a word to use as" +
								"key (letters only) "	);
			for (int i = 0; i < keyWord.length(); i++) {
				if (((int)(keyWord.charAt(i)) >= 65 && (int)(keyWord.charAt(i)) 
				<= 90 ) || ((int)(keyWord.charAt(i)) >= 65 && (int)
				(keyWord.charAt(i)) <= 90 ));
								
		
		/* Prompt for encrypt or decrypt */
		
		int choiceP = Prompt.getInt("Encrypt or decrypt? (1, 2) ");
		
			
		/* Prompt for an input file name */
		if (choiceP == 1) {
			String inputF = Prompt.getString("Name of file to ecrypt ");
		}
		else {
			String inputF = Prompt.getString("Name of file to decrypt ");
		}
		
		
		
		/* Prompt for an output file name */
		
		String outputF = Prompt.getString("Name of output file ");
		
		
		/* Read input file, encrypt or decrypt, and print to output file */
		
		
		/* Don't forget to close your output file */
	}
	
	// other methods go here
	
}
