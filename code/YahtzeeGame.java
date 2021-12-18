import java.util.*;

public class YahtzeeGame
{
	/* five yahtzee dice, a scoreboard, and a CONSTANT (static final) variable NUM_SIDES
	which is set to six (the number of sides on a yahtzee die) */

	private YahtzeeDie d1;
	private YahtzeeDie d2;
	private YahtzeeDie d3;
	private YahtzeeDie d4;
	private YahtzeeDie d5;
	private YahtzeeScorecard scoreC;
	public static final int NUM_SIDES = 6;


	/* initializes the dice and scoreboard */
	public YahtzeeGame()
	{
		d1 = new YahtzeeDie(NUM_SIDES);
		d2 = new YahtzeeDie(NUM_SIDES);
		d3 = new YahtzeeDie(NUM_SIDES);
		d4 = new YahtzeeDie(NUM_SIDES);
		d5 = new YahtzeeDie(NUM_SIDES);
		scoreC = new YahtzeeScorecard();
	}

	/* check to see if the game is over, and while the game is not over call the method takeTurn()
	once the game ends (there are 13 turns in a game of Yahtzee), the method should print a
	final scorecard and return the grand total */
	public int playGame()
	{
		for (int i = 0; i<13; i++) //conduct 13 turns
		{
			takeTurn();
		}
		scoreC.printScoreCard();
		return scoreC.getGrandTotal();
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
		Scanner s = new Scanner(System.in);
		rollDice();
		printDice();

		System.out.print("Are you satisfied with your run or would you like to roll again? (type \"s\" for satisfied and \"r\" for roll again): ");
		char satOrRoll = s.nextLine().charAt(0);

		if (satOrRoll == 's') {
			markScore();
		} else {
			chooseFrozen();
			rollDice();
			printDice();

			System.out.print("Are you satisfied with your run or would you like to roll again? (type \"s\" for satisfied and \"r\" for roll again): ");
			satOrRoll = s.nextLine().charAt(0);
			if (satOrRoll == 's') {
				markScore();
			} else {
				chooseFrozen();
				rollDice();
				printDice();
				markScore();
			}
		}
	}

	/* Rolls all unfrozen dice.  Also resets all dice to the unfrozen state after the roll */
	private void rollDice()
	{
		if (!d1.isFrozen())
		{
			d1.rollDie();
		}
		if (!d2.isFrozen())
		{
			d2.rollDie();
		}
		if (!d3.isFrozen())
		{
			d3.rollDie();
		}
		if (!d4.isFrozen())
		{
			d4.rollDie();
		}
		if (!d5.isFrozen())
		{
			d5.rollDie();
		}

		d1.unfreezeDie();
		d2.unfreezeDie();
		d3.unfreezeDie();
		d4.unfreezeDie();
		d5.unfreezeDie();
	}

	/* Asks the user which dice should be frozen 1-5 (should be read in in one line) */
	private void chooseFrozen()
	{
		Scanner s = new Scanner(System.in);
		System.out.print("Which dice should be frozen? (enter the number of each dice to freeze): ");
		String input = s.nextLine();

		if (input.indexOf("1") != -1) //freeze die if it is in the entered string
		{
			d1.freezeDie();
		}
		if (input.indexOf("2") != -1) //freeze die if it is in the entered string
		{
			d2.freezeDie();
		}
		if (input.indexOf("3") != -1) //freeze die if it is in the entered string
		{
			d3.freezeDie();
		}
		if (input.indexOf("4") != -1) //freeze die if it is in the entered string
		{
			d4.freezeDie();
		}
		if (input.indexOf("5") != -1) //freeze die if it is in the entered string
		{
			d5.freezeDie();
		}
	}

	/* Print the value of all five dice separated by a tab (\t) to the console */
	private void printDice()
	{
		System.out.println(d1.getValue()+ "\t" + d2.getValue()+ "\t" + d3.getValue()+ "\t" + d4.getValue()+ "\t" + d5.getValue());
	}

