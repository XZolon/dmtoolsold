package dmtools;

/**
 * @author Christopher Stewart (ZolonGames Software Development)
 * @version 0.3.1
 */
public class Data1e {

	public static final String[] shopsTypes = { "Docks", "Black Market",
			"Stables", "Armorer", "Leatherworker", "Blacksmith", "Jeweler",
			"General Store", "Alchemist", "Sage", "Fletcher", "Trader" };
	public static final String[] types = { "Potions", // 0
			"Scrolls", // 1
			"RS & W", // 2
			"Misc Magic", // 3
			"Armor/Shields", // 4
			"Swords", // 5
			"Misc Weapons", // 6
			"All", // 7
			"Rings" // 8
	};

	public static final int[] docksTypes = { 3, 6, 7, 8 };
	public static final int[] bmarketTypes = { 0, 2, 3, 4, 5, 6, 7, 8 };
	public static final int[] stablesTypes = { 7 };
	public static final int[] armorerTypes = { 4 };
	public static final int[] lwerTypes = { 4, 6 };
	public static final int[] bsmithTypes = { 4, 5, 6 };
	public static final int[] jewelerTypes = { 3, 8 };
	public static final int[] gstoreTypes = { 7 };
	public static final int[] alchemistTypes = { 0 };
	public static final int[] sageTypes = { 0, 1, 2, 3 };
	public static final int[] fletcherTypes = { 6 };
	public static final int[] traderTypes = { 0, 1, 2, 3, 4, 5, 6, 7, 8 };

	public static final int[] docksSizes = { 2, 4, 8, 16, 32 };
	public static final int[] bmarketSizes = { 0, 2, 4, 16, 64 };
	public static final int[] stablesSizes = { 1, 2, 3, 6, 12 };
	public static final int[] armorerSizes = { 2, 4, 8, 32, 64 };
	public static final int[] lwerSizes = { 2, 4, 8, 16, 32 };
	public static final int[] bsmithSizes = { 4, 8, 6, 32, 64 };
	public static final int[] jewelerSizes = { 2, 4, 4, 16, 32 };
	public static final int[] gstoreSizes = { 5, 10, 15, 20, 25 };
	public static final int[] alchemistSizes = { 0, 2, 4, 8, 32 };
	public static final int[] sageSizes = { 2, 2, 2, 4, 8 };
	public static final int[] fletcherSizes = { 2, 2, 4, 8, 16 };
	public static final int[] traderSizes = { 4, 4, 4, 8, 16 };

	public static final int[] docksMChance = { 1, 2, 4, 8, 16 };
	public static final int[] bmarketMChance = { 4, 8, 16, 16, 16 };
	public static final int[] stablesMChance = { 0, 0, 0, 1, 2 };
	public static final int[] armorerMChance = { 5, 10, 10, 20, 40 };
	public static final int[] lwerMChance = { 2, 8, 10, 20, 40 };
	public static final int[] bsmithMChance = { 5, 10, 20, 20, 40 };
	public static final int[] jewelerMChance = { 2, 4, 8, 16, 32 };
	public static final int[] gstoreMChance = { 5, 5, 10, 10, 10 };
	public static final int[] alchemistMChance = { 100, 100, 100, 100, 100 };
	public static final int[] sageMChance = { 40, 50, 55, 60, 60 };
	public static final int[] fletcherMChance = { 2, 2, 2, 4, 8 };
	public static final int[] traderMChance = { 4, 4, 8, 8, 16 };

	public static final String[] sizes = { "Hamlet", "Village", "Town", "City",
			"Capital" };

	// Error Codes in Cost:
	// -1: DM Determines cost based on spell
	// -2: Roll Cursed Value

	/*
	 * Templates
	 * 
	 * else if (rr(roll, x, y)) { item = new Item("XXXX", z); }
	 */
	public static Item generateAllMagic() {
		Item item = null;
		int roll = Funcs.rollD100();

		if (Funcs.rr(roll, 1, 20)) {
			item = generatePotion();
		} else if (Funcs.rr(roll, 21, 35)) {
			item = generateScroll();
		} else if (Funcs.rr(roll, 36, 40)) {
			item = generateRing();
		} else if (Funcs.rr(roll, 41, 45)) {
			item = generateRodsStavesWands();
		} else if (Funcs.rr(roll, 46, 48)) {
			item = generateTypeOneMisc();
		} else if (Funcs.rr(roll, 49, 51)) {
			item = generateTypeTwoMisc();
		} else if (Funcs.rr(roll, 52, 54)) {
			item = generateTypeThreeMisc();
		} else if (Funcs.rr(roll, 55, 57)) {
			item = generateTypeFourMisc();
		} else if (Funcs.rr(roll, 58, 60)) {
			item = generateTypeFiveMisc();
		} else if (Funcs.rr(roll, 61, 75)) {
			item = generateArmorShields();
		} else if (Funcs.rr(roll, 76, 86)) {
			item = generateSwords();
		} else if (Funcs.rr(roll, 87, 100)) {
			item = generateMiscWeapon();
		} else {
			item = new Item("Error: Invalid MagicItem", roll);
		}

		return item;
	}

