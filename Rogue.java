
public class Rogue extends Character {
	public static final int ROGUE_STRENGTH = 4;
	public static final int ROGUE_MAGICPOINTS = 3;
    public static final int ROGUE_SPEED = 7; 
    
	public Rogue() {
		super();
		super.setStrength(ROGUE_STRENGTH);
		super.setMagicPoints(ROGUE_MAGICPOINTS);
		super.setSpeed(ROGUE_SPEED);
	}
	
	public void rogueHitPoints(int hp) {
		hp = hp + super.getStrength() * STAT_MODIFIER;
		super.setHitPoints(hp);
	}
	
	public void setName(String name) {
		super.setName(name + " (Rogue)");
	}

}
