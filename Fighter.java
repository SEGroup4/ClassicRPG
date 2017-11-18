
public class Fighter extends Character {
	public static final int FIGHTER_STRENGTH = 7;
	
	public Fighter() {
		super();
		super.setStrength(FIGHTER_STRENGTH);
	}
	
	public void fighterHitPoints(int hp) {
		hp = hp + super.getStrength() * HP_MODIFIER;
		super.setHitPoints(hp);
	}
	
	public void setName(String name) {
		super.setName(name + " (Fighter)");
	}
	
//	public void levelUp() {
		
//	}
}
