import java.util.Scanner;

public class Yahtzee {
	
	private DiceGroup dg = new DiceGroup();
	private YahtzeePlayer yz1 = new YahtzeePlayer();
	private	YahtzeePlayer yz2 = new YahtzeePlayer();
	private YahtzeeScoreCard ysc1 = new YahtzeeScoreCard();
		
	public static void main(String [] args) {
		Yahtzee yz = new Yahtzee();
		yz.run();
	}
	public void run() {
		
		printHeader(); 
		
		yz1.setName(Prompt.getString("Player 1, please enter your"
										+" first name"));
		System.out.println();
		yz2.setName(Prompt.getString("Player 2, please enter your"
									+" first name"));
		System.out.println();
		String canContinue = Prompt.getString(("Let's see who will go first. " 
				+ yz1.getName() + " please hit enter to roll the dice -> "));
				
		startGame();
		playGame();
	}
	public void startGame() {							
		DiceGroup dg = new DiceGroup();
		dg.rollDice();
		int val1 = dg.getTotal();
		dg.printDice();
		
		String canContinue2 = Prompt.getString(("Let's see who will go first. " 
				+ yz2.getName() + " please hit enter to roll the dice "));
							
		dg.rollDice();
		int val2 = dg.getTotal();
		dg.printDice();
		
		System.out.println(yz1.getName() + ", you rolled a sum of " + val1
		+ ", and " + yz2.getName() + ", you rolled a sum of " + val2);
		
		if (val2 > val1) {
			String name = yz1.getName();
			yz1.setName(yz2.getName());
			yz2.setName(name);
			
			System.out.print("\n" + yz1.getName() + ", since your sum was higher " +
							"you'll roll first.");
		}
		else if (val2 == val1) {
			startGame();
		}
		else {
			System.out.print("\n" + yz1.getName() + ", since your sum was higher " +
							"you'll roll first.");
		}
		
	}
	
	public void playGame() {
		ysc1.printCardHeader();
		ysc1.printPlayerScore(yz1);
		ysc1.printPlayerScore(yz2);

		
	}
	
	
	public void printHeader() {
		System.out.println("\n");
		System.out.println("+------------------------------------------------------------------------------------+");
		System.out.println("| WELCOME TO MONTA VISTA YAHTZEE!                                                    |");
		System.out.println("|                                                                                    |");
		System.out.println("| There are 13 rounds in a game of Yahtzee. In each turn, a player can roll his/her  |");
		System.out.println("| dice up to 3 times in order to get the desired combination. On the first roll, the |");
		System.out.println("| player rolls all five of the dice at once. On the second and third rolls, the      |");
		System.out.println("| player can roll any number of dice he/she wants to, including none or all of them, |");
		System.out.println("| trying to get a good combination.                                                  |");
		System.out.println("| The player can choose whether he/she wants to roll once, twice or three times in   |");
		System.out.println("| each turn. After the three rolls in a turn, the player must put his/her score down |");
		System.out.println("| on the scorecard, under any one of the thirteen categories. The score that the     |");
		System.out.println("| player finally gets for that turn depends on the category/box that he/she chooses  |");
		System.out.println("| and the combination that he/she got by rolling the dice. But once a box is chosen  |");
		System.out.println("| on the score card, it can't be chosen again.                                       |");
		System.out.println("|                                                                                    |");
		System.out.println("| LET'S PLAY SOME YAHTZEE!                                                           |");
		System.out.println("+------------------------------------------------------------------------------------+");
		System.out.println("\n\n");
	}
}
