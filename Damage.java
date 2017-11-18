import java.util.Random;

public class Damage {
	Random rand;
	//Character chars;
	// needsan equals for objects passed into this?
	public Damage() {
		this.rand = new Random();
	}

	private int randomDamage(int base, int stat) {
		int damage = rand.nextInt((stat + 1) - base) + base;
		return damage;
	}
	
	public int attackDamage(int strength) {
	    int base = strength / Character.STAT_MODIFIER;
	    strength = strength + Character.STAT_MODIFIER;
	    
		if (strength == Fighter.FIGHTER_STRENGTH + Character.STAT_MODIFIER) {
		   int fighterDamage = randomDamage(base, strength);
		   return fighterDamage; 
	   }
	   return 1;
		
	}
}
