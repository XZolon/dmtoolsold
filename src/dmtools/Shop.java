package dmtools;

import java.io.Serializable;

/**
 * @author Christopher Stewart (ZolonGames Software Development)
 * @version 0.3.1
 */
public class Shop implements Serializable
{
	private static final long serialVersionUID = 1L;
	protected String name;
	private String type;
	private int[] itemTypes;
	private int size;
	private int magicChance;
	private String itemString;
	private String costString;
	
	public Shop (String name, int[] itemTypes, int size, int magicChance, String type)
	{
		this.name = name;
		this.type = type;
		this.itemTypes = itemTypes;
		this.size = size;
		this.magicChance = magicChance;
		itemString = "";
		costString = "";
	}
	
	public Shop (int[] itemTypes, int size, int magicChance, String type)
	{
		this.type = type;
		this.name = generateName();
		this.itemTypes = itemTypes;
		this.size = size;
		this.magicChance = magicChance;
		itemString = "";
		costString = "";
	}
	
	private String generateName() 
	{
		String tempName = "";
		String namePart = "";
		
		namePart = GeneralData.shopPrefixes[Funcs.randInt(0, GeneralData.shopPrefixes.length - 1)];
		if (!namePart.equals(""))
		{
			tempName = namePart;
		}
		
		namePart = GeneralData.shopDescriptors[Funcs.randInt(0, GeneralData.shopDescriptors.length - 1)];
		
		if (!namePart.equals(""))
		{
			tempName = tempName + " " + namePart;
		}
		
		if (type.equals("Docks"))
		{
			namePart = GeneralData.docksSuffixes[Funcs.randInt(0, GeneralData.docksSuffixes.length - 1)];
		}
		else if (type.equals("Black Market"))
		{
			namePart = GeneralData.bmarketSuffixes[Funcs.randInt(0, GeneralData.bmarketSuffixes.length - 1)];
		}
		else if (type.equals("Stables"))
		{
			namePart = GeneralData.stablesSuffixes[Funcs.randInt(0, GeneralData.stablesSuffixes.length - 1)];
		}
		else if (type.equals("Armorer"))
		{
			namePart = GeneralData.armorerSuffixes[Funcs.randInt(0, GeneralData.armorerSuffixes.length - 1)];
		}
		else if (type.equals("Leatherworker"))
		{
			namePart = GeneralData.lwerSuffixes[Funcs.randInt(0, GeneralData.lwerSuffixes.length - 1)];
		}
		else if (type.equals("Blacksmith"))
		{
			namePart = GeneralData.bsmithSuffixes[Funcs.randInt(0, GeneralData.bsmithSuffixes.length - 1)];
		}
		else if (type.equals("Jeweler"))
		{
			namePart = GeneralData.jewelerSuffixes[Funcs.randInt(0, GeneralData.jewelerSuffixes.length - 1)];
		}
		else if (type.equals("General Store"))
		{
			namePart = GeneralData.gstoreSuffixes[Funcs.randInt(0, GeneralData.gstoreSuffixes.length - 1)];
		}
		else if (type.equals("Alchemist"))
		{
			namePart = GeneralData.alchemistSuffixes[Funcs.randInt(0, GeneralData.alchemistSuffixes.length - 1)];
		}
		else if (type.equals("Sage"))
		{
			namePart = GeneralData.sageSuffixes[Funcs.randInt(0, GeneralData.sageSuffixes.length - 1)];
		}
		else if (type.equals("Fletcher"))
		{
			namePart = GeneralData.fletcherSuffixes[Funcs.randInt(0, GeneralData.fletcherSuffixes.length - 1)];
		}
		else if (type.equals("Trader"))
		{
			namePart = GeneralData.traderSuffixes[Funcs.randInt(0, GeneralData.traderSuffixes.length - 1)];
		}
		
		tempName = tempName + " " + namePart;
		
		return tempName;
	}

	public String[] getExistingData()
	{
		String[] data = new String[2];
		data[0] = itemString;
		data[1] = costString;
	
		return data;
	}
	public String[] generate() 
	{
//		System.out.println("in generate");
		itemString = "";
		costString = "";
		String[] data = new String[2];
		Item currItem = null;
		int currType = 0;
		int currPos = 1;
		for (int i = 0; i < size; i++ )
		{
			currType = (int) (Math.random() * itemTypes.length);
			currType = itemTypes[currType];
			switch (currType)
			{
			case 0: // Potion
				if (isMagic())
				{
					currItem = Data1e.generatePotion();
				}
				break;
			case 1: // Scroll
				if (isMagic())
				{
					currItem = Data1e.generateScroll();
				}
				break;
			case 2: // Rods, Staves and Wands
				if (isMagic())
				{
					currItem = Data1e.generateRodsStavesWands();
				}
				break;
			case 3: // Misc Magic
				if (isMagic())
				{
					currItem = getMisc();
				}
				break;
			case 4: // Armor/Shields
				if (isMagic())
				{
					currItem = Data1e.generateArmorShields();
				}
				break;
			case 5: // Swords
				if (isMagic())
				{
					currItem = Data1e.generateSwords();
				}
				break;
			case 6: // Misc Weapons
				if (isMagic())
				{
					currItem = Data1e.generateMiscWeapon();
				}
				break;
			case 7: // All Magic
				if (isMagic())
				{
					currItem = Data1e.generateAllMagic();
				}
				break;
			case 8: // Rings
				if (isMagic())
				{
					currItem = Data1e.generateRing();
				}
				break;
			}
			if (currItem != null)
			{
				itemString += currPos + ". " + currItem.name + "\n";
				costString += currPos + ". " + currItem.cost + "gp\n";
				currPos++;
			}
			currItem = null;
		}
		
		data[0] = itemString;
		data[1] = costString;
		return data;
	}

	private Item getMisc() 
	{
		Item item = null;
		
		int roll = Funcs.randInt(1, 5);
		switch (roll)
		{
		case 1:
			item = Data1e.generateTypeOneMisc();
			break;
		case 2:
			item = Data1e.generateTypeTwoMisc();
			break;
		case 3:
			item = Data1e.generateTypeThreeMisc();
			break;
		case 4:
			item = Data1e.generateTypeFourMisc();
			break;
		case 5:
			item = Data1e.generateTypeFiveMisc();
			break;
		}
		if (item == null)
		{
			item = new Item("Invalid Item", 0);
		}
		return item;
	}

	private boolean isMagic() 
	{
//		System.out.println("in isMagic");
		int roll = Funcs.rollD100();
		if (magicChance == 0)
		{
			return false;
		}
		else if (Funcs.rr(roll, 1, magicChance))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	public String toString()
	{
		return name + " (" + type + ")";
	}
}
