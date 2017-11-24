package classicRPG.model;

public class Mage extends Character {
	public static final int MAGE_STRENGTH = 1;
	public static final int MAGE_MAGICPOINTS = 8;
	public static final int MAGE_SPEED = 5; 
	
	public Mage() {
		super();
		super.setStrength(MAGE_STRENGTH);
		super.setMagicPoints(MAGE_MAGICPOINTS);
		super.setSpeed(MAGE_SPEED);
	}
	
	public void mageHitPoints(int hp) {
		hp = hp + super.getStrength() * STAT_MODIFIER;
		super.setHitPoints(hp);
	}
	
	public void setName(String name, String charType) {
		super.setName(name, charType);
	}

}