	public static Item generateMiscWeapon() {
		// TODO Auto-generated method stub
		Item item = null;
		int roll = Funcs.rollD100();

		if (true) {
			item = new Item("Error: MiscWeap", roll);
		} else {
			item = new Item("Error: Invalid MiscWeap", roll);
		}
		return item;
	}

	public static Item generateSwords() 
	{
		// TODO Generate Sword Types
		Item item = null;
		int roll = Funcs.rollD100();
		String swordType = Data5e.getSword();
		if (Funcs.rr(roll, 1, 25))
	 	{
	 		item = new Item(swordType + " +1", 2000);
	 	}
		else if (Funcs.rr(roll, 26, 30))
		{
			item = new Item(swordType + " +1, +2 vs Magic using or enchnted creatures", 3000);
		}
		else if (Funcs.rr(roll, 31, 35))
		{
			item = new Item(swordType + " +1, +3 vs Lycanthropes and Shape changers", 3500);
		}
		else if (Funcs.rr(roll, 36, 40))
		{
			item = new Item(swordType + " +1, +3 vs Regenerating Creatures", 4000);
		}
		else if (Funcs.rr(roll, 41, 45))
		{
			item = new Item(swordType + " +1, +4 vs Reptiles", 4500);
		}
		else if (Funcs.rr(roll, 46, 49))
		{
			item = new Item(swordType + " +1 Flame Tongue, +2 vs Regenerating, +3 vs cold using/inflamable/avian creatures, +4 vs Undead", 4500);
		}
		else if (Funcs.rr(roll, 50, 50))
		{
			item = new Item(swordType + " +1, Luck Blade", 5000);
		}
		else if (Funcs.rr(roll, 51, 58))
		{
			item = new Item(swordType + " +2", 4000);
		}
		else if (Funcs.rr(roll, 59, 62))
		{
			item = new Item(swordType + " +2, Giant Slayer", 4500);
		}
		else if (Funcs.rr(roll, 63, 66))
		{
			item = new Item(swordType + " +2, Dragon Slayer", 4500);
		}
		else if (Funcs.rr(roll, 67, 67))
		{
			item = new Item(swordType + " +2, Nine Lives Stealer", 8000);
		}
		else if (Funcs.rr(roll, 68, 71))
		{
			item = new Item(swordType + " +3", 7000);
		}
		else if (Funcs.rr(roll, 72, 74))
		{
			item = new Item(swordType + " +3, Frost Brand/+6 vs Fire Using/dwelling", 8000);
		}
		else if (Funcs.rr(roll, 75, 76))
		{
			item = new Item(swordType + " +4", 10000);
		}
		else if (Funcs.rr(roll, 77, 77))
		{
			item = new Item(swordType + " +4, Defender", 15000);
		}
		else if (Funcs.rr(roll, 78, 78))
		{
			item = new Item(swordType + " +5", 15000);
		}
		else if (Funcs.rr(roll, 79, 79))
		{
			item = new Item(swordType + " +5, Defender", 18000);
		}
		else if (Funcs.rr(roll, 80, 80))
		{
			item = new Item(swordType + " +5, Holy Avenger", 20000);
		}
		else if (Funcs.rr(roll, 81, 81))
		{
			item = new Item(swordType + " of Dancing (Special)", 22000);
		}
		else if (Funcs.rr(roll, 82, 82))
		{
			item = new Item(swordType + " of Wounding", 22000);
		}
		else if (Funcs.rr(roll, 83, 83))
		{
			item = new Item(swordType + " of Life Stealing", 25000);
		}
		else if (Funcs.rr(roll, 84, 84))
		{
			item = new Item(swordType + " of Sharpness", 35000);
		}
		else if (Funcs.rr(roll, 85, 85))
		{
			item = new Item(swordType + " - Vorpal Weapon", 50000);
		}
		else if (Funcs.rr(roll, 86, 90))
		{
			item = new Item("Cursed " + swordType + " -1", 2500);
		}
		else if (Funcs.rr(roll, 91, 95))
		{
			item = new Item("Cursed " + swordType + " -2", 4000);
		}
		else if (Funcs.rr(roll, 96, 100))
		{
			item = new Item("Cursed: " + swordType + " Berzerker", 6000);
		} 
		else 
		{
			item = new Item("Error: Invalid Sword", roll);
		}
		
		return item;
	}

