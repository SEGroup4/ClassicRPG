
public class Paladin extends Character {
	public static final int PALADIN_STRENGTH = 5;
	
	public Paladin() {
		super();
	}
	
	public int getHitPoints() {
		int points = super.getHitPoints();
		setStrength(PALADIN_STRENGTH);
		points = points + super.getStrength() * HP_MODIFIER;
		return points;
	}
	
	public void setName(String name) {
		super.setName(name + " (Paladin)");
	}

}
