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
		if (ones>-1){
			return false;
		}else{
			ones=0;
			if (die1==1){ ones++; }
			if (die2==1){ ones++; }
			if (die3==1){ ones++; }
			if (die4==1){ ones++; }
			if (die5==1){ ones++; }
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
		if (twos>-1){
			return false;
		}else{
			twos=0;
			if (die1==2){ twos+=2; }
			if (die2==2){ twos+=2; }
			if (die3==2){ twos+=2; }
			if (die4==2){ twos+=2; }
			if (die5==2){ twos+=2; }
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
		if (threes>-1){
			return false;
		}else{
			threes=0;
			if (die1==3){ threes+=3; }
			if (die2==3){ threes+=3; }
			if (die3==3){ threes+=3; }
			if (die4==3){ threes+=3; }
			if (die5==3){ threes+=3; }
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
		if (fours>-1){
			return false;
		}else{
			fours=0;
			if (die1==4){ fours+=4; }
			if (die2==4){ fours+=4; }
			if (die3==4){ fours+=4; }
			if (die4==4){ fours+=4; }
			if (die5==4){ fours+=4; }
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
		if (fives>-1){
			return false;
		}else{
			fives=0;
			if (die1==5){ fives+=5; }
			if (die2==5){ fives+=5; }
			if (die3==5){ fives+=5; }
			if (die4==5){ fives+=5; }
			if (die5==5){ fives+=5; }
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
		if (sixes>-1){
			return false;
		}else{
			sixes=0;
			if (die1==6){ sixes+=6; }
			if (die2==6){ sixes+=6; }
			if (die3==6){ sixes+=6; }
			if (die4==6){ sixes+=6; }
			if (die5==6){ sixes+=6; }
			updateBonus();
			return true;
		}
	}

	/* 	1. If the field is already full, return false
		2. Check to see if there are actually three of the same value.
		   If there are, set the data value threeKind to the value of all five dice.
		   If there aren’t set the value to 0.
	   	   (Hint: use YahtzeeSortDice class!)
	   	4. Return true   */
	public boolean markThreeOfAKind(int die1, int die2, int die3, int die4, int die5)
	{
		YahtzeeSortDice sort = new YahtzeeSortDice(die1, die2, die3, die4, die5);
		int smallest = sort.getFirst();
		int second = sort.getSecond();
		int middle = sort.getThird();
		int fourth = sort.getFourth();
		int largest = sort.getFifth();
		if (threeKind>-1){
			return false;
		}else{
			threeKind=0;
			if ((smallest==second&&second==middle)||(second==middle&&middle==fourth)||(middle==fourth&&fourth==largest)){
				threeKind = die1+die2+die3+die4+die5;
				return true;
			}else{
				threeKind = 0;
				return true;
			}
		}
	}

	/* 	1. If the field is already full, return false
		2. Check to see if there are actually four of the same value.
		   If there are, set the data value fourKind to the value of all five dice.
		   If there aren’t set the value to 0;
		   (Hint: use YahtzeeSortDice class!)
		4. Return true  */
	public boolean markFourOfAKind(int die1, int die2, int die3, int die4, int die5)
	{
		YahtzeeSortDice sort = new YahtzeeSortDice(die1, die2, die3, die4, die5);
		int smallest = sort.getFirst();
		int second = sort.getSecond();
		int middle = sort.getThird();
		int fourth = sort.getFourth();
		int largest = sort.getFifth();
		if (fourKind>-1){
			return false;
		}else{
			fourKind=0;
			if ((smallest==second&&second==middle&&middle==fourth)||(second==middle&&middle==fourth&&fourth==largest)){
				fourKind = die1+die2+die3+die4+die5;
				return true;
			}else{
				fourKind = 0;
				return true;
			}
		}
	}

	/* 1. If the field is already full, return false
	   2. Check to see if there are actually three die with the same value, and two with another value.
	      If there are, set the data value fullHouse to 25.
	      If there aren’t set the value to 0.
	      (Hint: Use YahtzeeSortedDice class!)
       3. Return true   */
	public boolean markFullHouse(int die1, int die2, int die3, int die4, int die5)
	{
		YahtzeeSortDice sort = new YahtzeeSortDice(die1, die2, die3, die4, die5);
		int smallest = sort.getFirst();
		int second = sort.getSecond();
		int middle = sort.getThird();
		int fourth = sort.getFourth();
		int largest = sort.getFifth();
		if (fullHouse>-1){
			return false;
		}else{
			if ((smallest==second&&second==middle&&fourth==largest)||(smallest==second&&middle==fourth&&fourth==largest)){
				fullHouse = 25;
				return true;
			}else{
				fullHouse = 0;
				return true;
			}
		}
	}

	/* 	1. If the field is already full, return false
		2. Check to see if there are actually four consecutive dice numbers.
		   If there are, set the data value smStraight to 30.
		   If there aren’t set the value to 0.
		   (Hint: Use YahtzeeSortedDice class)
		4. Return true  */
	public boolean markSmallStraight(int die1, int die2, int die3, int die4, int die5)
	{
		YahtzeeSortDice sort = new YahtzeeSortDice(die1, die2, die3, die4, die5);
		int smallest = sort.getFirst();
		int second = sort.getSecond();
		int middle = sort.getThird();
		int fourth = sort.getFourth();
		int largest = sort.getFifth();
		if (smStraight>-1){
			return false;
		}else{
			if ((smallest==second-1&&second-1==middle-2&&middle-2==fourth-3)||(second==middle-1&&middle-1==fourth-2
				&&fourth-2==largest-3)){
				smStraight = 30;
				return true;
			}else{
				smStraight = 0;
				return true;
			}
		}
	}

	/* 	1. If the field is already full, return false
		2. Check to see if there are actually five consecutive dice numbers.
		   If there are, set the data value lgStraight to 40.
		   If there aren’t set the value to 0;
		   (Hint: use YahtzeeSortDice class!)
		3. Return true  */
	public boolean markLargeStraight(int die1, int die2, int die3, int die4, int die5)
	{
		YahtzeeSortDice sort = new YahtzeeSortDice(die1, die2, die3, die4, die5);
		int smallest = sort.getFirst();
		int second = sort.getSecond();
		int middle = sort.getThird();
		int fourth = sort.getFourth();
		int largest = sort.getFifth();
		if (lgStraight>-1){
			return false;
		}else{
			if ((smallest==second-1&&second-1==middle-2&&middle-2==fourth-3&&fourth-3==largest-4)){
				lgStraight = 40;
				return true;
			}else{
				lgStraight = 0;
				return true;
			}
		}
	}

	/* 1. If the field is already full, return false
	   2. Checks to see if there are actually five of the same value.  If there are, set the data value fiveKind to 50.  If there aren’t set the value to 0;
       3. Return true   */
	public boolean markYahtzee(int die1, int die2, int die3, int die4, int die5)
	{
		YahtzeeSortDice sort = new YahtzeeSortDice(die1, die2, die3, die4, die5);
		int smallest = sort.getFirst();
		int second = sort.getSecond();
		int middle = sort.getThird();
		int fourth = sort.getFourth();
		int largest = sort.getFifth();
		if (fiveKind>-1){
			return false;
		}else{
			if (smallest==second&&second==middle&&middle==fourth&&fourth==largest){
				fiveKind = 50;
				return true;
			}else{
				fullHouse = 0;
				return true;
			}
		}
	}

	/* 1. If the field is already full, return false
	   2. Set the data value chance to the value of all five dice.
	   3. Return true  */
	public boolean markChance(int die1, int die2, int die3, int die4, int die5)
	{
		if (chance>-1){
			return false;
		}else{
			chance = die1+die2+die3+die4+die5;
			return true;
		}
	}

	/* 	1. If the bonus has already been assigned, do nothing
		2. If the upper section’s total is 63 or greater, set the data value bonus to true */
	private void updateBonus()
	{
		if (ones+twos+threes+fours+fives+sixes>63){
			bonus = true;
		}
	}

	/* 	returns the upper total, remember incompletes (-1s) should not be factored in! */
	public int getUpperTotal()
	{
		int upperTotal = 0;
		if (ones>-1){ upperTotal+=ones; }
		if (twos>-1){ upperTotal+=twos; }
		if (threes>-1){ upperTotal+=threes; }
		if (fours>-1){ upperTotal+=fours; }
		if (fives>-1){ upperTotal+=fives; }
		if (sixes>-1){ upperTotal+=sixes; }
		if (bonus){ upperTotal+=35; }
		return upperTotal;
	}

	/* 	returns the lower total, remember incompletes (-1s) should not be factored in! */
	public int getLowerTotal()
	{
		int lowerTotal = 0;
		if (threeKind>-1){ lowerTotal+=threeKind; }
		if (fourKind>-1){ lowerTotal+=fourKind; }
		if (fullHouse>-1){ lowerTotal+=fullHouse; }
		if (smStraight>-1){ lowerTotal+=smStraight; }
		if (lgStraight>-1){ lowerTotal+=lgStraight; }
		if (fiveKind>-1){ lowerTotal+=fiveKind; }
		if (chance>-1){ lowerTotal+=chance; }
		return lowerTotal;
	}

	/* 	returns the grand total, remember incompletes (-1s) should not be factored in! */
	public int getGrandTotal()
	{
		return getUpperTotal()+getLowerTotal();
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
		String border = "*                               *";
		String oneToPrint = "__";
		String twoToPrint = "__";
		String threeToPrint = "__";
		String fourToPrint = "__";
		String fiveToPrint = "__";
		String sixToPrint = "__";
		String uppBonusToPrint = "__";
		String upperTotalToPrint = this.getUpperTotal()+"";
		String threeKindToPrint = "__";
		String fourKindToPrint = "__";
		String fullHouseToPrint = "__";
		String smStraightToPrint = "__";
		String lgStraightToPrint = "__";
		String yahtzeeToPrint = "__";
		String chanceToPrint = "__";
		String lowerTotalToPrint = this.getLowerTotal()+"";
		String grandTotalToPrint = this.getGrandTotal()+"";
		//title part
		System.out.println();
		System.out.println("*********************************");
		System.out.println("*      Yahtzee Score Card       *");
		System.out.println(border);
		//ones
		if(ones!=-1) oneToPrint = ones+"";
		String onesGroup = "*  Ones: "+border.substring("* Ones: ".length(), border.length()-oneToPrint.length()-"\t\t\t\t *".length())
				+oneToPrint+" \t *";
		System.out.println(onesGroup);
		//twos
		if(twos!=-1) twoToPrint = twos+"";
		String twosGroup = "*  Twos: "+border.substring("* Twos: ".length(), border.length()-twoToPrint.length()-"\t\t\t\t *".length())
				+twoToPrint+" \t *";
		System.out.println(twosGroup);
		//threes
		if(threes!=-1) threeToPrint = threes+"";
		String threesGroup = "*  Threes: "+border.substring("* Threes: ".length(), border.length()-threeToPrint.length()-"\t\t\t\t *".length())
				+threeToPrint+" \t *";
		System.out.println(threesGroup);
		//fours
		if(fours!=-1) fourToPrint = fours+"";
		String foursGroup = "*  Fours: "+border.substring("* Fours: ".length(), border.length()-fourToPrint.length()-"\t\t\t\t *".length())
				+fourToPrint+" \t *";
		System.out.println(foursGroup);
		//fives
		if(fives!=-1) fiveToPrint = fives+"";
		String fivesGroup = "*  Fives: "+border.substring("* Fives: ".length(), border.length()-fiveToPrint.length()-"\t\t\t\t *".length())
				+fiveToPrint+" \t *";
		System.out.println(fivesGroup);
		//sixes
		if(sixes!=-1) sixToPrint = sixes+"";
		String sixesGroup = "*  Sixes: "+border.substring("* Sixes: ".length(), border.length()-sixToPrint.length()-"\t\t\t\t *".length())
				+sixToPrint+" \t *";
		System.out.println(sixesGroup);
		//break
		System.out.println("*                               *");
		//upper bonus
		if(bonus) uppBonusToPrint = "35";
		else if (!bonus) uppBonusToPrint = "0";
		String upperBonusGroup = "*  Upper Bonus: "+border.substring("* Upper Bonus: ".length(), border.length()-uppBonusToPrint.length()-"\t\t\t\t *".length())
				+uppBonusToPrint+" \t *";
		System.out.println(upperBonusGroup);
		//break
		System.out.println("*                               *");
		//upper total
		String upperTotalGroup = "*  Upper Total: "+border.substring("* Upper Total: ".length(), border.length()-upperTotalToPrint.length()-"\t\t\t\t *".length())
				+upperTotalToPrint+" \t *";
		System.out.println(upperTotalGroup);
		//break
		System.out.println("*                               *");
		//three of a kind
		if(threeKind!=-1) threeKindToPrint = threeKind+"";
		String threeKindGroup = "*  3 of Kind: "+border.substring("* 3 of Kind: ".length(), border.length()-threeKindToPrint.length()
				-"\t\t\t\t *".length())+threeKindToPrint+" \t *";
		System.out.println(threeKindGroup);
		//four of a kind
		if(fourKind!=-1) fourKindToPrint = fourKind+"";
		String fourKindGroup = "*  4 of Kind: "+border.substring("* 4 of Kind: ".length(), border.length()-fourKindToPrint.length()
				-"\t\t\t\t *".length())+fourKindToPrint+" \t *";
		System.out.println(fourKindGroup);
		//full house
		if(fullHouse!=-1) fullHouseToPrint = fullHouse+"";
		String fullHouseGroup = "*  Full House: "+border.substring("* Full House: ".length(), border.length()-fullHouseToPrint.length()
				-"\t\t\t\t *".length())+fullHouseToPrint+" \t *";
		System.out.println(fullHouseGroup);
		//small straight
		if(smStraight!=-1) smStraightToPrint = smStraight+"";
		String smStraightGroup = "*  Sm Straight: "+border.substring("* Sm Straight: ".length(), border.length()-smStraightToPrint.length()
				-"\t\t\t\t *".length())+smStraightToPrint+" \t *";
		System.out.println(smStraightGroup);
		//large straight
		if(lgStraight!=-1) lgStraightToPrint = lgStraight+"";
		String lgStraightGroup = "*  Lg Straight: "+border.substring("* Lg Straight: ".length(), border.length()-lgStraightToPrint.length()
				-"\t\t\t\t *".length())+lgStraightToPrint+" \t *";
		System.out.println(lgStraightGroup);
		//yahtzee
		if(fiveKind!=-1) yahtzeeToPrint = fiveKind+"";
		String fiveKindGroup = "*  Yahtzee: "+border.substring("* Yahtzee: ".length(), border.length()-yahtzeeToPrint.length()
				-"\t\t\t\t *".length())+yahtzeeToPrint+" \t *";
		System.out.println(fiveKindGroup);
		//chance
		if(chance!=-1) chanceToPrint = chance+"";
		String chanceGroup = "*  Chance: "+border.substring("* Chance: ".length(), border.length()-chanceToPrint.length()
				-"\t\t\t\t *".length())+chanceToPrint+" \t *";
		System.out.println(chanceGroup);
		//break
		System.out.println("*                               *");
		//lower total
		String lowerTotalGroup = "*  Lower Total: "+border.substring("* Lower Total: ".length(), border.length()-
				lowerTotalToPrint.length()-"\t\t\t\t *".length())+lowerTotalToPrint+" \t *";
		System.out.println(lowerTotalGroup);
		//break
		System.out.println("*                               *");
		//grand total
		String grandTotalGroup = "*  Grand Total: "+border.substring("* Grand Total: ".length(), border.length()-
				grandTotalToPrint.length()-"\t\t\t\t *".length())+grandTotalToPrint+" \t *";
		System.out.println(grandTotalGroup);
		//footer
		System.out.println("**********************************");
		System.out.println();
	}


}