	public static Item generateArmorShields() 
	{
		Item item = null;
		int roll = Funcs.rollD100();
		
		if (Funcs.rr(roll, 1, 5))
		{
			item = new Item("Chain Mail +1", 3500);
		}
		else if (Funcs.rr(roll, 6, 9))
		{
			item = new Item("Chain Mail +2", 7500);
		}
		else if (Funcs.rr(roll, 10, 11))
		{
			item = new Item("Chain Mail +3", 12500);
		}
		else if (Funcs.rr(roll, 12, 19))
		{
			item = new Item("Leather +1", 2000);
		}
		else if (Funcs.rr(roll, 20, 26))
		{
			item = new Item("Plate Mail +1", 5000);
		}
		else if (Funcs.rr(roll, 27, 32))
		{
			item = new Item("Plate Mail +2", 10500);
		}
		else if (Funcs.rr(roll, 33, 35))
		{
			item = new Item("Plate Mail +3", 17500);
		}
		else if (Funcs.rr(roll, 36, 37))
		{
			item = new Item("Plate Mail +4", 20500);
		}
		else if (Funcs.rr(roll, 38, 38))
		{
			item = new Item("Plate Mail +5", 27500);
		}
		else if (Funcs.rr(roll, 39, 39))
		{
			item = new Item("Etherial Plate Mail", 30000);
		}
		else if (Funcs.rr(roll, 40, 44))
		{
			item = new Item("Cursed: Plate Mail of Vulnerability", 5000);
		}
		else if (Funcs.rr(roll, 45, 50))
		{
			item = new Item("Ring Mail +1", 2500);
		}
		else if (Funcs.rr(roll, 51, 55))
		{
			item = new Item("Scale Mail +1", 3000);
		}
		else if (Funcs.rr(roll, 56, 59))
		{
			item = new Item("Scale Mail +2", 6750);
		}
		else if (Funcs.rr(roll, 60, 63))
		{
			item = new Item("Splint Mail +1", 4000);
		}
		else if (Funcs.rr(roll, 64, 66))
		{
			item = new Item("Splint Mail +2", 6750);
		}
		else if (Funcs.rr(roll, 67, 68))
		{
			item = new Item("Splint Mail +3", 14500);
		}
		else if (Funcs.rr(roll, 69, 69))
		{
			item = new Item("Splint Mail +4", 19000);
		}
		else if (Funcs.rr(roll, 70, 75))
		{
			item = new Item("Studded Leather +1", 2500);
		}
		else if (Funcs.rr(roll, 76, 84))
		{
			item = new Item("Shield +1", 2500);
		}
		else if (Funcs.rr(roll, 85, 89))
		{
			item = new Item("Shield +2", 5000);
		}
		else if (Funcs.rr(roll, 90, 93))
		{
			item = new Item("Shield +3", 8000);
		}
		else if (Funcs.rr(roll, 94, 95))
		{
			item = new Item("Shield +4", 12000);
		}
		else if (Funcs.rr(roll, 96, 96))
		{
			item = new Item("Shield +5", 17500);
		}
		else if (Funcs.rr(roll, 97, 97))
		{
			item = new Item("Shield +1, +4 Vs Missiles", 4000);
		}
		else if (Funcs.rr(roll, 98, 100))
		{
			item = new Item("Cursed: Shield -1, Missile attractor", 4000);
		}
		else 
		{
			item = new Item("Error: Invalid Armor", roll);
		}
		return item;
	}

	public static Item generateTypeFiveMisc() {
		// TODO Auto-generated method stub
		Item item = null;
		int roll = Funcs.rollD100();

		if (true) {
			item = new Item("Error: Misc 5", roll);
		} else {
			item = new Item("Error: Invalid Item", roll);
		}
		return item;
	}

