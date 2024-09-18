/**
 *	The game of Pig.
 *	(Description here)
 *
 *	@author	
 *	@since	
 */
public class PigGame {
	public static void main(String[] args) {
		PigGame pigG = new PigGame();
			pigG.printIntroduction();
			pigG.userChoice();
			pigG.playGame();
		}
	public void userChoice() {
		boolean check = false;
		String str = "";
		do {
			str = Prompt.getString("Play game or Statistics (p or s) -> ");
			if (str.equals("p") || str.equals("s"))
			{
				check = true;
			}
		} while (check == false);
		if (str == "s") {
			
		}
		else {
			playGame();
		}
	}
	public void playGame() {
		int userScore = 0;
		int computerScore = 0;
		boolean check = false;
		do {
			System.out.println("Your turn score: " +  userScore);
			System.out.println("Your total score: " + computerScore);
			String str = Prompt.getString("(r)oll or (h)old -> ");
			if (str.equals("r") || str.equals("h"))
			{
				if (str.equals("r")) {
					userTurn();
				}
				else {
				}
				check = true;
			}
		} while (check == false || (userScore != 100 ||computerScore != 100));
	}
	
	public void userTurn() {
		
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
