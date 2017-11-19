import java.util.Random;

public class Damage {
	Random rand;
	// Character chars;

	public Damage() {
		this.rand = new Random();
	}

	private int randomDamage(int base, int stat) {
		int damage = rand.nextInt((stat + 1) - base) + base;
		return damage;
	}

	public int attackDamage(int strength) {
		int base = strength / Character.STAT_MODIFIER;
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
		int base = magicPoints / Character.STAT_MODIFIER;
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

	// public int defend
}
