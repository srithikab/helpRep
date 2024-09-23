/**
 *	The game of Pig.
 *	User can decide wether to play with the computer, or run a simulation.
 * 	In playing with the computer, the goal is to get to a 100. However,
 * 	if you roll a 1, you will lose your current turn, and it's the computers
 *  turn, which is the same for the computer. In the simulation, it is
 *  a version of the Monte Carlo simulation, where the user enters a number
 *  of turns that the computer will simulate, and give the probabilty
 *  of rolling a couple of numbers.
 *  
 *	@author Srithika Barakam	
 *	@since 09/13/24
 */
public class PigGame {
	private int userTurn = 0; // users # of points on turn
	private int userTotal = 0; // users total TOTAL # of pointsnumber
	private int computerTurn = 0; //computers # of points on turn
	private int computerTotal = 0; // computers total TOTAL # of pointsnumber
	private boolean isUserTurn = true; // determines user/computer method
	private Dice dice = new Dice(); // object of dice class
	private double[] statisticsCounter = {0.0,0.0,0.0,0.0,0.0,0.0,0.0}; 
	// used for statistics, to collect values

	/** This method runs the two different methods needed to be run.
	 * Precondition:Program has no errors.
	 * @param n/a
	 * @return n/a
	 */
	
	public static void main(String[] args) {
		PigGame pigG = new PigGame();
			pigG.printIntroduction();
			pigG.userChoice();
		}
		
	/** This method is used for the first choice prompt, when the user
	 *  chooses between statistics or playing the game. Whatever the user
  	 *  chooses, is what is run.
	 * Postcondition: Another method is run depending on user choice
	 * @param n/a
	 * @return n/a
	 */
	
	public void userChoice() {
		boolean check = false;
		String str = "";
		do {
			str = Prompt.getString("Play game or Statistics (p or s) ");
			System.out.println("");
			if (str.equals("p") || str.equals("s"))
			{
				check = true;
			}
			else {
			}
		} while (check == false);
		if (str.equals("s")) {
			runStats();
		}
		else {
			play();
		}
	}
	
	/** This method is used when the user chooses statistics. This method
	 *  calls the computer stats method, which is where the computation
  	 *  occurs.
	 *  Postcondition: Statistics is printed out based on user entry.
	 *  @param n/a
	 *  @return n/a
	 */
	
	public void runStats() {
		System.out.print("Run statistical analysis - \"Hold at 20\"\n\n"); 
		int numberOfTurns = Prompt.getInt("Number of turns ", 1000, 1000000);
		System.out.print("\nEstimated Score Probability\n");
		System.out.println();
		for (int i = 0; i < numberOfTurns; i++) {
			computerStatsTurn();
		}

		System.out.println("0       " + (statisticsCounter[0]/numberOfTurns));
		System.out.println("20      " + (statisticsCounter[1]/numberOfTurns));
		System.out.println("21      " + (statisticsCounter[2]/numberOfTurns));
		System.out.println("22      " + (statisticsCounter[3]/numberOfTurns));
		System.out.println("23      " + (statisticsCounter[4]/numberOfTurns));
		System.out.println("24      " + (statisticsCounter[5]/numberOfTurns));
		System.out.println("25      " + (statisticsCounter[6]/numberOfTurns));
		System.out.println();
		
	}
	
	/** This method is where the statistics are calculated, by running
	 *  the game without printing anything out, and stopping if the dice
  	 *  roles past 20.
	 * Postcondition: Global Variable statisticsCounter gets updated.
	 * @param n/a
	 * @return n/a
	 */
	
	public void computerStatsTurn() {
		boolean bool = true;
		while (bool) {
			int diceVal = dice.roll();
		if (diceVal == 1) {
			statisticsCounter[0]++;
			bool = false;
		}
		else {
			computerTurn += diceVal;
			if (computerTurn >= 20) {
				if (computerTurn == 20) 
					statisticsCounter[1]++;
				else if (computerTurn == 21)
					statisticsCounter[2]++;
				else if (computerTurn == 22)
					statisticsCounter[3]++;
				else if (computerTurn == 23)
					statisticsCounter[4]++;
				else if (computerTurn == 24)
					statisticsCounter[5]++;
				else if (computerTurn == 25) 
					statisticsCounter[6]++;	
					bool = false;
				
				}
		
			}
		}
		computerTurn = 0;
	}
	
	/** This method is where both the computer and user playing is occuring.
	 *  A do while is runned, so that the user goes first, then prompting
  	 *  the computers part for the user to enter. Depending on whos turn 
  	 *  it is, which is based on the global variable isUserTurn, the computer
  	 *  will prompt the user/computer with either the roll option, or enter
  	 *  for computers turn. At the end, if the computer has gotten more 
  	 *  than a 100, it will print out a computer win, or it will print out
  	 * 	a user victory.
	 * Postcondition: APrints out who has won (at the very end).
	 * @param n/a
	 * @return n/a
	 */
	
