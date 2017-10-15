package edu.pwr.unit;

import junit.framework.TestCase;

public class TestDeck extends TestCase {

	Deck deck = null;

	public void setUp() {
		deck = new Deck();
	}

	public void testTakeTopSizeChange() {
		int old = deck.getDeckSize();
		deck.takeTop();
		assertEquals(old - 1, deck.getDeckSize());
	}

	public void testTakeTopNotNull() {
		assertNotNull(deck.takeTop());
	}

	public void testSevenUpDeckSize() {
		deck.setType(DeckType.SEVEN_UP);
		assertTrue(deck.getDeckSize() == 32);
	}

	public void testNineUpDeckSize() {
		deck.setType(DeckType.NINE_UP);
		assertFalse(deck.getDeckSize() != 24);
	}

	public void testShuffle() {
		Card[] old = new Card[deck.getDeckSize()];
		for (int i = 0; i < old.length; i++)
			old[i] = deck.getCards()[i];

		deck.shuffleDeck(1);
		assertNotSame(old, deck.getCards());
	}

	public void specificTest() {
		Card beforeShuffleTop = deck.takeTop();
		deck.shuffleDeck(7);
		assertNotSame(beforeShuffleTop, deck.takeTop());
	}

	public void tearDown() {
		deck = null;
	}

}