	public static Item generateTypeFourMisc() {
		// TODO Auto-generated method stub
		Item item = null;
		int roll = Funcs.rollD100();

		if (true) {
			item = new Item("Error: Misc Four", roll);
		} else {
			item = new Item("Error: Invalid Item", roll);
		}
		return item;
	}

	public static Item generateTypeThreeMisc() {
		// TODO Auto-generated method stub
		Item item = null;
		int roll = Funcs.rollD100();

		if (true) {
			item = new Item("Error: Misc Three", roll);
		} else {
			item = new Item("Error: Invalid Item", roll);
		}
		return item;
	}

	public static Item generateTypeTwoMisc() {
		// TODO Auto-generated method stub
		Item item = null;
		int roll = Funcs.rollD100();

		if (true) {
			item = new Item("Error: Misc Two", roll);
		} else {
			item = new Item("Error: Invalid Item", roll);
		}
		return item;
	}

	public static Item generateTypeOneMisc() 
	{
		// TODO Auto-generated method stub
		Item item = null;
		int roll = Funcs.rollD100();
		
		if (Funcs.rr(roll, 1, 2))
	 	{
	 		item = new Item("Alchemy Jug", 12000);
	 	}
		else if (Funcs.rr(roll, 3, 4))
	 	{
	 		item = new Item("Amulet of Inescapable location(curse)", 1000);
	 	}
		else if (Funcs.rr(roll, 5, 5))
	 	{
	 		item = new Item("Amulet of Life Protection", 20000);
	 	}
		else if (Funcs.rr(roll, 6, 7))
	 	{
	 		item = new Item("Amulet of the planes.", 30000);
	 	}
		else if (Funcs.rr(roll, 8, 11))
	 	{
			item = new Item("Amulet: Proof against detection and location", 15000);
	 	}
		else if (Funcs.rr(roll, 12, 13))
	 	{
			item = new Item("Aparatus of Kwalish", 35000);
	 	}
		else if (Funcs.rr(roll, 14, 16))
	 	{
			item = new Item("Arrow of Direction", 17500);
	 	}
		else if (Funcs.rr(roll, 17, 17))
	 	{
	 		// SEE SPECIAL TABLE: Artifact or Relic
			item = new Item("ROLL ON SPECIAL TABLE", roll);
	 	}
		else if (Funcs.rr(roll, 18, 20))
	 	{
			item = new Item("Bag of Beans", 5000);
	 	}
		else if (Funcs.rr(roll, 21, 21))
	 	{
			item = new Item("Cursed Item: Bag of Devouring", 1500);
	 	}
		else if (Funcs.rr(roll, 22, 26))
	 	{
			item = new Item("Bag of Holding", 25000);
	 	}
		else if (Funcs.rr(roll, 27, 27))
	 	{
			item = new Item("Cursed: Bag of Transmuting", 500);
	 	}
		else if (Funcs.rr(roll, 28, 29))
	 	{
			item = new Item("Bag of Tricks", 15000);
	 	}
		else if (Funcs.rr(roll, 30, 31))
	 	{
			item = new Item("Beaker of Plentiful Potions", 12500);
	 	}
		else if (Funcs.rr(roll, 32, 32))
	 	{
			item = new Item("Boat Folding", 25000);
	 	}
		else if (Funcs.rr(roll, 33, 33))
	 	{
			item = new Item("Book of Exalted Deeds", 40000);
	 	}
		else if (Funcs.rr(roll, 34, 34))
	 	{
			item = new Item("Book of Infinate Spells", 50000);
	 	}
		else if (Funcs.rr(roll, 35, 35))
	 	{
			item = new Item("Book of Vile Darkness", 40000);
	 	}
		else if (Funcs.rr(roll, 36, 36))
	 	{
			item = new Item("Cursed: Boots of Dancing", 5000);
	 	}
		else if (Funcs.rr(roll, 37, 42))
	 	{
			item = new Item("Boots of Elvenkind", 5000);
	 	}
		else if (Funcs.rr(roll, 43, 47))
	 	{
			item = new Item("Boots of Levitation", 15000);
	 	}
		else if (Funcs.rr(roll, 48, 51))
	 	{
			item = new Item("Boots of Speed", 20000);
	 	}
		else if (Funcs.rr(roll, 52, 55))
	 	{
			item = new Item("Boots of Striding and Springing", 20000);
	 	}
		else if (Funcs.rr(roll, 56, 58))
	 	{
			item = new Item("Bowl of Commanding Water Elementals", 25000);
	 	}
		else if (Funcs.rr(roll, 59, 59))
	 	{
			item = new Item("Cursed Item: Bowl of Watery Death", 1000);
	 	}
		else if (Funcs.rr(roll, 60, 79))
	 	{
			//SEE SPECIAL TABLE: BRACERS OF DEFENSE
			item = new Item("ROLL ON SPECIAL TABLE", roll);
	 	}
		else if (Funcs.rr(roll, 80, 81))
	 	{
			item = new Item("Cursed Item: Bracers of Defenselessness", 2000);
	 	}
		else if (Funcs.rr(roll, 82, 84))
	 	{
			item = new Item("Bowl of Controlling Fire Elementals", 25000);
	 	}
		else if (Funcs.rr(roll, 85, 85))
	 	{
			item = new Item("Brazier of Sleep Smoke", 10000);
	 	}
		else if (Funcs.rr(roll, 86, 92))
	 	{
			item = new Item("Brooch of Shielding", 10000);
	 	}
		else if (Funcs.rr(roll, 93, 93))
	 	{
			item = new Item("Cursed Item: Broom of Animated Attack", 3000);
	 	}
		else if (Funcs.rr(roll, 94, 98))
	 	{
			item = new Item("Broom of Flying", 10000);
	 	}
		else if (Funcs.rr(roll, 99, 100))
	 	{
			item = new Item("Bucknard's Everfull Purse (Check for type)", 15000);
	 	}
		else
		{
			item = new Item("Error: Invalid Item", roll);
		}
		return item;
	}

