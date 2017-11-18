import java.util.Random;

public class Damage {
	Random rand;
	//Character chars;
	// needsan equals for objects passed into this?
	public Damage() {
		this.rand = null;
	}

	public int attackDamage(int strength) {
	   if (strength == Fighter.FIGHTER_STRENGTH) {
		   return 4; 
	   }
	   return 1;
		
	}
}
