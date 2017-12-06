package classicRPG.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class FighterTest {

	@Test
	public void fighterClassShouldOverrideCharacterStatsPolymorphically() {
		Character charClass = new Character();
		Fighter fighterClass = new Fighter();
		charClass.setHitPoints(10);
		fighterClass.fighterHitPoints(20);
		
		assertNotEquals(charClass, fighterClass);
		assertNotEquals(charClass.getHitPoints(), fighterClass.getHitPoints());
	}

}
