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
		Damage damage = new Damage();
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
		
		System.out.println(fighter.getName());
		System.out.println("HP: " + fighter.getHitPoints() + "\n");
		System.out.println(mage.getName());
		System.out.println("HP: " + mage.getHitPoints() + "\n");
		System.out.println(rogue.getName());
		System.out.println("HP: " + rogue.getHitPoints() + "\n");
		System.out.println(paladin.getName());
		System.out.println("HP: " + paladin.getHitPoints());
		
		// NEEDS MORE WORK HERE
		for (Character element : enemy) {
			//System.out.println(fighter.getHitPoints());
			//System.out.println(enemyFighter.getHitPoints());
			System.out.println(element.getName());
			menu.actionMenu(input, element, enemy);
		}
				
		input.close();
	}

}