	// else if (rr(roll, x, y))
	// {
	// item = new Item("XXXX", z);
	// }
	public static Item generateRodsStavesWands() {
		// TODO Auto-generated method stub
		Item item = null;
		int roll = Funcs.rollD100();

		if (Funcs.rr(roll, 1, 3)) {
			item = new Item("Rod of Absorption", 40000);
		} else if (Funcs.rr(roll, 4, 4)) {
			item = new Item("Rod of Beguiling", 30000);
		} else if (Funcs.rr(roll, 5, 14)) {
			item = new Item("Rod of Cancellation", 15000);
		} else if (Funcs.rr(roll, 15, 16)) {
			item = new Item("Rod of Lordly Might", 20000);
		} else if (Funcs.rr(roll, 17, 17)) {
			item = new Item("Rod of Resurection", 35000);
		} else if (Funcs.rr(roll, 18, 18)) {
			item = new Item("Rod of Rulership", 35000);
		} else if (Funcs.rr(roll, 19, 19)) {
			item = new Item("Rod of Smiting", 15000);
		} else if (Funcs.rr(roll, 20, 20)) {
			item = new Item("Staff of Command", 25000);
		} else if (Funcs.rr(roll, 21, 22)) {
			item = new Item("Staff of Curing", 25000);
		} else if (Funcs.rr(roll, 23, 23)) {
			item = new Item("Staff of the Magi", 75000);
		} else if (Funcs.rr(roll, 24, 24)) {
			item = new Item("Staff of Power", 60000);
		} else if (Funcs.rr(roll, 25, 27)) {
			item = new Item("Staff of the Serpent", 35000);
		} else if (Funcs.rr(roll, 28, 31)) {
			item = new Item("Staff of Striking", 15000);
		} else if (Funcs.rr(roll, 32, 33)) {
			item = new Item("Staff of Withering", 35000);
		} else if (Funcs.rr(roll, 34, 34)) {
			item = new Item("Wand of Conjuration", 35000);
		} else if (Funcs.rr(roll, 35, 38)) {
			item = new Item("Wand of Enemy Detection", 10000);
		} else if (Funcs.rr(roll, 39, 41)) {
			item = new Item("Wand of Fear", 15000);
		} else if (Funcs.rr(roll, 42, 44)) {
			item = new Item("Wand of Fire", 25000);
		} else if (Funcs.rr(roll, 45, 47)) {
			item = new Item("Wand of Frost", 50000);
		} else if (Funcs.rr(roll, 48, 52)) {
			item = new Item("Wand of Illumination", 10000);
		} else if (Funcs.rr(roll, 53, 56)) {
			item = new Item("Wand of Illusion", 20000);
		} else if (Funcs.rr(roll, 57, 59)) {
			item = new Item("Wand of Lightning", 30000);
		} else if (Funcs.rr(roll, 60, 68)) {
			item = new Item("Wand of Magic Detection", 25000);
		} else if (Funcs.rr(roll, 69, 73)) {
			item = new Item("Wand of Metal & Mineral Detection", 7500);
		} else if (Funcs.rr(roll, 74, 78)) {
			item = new Item("Wand of Magic Missiles", 35000);
		} else if (Funcs.rr(roll, 79, 86)) {
			item = new Item("Wand of Negation", 15000);
		} else if (Funcs.rr(roll, 87, 89)) {
			item = new Item("Wand of Paralyzation", 25000);
		} else if (Funcs.rr(roll, 90, 92)) {
			item = new Item("Wand of Polymorphing", 25000);
		} else if (Funcs.rr(roll, 93, 94)) {
			item = new Item("Wand of Secret Door and Trap Location", 40000);
		} else if (Funcs.rr(roll, 95, 100)) {
			item = new Item("Wand of Wonder", 10000);
		} else {
			item = new Item(
					"Error: Rod of Fuck You, Steve! (Actually, invalid item)",
					roll);
		}
		return item;
	}

