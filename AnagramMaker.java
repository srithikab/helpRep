import java.util.ArrayList;
/**
 *	AnagramMaker - <description goes here>
 *
 *	Requires the WordUtilities, SortMethods, Prompt, and FileUtils classes
 *
 *	@author	Srithika Barakam
 *	@since	1/15/2024
 */
public class AnagramMaker {
								
	private final String FILE_NAME = "randomWords.txt";	// file containing all words
	
	private WordUtilities wu;	// the word utilities for building the word
								// database, sorting the database,
								// and finding all words that match
								// a string of characters
	
	// variables for constraining the print output of AnagramMaker
	private int numWords;		// the number of words in a phrase to print
	private int maxPhrases;		// the maximum number of phrases to print
	private int numPhrases;		// the number of phrases that have been printed
	boolean userPlaying;        // determines wether user wants to play or not
		
	/*	Initialize the database inside WordUtilities
	 *	The database of words does NOT have to be sorted for AnagramMaker to work,
	 *	but the output will appear in order if you DO sort.
	 */
	public AnagramMaker() {
		WordUtilities wu = new WordUtilities();
		//wu.readWordsFromFile(FILE_NAME);
		//wu.sortWords();
	}
	
	public static void main(String[] args) {
		AnagramMaker am = new AnagramMaker();
		am.run();
	}
	
	/**	The top routine that prints the introduction and runs the anagram-maker.
	 */
	public void run() {
		printIntroduction();
		runAnagramMaker();
		System.out.println("\nThanks for using AnagramMaker!\n");
	}
	
	/**
	 *	Print the introduction to AnagramMaker
	 */
	public void printIntroduction() {
		System.out.println("\nWelcome to ANAGRAM MAKER");
		System.out.println("\nProvide a word, name, or phrase and out comes their anagrams.");
		System.out.println("You can choose the number of words in the anagram.");
		System.out.println("You can choose the number of anagrams shown.");
		System.out.println("\nLet's get started!");
	}
	
	/**
	 *	Prompt the user for a phrase of characters, then create anagrams from those
	 *	characters.
	 */
	public void runAnagramMaker() {
		
		while(userPlaying) {
			
			String choice = getUserChoice();
			if (wordPlaying) {
				createAnagrams(choice);
				
			}
		}

	}
	/**
	 *	Prompts the user for the words they want to use, how many words
	 *  their anagram should be, and how many anagrams should be printed
	 * 	out. The only one returned is the word that the program should be 
	 * 	done on, and everything else is set with it's field variable.
	 *	@param listOfWords		list of words to search
	 *	@param target			the word to search for
	 *	@return					if found, the index of the word inside words;
	 *							if not found, a negative number
	 */
	public String getUserChoice() {

		String choice = Prompt.getString("Word(s), name, or phrase (q to quit)");
		if (choice.equalsIgnoreCase("q")) {
			userPlaying = false;
		}
		else {
			numWords = Prompt.getInt("Number of words in anagram -> ");
			maxPhrases = Prompt.getInt("Maximum number of anagrams to print -> ");
		}
		return choice;
	}
	public String createAnagrams	
}
