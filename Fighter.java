
public class Fighter extends Character {
	public static final int FIGHTER_STRENGTH = 7;
	public static final int FIGHTER_MAGICPOINTS = 1;
	
	public Fighter() {
		super();
		super.setStrength(FIGHTER_STRENGTH);
		super.setMagicPoints(FIGHTER_MAGICPOINTS);
	}
	
	public void fighterHitPoints(int hp) {
		hp = hp + super.getStrength() * STAT_MODIFIER;
		super.setHitPoints(hp);
	}
	
	public void setName(String name) {
		super.setName(name + " (Fighter)");
	}
	
//	public void levelUp() {
		
//	}
}
