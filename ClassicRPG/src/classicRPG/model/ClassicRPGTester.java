package classicRPG.model;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ClassicRPGTester {
	public static final int ALL_CLASS_HP = 20;

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Scanner input = new Scanner(System.in);
		Fighter fight = new Fighter();
		Fighter enemyFight = new Fighter();
		Mage magicUser = new Mage();
		Mage enemyMagicUser = new Mage();
		Rogue thief = new Rogue();
		Rogue enemyThief = new Rogue();
		Paladin pald = new Paladin();
		Paladin enemyPald = new Paladin();
		Files files = new Files();

		// Generic to be able to make use of character array lists in Battle Menu
		BattleMenu<Character> menu = new BattleMenu<Character>();
		// Array for a character for each class of character (4 chars)
		ArrayList<Character> chars = new ArrayList<Character>();
		// Array for an enemy of each class to represent monsters
		ArrayList<Character> enemy = new ArrayList<Character>();

		Character fighter = fight;
		chars.add(fighter);
		Character mage = magicUser;
		chars.add(mage);
		Character rogue = thief;
		chars.add(rogue);
		Character paladin = pald;
		chars.add(paladin);

		Character enemyFighter = enemyFight;
		enemy.add(enemyFighter);
		Character enemyMage = enemyMagicUser;
		enemy.add(enemyMage);
		Character enemyRogue = enemyThief;
		enemy.add(enemyRogue);
		Character enemyPaladin = enemyPald;
		enemy.add(enemyPaladin);

		System.out.println("Name your fighter: ");
		String name = input.nextLine();
		fighter.setName(name, "(Fighter)");
		System.out.println("Name your mage: ");
		name = input.nextLine();
		mage.setName(name, "(Mage)");
		System.out.println("Name your Rogue: ");
		name = input.nextLine();
		rogue.setName(name, ("Rogue"));
		System.out.println("Name your Paladin: ");
		name = input.nextLine();
		paladin.setName(name, "(Paladin)");

		try {
			files.openMonsters();
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			System.exit(0);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Read monster types/names from file and add to enemy object (of type
		// Character)
		String monsterType = files.readMonster();
		enemyFighter.setName(monsterType, "");
		// This needs to be caught in a catch block. Not hard just havnt gotten to it
		// yet
		files.openMonsters(); // Need to fix throws declaration here by adding catch...
		monsterType = files.readMonster();
		enemyMage.setName(monsterType, "");
		files.openMonsters();
		monsterType = files.readMonster();
		enemyRogue.setName(monsterType, "");
		files.openMonsters();
		monsterType = files.readMonster();
		enemyPaladin.setName(monsterType, "");

		/*
		 * All_CLASS_HP is altered in individual character classes (IE fighter, mage,
		 * etc) Strength is used to modify ALL_CLASS_HP according to class (character
		 * type)
		 */
		fight.fighterHitPoints(ALL_CLASS_HP);
		magicUser.mageHitPoints(ALL_CLASS_HP);
		thief.rogueHitPoints(ALL_CLASS_HP);
		pald.paladinHitPoints(ALL_CLASS_HP);
		enemyFight.fighterHitPoints(ALL_CLASS_HP);
		enemyMagicUser.mageHitPoints(ALL_CLASS_HP);
		enemyThief.rogueHitPoints(ALL_CLASS_HP);
		enemyPald.paladinHitPoints(ALL_CLASS_HP);

		// Just lists character names, their class (fighter, mage, etc), and hit points
		// for user
		for (Character element : chars) {
			System.out.println(element.getName());
			System.out.println("HP: " + element.getHitPoints() + "\n");
		}

		// These while statements could easily be changed to a for loop, and probably
		// could work better as a for loop. Just changed it trying to get something to
		// work, but ditched using that 'something.'
		boolean flag = false;
		// Loop for entire battle sequence. Multiple iterations of player and enemy
		// turns
		while (!flag) {
			int i = 0;
			// Player turn. Each iteration is another player's character turn
			while (i <= (enemy.size() - 1)) {
				System.out.println(chars.get(i).getName());
				// Provides menu choices and calculates results (see BattleMenu and Damage
				// classes). 
				menu.actionMenu(input, enemy, chars.get(i));
				if (enemyFighter.getHitPoints() <= 0 && enemyMage.getHitPoints() <= 0 && enemyRogue.getHitPoints() <= 0
						&& enemyPaladin.getHitPoints() <= 0) {
					System.out.println("Victory! \nPress enter to continue...");
					input.nextLine();
					@SuppressWarnings("unused")
					String junk = input.nextLine();
					flag = true;
					break;
				}

				i++;
			}

			// Enemy turn. For loop for each enemy char is in method autoEnemy in class
			// BattleMenu
			if (!flag) {
				menu.autoEnemy(chars, input, enemy);
				System.out.println("");
				if (fighter.getHitPoints() <= 0 && mage.getHitPoints() <= 0 && rogue.getHitPoints() <= 0
						&& paladin.getHitPoints() <= 0) {
					System.out.println("GAME OVER");
					System.exit(0);
				}
			}
		}
		input.close();
	}
}
