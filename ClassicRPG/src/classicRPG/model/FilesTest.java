package classicRPG.model;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class FilesTest {
	Files file;
	
	public FilesTest() {
		this.file = new Files();
	}

	@Test
	public void fileShouldNotBeNull() throws IOException {
		file.openMonsters();
		assertNotNull(file.getFileIn());
	}

}
