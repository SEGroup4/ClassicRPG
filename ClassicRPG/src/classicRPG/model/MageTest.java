package classicRPG.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class MageTest {

	@Test
	public void mageClassShouldOverrideCharacterStatsPolymorphically() {
		Character charClass = new Character();
		Mage mageClass = new Mage();
		charClass.setHitPoints(10);
		mageClass.mageHitPoints(20);
		
		assertNotEquals(charClass, mageClass);
		assertNotEquals(charClass.getHitPoints(), mageClass.getHitPoints());
	}

}
