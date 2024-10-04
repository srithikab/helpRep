/**
 *  This class creates and manages one array of pegs from the game MasterMind.
 *
 *  @author
 *  @since
*/

public class PegArray {

	// array of pegs
	private Peg [] pegs;
	private Peg [] masterPegs;
	private Peg [] tempPegs;
	private Peg [] tempMasterPegs;

	// the number of exact and partial matches for this array
	// as matched against the master.
	// Precondition: these values are valid after getExactMatches() and getPartialMatches()
	//				are called
	private int exactMatches, partialMatches;
		
	/**
	 *	Constructor
	 *	@param numPegs	number of pegs in the array
	 */
	public PegArray(int numPegs) {	
		
		
		}
		
	/**
	 *	Constructor
	 * 	Initialzes pegs array
	 *	@param str		String entered when called.
	 */
	public PegArray(String str) {
		pegs= new Peg[4];
		tempPegs = new Peg[4];
		for (int i = 0; i < str.length(); i++)
		{
			pegs[i] = new Peg(str.charAt(i));
			tempPegs[i] = new Peg(str.charAt(i));
		}
		
	}

	/**
	 *	Return the peg object
	 *	@param n	The peg index into the array
	 *	@return		the peg object
	 */
	public Peg getPeg(int n) { 
		
		
		return pegs[n];
		
		
		
		 }
	
	/**
	 *  Finds exact matches between master (key) peg array and this peg array
	 *	Postcondition: field exactMatches contains the matches with the master
	 *  @param master	The master (code) peg array
	 *	@return			The number of exact matches
	 */
	public int getExactMatches(PegArray master) { 
		tempMasterPegs = new Peg[4];
		for (int i = 0; i < 4; i ++) {
			tempMasterPegs[i] = new Peg(master.getPeg(i).getLetter());
		}
		
		int counter = 0;
		
		for (int i = 0; i < pegs.length; i++) {
			if (pegs[i].getLetter() == master.getPeg(i).getLetter()) {
				tempPegs[i] = new Peg('X');
				tempMasterPegs[i] = new Peg('Y');
				counter++;	
			}	
		}
		exactMatches = counter;
		return counter; 
	}
	
	/**
	 *  Find partial matches between master (key) peg array and this peg array
	 *	Postcondition: field partialMatches contains the matches with the master
	 *  @param master	The master (code) peg array
	 *	@return			The number of partial matches
	 */
	public int getPartialMatches(PegArray master) { 
		int counter = 0;
		for (int i = 0; i < pegs.length; i++) {
			for (int j = 0; j < tempPegs.length; j++) {
				//System.out.println(tempPegs[i].getLetter() + " " + tempMasterPegs[j].getLetter());
				if (tempMasterPegs[j].getLetter() == tempPegs[i].getLetter()) {
					tempPegs[i] = new Peg('X');
					tempMasterPegs[j] = new Peg('Y');
					counter++;
				}
			}
		}
		partialMatches = counter;
		return counter; 
	}
	
	// Accessor methods
	// Precondition: getExactMatches() and getPartialMatches() must be called first
	public int getExact() { return exactMatches; }
	public int getPartial() { return partialMatches; }

}
