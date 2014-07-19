package dmtools;

import java.util.Random;
/**
 * @author Christopher Stewart (ZolonGames Software Development)
 * @version 0.3.1
 */
public class Funcs 
{

	public static int randInt(int min, int max) 
	{
	    Random rand = new Random();
	    int randomNum = rand.nextInt((max - min) + 1) + min;
	    return randomNum;
	}

	public static int rollD100() 
	{
		return (int) ((Math.random() * 100)) + 1;
	}

	// ROLL RANGE CHECKER
	public static boolean rr(int roll, int min, int max)
	{
		if (roll >= min && roll <= max)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