	public static Item generateRing() {
		Item item = null;
		int roll = Funcs.rollD100();

		if (Funcs.rr(roll, 1, 6)) {
			item = new Item("Ring of Contrariness", 1000);
		} else if (Funcs.rr(roll, 7, 12)) {
			item = new Item("Ring of Delusion", 2000);
		} else if (Funcs.rr(roll, 13, 14)) {
			item = new Item("Ring of Djinni Summoning (" + Funcs.randInt(1, 5)
					+ " charges)", 20000);
		} else if (Funcs.rr(roll, 15, 15)) {
			item = new Item("Ring of Elemental Command", 25000);
		} else if (Funcs.rr(roll, 16, 21)) {
			item = new Item("Ring of Feather Falling", 5000);
		} else if (Funcs.rr(roll, 22, 27)) {
			item = new Item("Ring of Fire Resistance", 5000);
		} else if (Funcs.rr(roll, 28, 30)) {
			item = new Item("Ring of Free Action", 5000);
		} else if (Funcs.rr(roll, 31, 33)) {
			item = new Item("Ring of Human Influence (" + Funcs.randInt(1, 5)
					+ " charges)", 10000);
		} else if (Funcs.rr(roll, 34, 40)) {
			item = new Item("Ring of Invisibility", 7500);
		} else if (Funcs.rr(roll, 41, 43)) {
			item = new Item("Ring of Mammal Control (" + Funcs.randInt(1, 5)
					+ " charges)", 5000);
		} else if (Funcs.rr(roll, 44, 44)) {
			item = new Item("Ring of Multiple Wishes (" + Funcs.randInt(1, 5)
					+ " wishes)", 25000);
		} else if (Funcs.rr(roll, 45, 60)) {
			int plus = Funcs.randInt(1, 2);
			item = new Item("Ring of Protection +" + plus, 10000 * plus);
		} else if (Funcs.rr(roll, 61, 61)) {
			item = new Item("Ring of Regeneration", 40000);
		} else if (Funcs.rr(roll, 62, 63)) {
			item = new Item("Ring of Shooting Stars", 15000);
		} else if (Funcs.rr(roll, 64, 65)) {
			item = new Item("Ring of Spell Storing", 22500);
		} else if (Funcs.rr(roll, 66, 69)) {
			item = new Item("Ring of Spell Turning", 17500);
		} else if (Funcs.rr(roll, 70, 75)) {
			item = new Item("Ring of Swimming", 5000);
		} else if (Funcs.rr(roll, 76, 77)) {
			item = new Item("Ring of Telekinesis (" + Funcs.randInt(1, 5)
					+ " charges)", 10000);
		} else if (Funcs.rr(roll, 78, 79)) {
			item = new Item("Ring of Three Wishes (" + Funcs.randInt(1, 5)
					+ " charges)", 15000);
		} else if (Funcs.rr(roll, 80, 85)) {
			item = new Item("Ring of Warmth", 5000);
		} else if (Funcs.rr(roll, 86, 90)) {
			item = new Item("Ring of Water Walking", 5000);
		} else if (Funcs.rr(roll, 91, 98)) {
			item = new Item("Ring of Weakness", 1000);
		} else if (Funcs.rr(roll, 99, 99)) {
			item = new Item("Ring of Wizardry (" + Funcs.randInt(1, 5)
					+ " charges)", 50000);
		} else if (Funcs.rr(roll, 100, 100)) {
			item = new Item("Ring of X-Ray Vision", 35000);
		} else {
			item = new Item("Error: Invalid Item", roll);
		}
		return item;
	}

