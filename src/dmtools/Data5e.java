package dmtools;
/**
 * @author Christopher Stewart (ZolonGames Software Development)
 * @version 0.3.1
 */
public class Data5e {

	public static String getSword() 
	{
		int roll = Funcs.randInt(1, 5);
		
		if (roll == 1)
		{
			return "Greatsword";
		}
		else if (roll == 2)
		{
			return "Longsword";
		}		
		else if (roll == 3)
		{
			return "Rapier";
		}		
		else if (roll == 4)
		{
			return "Scimitar";
		}		
		else if (roll == 5)
		{
			return "Shortsword";
		}		
		else
		{
			return "Sword";
		}
	}

}