	/* 1. Print a scoreboard
	   2. Ask the user where they would like to mark their score.
	   3. Call appropriate function
	   4. If false is returned the user entered an invalid number, so ask the user to try again	*/
	private void markScore()
	{
		boolean valid = false;
		Scanner s = new Scanner(System.in);

		scoreC.printScoreCard();


		System.out.print("Where would you like to place your score?\n" +
				"1. Ones \t7.  3 of Kind\n" +
				"2. Twos \t8.  4 of Kind\n" +
				"3. Threes \t9.  Full House\n" +
				"4. Fours \t10. Sm Straight\n" +
				"5. Fives \t11. Lg Straight\n" +
				"6. Sixes \t12. Yahtzee\n" +
				"\t\t13. Chance\n" +
				"Enter 1-13: ");

		int mark = s.nextInt();

		while (mark < 1 || mark > 13 )
		{
			System.out.print("Where would you like to place your score?\n" +
					"1. Ones \t7.  3 of Kind\n" +
					"2. Twos \t8.  4 of Kind\n" +
					"3. Threes \t9.  Full House\n" +
					"4. Fours \t10. Sm Straight\n" +
					"5. Fives \t11. Lg Straight\n" +
					"6. Sixes \t12. Yahtzee\n" +
					"\t\t13. Chance\n" +
					"Enter 1-13: ");
			mark = s.nextInt();

		}


		while (!valid)
		{
			if (mark == 1)
			{
				valid = scoreC.markOnes(d1.getValue(), d2.getValue(), d3.getValue(), d4.getValue(), d5.getValue());
			}
			else if (mark == 2)
			{
				valid = scoreC.markTwos(d1.getValue(), d2.getValue(), d3.getValue(), d4.getValue(), d5.getValue());
			}
			else if (mark == 3)
			{
				valid = scoreC.markThrees(d1.getValue(), d2.getValue(), d3.getValue(), d4.getValue(), d5.getValue());
			}
			else if (mark == 4)
			{
				valid = scoreC.markFours(d1.getValue(), d2.getValue(), d3.getValue(), d4.getValue(), d5.getValue());
			}
			else if (mark == 5)
			{
				valid = scoreC.markFives(d1.getValue(), d2.getValue(), d3.getValue(), d4.getValue(), d5.getValue());
			}
			else if (mark == 6)
			{
				valid = scoreC.markSixes(d1.getValue(), d2.getValue(), d3.getValue(), d4.getValue(), d5.getValue());
			}
			else if (mark == 7)
			{
				valid = scoreC.markThreeOfAKind(d1.getValue(), d2.getValue(), d3.getValue(), d4.getValue(), d5.getValue());
			}
			else if (mark == 8)
			{
				valid = scoreC.markFourOfAKind(d1.getValue(), d2.getValue(), d3.getValue(), d4.getValue(), d5.getValue());
			}
			else if (mark == 9)
			{
				valid = scoreC.markFullHouse(d1.getValue(), d2.getValue(), d3.getValue(), d4.getValue(), d5.getValue());
			}
			else if (mark == 10)
			{
				valid = scoreC.markSmallStraight(d1.getValue(), d2.getValue(), d3.getValue(), d4.getValue(), d5.getValue());
			}
			else if (mark == 11)
			{
				valid = scoreC.markLargeStraight(d1.getValue(), d2.getValue(), d3.getValue(), d4.getValue(), d5.getValue());
			}
			else if (mark == 12)
			{
				valid = scoreC.markYahtzee(d1.getValue(), d2.getValue(), d3.getValue(), d4.getValue(), d5.getValue());
			}
			else if (mark == 13)
			{
				valid = scoreC.markChance(d1.getValue(), d2.getValue(), d3.getValue(), d4.getValue(), d5.getValue());
			}

			if (!valid)
			{
				System.out.println("Invalid Input\n" +
						"Where would you like to place your score?\n" +
						"1. Ones \t7.  3 of Kind\n" +
						"2. Twos \t8.  4 of Kind\n" +
						"3. Threes \t9.  Full House\n" +
						"4. Fours \t10. Sm Straight\n" +
						"5. Fives \t11. Lg Straight\n" +
						"6. Sixes \t12. Yahtzee\n" +
						"\t\t13. Chance\n" +
						"Enter 1-13: ");
				mark = s.nextInt();
			}
		}

	}
}