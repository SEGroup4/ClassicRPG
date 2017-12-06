package classicRPG.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class RogueTest {

	@Test
	public void rogueClassShouldOverrideCharacterClassPolymorphically() {
		Character charClass = new Character();
		Rogue rogueClass = new Rogue();
		charClass.setHitPoints(10);
		rogueClass.rogueHitPoints(20);
		
		assertNotEquals(charClass, rogueClass);
		assertNotEquals(charClass.getHitPoints(), rogueClass.getHitPoints());
	}

}
