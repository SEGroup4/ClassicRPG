import java.util.Random;

public class Damage {
	public static final int DEFEND_MAX_RANGE = 25;
	private Random rand;
	private int base;

	public Damage() {
		this.rand = new Random();
		this.base = 0;
	}

	private int randomDamage(int base, int stat) {
		int damage = rand.nextInt((stat + 1) - base) + base;
		return damage;
	}

	public int attackDamage(int strength) {
		base = strength / Character.STAT_MODIFIER;
		strength = strength + Character.STAT_MODIFIER;

		if (strength == Fighter.FIGHTER_STRENGTH + Character.STAT_MODIFIER) {
			int fighterDamage = randomDamage(base, strength);
			return fighterDamage;
		} else if (strength == Mage.MAGE_STRENGTH + Character.STAT_MODIFIER) {
			int mageDamage = randomDamage(base, strength);
			return mageDamage;
		} else if (strength == Rogue.ROGUE_STRENGTH + Character.STAT_MODIFIER) {
			int rogueDamage = randomDamage(base, strength);
			return rogueDamage;
		} else if (strength == Paladin.PALADIN_STRENGTH + Character.STAT_MODIFIER) {
			int paladinDamage = randomDamage(base, strength);
			return paladinDamage;
		} else
			return 0;
	}

	public int abilityDamage(int magicPoints) {
		base = magicPoints / Character.STAT_MODIFIER;
		magicPoints = magicPoints * Character.STAT_MODIFIER;

		if (magicPoints == Fighter.FIGHTER_MAGICPOINTS * Character.STAT_MODIFIER) {
			int fighterDamage = randomDamage(base, magicPoints);
			return fighterDamage;
		} else if (magicPoints == Mage.MAGE_MAGICPOINTS * Character.STAT_MODIFIER) {
			int mageDamage = randomDamage(base, magicPoints);
			return mageDamage;
		} else if (magicPoints == Rogue.ROGUE_MAGICPOINTS * Character.STAT_MODIFIER) {
			int fighterDamage = randomDamage(base, magicPoints);
			return fighterDamage;
		} else if (magicPoints == Paladin.PALADIN_MAGICPOINTS * Character.STAT_MODIFIER) {
			int paladinDamage = randomDamage(base, magicPoints);
			return paladinDamage;
		} else
			return 0;
	}

	public int defend(int speed, int attackDamage, Character element) {
		base = 0;
		int successRange = speed * (Character.STAT_MODIFIER + 1);
		int successNumber = 0;
		if (speed == Fighter.FIGHTER_SPEED || speed == Mage.MAGE_SPEED || speed == Rogue.ROGUE_SPEED
				|| speed == Paladin.PALADIN_SPEED) {
			successNumber = randomDamage(base, DEFEND_MAX_RANGE);
			if (successNumber <= successRange) {
				System.out.println(element.getName() + " successfully defended the attack!");
				return base;
			} else {
				System.out.println(element.getName() + " was not fast enough to defend the attack!");
				return attackDamage;
			}
		}

		return attackDamage;
	}
	
	public void defensiveStance(Character element) {
		element.setDefending(true);
		System.out.println(element.getName() + " enters a defensive stance\n");
	}

}
