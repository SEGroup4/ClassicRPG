import java.util.Scanner;

public class ClassicRPGTester {
	public static final int ALL_CLASS_HP = 20;
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Fighter fight = new Fighter();
		Mage magicUser = new Mage();
		Rogue thief = new Rogue();
		Paladin pald = new Paladin();
		
		Character mage = magicUser;
		Character fighter = fight;
		Character rogue = thief;
		Character paladin = pald;
		
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
		
		fighter.setHitPoints(ALL_CLASS_HP);
		mage.setHitPoints(ALL_CLASS_HP);
		rogue.setHitPoints(ALL_CLASS_HP);
		paladin.setHitPoints(ALL_CLASS_HP);
		
		System.out.println(fighter.getName());
		System.out.println("HP: " + fighter.getHitPoints() + "\n");
		System.out.println(mage.getName());
		System.out.println("HP: " + mage.getHitPoints() + "\n");
		System.out.println(rogue.getName());
		System.out.println("HP: " + rogue.getHitPoints() + "\n");
		System.out.println(paladin.getName());
		System.out.println("HP: " + paladin.getHitPoints());
		
		input.close();
	}

}
