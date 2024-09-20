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
	private int userTurn = 0;
	private int userTotal = 0;
	private int computerTurn = 0;
	private int computerTotal = 0;
	private boolean isUserTurn = true;
	private Dice dice = new Dice();
	private double[] statisticsCounter = {0.0,0.0,0.0,0.0,0.0,0.0,0.0};
	
	public static void main(String[] args) {
		PigGame pigG = new PigGame();
			pigG.printIntroduction();
			pigG.userChoice();
		}
		
	public void userChoice() {
		boolean check = false;
		String str = "";
		do {
			str = Prompt.getString("Play game or Statistics (p or s)");
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
	
	public void runStats() {
		System.out.print("Run statistical analysis - \"Hold at 20\"\n\n"); 
		int numberOfTurns = Prompt.getInt("Number of turns ", 1000, 1000000);
		System.out.print("\nEstimated Score Probability\n");
		System.out.println();
		for (int i = 0; i < numberOfTurns; i++) {
			computerStatsTurn();
		}
		//System.out.println(statisticsCounter[0] + " " + numberOfTurns);
		System.out.println("0       " + (statisticsCounter[0]/numberOfTurns));
		
		//System.out.println(statisticsCounter[1] + " " + numberOfTurns);
		System.out.println("20      " + (statisticsCounter[1]/numberOfTurns));
		
		//System.out.println(statisticsCounter[2] + " " + numberOfTurns);
		System.out.println("21      " + (statisticsCounter[2]/numberOfTurns));
		
		//System.out.println(statisticsCounter[3] + " " + numberOfTurns);
		System.out.println("22      " + (statisticsCounter[3]/numberOfTurns));
		
		//System.out.println(statisticsCounter[4] + " " + numberOfTurns);
		System.out.println("23      " + (statisticsCounter[4]/numberOfTurns));
		
		//System.out.println(statisticsCounter[5] + " " + numberOfTurns);
		System.out.println("24      " + (statisticsCounter[5]/numberOfTurns));
		
		//System.out.println(statisticsCounter[6] + " " + numberOfTurns);
		System.out.println("25      " + (statisticsCounter[6]/numberOfTurns));
		System.out.println();
		
	}
	
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
			System.out.println("Too bad. USER WON.\n");
		}
			
	}
	
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
		
	/**	Print the introduction to the game */
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
