package classicRPG.model;

public class Paladin extends Character {
	public static final int PALADIN_STRENGTH = 5;
	public static final int PALADIN_MAGICPOINTS = 5;
	public static final int PALADIN_SPEED = 3;
	
	public Paladin() {
		super();
		super.setStrength(PALADIN_STRENGTH);
		super.setMagicPoints(PALADIN_MAGICPOINTS);
		super.setSpeed(PALADIN_SPEED);
	}
	
	public void paladinHitPoints(int hp) {
		hp = hp + super.getStrength() * STAT_MODIFIER;
		super.setHitPoints(hp);
	}
	
	public void setName(String name, String charType) {
		super.setName(name, charType);
	}

}
