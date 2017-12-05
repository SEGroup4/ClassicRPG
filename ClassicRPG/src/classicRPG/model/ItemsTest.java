package classicRPG.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class ItemsTest {
	Items item;
	
	public ItemsTest() {
		item = new Items();
	}

	@Test
	public void resurrectShouldReturnFive() {
		assertEquals(5, item.getNumRes());
	}
	
	@Test
	public void healShouldReturnFive() {
		assertEquals(5, item.getNumHeal());
	}
	
	@Test
	public void methodShouldDecrementResurrectItemsByOneFromFive() {
		Character element = new Character();
		item.resChar(element);
		
		assertEquals(4, item.getNumRes());
	}
	
	@Test
	public void methodShouldDecrementHealItemsByOneFromFive() {
		item.healChar();
		
		assertEquals(4, item.getNumHeal());
	}

}
