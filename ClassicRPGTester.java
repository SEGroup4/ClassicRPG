import java.util.ArrayList;
import java.util.Scanner;

public class ClassicRPGTester {
	public static final int ALL_CLASS_HP = 20;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Fighter fight = new Fighter();
		Fighter enemyFight = new Fighter();
		Mage magicUser = new Mage();
		Mage enemyMagicUser = new Mage();
		Rogue thief = new Rogue();
		Rogue enemyThief = new Rogue();
		Paladin pald = new Paladin();
		Paladin enemyPald = new Paladin();
		// Damage damage = new Damage();
		BattleMenu<Character> menu = new BattleMenu<Character>();
		ArrayList<Character> chars = new ArrayList<Character>();
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
		fighter.setName(name);
		System.out.println("Name your mage: ");
		name = input.nextLine();
		mage.setName(name);
		System.out.println("Name your Rogue: ");
		name = input.nextLine();
		rogue.setName(name);
		System.out.println("Name your Paladin: ");
		name = input.nextLine();
		paladin.setName(name);

		// need to establish random enemy names from file?
		enemyFighter.setName("Rick");
		enemyMage.setName("Tom");
		enemyRogue.setName("Locke");
		enemyPaladin.setName("Hue");

		fight.fighterHitPoints(ALL_CLASS_HP);
		magicUser.mageHitPoints(ALL_CLASS_HP);
		thief.rogueHitPoints(ALL_CLASS_HP);
		pald.paladinHitPoints(ALL_CLASS_HP);
		enemyFight.fighterHitPoints(ALL_CLASS_HP);
		enemyMagicUser.mageHitPoints(ALL_CLASS_HP);
		enemyThief.rogueHitPoints(ALL_CLASS_HP);
		enemyPald.paladinHitPoints(ALL_CLASS_HP);

		for (Character element : chars) {
			System.out.println(element.getName());
			System.out.println("HP: " + element.getHitPoints() + "\n");
		}

		// NEEDS MORE WORK HERE
		boolean flag = false;
		while (!flag) {
			int i = 0;
			for (Character element : enemy) {
				System.out.println(chars.get(i).getName());
				menu.actionMenu(input, element, enemy, chars.get(i));
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

			if (!flag) {
				menu.autoEnemy(chars, input);
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
