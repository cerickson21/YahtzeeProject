import java.util.Scanner;

public class YahtzeeDriver
{
	/*
	1. Creates a new instance of the YahtzeeGame class
	2. Calls the playGame method on the Yahtzee object
	3. Asks user if they would like to play again
	4. When the user is done playing, prints the number of games played, min, max, and average score
	*/
	public static void main(String [] args) {
		char playAgain = 'y';
		Scanner s = new Scanner(System.in);
		int score = 0;
		int maxScore = -1;
		int minScore = 999999999;
		int totalScore = 0;
		double numTimesPlayed = 0;
		while (playAgain == 'y'){
			YahtzeeGame myGame = new YahtzeeGame();
			System.out.println("Welcome to Connor's AP CSA Yahtzee Game!");
			score = myGame.playGame();
			if (score>maxScore){
				maxScore = score;
			}if (score<minScore){
				minScore = score;
			}
			System.out.print("Would you like to play again? y/n: ");
			playAgain = s.nextLine().charAt(0);
			totalScore+=score;
			numTimesPlayed++;
		}
		System.out.println("Your high score is "+maxScore);
		System.out.println("Your low score is "+minScore);
		System.out.println("Your average score is "+totalScore/numTimesPlayed);
	}
}
