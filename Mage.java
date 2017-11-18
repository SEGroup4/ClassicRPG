
public class Mage extends Character {
	public static final int MAGE_STRENGTH = 1;
	
	public Mage() {
		super();
		super.setStrength(MAGE_STRENGTH);
	}
	
	public void mageHitPoints(int hp) {
		hp = hp + super.getStrength() * HP_MODIFIER;
		super.setHitPoints(hp);
	}
	
	public void setName(String name) {
		super.setName(name + " (Mage)");
	}
	
	

}
