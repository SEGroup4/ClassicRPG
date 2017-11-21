
public class Fighter extends Character {
	public static final int FIGHTER_STRENGTH = 7;
	public static final int FIGHTER_MAGICPOINTS = 1;
	public static final int FIGHTER_SPEED = 3; 
	
	public Fighter() {
		super();
		super.setStrength(FIGHTER_STRENGTH);
		super.setMagicPoints(FIGHTER_MAGICPOINTS);
		super.setSpeed(FIGHTER_SPEED);
	}
	
	public void fighterHitPoints(int hp) {
		hp = hp + super.getStrength() * STAT_MODIFIER;
		super.setHitPoints(hp);
	}
	
	public void setName(String name, String charType) {
		super.setName(name, charType);
	}
	
//	public void levelUp() {
		
//	}
}
