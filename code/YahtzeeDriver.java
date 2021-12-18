import java.util.*;

public class YahtzeeDriver
{
	/*
	1. Creates a new instance of the YahtzeeGame class
	2. Calls the playGame method on the Yahtzee object
	3. Asks user if they would like to play again
	4. When the user is done playing, prints the number of games played, min, max, and average score
	*/
	public static void main(String [] args)
	{
		int score; //current game's score
		char replay; //user input telling whether to replay game or not
		int x = 0; //to determine whether to continue while loop
		Scanner s = new Scanner(System.in);
		int min; //min score
		int max; //max score
		int numGames = 1; //number of games played
		int totalScore; //sum of scores
		YahtzeeGame myGame = new YahtzeeGame();
		System.out.println("Welcome to Dhruv's APCSA Yahtzee Game!");
		score=myGame.playGame();
		min = score;
		max = score;
		totalScore = score;




		while (x == 0) //replay the game or not
		{
			System.out.print("Would you like to play again? (y/n)");
			replay = s.nextLine().charAt(0);

			if (replay == 'y' || replay == 'Y')
			{
				myGame = new YahtzeeGame();
				score=myGame.playGame();
				totalScore += score;
				numGames ++;

				if (score < min)//update min if necessary
				{
					min = score;
				}
				if (score > max) //update max if necessary
				{
					max = score;
				}
			}
			else if (replay == 'n' || replay == 'N')
			{
				System.out.println("Thank you for playing Dhruv's APCSA Yahtzee Game! You played " + numGames + " games. " +
						"Your highest score was " + max + ", your lowest score was " + min + ", and your average score was "
						+ 1.0*totalScore/numGames + ".");
				x++;
			}
			else
			{
				System.out.println("Please enter a valid option.");
			}

		}

	}
}
