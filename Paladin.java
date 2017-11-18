
public class Paladin extends Character {
	public static final int PALADIN_STRENGTH = 5;
	
	public Paladin() {
		super();
		super.setStrength(PALADIN_STRENGTH);
	}
	
	public void paladinHitPoints(int hp) {
		hp = hp + super.getStrength() * HP_MODIFIER;
		super.setHitPoints(hp);
	}
	
	public void setName(String name) {
		super.setName(name + " (Paladin)");
	}

}
