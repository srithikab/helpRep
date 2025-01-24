import java.util.ArrayList;

/**
 *	AnagramMaker - <description goes here>
 *
 *	Requires the WordUtilities, SortMethods, Prompt, and FileUtils classes
 *
 *	@author	Srithika Barakam
 *	@since	01/19/25
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
	private int numPhrasesPrint;		// the number of phrases that have been printed
	private ArrayList<String> anagram = new ArrayList<>();
	String newPhrase;
	boolean play = true;

		
	/*	Initialize the database inside WordUtilities
	 *	The database of words does NOT have to be sorted for AnagramMaker to work,
	 *	but the output will appear in order if you DO sort.
	 */
	public AnagramMaker() {
		wu = new WordUtilities();
		wu.readWordsFromFile(FILE_NAME);
		wu.sortWords();
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
		while (play) {
			String getWord = Prompt.getString("\nWord(s), name or phrase (q to quit) ");
			if (getWord.equalsIgnoreCase("q")) 
				return;
			numWords = Prompt.getInt("Number of words in anagram ");
			numPhrasesPrint = Prompt.getInt("Maximum number of anagrams to print ");
			int numTimes = numPhrasesPrint;
			System.out.println();
			newPhrase = removeNonAlpha(getWord);
			makeAnagram(newPhrase);
			System.out.println("\nStopped at " + numTimes + " anagrams.");
		}
	}
	
	private void makeAnagram(String phrase) {
		if (numPhrasesPrint <= 0 || (anagram.size() >= numWords && phrase.length() > 0)) {
			return;
		}
		if (phrase.length() == 0) {
			if (anagram.size() == numWords) {
				printAnagram(anagram);
				numPhrasesPrint--;
			}
			return;
		}

		if (phrase.length() == 1) {
			return;
		}
		ArrayList<String> allWords = wu.allWords(phrase);

		for (int i = 0; i < allWords.size() && anagram.size() < numWords; i++) {
			String word = allWords.get(i);
			
			// add to anagram
			anagram.add(word);
			
			// remove the word chars from phrase
            String newPhrase2 = removeWord(phrase, word);

			makeAnagram(newPhrase2);
            			
			anagram.remove(word);
		}
	}
	
	private String removeWord(String phrase, String word) {
		if (word.length() == 0) {
			return phrase;
		}
		int chCount [] = new int[122];
		for (int i = 0;i < word.length(); i++) {
			chCount[word.charAt(i)]++;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0;i < phrase.length(); i++) {
			if (chCount[phrase.charAt(i)] > 0) {
				chCount[phrase.charAt(i)]--;
			} else {
				sb.append(phrase.charAt(i));
			}
		}
		return sb.toString();
	}
	
	private void printAnagram(ArrayList<String> a) {
		for (int i = 0; i < a.size(); i++) {
			System.out.print(a.get(i) + " ");
		}
		System.out.println();
		
	}
	
	private String removeNonAlpha(String str) {
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (Character.isLetter(c)) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
