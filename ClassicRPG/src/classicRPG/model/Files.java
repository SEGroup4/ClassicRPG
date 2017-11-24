package classicRPG.model;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Files {
	public static final int BASE = 0;
	public static final int HIGHEST_NUMBER = 34;
	private Scanner fileIn;
	
	public Files() {
		fileIn = null;
	}
	
	public void openMonsters() throws IOException, FileNotFoundException {
		if (fileIn != null) {
			fileIn.close();
		}
		
		fileIn = new Scanner(new FileInputStream("Monsters.txt"));
		fileIn.useDelimiter("\\.|\\n|\\r");
	}
	
	public String readMonster() {
		Damage random = new Damage();
		String monster = "";
		boolean foundNumber = false;
		int randomNumber = random.randomDamage(BASE, HIGHEST_NUMBER);
		String monsterNumber = Integer.toString(randomNumber);
		while (!foundNumber) {
			if (fileIn.next().equals(monsterNumber)) {
				monster = fileIn.next();
				foundNumber = true;
				fileIn.close();
			}
		}
		
		return monster;
	}

}
