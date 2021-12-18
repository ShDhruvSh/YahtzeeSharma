public class YahtzeeScorecard
{
	/* instance data given */
	private int ones;
	private int twos;
	private int threes;
	private int fours;
	private int fives;
	private int sixes;
	private int threeKind;
	private int fourKind;
	private int fiveKind;
	private int chance;
	private int fullHouse;
	private int smStraight;
	private int lgStraight;
	private boolean bonus;

	/* Sets up a new game.  Sets all instance data to incomplete (-1). Sets bonus to false */
	public YahtzeeScorecard()
	{
		ones = -1;
		twos = -1;
		threes = -1;
		fours = -1;
		fives = -1;
		sixes = -1;
		threeKind = -1;
		fourKind = -1;
		fiveKind = -1;
		chance = -1;
		fullHouse = -1;
		smStraight = -1;
		lgStraight = -1;
		bonus = false;
	}

	/* 1. If the field is already full, return false
	   2. Set data value ones equal to number of ones rolled multiplied by one.
	   3. Update the bonus (call updateBonus())
	   4. Return true   */
	public boolean markOnes(int die1, int die2, int die3, int die4, int die5)
	{
		int score = 0;

		if (ones != -1)
		{
			return false;
		}
		else
		{
			if (die1 == 1)
			{
				score++;
			}

			if (die2 == 1)
			{
				score++;
			}

			if (die3 == 1)
			{
				score++;
			}

			if (die4 == 1)
			{
				score++;
			}

			if (die5 == 1)
			{
				score++;
			}

			ones = score;
			updateBonus();
			return true;
		}
	}

	/* 1. If the field is already full, return false
	   2. Set data value twos equal to number of twos rolled multiplied by two.
	   3. Update the bonus (call updateBonus())
	   4. Return true   */
	public boolean markTwos(int die1, int die2, int die3, int die4, int die5)
	{
		int score = 0;

		if (twos != -1)
		{
			return false;
		}
		else
		{
			if (die1 == 2)
			{
				score++;
			}

			if (die2 == 2)
			{
				score++;
			}

			if (die3 == 2)
			{
				score++;
			}

			if (die4 == 2)
			{
				score++;
			}

			if (die5 == 2)
			{
				score++;
			}

			twos = score * 2;
			updateBonus();
			return true;
		}
	}

	/* 1. If the field is already full, return false
	   2. Set data value threes equal to number of threes rolled multiplied by three.
	   3. Update the bonus (call updateBonus())
	   4. Return true  */
	public boolean markThrees(int die1, int die2, int die3, int die4, int die5)
	{
		int score = 0;

		if (threes != -1)
		{
			return false;
		}
		else
		{
			if (die1 == 3)
			{
				score++;
			}

			if (die2 == 3)
			{
				score++;
			}

			if (die3 == 3)
			{
				score++;
			}

			if (die4 == 3)
			{
				score++;
			}

			if (die5 == 3)
			{
				score++;
			}

			threes = score * 3;
			updateBonus();
			return true;
		}
	}

	/* 1. If the field is already full, the method returns false
	   2. Sets data value fours equal to number of fours rolled multiplied by four.
	   3. Update the bonus (call updateBonus())
	   4. Returns true   */
	public boolean markFours(int die1, int die2, int die3, int die4, int die5)
	{
		int score = 0;

		if (fours != -1)
		{
			return false;
		}
		else
		{
			if (die1 == 4) {
				score++;
			}

			if (die2 == 4) {
				score++;
			}

			if (die3 == 4) {
				score++;
			}

			if (die4 == 4) {
				score++;
			}

			if (die5 == 4) {
				score++;
			}

			fours = score * 4;
			updateBonus();
			return true;
		}
	}

	/* 1. If the field is already full, the method returns false
	   2. Sets data value fives equal to number of fives rolled multiplied by five.
	   3. Update the bonus (call updateBonus())
	   4. Returns true   */
	public boolean markFives(int die1, int die2, int die3, int die4, int die5)
	{
		int score = 0;

		if (fives != -1)
		{
			return false;
		}
		else
		{
			if (die1 == 5)
			{
				score++;
			}

			if (die2 == 5)
			{
				score++;
			}

			if (die3 == 5)
			{
				score++;
			}

			if (die4 == 5)
			{
				score++;
			}

			if (die5 == 5)
			{
				score++;
			}

			fives = score * 5;
			updateBonus();
			return true;
		}
	}

	/* 1. If the field is already full, the method returns false
	   2. Sets data value sixes equal to number of sixes rolled multiplied by six.
	   3. Update the bonus (call updateBonus())
	   4. Returns true */
	public boolean markSixes(int die1, int die2, int die3, int die4, int die5)
	{
		int score = 0;

		if (sixes != -1)
		{
			return false;
		}
		else
		{
			if (die1 == 6)
			{
				score++;
			}

			if (die2 == 6)
			{
				score++;
			}

			if (die3 == 6)
			{
				score++;
			}

			if (die4 == 6)
			{
				score++;
			}

			if (die5 == 6)
			{
				score++;
			}

			sixes = score * 6;
			updateBonus();
			return true;
		}
	}

	/* 	1. If the field is already full, return false
		2. Check to see if there are actually three of the same value.
		   If there are, set the data value threeKind to the value of all five dice.
		   If there aren't set the value to 0.
	   	   (Hint: use YahtzeeSortDice class!)
	   	4. Return true   */
	public boolean markThreeOfAKind(int die1, int die2, int die3, int die4, int die5)
	{
		if (threeKind != -1)
		{
			return false;
		}
		else
		{
			YahtzeeSortDice check = new YahtzeeSortDice(die1, die2, die3, die4, die5);

			if (
					(check.getFirst() != check.getSecond() || check.getSecond() != check.getThird())
					&& (check.getSecond() != check.getThird() || check.getThird() != check.getFourth())
					&& (check.getThird() != check.getFourth() || check.getFourth() != check.getFifth())
			)
			{
				threeKind = 0;
			}
			else
			{
				threeKind = die1 + die2 + die3 + die4 + die5;
			}
			return true;
		}
	}

	/* 	1. If the field is already full, return false
		2. Check to see if there are actually four of the same value.
		   If there are, set the data value fourKind to the value of all five dice.
		   If there aren't set the value to 0;
		   (Hint: use YahtzeeSortDice class!)
		4. Return true  */
	public boolean markFourOfAKind(int die1, int die2, int die3, int die4, int die5)
	{
		if (fourKind != -1)
		{
			return false;
		}
		else
		{
			YahtzeeSortDice check = new YahtzeeSortDice(die1, die2, die3, die4, die5);

			if (
					(check.getFirst() != check.getSecond() || check.getSecond() != check.getThird() || check.getThird() != check.getFourth())
					&& (check.getSecond() != check.getThird() || check.getThird() != check.getFourth() || check.getFourth() != check.getFifth())
			)
			{
				fourKind = 0;
			}
			else
			{
				fourKind = die1 + die2 + die3 + die4 + die5;
			}
			return true;
		}
	}

	/* 1. If the field is already full, return false
	   2. Check to see if there are actually three die with the same value, and two with another value.
	      If there are, set the data value fullHouse to 25.
	      If there aren't set the value to 0.
	      (Hint: Use YahtzeeSortedDice class!)
       3. Return true   */
	public boolean markFullHouse(int die1, int die2, int die3, int die4, int die5)
	{
		if (fullHouse != -1)
		{
			return false;
		}
		else
		{
			YahtzeeSortDice check = new YahtzeeSortDice(die1, die2, die3, die4, die5);

			if (
					check.getFirst() == check.getSecond()
					&& check.getFourth() == check.getFifth()
					&& (check.getThird() == check.getSecond() || check.getThird() == check.getFourth())
			)
			{
				fullHouse = 25;
			}
			else
			{
				fullHouse = 0;
			}
			return true;
		}
	}

	/* 	1. If the field is already full, return false
		2. Check to see if there are actually four consecutive dice numbers.
		   If there are, set the data value smStraight to 30.
		   If there aren't set the value to 0.
		   (Hint: Use YahtzeeSortedDice class)
		4. Return true  */
	public boolean markSmallStraight(int die1, int die2, int die3, int die4, int die5)
	{
		if (smStraight != -1)
		{
			return false;
		}
		else
		{
			smStraight = 0;

			YahtzeeSortDice check = new YahtzeeSortDice(die1, die2, die3, die4, die5);
			if (check.getFirst() + 1 == check.getSecond())
			{
				if (check.getSecond() + 1 == check.getThird())
				{
					if (check.getThird() + 1 == check.getFourth())
					{
						smStraight = 30;
					}
					else if (check.getThird() + 1 == check.getFifth())
					{
						smStraight = 30;
					}
				}
				else if (check.getSecond() + 1 == check.getFourth() && check.getFourth() + 1 == check.getFifth())
				{
					smStraight = 30;
				}
			}
			else if (check.getSecond() + 1 == check.getThird() && check.getThird() + 1 == check.getFourth() && check.getFourth() + 1 == check.getFifth())
			{
				smStraight = 30;
			}
			return true;
		}
	}

	/* 	1. If the field is already full, return false
		2. Check to see if there are actually five consecutive dice numbers.
		   If there are, set the data value lgStraight to 40.
		   If there aren't set the value to 0;
		   (Hint: use YahtzeeSortDice class!)
		3. Return true  */
	public boolean markLargeStraight(int die1, int die2, int die3, int die4, int die5)
	{
		if (lgStraight != -1)
		{
			return false;
		}
		else
		{
			YahtzeeSortDice check = new YahtzeeSortDice(die1, die2, die3, die4, die5);

			if (
					check.getFirst() + 1 == check.getSecond()
					&& check.getSecond() + 1 == check.getThird()
					&& check.getThird() + 1 == check.getFourth()
					&& check.getFourth() + 1 == check.getFifth()
			)
			{
				lgStraight = 40;
			}
			else
			{
				lgStraight = 0;
			}
			return true;
		}
	}

	/* 1. If the field is already full, return false
	   2. Checks to see if there are actually five of the same value.  If there are, set the data value fiveKind to 50.  If there aren�t set the value to 0;
       3. Return true   */
	public boolean markYahtzee(int die1, int die2, int die3, int die4, int die5)
	{
		if (fiveKind != -1)
		{
			return false;
		}
		else
		{
			if (
					die1 == die2
					&& die2 == die3
					&& die3 == die4
					&& die4 == die5
			)
			{
				fiveKind = 50;
			}
			else
			{
				fiveKind = 0;
			}
			return true;
		}
	}

	/* 1. If the field is already full, return false
	   2. Set the data value chance to the value of all five dice.
	   3. Return true  */
	public boolean markChance(int die1, int die2, int die3, int die4, int die5)
	{
		if (chance != -1)
		{
			return false;
		}
		else
		{
			chance = die1 + die2 + die3 + die4 + die5;
			return true;
		}
	}

	/* 	1. If the bonus has already been assigned, do nothing
		2. If the upper section's total is 63 or greater, set the data value bonus to true */
	private void updateBonus()
	{
		if (!bonus && getUpperTotal() >= 63)
		{
			bonus = true;
		}
	}

	/* 	returns the upper total (ones - sixes), incompletes (-1s) not factored in */
	public int getUpperTotal()
	{
		int uTotal = 0;

		if (ones != -1)
		{
			uTotal += ones;
		}

		if (twos != -1)
		{
			uTotal += twos;
		}

		if (threes != -1)
		{
			uTotal += threes;
		}

		if (fours != -1)
		{
			uTotal += fours;
		}

		if (fives != -1)
		{
			uTotal += fives;
		}

		if (sixes != -1)
		{
			uTotal += sixes;
		}

		if (bonus)
		{
			uTotal += 35;
		}

		return uTotal;
	}

	/* 	returns the lower total (threeKind - lgStraight), incompletes (-1s) not factored in */
	public int getLowerTotal()
	{
		int lTotal = 0;

		if (threeKind != -1)
		{
			lTotal += threeKind;
		}

		if (fourKind != -1)
		{
			lTotal += fourKind;
		}

		if (fiveKind != -1)
		{
			lTotal += fiveKind;
		}

		if (chance != -1)
		{
			lTotal += chance;
		}

		if (fullHouse != -1)
		{
			lTotal += fullHouse;
		}

		if (smStraight != -1)
		{
			lTotal += smStraight;
		}

		if (lgStraight != -1)
		{
			lTotal += lgStraight;
		}

		return lTotal;
	}

	/* 	returns the grand total, remember incompletes (-1s) should not be factored in! */
	public int getGrandTotal()
	{
		return getUpperTotal() + getLowerTotal();
	}

	/*	Prints a scorecard with the current total, using "__" to mark uncompleted fields and a number to mark filled fields
		Sample:
		**********************************
		*  	    Yahtzee Score Card		 *
		*  					`		  	 *
		* 	Ones:				__		 *
		* 	Twos:				__		 *
		* 	Threes:				__		 *
		* 	Fours:				__		 *
		* 	Fives:				25		 *
		* 	Sixes:				__		 *
		*								 *
		*	Upper Bonus:		 0		 *
		* 	Upper Total:   		25		 *
		*								 *
		*	3 of Kind:			__		 *
		* 	4 of Kind:			__		 *
		* 	Full House:			25		 *
		* 	Sm Straight:		__		 *
		* 	Lg  Straight:		__		 *
		* 	Yahtzee:	  		 0		 *
		* 	Chance:				__		 *
		*								 *
		* 	Lower Total:		25		 *
		*								 *
		* 	Grand Total:		50		 *
		**********************************
		already implemented
	*/
	public void printScoreCard()
	{
		System.out.println();
		System.out.println("*********************************");
		System.out.println("*      Yahtzee Score Card       *");
		System.out.println("*                               *");
		System.out.print("*  Ones:\t\t");
		if(ones==-1)System.out.print("__");
		else System.out.print(ones);
		System.out.println("\t*");
		System.out.print("*  Twos:\t\t");
		if(twos==-1)System.out.print("__");
		else System.out.print(twos);
		System.out.println("\t*");
		System.out.print("*  Threes:\t\t");
		if(threes==-1)System.out.print("__");
		else System.out.print(threes);
		System.out.println("\t*");
		System.out.print("*  Fours:\t\t");
		if(fours==-1)System.out.print("__");
		else System.out.print(fours);
		System.out.println("\t*");
		System.out.print("*  Fives:\t\t");
		if(fives==-1)System.out.print("__");
		else System.out.print(fives);
		System.out.println("\t*");
		System.out.print("*  Sixes:\t\t");
		if(sixes==-1)System.out.print("__");
		else System.out.print(sixes);
		System.out.println("\t*");
		System.out.println("*\t\t\t\t*");
		System.out.print("*  Upper Bonus:\t\t");
		if(bonus)System.out.print("35");
		else System.out.print("0");
		System.out.println("\t*");
		System.out.print("*  Upper Total:\t\t");
		System.out.print(this.getUpperTotal());
		System.out.println("\t*");
		System.out.println("*                               *");
		System.out.print("*  3 of Kind:\t\t");
		if(threeKind==-1)System.out.print("__");
		else System.out.print(threeKind);
		System.out.println("\t*");
		System.out.print("*  4 of Kind:\t\t");
		if(fourKind==-1)System.out.print("__");
		else System.out.print(fourKind);
		System.out.println("\t*");
		System.out.print("*  Full House:\t\t");
		if(fullHouse==-1)System.out.print("__");
		else System.out.print(fullHouse);
		System.out.println("\t*");
		System.out.print("*  Sm Straight:\t\t");
		if(smStraight==-1)System.out.print("__");
		else System.out.print(smStraight);
		System.out.println("\t*");
		System.out.print("*  Lg Straight:\t\t");
		if(lgStraight==-1)System.out.print("__");
		else System.out.print(lgStraight);
		System.out.println("\t*");
		System.out.print("*  Yahtzee:\t\t");
		if(fiveKind==-1)System.out.print("__");
		else System.out.print(fiveKind);
		System.out.println("\t*");
		System.out.print("*  Chance:\t\t");
		if(chance==-1)System.out.print("__");
		else System.out.print(chance);
		System.out.println("\t*");
		System.out.println("*                               *");
		System.out.print("*  Lower Total:\t\t");
		System.out.print(this.getLowerTotal());
		System.out.println("\t*");
		System.out.println("*                               *");
		System.out.print("*  Grand Total:\t\t");
		System.out.print(this.getGrandTotal());
		System.out.println("\t*");
		System.out.println("**********************************");
		System.out.println();
	}


}