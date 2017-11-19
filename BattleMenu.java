import java.util.ArrayList;
import java.util.Scanner;

public class BattleMenu<T extends Character> {
	Damage damage;
	//Character enemy1;
	//Character enemy2;
	//Character enemy3;
	
	public BattleMenu() {
		damage = new Damage();
	}
	
	public int actionMenu(Scanner input, Character element, ArrayList<T> enemies) {
		System.out.println("Action Menu: \n" + "1. Attack\n2. Defend\n3. Ability\n4. Item");
		int menuItem = input.nextInt();

		switch (menuItem) {
		case 1:
			int attackDamage = damage.attackDamage(element.getStrength());
			System.out.println("Whom do you wish to attack?");
			enemyMenu(input, attackDamage, enemies);
			break;
		case 2:
			//damage.defend();
			break;
		case 3:
			int abilityDamage = damage.abilityDamage(element.getMagicPoints());
			System.out.println("Whom do you wish to cast your ability on?");
			enemyMenu(input, abilityDamage, enemies);
			break;
		}
		return 1;
	}
	
	private void displayChars(ArrayList<T> chars) {
		int i = 1;
		for (T element : chars) {
			System.out.println(i + ". " + element.getName() + " HP: " + element.getHitPoints());
			i++;
		}
	}
	
	private void enemyMenu(Scanner input, int enemyDamage, ArrayList<T> enemies) {
		boolean flag = false;
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
					flag = true;
					break;
				}
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
					flag = true;
					break;
				}
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
					flag = true;
					break;
				}
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
					flag = true;
					break;
				}

			}
		}
	}
	
	public void autoEnemy(ArrayList<T> chars, Scanner input) {
		System.out.println("\n<<Enemy's Turn>>");
		input.nextLine();
		System.out.println("Press enter to continue...");
		@SuppressWarnings("unused")
		String junk1 = input.nextLine();
		
		for (Character element : chars) {
			int attackDamage = damage.attackDamage(element.getStrength());
			element.setHitPoints(element.getHitPoints() - attackDamage);
			System.out
			.println("\nThe enemy hit " + element.getName() + " for " + attackDamage + " points of damage. \nThe hit points of "
					+ element.getName() + " is now " + element.getHitPoints());
			displayChars(chars);
			System.out.println("Press enter to continue...");
			@SuppressWarnings("unused")
			String junk2 = input.nextLine();
		}
	}

}
