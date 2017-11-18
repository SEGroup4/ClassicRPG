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
			enemies(attackDamage, enemies, input);
			//System.out.println("Strength = " + element.getStrength());
		}
		return 1;
	}
	
	private void enemies(int enemyDamage, ArrayList<T> enemies, Scanner input) {
		// enemy1 = (Character) enemies.get(0);
		int i = 1;
		System.out.println("Whom do you wish to attack?");
		for (T element : enemies) {
			System.out.println(i + ". " + element.getName() + " HP: " + element.getHitPoints());
			i++;
		}

		int menuItem = input.nextInt();
		switch (menuItem) {

		case 1:
			Character enemy1 = (Character) enemies.get(0);
			enemy1.setHitPoints(enemy1.getHitPoints() - enemyDamage);
			System.out.println("You hit the enemy for " + enemyDamage + " points of damage. \nThe hit points of "
					+ enemy1.getName() + " is now " + enemy1.getHitPoints());

		}

		// System.out.println(enemy.getName());
		// System.out.println("Whom do you wish to attack: \n1. " + chars.getName() +
		// "2. " + enemies.get(1) + "3. " + enemies);
	}

}
