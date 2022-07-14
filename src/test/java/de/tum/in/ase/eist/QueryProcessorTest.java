package de.tum.in.ase.eist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class QueryProcessorTest {

	private final QueryProcessor queryProcessor = new QueryProcessor();

	@Test
	void testEmptyStringIfCannotProcessQuery() {
		assertEquals("", queryProcessor.process("test"));
	}

	@Test
	void testKnowsAboutShakespeare() {
		String actual = queryProcessor.process("Shakespeare");
		if (!actual.contains("playwright")) {
			fail("The QueryProcessor does not know about Shakespeare.");
		}
	}

	@Test
	void isNotCaseSensitive() {
		String actual = queryProcessor.process("shakespeare");
		if (!actual.contains("playwright")) {
			fail("Your QueryProcessor should not be case sensitive.");
		}
	}

	@Test
	void testKnowsName() {
		String actual = queryProcessor.process("name");
		if (!actual.contains("Yin")) {
			fail("The QueryProcessor does not know about the name.");
		}
	}

	@Test
	void testCanAddition() {
		String actual = queryProcessor.process("794c9320: what is 3 plus 8");
		if (!actual.contains("11")) {
			fail("The QueryProcessor fails to add numbers");
		}
	}

	@Test
	void testLargestNumber() {
		String actual = queryProcessor.process("d22cc7d0: which of the following numbers is the largest: 37, 6, 160, 468");
		if (!actual.contains("468")) {
			fail("The QueryProcessor fails to find the largest number.");
		}
	}
}
