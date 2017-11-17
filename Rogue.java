
public class Rogue extends Character {
	public static final int ROGUE_STRENGTH = 4;

	public Rogue() {
		super();
	}
	
	public int getHitPoints() {
		int points = super.getHitPoints();
		setStrength(ROGUE_STRENGTH);
		points = points + super.getStrength() * HP_MODIFIER;
		return points;
	}
	
	public void setName(String name) {
		super.setName(name + " (Rogue)");
	}

}
