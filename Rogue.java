
public class Rogue extends Character {
	public static final int ROGUE_STRENGTH = 4;

	public Rogue() {
		super();
		super.setStrength(ROGUE_STRENGTH);
	}
	
	public void rogueHitPoints(int hp) {
		hp = hp + super.getStrength() * STAT_MODIFIER;
		super.setHitPoints(hp);
	}
	
	public void setName(String name) {
		super.setName(name + " (Rogue)");
	}

}
