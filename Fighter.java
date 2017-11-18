
public class Fighter extends Character {
	public static final int FIGHTER_STRENGTH = 7;
	
	public Fighter() {
		super();
	}
	
	public void setHitPoints(int hp) {
		setStrength(FIGHTER_STRENGTH);
		hp = hp + super.getStrength() * HP_MODIFIER;
		super.setHitPoints(hp);
	}
	
	public void setName(String name) {
		super.setName(name + " (Fighter)");
	}
	
//	public void levelUp() {
		
//	}
}
