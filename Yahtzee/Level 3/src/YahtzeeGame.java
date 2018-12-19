import java.util.Scanner;

public class YahtzeeGame
{
	/* instance data should include the five yahtzee dice, a scoreboard, and a CONSTANT (static final) variable NUM_SIDES
	which should be set to six (the number of sides on a yahtzee die) */

	private YahtzeeDie die1;
	private YahtzeeDie die2;
	private YahtzeeDie die3;
	private YahtzeeDie die4;
	private YahtzeeDie die5;
	private static int NUM_SIDES = 6;
	private YahtzeeScorecard scorecard;
	private Scanner s;


	/* initializes the dice and scoreboard */
	public YahtzeeGame()
	{
		die1 = new YahtzeeDie(NUM_SIDES);
		die2 = new YahtzeeDie(NUM_SIDES);
		die3 = new YahtzeeDie(NUM_SIDES);
		die4 = new YahtzeeDie(NUM_SIDES);
		die5 = new YahtzeeDie(NUM_SIDES);
		scorecard = new YahtzeeScorecard();
		s = new Scanner (System.in);
	}

	/* check to see if the game is over, and while the game is not over call the method takeTurn()
	once the game ends (hint: there are 13 turns in a game of Yahtzee), the method should print a
	final scorecard and return the grand total */
	public int playGame()
	{
		int count = 13;
		while (count>0){
			takeTurn();
			count--;
		}
		scorecard.printScoreCard();
		return scorecard.getGrandTotal();
	}

	/* 	1. call rollDice()
		2. call printDice()
		3. Ask the user if they are satisfied with their roll, or if they would like to roll again.
		   If they are not satisfied continue, otherwise call markScore()
		4. call chooseFrozen()
		5. call rollDice()
		6. call printDice()
		7. Ask the user if they are satisfied with their roll, or if they would like to roll again.
		   If they are not satisfied continue, otherwise call markScore()
		8. call chooseFrozen()
		9. call rollDice()
		10. call printDice()
		11. call markScore()
	*/
	private void takeTurn()
	{
		System.out.println("Your first roll: ");
		rollDice();
		printDice();
		System.out.print("Press \"s\" if you're satisfied, and press \"r\" if you want to roll again.");
		String userChoice = s.nextLine();
		if (userChoice.charAt(0) =='s'){
			markScore();
		}else if (userChoice.charAt(0)=='r') {
			chooseFrozen();
			System.out.println("Your second roll: ");
			rollDice();
			printDice();
			System.out.print("Press \"s\" if you're satisfied, or press \"r\" if you want to roll again.");
			userChoice = s.nextLine();
			if (userChoice.charAt(0) == 's') {
				markScore();
			}else if (userChoice.charAt(0) == 'r') {
				chooseFrozen();
				System.out.println("Your third roll: ");
				rollDice();
				printDice();
				markScore();
			}
		}
	}

	/* Rolls all unfrozen dice.  Also resets all dice to the unfrozen state after the roll */
	private void rollDice()
	{
		if (!die1.isFrozen()){
			die1.rollDie();
		}
		if (!die2.isFrozen()){
			die2.rollDie();
		}
		if (!die3.isFrozen()){
			die3.rollDie();
		}
		if (!die4.isFrozen()){
			die4.rollDie();
		}
		if (!die5.isFrozen()){
			die5.rollDie();
		}
	}

	/* Asks the user which dice should be frozen 1-5 (should be read in in one line) */
	private void chooseFrozen()
	{
		System.out.print("Which dice would you like to freeze?");
		String dieToFreeze = s.nextLine();
		if (dieToFreeze.indexOf('1')>=0){
			die1.freezeDie();
		}
		if (dieToFreeze.indexOf('2')>=0){
			die2.freezeDie();
		}
		if (dieToFreeze.indexOf('3')>=0){
			die3.freezeDie();
		}
		if (dieToFreeze.indexOf('4')>=0){
			die4.freezeDie();
		}
		if (dieToFreeze.indexOf('5')>=0){
			die5.freezeDie();
		}
	}

	/* Should print the value of all five dice separated by a tab (\t) to the console */
	private void printDice()
	{
		System.out.println(die1.getValue()+"\t"+die2.getValue()+"\t"+die3.getValue()+"\t"+die4.getValue()+"\t"+
				die5.getValue()+"\t");
	}