	public void play() {
		do {
			if (isUserTurn) {
				System.out.println("Your turn score: " +  userTurn);
				System.out.println("Your total score: " + userTotal);
				String str = Prompt.getString("(r)oll or (h)old -> ");
				System.out.println("");
				if (str.equals("r") || str.equals("h")) {
					if (str.equals("r")) {
						userTurn();
					}
					else {
						isUserTurn = false;
						userTotal += userTurn;
						userTurn = 0;
						System.out.println("\nYou HOLD.");
						System.out.println("Your total score: " + userTotal);
						System.out.println();
					}
				}
			} else if (!isUserTurn) {
				System.out.println("Computer turn score: " +  computerTurn);
				System.out.println("Computer total score: " + computerTotal);
				String str = Prompt.getString("Press enter for computer turn -> ");
				if (computerTotal + computerTurn < 100) {
					computerTurn();
				} else {
					System.out.println("\nComputer will HOLD.");
					System.out.println("Computer total score: " + 
										(computerTotal + computerTurn));
					System.out.println();
					System.out.println("Too bad. COMPUTER WON.\n");
					break;
				}
			}
		} while (userTotal < 100 && computerTotal < 100);
		
		if (userTotal >= 100) {
			System.out.println("\nUser HOLD.");
			System.out.println("User total score: " + (userTotal + userTurn));
			System.out.println();
			System.out.println("CONGRATULATIONS, YOU WON!!!\n");
		}
		System.out.print("Thanks for playing Pig game!!!\n\n");
			
	}
	
	/** This method is where the dice is printed out, and the userTurn value
	 *  is increasing. If the dice is a 1, the user will lose their turn,
	 *  but if it's not a 1, the value is added to userTurn.
	 * Postcondition: Dice is printed out, and userTurn is getting updated.
	 * @param n/a
	 * @return n/a
	 */
	
	public void userTurn() {
		int diceVal = dice.roll();
		System.out.print("\nYou ROLL\n");
		dice.printDice();
		System.out.println();
		if (diceVal == 1) {
			userTurn = 0;
			isUserTurn = false;
			System.out.println("\nYou LOSE your turn.\nYour total score: " + 
															userTotal);
			System.out.println();
		}
		else {
			userTurn += diceVal;
		}
	}
	
	/** This method is similar to userTurn, since it is where the dice is
	 *  being printed out, and the computerTurn val is getting updated.
	 *  However, if the computer gets any more than a 20 on a turn, it will
	 *  automatically hold.
	 *  Postcondition: Computer dice is printed out, and computerVal is 
	 *  updated.
	 *  @param n/a
	 *  @return n/a
	 */
	
	public void computerTurn() {
		int diceVal = dice.roll();
		System.out.print("\nComputer Will ROLL\n");
		dice.printDice();
		System.out.println();
		if (diceVal == 1) {
			computerTurn = 0;
			isUserTurn = true;
			System.out.print("\nComputer loses turn.\nComputer total score: " + 
														computerTotal);
			System.out.println("\n");
		}
		else {
			computerTurn += diceVal;
			if (computerTurn >= 20) {
				isUserTurn = true;
				computerTotal += computerTurn;
				computerTurn = 0;
			}
		}
	}
		
	/** This method prints the introduction to the game.
	 * Post/precondition: n/a
	 * @param n/a
	 * @return n/a
	 */ 
	public void printIntroduction() {
		System.out.println("\n");
		System.out.println("______ _         _____");
		System.out.println("| ___ (_)       |  __ \\");
		System.out.println("| |_/ /_  __ _  | |  \\/ __ _ _ __ ___   ___");
		System.out.println("|  __/| |/ _` | | | __ / _` | '_ ` _ \\ / _ \\");
		System.out.println("| |   | | (_| | | |_\\ \\ (_| | | | | | |  __/");
		System.out.println("\\_|   |_|\\__, |  \\____/\\__,_|_| |_| |_|\\___|");
		System.out.println("          __/ |");
		System.out.println("         |___/");
		System.out.println("\nThe Pig Game is human vs computer. Each takes a"
							+ " turn rolling a die and the first to score");
		System.out.println("100 points wins. A player can either ROLL or "
							+ "HOLD. A turn works this way:");
		System.out.println("\n\tROLL:\t2 through 6: add points to turn total, "
							+ "player's turn continues");
		System.out.println("\t\t1: player loses turn");
		System.out.println("\tHOLD:\tturn total is added to player's score, "
							+ "turn goes to other player");
		System.out.println("\n");
	}
	
}
