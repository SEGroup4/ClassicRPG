import java.util.ArrayList;
import java.util.Scanner;

public class BattleMenu<T extends Character> {
	private Damage damage;
	private Items items;

	public BattleMenu() {
		damage = new Damage();
		items = new Items();
	}

	/**
	 * Produces a menu for player to choose options of attack, defend, ability or
	 * item, and then, depending on choice, calls methods to act on choice.
	 * 
	 * @param input this scanner object is needed from main because once a scanner is
	 * closed you cannot reopen it (I can explain further if needed)
	 * @param enemies an array of enemy objects. This is just here to pass it to the
	 * private enemyMenu method
	 * @param chars the current character object of player in the for/while loop
	 */
	public void actionMenu(Scanner input, ArrayList<T> enemies, Character chars, ArrayList<T> dchar) {
		System.out.println("Action Menu: \n" + "1. Attack\n2. Defend\n3. Ability\n4. Item");
		int menuItem = input.nextInt();

		switch (menuItem) {
		case 1:
			// Acquires attack damage of current player character and passes it to an enemy
			// menu for player to choose who to apply that damage to
			int attackDamage = damage.attackDamage(chars.getStrength());
			System.out.println("Whom do you wish to attack?");
			enemyMenu(input, attackDamage, enemies);
			break;
		case 2:
			// Sets a flag that a player chose defend for a character. (During enemy turn)
			// When enemy attacks said character flag signals to use method defend in class
			// Damage
			damage.defensiveStance(chars);
			break;
		case 3:
			// Same as case one only with ability damage
			int abilityDamage = damage.abilityDamage(chars.getMagicPoints());
			System.out.println("Whom do you wish to cast your ability on?");
			enemyMenu(input, abilityDamage, enemies);
			break;
		case 4:
			//Displays the number of items, then allows you to choose which character to use said item on
			System.out.println("Select which item to use");
			System.out.println("1. Heals: " + items.getNumHeal());
			System.out.println("2. Resurretions: " + items.getNumRes());
			int itemSelect = input.nextInt();
			switch (itemSelect) {
			case 1:
				System.out.println("Whom would you like to use the potion on?");
				int healPoints = items.healChar();
				itemChars(input, healPoints,  dchar);
				break;
			case 2:
				System.out.println("Whom would you like to resurrect on?");
				int resPoints = items.resChar(chars);
				itemChars(input, resPoints,  dchar);
			}
			
			
			
			break;
		}
	}

	/**
	 * Displays all character data relevant for a battle sequence
	 * @param chars the objects in player and/or enemy array list
	 */
	private void displayChars(ArrayList<T> chars) {
		int i = 1;
		for (T element : chars) {
			System.out.println(i + ". " + element.getName() + " HP: " + element.getHitPoints());
			i++;
		}
	}
	
	//Method to select which character to use an item on.
	private void itemChars(Scanner input, int healPoints, ArrayList<T> chars)
	{
		displayChars(chars);
		int menuItem = input.nextInt();
		switch (menuItem) {
		case 1:
			Character char1 = (Character) chars.get(0);
			char1.setHitPoints(char1.getHitPoints() + healPoints);
			System.out.println(char1.getName() + "Was healed for " + healPoints);
			break;
		case 2:
			Character char2 = (Character) chars.get(1);
			char2.setHitPoints(char2.getHitPoints() + healPoints);
			System.out.println(char2.getName() + "Was healed for " + healPoints);
			break;
		case 3:
			Character char3 = (Character) chars.get(2);
			char3.setHitPoints(char3.getHitPoints() + healPoints);
			System.out.println(char3.getName() + "Was healed for " + healPoints);
			break;
		case 4:
			Character char4 = (Character) chars.get(3);
			char4.setHitPoints(char4.getHitPoints() + healPoints);
			System.out.println(char4.getName() + "Was healed for " + healPoints);
			break;
		}
		
		
	}

