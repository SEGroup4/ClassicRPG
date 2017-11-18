
public class Paladin extends Character {
	public static final int PALADIN_STRENGTH = 5;
	
	public Paladin() {
		super();
	}
	
	public void setHitPoints(int hp) {
		setStrength(PALADIN_STRENGTH);
		hp = hp + super.getStrength() * HP_MODIFIER;
		super.setHitPoints(hp);
	}
	
	public void setName(String name) {
		super.setName(name + " (Paladin)");
	}

}
