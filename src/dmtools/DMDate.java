package dmtools;

import java.io.Serializable;

/**
 * @author Christopher Stewart (ZolonGames Software Development)
 * @version 0.4.0
 */
public class DMDate implements Serializable
{
	
	private static final long serialVersionUID = 1L;
	public static final int DAYS_IN_WEEK = 6;
	public static final String[] DAYS_OF_WEEK = {"Dawnrise", "Nooncrest", "Duskfall", "Nightfall", "Twilight", "Eventide"};
	public static final int WEEKS_IN_MONTH = 5;
	public static final int MONTHS_IN_YEAR = 12;
	public static final String[] MONTHS = {"Mystara's Star", "Tyrus' Command", "Tyraela's Beauty",
										   "Issandre's Renewal", "Ysen's Gift", "Iskarr's Wrath",
										   "Araelys' Guard", "Avaetria's Bounty", "Surat's Discord",
										   "Karystra's Gaze", "Illusoria's Shadow", "Tekara's Judgment"};
	public static final int HOURS_IN_DAY = 24;
	public static final int MINS_IN_HOUR = 60;
	public static final int SECS_IN_MIN = 60;
	
	private int day = 0;
	private int month = 0;
	private int year = 0;
	private int hour = 0;
	private int min = 0;
	private int sec = 0;
	
	public DMDate()
	{
		day = Funcs.randInt(1, DAYS_IN_WEEK * WEEKS_IN_MONTH);
		month = Funcs.randInt(0, MONTHS_IN_YEAR - 1);
		year = Funcs.randInt(100, 1500);
		
		hour = Funcs.randInt(0, HOURS_IN_DAY - 1);
		min = Funcs.randInt(0, MINS_IN_HOUR - 1);
		sec = Funcs.randInt(0, SECS_IN_MIN -1);
	}
	
	public String getDateString()
	{
		String dateString = "";
		
		dateString = getDay() + ", day " + day + " of ";
		dateString = dateString + MONTHS[month] + ", in the year " + year + ", "; 
		dateString = dateString + "at " + getTime() + ".";
		return dateString;
	}
	
	private String getTime()
	{
		String hourString = "";
		String minString = "";
		String secString = "";
		
		if (hour < 10)
		{
			hourString = "0" + hour;
		}
		else
		{
			hourString = "" + hour;
		}
		if (min < 10)
		{
			minString = "0"+ min;
		}
		else
		{
			minString = "" + min;
		}
		if (sec < 10)
		{
			secString = "0" + sec;
		}
		else
		{
			secString = "" + sec;
		}
		
		return hourString + ":" + minString + ":" + secString;
	}
	
	private String getDay() 
	{
		String dayOfWeek = "";
		
		
		switch (day)
		{
		case 1: case 7: case 13: case 19: case 25: 
			dayOfWeek = DAYS_OF_WEEK[0];
			break;
		case 2: case 8: case 14: case 20: case 26: 
			dayOfWeek = DAYS_OF_WEEK[1];
			break;	
		case 3: case 9: case 15: case 21: case 27: 
			dayOfWeek = DAYS_OF_WEEK[2];
			break;		
		case 4: case 10: case 16: case 22: case 28: 
			dayOfWeek = DAYS_OF_WEEK[3];
			break;
		case 5: case 11: case 17: case 23: case 29: 
			dayOfWeek = DAYS_OF_WEEK[4];
			break;
		case 6: case 12: case 18: case 24: case 30: 
			dayOfWeek = DAYS_OF_WEEK[5];
			break;	
		}
		
		return dayOfWeek;
	}
	
	public void addSecond(int amount)
	{
		if ((sec + amount) >= 60)
		{
			addMinute(1);
			sec = sec + amount - 60;
		}
		else
		{
			sec += amount;
		}
	}
	
	
	public void addMinute(int amount)
	{
		if ((min + amount) >= 60)
		{
			addHour(1);
			min = min + amount - 60;
		}
		else
		{
			min += amount;
		}
	}
	
	public void addHour(int amount)
	{
		if ((hour + amount) >= 24)
		{
			addDay(1);
			hour = hour + amount - 24;
		}
		else
		{
			hour += amount;
		}
	}
	
	public void addDay(int amount)
	{
		if ((day + amount) > 30)
		{
			addMonth(1);
			day = day + amount - 30;
		}
		else
		{
			day += amount;
		}
	}

	public void addMonth(int amount) 
	{
		if ((month + amount) >= 12)
		{
			addYear(1);
			month = month + amount - 12;
		}
		else
		{
			month += amount;
		}
	}

	public void addYear(int amount) 
	{
		year = year + amount;
	}
}
