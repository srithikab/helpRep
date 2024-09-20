/**
 *	The game of Pig.
 *	(Description here)
 *
 *	@author	
 *	@since	
 */
public class PigGame {
	private int userTurn = 0;
	private int userTotal = 0;
	private int computerTurn = 0;
	private int computerTotal = 0;
	private boolean isUserTurn = true;
	private Dice dice = new Dice();
	
	public static void main(String[] args) {
		PigGame pigG = new PigGame();
			pigG.printIntroduction();
			pigG.userChoice();
		}
		
	public void userChoice() {
		boolean check = false;
		String str = "";
		do {
			str = Prompt.getString("Play game or Statistics (p or s) -> ");
			System.out.println("");
			if (str.equals("p") || str.equals("s"))
			{
				check = true;
			}
		} while (check == false);
		if (str == "s") {
			
		}
		else {
			play();
		}
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
					System.out.println("Computer total score: " + (computerTotal + computerTurn));
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
			System.out.println("\nYou LOSE your turn.\nYour total score: " + userTotal);
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
			System.out.print("\nComputer loses turn.\nComputer total score: " + computerTotal);
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

