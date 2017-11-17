
public class Fighter extends Character {
	public static final int FIGHTER_STRENGTH = 7;
	
	public Fighter() {
		super();
	}
	
	public int getHitPoints() {
		int points = super.getHitPoints();
		setStrength(FIGHTER_STRENGTH);
		points = points + super.getStrength() * HP_MODIFIER;
		return points;
	}
	
	public void setName(String name) {
		super.setName(name + " (Fighter)");
	}
	
//	public void levelUp() {
		
//	}
}
