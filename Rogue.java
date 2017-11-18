
public class Rogue extends Character {
	public static final int ROGUE_STRENGTH = 4;

	public Rogue() {
		super();
	}
	
	public void setHitPoints(int hp) {
		setStrength(ROGUE_STRENGTH);
		hp = hp + super.getStrength() * HP_MODIFIER;
		super.setHitPoints(hp);
	}
	
	public void setName(String name) {
		super.setName(name + " (Rogue)");
	}

}
