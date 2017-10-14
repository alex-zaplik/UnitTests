package edu.pwr.unit;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;


public class TestDeckJUnit4 {

	Deck deck = null;

	@Before
	public void init() {
		deck = new Deck();
	}

	@Ignore
	@Test
	public void testTakeTopSizeChange() {
		int old = deck.getDeckSize();
		deck.takeTop();
		assertEquals(old - 1, deck.getDeckSize());
	}

	@Test(expected = NullPointerException.class)
	public void testDeckRunningOut() throws Exception {
		while (true) {
			Card c = deck.takeTop();
			c.toString();
		}
	}

	@Test(timeout = 100)
	public void testShuffleSpeed() {
		deck.shuffleDeck(1000);
	}

	@After
	public void cleanUp() {
		deck = null;
	}
}
