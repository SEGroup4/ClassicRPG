package classicRPG.model;

public class Character {
	public static final int STAT_MODIFIER = 2;
	private String name;
	private int hitPoints;
	private int magicPoints;
	private int speed;
	private int strength;
	private boolean defending;

	public Character() {
		this.hitPoints = 0;
		this.magicPoints = 0;
		this.speed = 0;
		this.strength = 0;
		this.defending = false;
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
	public void setName(String name, String charType) {
		String fullName = name + " " + charType;
		this.name = fullName;
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
		if (hitPoints <= 0) {
			hitPoints = 0;
		}
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

	/**
	 * @return the defending
	 */
	public boolean isDefending() {
		return defending;
	}

	/**
	 * @param defending the defending to set
	 */
	public void setDefending(boolean defending) {
		this.defending = defending;
	}

}
