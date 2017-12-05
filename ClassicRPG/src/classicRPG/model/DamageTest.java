package classicRPG.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class DamageTest {
	private Damage tester;
	private Character element;
	
	/**
	 * Used to test methods many times because of random number generation 
	 */
	public static final int NUM_OF_TESTS = 100;

	public DamageTest() {
		this.tester = new Damage();
		this.element = new Character();

	}

	// method attackDamage()
	@Test
	public void attackDamageShouldReturnBetweenBaseAndHighestForaFighter() {
		int i = 0;

		while (i < NUM_OF_TESTS) {
			// Range between 3-9
			assertNotEquals(2, tester.attackDamage(Fighter.FIGHTER_STRENGTH));
			assertNotEquals(10, tester.attackDamage(Fighter.FIGHTER_STRENGTH));
			i++;
		}
	}

	@Test
	public void attackDamageShouldReturnBetweenBaseAndHighestForaMage() {
		int i = 0;

		while (i < NUM_OF_TESTS) {
			// Range between 0-3
			assertNotEquals(-1, tester.attackDamage(Mage.MAGE_STRENGTH));
			assertNotEquals(4, tester.attackDamage(Mage.MAGE_STRENGTH));
			i++;
		}
	}

	@Test
	public void attackDamageShouldReturnBetweenBaseAndHighestForaRogue() {
		int i = 0;

		while (i < NUM_OF_TESTS) {
			// Range between 2-6
			assertNotEquals(1, tester.attackDamage(Rogue.ROGUE_STRENGTH));
			assertNotEquals(7, tester.attackDamage(Rogue.ROGUE_STRENGTH));
			i++;
		}
	}

	@Test
	public void attackDamageShouldReturnBetweenBaseAndHighestForaPaladin() {
		int i = 0;

		while (i < NUM_OF_TESTS) {
			// Range between 2-7
			assertNotEquals(1, tester.attackDamage(Paladin.PALADIN_STRENGTH));
			assertNotEquals(8, tester.attackDamage(Paladin.PALADIN_STRENGTH));
			i++;
		}
	}

	// method abilityDamage()
	@Test
	public void abilityDamageShouldReturnBetweenBaseAndHighestForaFighter() {
		int i = 0;

		while (i < NUM_OF_TESTS) {
			// Range between 0-2
			assertNotEquals(-1, tester.abilityDamage(Fighter.FIGHTER_MAGICPOINTS));
			assertNotEquals(3, tester.abilityDamage(Fighter.FIGHTER_MAGICPOINTS));
			i++;
		}
	}

	@Test
	public void abilityDamageShouldReturnBetweenBaseAndHighestForaMage() {
		int i = 0;

		while (i < NUM_OF_TESTS) {
			// Range between 4-16
			assertNotEquals(3, tester.abilityDamage(Mage.MAGE_MAGICPOINTS));
			assertNotEquals(17, tester.abilityDamage(Mage.MAGE_MAGICPOINTS));
			i++;
		}
	}

	@Test
	public void abilityDamageShouldReturnBetweenBaseAndHighestForaRogue() {
		int i = 0;

		while (i < NUM_OF_TESTS) {
			// Range between 1-6
			assertNotEquals(0, tester.abilityDamage(Rogue.ROGUE_MAGICPOINTS));
			assertNotEquals(7, tester.abilityDamage(Rogue.ROGUE_MAGICPOINTS));
			i++;
		}
	}

	@Test
	public void abilityDamageShouldReturnBetweenBaseAndHighestForaPaladin() {
		int i = 0;

		while (i < NUM_OF_TESTS) {
			// Range between 2-10
			assertNotEquals(1, tester.abilityDamage(Paladin.PALADIN_MAGICPOINTS));
			assertNotEquals(11, tester.abilityDamage(Paladin.PALADIN_MAGICPOINTS));
			i++;
		}
	}

	// method defend()
	@Test
	public void successfulDefendShouldReturnZero() {
		int i = 0;

		// Needing to test many times because a defend is randomly generated
		while (i < NUM_OF_TESTS) {
			assertEquals(0, tester.defend(9, 20, element));
			i++;
		}
	}

	@Test
	public void failedDefendShouldReturnAttackDamage() {
		int i = 0;

		// Needing to test many times because a defend is randomly generated
		while (i < NUM_OF_TESTS) {
			assertEquals(20, tester.defend(0, 20, element));
			i++;
		}
	}
	
	// method randomDamage()
	@Test
	public void randomGenerationShouldReturnBetweenBaseAndHighest() {
		int base = 0;
		int highest = 10;
		int i = 0;

		while (i < NUM_OF_TESTS) {
			assertTrue(base <= tester.randomDamage(base, highest) && tester.randomDamage(base, highest) <= highest);
			assertNotEquals(-1, tester.randomDamage(base, highest));
			assertNotEquals(11, tester.randomDamage(base, highest));
			i++;
		}
	}

}
