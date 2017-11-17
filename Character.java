
public class Character {
	public static final int HP_MODIFIER = 2;
	private String name;
	private int hitPoints;
	private int magicPoints;
	private int speed;
	private int strength;

	public Character() {
		this.hitPoints = 0;
		this.magicPoints = 0;
		this.speed = 0;
		this.strength = 0;
	}
	
	public Character(int hitPoints, int magicPoints, int speed, int strength) {
		this.hitPoints = hitPoints;
		this.magicPoints = magicPoints;
		this.speed = speed;
		this.strength = strength;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the hitPoints
	 */
	public int getHitPoints() {
		return hitPoints;
	}

	/**
	 * @param hitPoints the hitPoints to set
	 */
	public void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
	}

	/**
	 * @return the magicPoints
	 */
	public int getMagicPoints() {
		return magicPoints;
	}

	/**
	 * @param magicPoints the magicPoints to set
	 */
	public void setMagicPoints(int magicPoints) {
		this.magicPoints = magicPoints;
	}

	/**
	 * @return the speed
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 * @param speed the speed to set
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	/**
	 * @return the strength
	 */
	public int getStrength() {
		return strength;
	}

	/**
	 * @param strength the strength to set
	 */
	public void setStrength(int strength) {
		this.strength = strength;
	}
	
	

}
