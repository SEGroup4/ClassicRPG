package classicRPG.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class CharacterTest {
	Character element;
	
	public CharacterTest() {
		this.element = new Character();
	}
	
	@Test
	public void characterNameShouldReturnNameAndClassType() {
		String name = "name";
		String charType = "type";
		
		element.setName(name, charType);
		assertEquals(name + " " + charType, element.getName());
	}
	
	@Test
	public void characterHitPointsShouldReturnHitPoints() {
		int hitPoints = 5;
		
		element.setHitPoints(hitPoints);
		assertEquals(hitPoints, element.getHitPoints());
	}
	
	@Test
	public void characterHitPointsShouldReturnZeroWhenTheyAreLessThanZero() {
		int hitPoints = -5;
		
		element.setHitPoints(hitPoints);
		assertEquals(0, element.getHitPoints());
	}
	
	@Test
	public void characterMagicPointsShouldReturnMagicPoints() {
		int magicPoints = 5;
		
		element.setMagicPoints(magicPoints);
		assertEquals(magicPoints, element.getMagicPoints());
	}
	
	@Test
	public void characterSpeedShouldReturnSpeed() {
		int speed = 5;
		
		element.setSpeed(speed);
		assertEquals(speed, element.getSpeed());
	}
	
	@Test
	public void characterStrengthShouldReturnStrength() {
		int strength = 5;
		
		element.setStrength(strength);
		assertEquals(strength, element.getStrength());
	}
	
	@Test
	public void whenCharacterIsDefendingDefendShouldBeTrueAndFalseOtherwise() {
		assertFalse(element.isDefending());
		element.setDefending(true);
		assertTrue(element.isDefending());
	}

}