	public static Item generateScroll() {
		Item item = null;
		String itemDetail = pickScrollType(Funcs.rollD100());
		int roll = Funcs.rollD100();

		if (Funcs.rr(roll, 1, 10)) {
			item = new Item(itemDetail + "1 Spell, Lv. 1-4", -1);
		} else if (Funcs.rr(roll, 11, 16)) {
			item = new Item(itemDetail + "1 Spell, Lv. 1-6", -1);
		} else if (Funcs.rr(roll, 17, 19)) {
			item = new Item(itemDetail + "1 Spell, See DMG (pg. 121) for Lv.",
					-1);
		} else if (Funcs.rr(roll, 20, 24)) {
			item = new Item(itemDetail + "2 Spells, Lv 1-4", 0);
		} else if (Funcs.rr(roll, 25, 27)) {
			item = new Item(itemDetail + "2 Spells, See DMG (pg. 121) for Lv.",
					-1);
		} else if (Funcs.rr(roll, 28, 32)) {
			item = new Item(itemDetail + "3 Spells, Lv 1-4", -1);
		} else if (Funcs.rr(roll, 33, 35)) {
			item = new Item(itemDetail + "3 Spells, See DMG (pg. 121) for Lv.",
					-1);
		} else if (Funcs.rr(roll, 36, 39)) {
			item = new Item(itemDetail + "4 Spells, Lv. 1-6", -1);
		} else if (Funcs.rr(roll, 40, 42)) {
			item = new Item(itemDetail + "4 Spells, See DMG (pg. 121) for Lv.",
					-1);
		} else if (Funcs.rr(roll, 43, 46)) {
			item = new Item(itemDetail + "5 Spells, Lv. 1-6", -1);
		} else if (Funcs.rr(roll, 47, 49)) {
			item = new Item(itemDetail + "5 Spells, See DMG (pg 121) for Lv.",
					-1);
		} else if (Funcs.rr(roll, 50, 52)) {
			item = new Item(itemDetail + "6 Spells, Lv. 1-6", -1);
		} else if (Funcs.rr(roll, 53, 54)) {
			item = new Item(itemDetail + "6 spells, See DMG (pg 121) for Lv.",
					-1);
		} else if (Funcs.rr(roll, 55, 57)) {
			item = new Item(itemDetail + "7 Spells, Lv. 1-8", -1);
		} else if (Funcs.rr(roll, 58, 59)) {
			item = new Item(itemDetail + "7 Spells, Lv. 2-9", -1);
		} else if (Funcs.rr(roll, 60, 60)) {
			item = new Item(itemDetail + "7 Spells, See DMG (pg 121) for Lv.",
					-1);
		} else if (Funcs.rr(roll, 61, 62)) {
			item = new Item("Scroll: Protection from Demons", 2500 * 5);
		} else if (Funcs.rr(roll, 63, 64)) {
			item = new Item("Scroll: Protection from Devils", 2500 * 5);
		} else if (Funcs.rr(roll, 65, 70)) {
			item = new Item("Scroll: Protection from Elementals", 1500 * 5);
		} else if (Funcs.rr(roll, 71, 76)) {
			item = new Item("Scroll: Protection from Lycanthropes", 1000 * 5);
		} else if (Funcs.rr(roll, 77, 82)) {
			item = new Item("Scroll: Protection from Magic", 1500 * 5);
		} else if (Funcs.rr(roll, 83, 87)) {
			item = new Item("Scroll: Protection from Petrification", 2000 * 5);
		} else if (Funcs.rr(roll, 88, 92)) {
			item = new Item("Scroll: Protection from Possession", 2000 * 5);
		} else if (Funcs.rr(roll, 93, 97)) {
			item = new Item("Scroll: Protection from Undead", 1500 * 5);
		} else if (Funcs.rr(roll, 98, 100)) {
			item = new Item(
					"Cursed Scroll: See DMG pg. 121 for table, with this value:",
					-2);
		} else {
			item = new Item("Error: Invalid Item", roll);
		}

		return item;
	}

	private static String pickScrollType(int roll) {
		if (Funcs.rr(roll, 1, 70)) {
			return "Divine Scroll: ";
		} else {
			return "Arcane Scroll: ";
		}
	}