	/**
	 * Menu of enemy characters currently battling for the player to apply attack or
	 * ability on.  Also determines if enemy is dead when applying attack or ability
	 * and notifies player when enemy hit points are 0.
	 * 
	 * @param input the Scanner object from main
	 * @param enemyDamage the damage to be applied to enemy
	 * @param enemies an array list of enemies
	 */
	private void enemyMenu(Scanner input, int enemyDamage, ArrayList<T> enemies) {
		boolean flag = false;

		// This while loop could also be changed to a for loop and probably would be 
		// better if it was.  Corrections like this here and the loops in main I can 
		// get to when I have time unless someone else does it.
		while (!flag) {
			displayChars(enemies);
			int menuItem = input.nextInt();
			switch (menuItem) {
			case 1:
				Character enemy1 = (Character) enemies.get(0);
				if (enemy1.getHitPoints() <= 0) {
					System.out.println(enemy1.getName() + " is dead!");
					System.out.println("Press enter to continue...");
					input.nextLine();
					// Pause game
					@SuppressWarnings("unused")
					String junk = input.nextLine();
					break;
				} else {
					enemy1.setHitPoints(enemy1.getHitPoints() - enemyDamage);
					System.out
							.println("You hit the enemy for " + enemyDamage + " points of damage. \nThe hit points of "
									+ enemy1.getName() + " is now " + enemy1.getHitPoints() + "\n");
				}
				if (enemy1.getHitPoints() <= 0) {
					System.out.println(enemy1.getName() + " has been vanquished!\n");
				}

				flag = true;
				break;
			case 2:
				Character enemy2 = (Character) enemies.get(1);
				if (enemy2.getHitPoints() <= 0) {
					System.out.println(enemy2.getName() + " is dead!");
					System.out.println("Press enter to continue...");
					input.nextLine();
					// Pause game
					@SuppressWarnings("unused")
					String junk = input.nextLine();
					break;
				} else {
					enemy2.setHitPoints(enemy2.getHitPoints() - enemyDamage);
					System.out
							.println("You hit the enemy for " + enemyDamage + " points of damage. \nThe hit points of "
									+ enemy2.getName() + " is now " + enemy2.getHitPoints() + "\n");
				}
				if (enemy2.getHitPoints() <= 0) {
					System.out.println(enemy2.getName() + " has been vanquished!\n");
				}

				flag = true;
				break;
			case 3:
				Character enemy3 = (Character) enemies.get(2);
				if (enemy3.getHitPoints() <= 0) {
					System.out.println(enemy3.getName() + " is dead!");
					System.out.println("Press enter to continue...");
					input.nextLine();
					// Pause game
					@SuppressWarnings("unused")
					String junk = input.nextLine();
					break;
				} else {
					enemy3.setHitPoints(enemy3.getHitPoints() - enemyDamage);
					System.out
							.println("You hit the enemy for " + enemyDamage + " points of damage. \nThe hit points of "
									+ enemy3.getName() + " is now " + enemy3.getHitPoints() + "\n");
				}
				if (enemy3.getHitPoints() <= 0) {
					System.out.println(enemy3.getName() + " has been vanquished!\n");
				}

				flag = true;
				break;
			case 4:
				Character enemy4 = (Character) enemies.get(3);
				if (enemy4.getHitPoints() <= 0) {
					System.out.println(enemy4.getName() + " is dead!");
					System.out.println("Press enter to continue...");
					input.nextLine();
					// Pause game
					@SuppressWarnings("unused")
					String junk = input.nextLine();
					break;
				} else {
					enemy4.setHitPoints(enemy4.getHitPoints() - enemyDamage);
					System.out
							.println("You hit the enemy for " + enemyDamage + " points of damage. \nThe hit points of "
									+ enemy4.getName() + " is now " + enemy4.getHitPoints() + "\n");
				}
				if (enemy4.getHitPoints() <= 0) {
					System.out.println(enemy4.getName() + " has been vanquished!\n");
				}

				flag = true;
				break;

			}
		}
	}

	/**
	 * Automatically does all menu choices and etc for enemy turn. Enemy simply
	 * attacks player characters one after the other in the order of their objects
	 * in array list. Could be changed to random choice.
	 * 
	 * @param chars the array list of player characters
	 * @param input the Scanner object from main
	 * @param enemy the array list of enemy characters
	 */
	public void autoEnemy(ArrayList<T> chars, Scanner input, ArrayList<T> enemy) {
		System.out.println("\n<<Enemy's Turn>>");
		input.nextLine();
		System.out.println("Press enter to continue...");
		// Pause game
		@SuppressWarnings("unused")
		String junk1 = input.nextLine();
		int deaths = 0;
		
		// Again, iterates through array attacking player characters one after the other
		// in the order of the array. For each enemy that is dead, the for loop
		// decreases by one so that enemy that is dead will not attack
		for (int i = 0; i < (chars.size() - deaths); i++) {
			if (enemy.get(i).getHitPoints() == 0) {
				deaths++;
			}

			int attackDamage = damage.attackDamage(chars.get(i).getStrength());
			// Tests if boolean instance field 'defending' is true. If true, makes a call to
			// method defend for character thats defending
			if (chars.get(i).isDefending()) {
				attackDamage = damage.defend(chars.get(i).getSpeed(), attackDamage, chars.get(i));
				chars.get(i).setDefending(false);
			}

			// Applies damage of attack to player character. Attack damage is 0 if defending
			// (successfully)
			chars.get(i).setHitPoints(chars.get(i).getHitPoints() - attackDamage);
			System.out.println("\nThe enemy hit " + chars.get(i).getName() + " for " + attackDamage
					+ " points of damage. \nThe hit points of " + chars.get(i).getName() + " is now "
					+ chars.get(i).getHitPoints());
			displayChars(chars);
			System.out.println("Press enter to continue...");
			@SuppressWarnings("unused")
			String junk2 = input.nextLine();
		}
	}

}
