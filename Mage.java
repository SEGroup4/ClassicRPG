
public class Mage extends Character {
	public static final int MAGE_STRENGTH = 1;
	public static final int MAGE_MAGICPOINTS = 7;
	
	public Mage() {
		super();
		super.setStrength(MAGE_STRENGTH);
		super.setMagicPoints(MAGE_MAGICPOINTS);
	}
	
	public void mageHitPoints(int hp) {
		hp = hp + super.getStrength() * STAT_MODIFIER;
		super.setHitPoints(hp);
	}
	
	public void setName(String name) {
		super.setName(name + " (Mage)");
	}

}