	/*
	 * TEMPLATE: else if (rr(roll, x, y)) { item = new
	 * Item("Potion of NEW ITEM", z); }
	 */
	public static Item generatePotion() {
		Item item = null;
		int roll = Funcs.rollD100();

		if (Funcs.rr(roll, 1, 3)) {
			item = new Item("Potion of Animal Control*", 400);
		} else if (Funcs.rr(roll, 4, 6)) {
			item = new Item("Potion of Clairaudience", 400);
		} else if (Funcs.rr(roll, 7, 9)) {
			item = new Item("Potion of Clairvoyance", 500);
		} else if (Funcs.rr(roll, 10, 12)) {
			item = new Item("Potion of Climbing", 500);
		} else if (Funcs.rr(roll, 13, 15)) {
			item = new Item("Potion of Delusion**", 150);
		} else if (Funcs.rr(roll, 16, 18)) {
			item = new Item("Potion of Diminution", 500);
		} else if (Funcs.rr(roll, 19, 20)) {
			item = new Item("Potion of Dragon Control*",
					Funcs.randInt(5, 9) * 1000);
		} else if (Funcs.rr(roll, 21, 23)) {
			item = new Item("Potion of ESP", 850);
		} else if (Funcs.rr(roll, 24, 26)) {
			item = new Item("Potion of Extra-Healing", 800);
		} else if (Funcs.rr(roll, 27, 29)) {
			item = new Item("Potion of Fire Resistance", 400);
		} else if (Funcs.rr(roll, 30, 32)) {
			item = new Item("Potion of Flying", 750);
		} else if (Funcs.rr(roll, 33, 34)) {
			item = new Item("Potion of Gaseous Form", 400);
		} else if (Funcs.rr(roll, 35, 36)) {
			item = new Item("Potion of Giant Control*",
					Funcs.randInt(1, 6) * 1000);
		} else if (Funcs.rr(roll, 37, 39)) {
			item = new Item("Potion of Giant Strength*",
					Funcs.randInt(9, 14) * 100);
		} else if (Funcs.rr(roll, 40, 41)) {
			item = new Item("Potion of Growth", 300);
		} else if (Funcs.rr(roll, 42, 47)) {
			item = new Item("Potion of Healing", 400);
		} else if (Funcs.rr(roll, 48, 49)) {
			item = new Item("Potion of Heroism", 500);
		} else if (Funcs.rr(roll, 50, 51)) {
			item = new Item("Potion of Human Control", 900);
		} else if (Funcs.rr(roll, 52, 54)) {
			item = new Item("Potion of Invisibility", 500);
		} else if (Funcs.rr(roll, 55, 57)) {
			item = new Item("Potion of Invulnerability", 500);
		} else if (Funcs.rr(roll, 58, 60)) {
			item = new Item("Potion of Levitation", 400);
		} else if (Funcs.rr(roll, 61, 63)) {
			item = new Item("Potion of Longevity", 1000);
		} else if (Funcs.rr(roll, 64, 66)) {
			item = new Item("Oil of Etherealness", 1500);
		} else if (Funcs.rr(roll, 67, 69)) {
			item = new Item("Oil of Slipperiness", 750);
		} else if (Funcs.rr(roll, 70, 72)) {
			item = new Item("Philter of Love", 300);
		} else if (Funcs.rr(roll, 73, 75)) {
			item = new Item("Philter of Persuasiveness", 850);
		} else if (Funcs.rr(roll, 76, 78)) {
			item = new Item("Potion of Plant Control", 300);
		} else if (Funcs.rr(roll, 79, 81)) {
			item = new Item("Potion of Polymorph (Self)", 350);
		} else if (Funcs.rr(roll, 82, 84)) {
			item = new Item("Random Poison**", Funcs.randInt(1, 500) * 50);
		} else if (Funcs.rr(roll, 85, 87)) {
			item = new Item("Potion of Speed", 450);
		} else if (Funcs.rr(roll, 88, 90)) {
			item = new Item("Potion of Super-Heroism", 750);
		} else if (Funcs.rr(roll, 91, 93)) {
			item = new Item("Potion of Sweet Water", 250);
		} else if (Funcs.rr(roll, 94, 96)) {
			item = new Item("Potion of Treasure Finding", 2000);
		} else if (Funcs.rr(roll, 97, 97)) {
			item = new Item("Potion of Undead Control*", 2500);
		} else if (Funcs.rr(roll, 98, 100)) {
			item = new Item("Potion of Water Breathing", 900);
		} else {
			item = new Item("Error: Invalid Item", roll);
		}
		return item;
	}
}
