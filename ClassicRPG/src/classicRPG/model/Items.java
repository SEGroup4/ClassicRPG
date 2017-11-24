
public class Items {
	private int resurrect;
	private int heal;
	
	//set each item at 5 for the moment, can be adjusted later
	public Items() {
		this.resurrect = 5;
		this.heal = 5;
		//ArrayList<Character> character = new ArrayList<Character>();
	}
	
	//These methods allow program to grab the number of each item.
	public int getNumRes()
	{
		return resurrect;
	}
	
	public int getNumHeal()
	{
		return heal;
	}
	
	//Method to heal a given character
	public int healChar()
	{
		int potion = 10; // number of hp to be healed
		heal--;
		return potion;
	}
	
	// revives a dead character to full health
	public int resChar(Character chars)
	{
		int res = chars.getMaxHP();
		resurrect--;
		return res;
	}
}
