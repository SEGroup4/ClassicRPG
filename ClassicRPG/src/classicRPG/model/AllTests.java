package classicRPG.model;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ DamageTest.class, FilesTest.class, ItemsTest.class, CharacterTest.class, FighterTest.class,
		MageTest.class, RogueTest.class, PaladinTest.class })
public class AllTests {

}