	/* 1. Print a scoreboard
	   2. Ask the user where they would like to mark their score.
	   3. Call appropriate function
	   4. If false is returned the user entered an invalid number, so ask the user to try again	*/
	private void markScore()
	{
		scorecard.printScoreCard();
		System.out.println("Where would you like to mark your score?");
		System.out.println("1. Ones \t7.  3 of Kind");
		System.out.println("2. Twos \t8.  4 of Kind");
		System.out.println("3. Threes \t9.  Full House");
		System.out.println("4. Fours \t10. Sm Straight");
		System.out.println("5. Fives \t11. Lg Straight");
		System.out.println("6. Sixes \t12. Yahtzee");
		System.out.println("\t\t13. Chance");
		System.out.print("Your final roll was: ");
		printDice();
		System.out.print("Enter 1-13: ");
		int scoreLocation = s.nextInt();
		s.nextLine();
		boolean scoreMarked = false;
		while (!scoreMarked){
			switch (scoreLocation){
				case 1:
					if (scorecard.markOnes(die1.getValue(),die2.getValue(),die3.getValue(),die4.getValue(),die5.getValue())){
						scorecard.markOnes(die1.getValue(),die2.getValue(),die3.getValue(),die4.getValue(),die5.getValue());
						scoreMarked = true;
					}else{
						System.out.println("Invalid entry. Please try again.");
						System.out.print("Enter 1-13: ");
						scoreLocation = s.nextInt();
						s.nextLine();
					}
					die1.unfreezeDie();
					die2.unfreezeDie();
					die3.unfreezeDie();
					die4.unfreezeDie();
					die5.unfreezeDie();
					break;
				case 2:
					if (scorecard.markTwos(die1.getValue(),die2.getValue(),die3.getValue(),die4.getValue(),die5.getValue())){
						scorecard.markTwos(die1.getValue(),die2.getValue(),die3.getValue(),die4.getValue(),die5.getValue());
						scoreMarked = true;
					}else{
						System.out.println("Invalid entry. Please try again.");
						System.out.print("Enter 1-13: ");
						scoreLocation = s.nextInt();
						s.nextLine();
					}
					die1.unfreezeDie();
					die2.unfreezeDie();
					die3.unfreezeDie();
					die4.unfreezeDie();
					die5.unfreezeDie();
					break;
				case 3:
					if (scorecard.markThrees(die1.getValue(),die2.getValue(),die3.getValue(),die4.getValue(),die5.getValue())){
						scorecard.markThrees(die1.getValue(),die2.getValue(),die3.getValue(),die4.getValue(),die5.getValue());
						scoreMarked = true;
					}else{
						System.out.println("Invalid entry. Please try again.");
						System.out.print("Enter 1-13: ");
						scoreLocation = s.nextInt();
						s.nextLine();
					}
					die1.unfreezeDie();
					die2.unfreezeDie();
					die3.unfreezeDie();
					die4.unfreezeDie();
					die5.unfreezeDie();
					break;
				case 4:
					if (scorecard.markFours(die1.getValue(),die2.getValue(),die3.getValue(),die4.getValue(),die5.getValue())){
						scorecard.markFours(die1.getValue(),die2.getValue(),die3.getValue(),die4.getValue(),die5.getValue());
						scoreMarked = true;
					}else{
						System.out.println("Invalid entry. Please try again.");
						System.out.print("Enter 1-13: ");
						scoreLocation = s.nextInt();
						s.nextLine();
					}
					die1.unfreezeDie();
					die2.unfreezeDie();
					die3.unfreezeDie();
					die4.unfreezeDie();
					die5.unfreezeDie();
					break;
				case 5:
					if (scorecard.markFives(die1.getValue(),die2.getValue(),die3.getValue(),die4.getValue(),die5.getValue())){
						scorecard.markFives(die1.getValue(),die2.getValue(),die3.getValue(),die4.getValue(),die5.getValue());
						scoreMarked = true;
					}else{
						System.out.println("Invalid entry. Please try again.");
						System.out.print("Enter 1-13: ");
						scoreLocation = s.nextInt();
						s.nextLine();
					}
					die1.unfreezeDie();
					die2.unfreezeDie();
					die3.unfreezeDie();
					die4.unfreezeDie();
					die5.unfreezeDie();
					break;
				case 6:
					if (scorecard.markSixes(die1.getValue(),die2.getValue(),die3.getValue(),die4.getValue(),die5.getValue())){
						scorecard.markSixes(die1.getValue(),die2.getValue(),die3.getValue(),die4.getValue(),die5.getValue());
						scoreMarked = true;
					}else{
						System.out.println("Invalid entry. Please try again.");
						System.out.print("Enter 1-13: ");
						scoreLocation = s.nextInt();
						s.nextLine();
					}
					die1.unfreezeDie();
					die2.unfreezeDie();
					die3.unfreezeDie();
					die4.unfreezeDie();
					die5.unfreezeDie();
					break;
				case 7:
					if (scorecard.markThreeOfAKind(die1.getValue(),die2.getValue(),die3.getValue(),die4.getValue(),die5.getValue())){
						scorecard.markThreeOfAKind(die1.getValue(),die2.getValue(),die3.getValue(),die4.getValue(),die5.getValue());
						scoreMarked = true;
					}else{
						System.out.println("Invalid entry. Please try again.");
						System.out.print("Enter 1-13: ");
						scoreLocation = s.nextInt();
						s.nextLine();
					}
					die1.unfreezeDie();
					die2.unfreezeDie();
					die3.unfreezeDie();
					die4.unfreezeDie();
					die5.unfreezeDie();
					break;
				case 8:
					if (scorecard.markFourOfAKind(die1.getValue(),die2.getValue(),die3.getValue(),die4.getValue(),die5.getValue())){
						scorecard.markFourOfAKind(die1.getValue(),die2.getValue(),die3.getValue(),die4.getValue(),die5.getValue());
						scoreMarked = true;
					}else{
						System.out.println("Invalid entry. Please try again.");
						System.out.print("Enter 1-13: ");
						scoreLocation = s.nextInt();
						s.nextLine();
					}
					die1.unfreezeDie();
					die2.unfreezeDie();
					die3.unfreezeDie();
					die4.unfreezeDie();
					die5.unfreezeDie();
					break;
				case 9:
					if (scorecard.markFullHouse(die1.getValue(),die2.getValue(),die3.getValue(),die4.getValue(),die5.getValue())){
					scorecard.markFullHouse(die1.getValue(),die2.getValue(),die3.getValue(),die4.getValue(),die5.getValue());
					scoreMarked = true;
					}else{
						System.out.println("Invalid entry. Please try again.");
						System.out.print("Enter 1-13: ");
						scoreLocation = s.nextInt();
						s.nextLine();
					}
					die1.unfreezeDie();
					die2.unfreezeDie();
					die3.unfreezeDie();
					die4.unfreezeDie();
					die5.unfreezeDie();
				break;
				case 10:
					if (scorecard.markSmallStraight(die1.getValue(),die2.getValue(),die3.getValue(),die4.getValue(),die5.getValue())){
						scorecard.markSmallStraight(die1.getValue(),die2.getValue(),die3.getValue(),die4.getValue(),die5.getValue());
						scoreMarked = true;
					}else{
						System.out.println("Invalid entry. Please try again.");
						System.out.print("Enter 1-13: ");
						scoreLocation = s.nextInt();
						s.nextLine();
					}
					die1.unfreezeDie();
					die2.unfreezeDie();
					die3.unfreezeDie();
					die4.unfreezeDie();
					die5.unfreezeDie();
					break;
				case 11:
					if (scorecard.markLargeStraight(die1.getValue(),die2.getValue(),die3.getValue(),die4.getValue(),die5.getValue())){
						scorecard.markLargeStraight(die1.getValue(),die2.getValue(),die3.getValue(),die4.getValue(),die5.getValue());
						scoreMarked = true;
					}else{
						System.out.println("Invalid entry. Please try again.");
						System.out.print("Enter 1-13: ");
						scoreLocation = s.nextInt();
						s.nextLine();
					}
					die1.unfreezeDie();
					die2.unfreezeDie();
					die3.unfreezeDie();
					die4.unfreezeDie();
					die5.unfreezeDie();
					break;
				case 12:
					if (scorecard.markYahtzee(die1.getValue(),die2.getValue(),die3.getValue(),die4.getValue(),die5.getValue())){
						scorecard.markYahtzee(die1.getValue(),die2.getValue(),die3.getValue(),die4.getValue(),die5.getValue());
						scoreMarked = true;
					}else{
						System.out.println("Invalid entry. Please try again.");
						System.out.print("Enter 1-13: ");
						scoreLocation = s.nextInt();
						s.nextLine();
					}
					die1.unfreezeDie();
					die2.unfreezeDie();
					die3.unfreezeDie();
					die4.unfreezeDie();
					die5.unfreezeDie();
					break;
				case 13:
					if (scorecard.markChance(die1.getValue(),die2.getValue(),die3.getValue(),die4.getValue(),die5.getValue())){
						scorecard.markChance(die1.getValue(),die2.getValue(),die3.getValue(),die4.getValue(),die5.getValue());
						scoreMarked = true;
					}else{
						System.out.println("Invalid entry. Please try again.");
						System.out.print("Enter 1-13: ");
						scoreLocation = s.nextInt();
						s.nextLine();
					}
					die1.unfreezeDie();
					die2.unfreezeDie();
					die3.unfreezeDie();
					die4.unfreezeDie();
					die5.unfreezeDie();
					break;
			}
		}
	}
}