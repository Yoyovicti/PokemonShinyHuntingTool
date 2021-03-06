package display.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import display.GeneralWindow;

class GeneralWindowTest {
	GeneralWindow generalWindow;
	
	String version;

	@BeforeEach
	void setUp() throws Exception {
		version = "0.0.1";
		
		generalWindow = new GeneralWindow(version);
	}

	@Test
	void testVersion() {
		assertEquals("0.0.1", generalWindow.getVersion());
	}

	@Test
	void testSize() {
		assertEquals(600, generalWindow.getWidth());
		assertEquals(600, generalWindow.getHeight());
	}
}
