package classicRPG.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class PaladinTest {

	@Test
	public void paladinClassShouldOverrideCharacterStatsPolymorphically() {
		Character charClass = new Character();
		Paladin paladinClass = new Paladin();
		charClass.setHitPoints(10);
		paladinClass.paladinHitPoints(20);
		
		assertNotEquals(charClass, paladinClass);
		assertNotEquals(charClass.getHitPoints(), paladinClass.getHitPoints());
	}

}
