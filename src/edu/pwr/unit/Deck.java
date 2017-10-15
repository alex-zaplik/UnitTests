package edu.pwr.unit;

import java.util.Arrays;
import java.util.Random;

public class Deck {

	private Card[] cards;
	private DeckType type;
	private int topOffset = 0;

	public Deck() {
		setType(DeckType.STD);
	}

	public Deck(DeckType type) {
		setType(type);
	}

	public void setType(DeckType type) {
		this.type = type;
		init();
	}

	public void init() {
		switch (type) {
			case STD:
				cards = new Card[52];
				break;
			case SEVEN_UP:
				cards = new Card[32];
				break;
			case NINE_UP:
				cards = new Card[24];
				break;
		}

		int dv = 0;
		if (type == DeckType.SEVEN_UP)
			dv = 5;
		else if (type == DeckType.NINE_UP)
			dv = 7;

		for (int s = 1; s <= 4; s++) {
			for (int v = 1; v <= 13; v++) {
				if (v == 2 && type == DeckType.SEVEN_UP)
					v = 7;
				else if (v == 2 && type == DeckType.NINE_UP)
					v = 9;

				int index = (s - 1) * (13 - dv) + v - dv - 1 + ((v == 1) ? dv : 0);
				cards[index] = new Card(s, v);
			}
		}
	}

	public void sortDeck() {
		Arrays.sort(cards, 0, cards.length - topOffset);
	}

	public void shuffleDeck(int times) {
		Random rand = new Random();

		for (int i = 0; i < times; i++) {
			for (int j = 0; j < cards.length - topOffset; j++) {
				int pick = rand.nextInt(cards.length - topOffset);
				Card c = cards[j];
				cards[j] = cards[pick];
				cards[pick] = c;
			}
		}
	}

	public Card takeTop() {
		if (topOffset < cards.length) {
			topOffset++;
			return cards[cards.length - topOffset];
		}
		return null;
	}

	public void displayDeck() {
		for (int i = 0; i < cards.length - topOffset; i++) {
			System.out.println(cards[i]);
		}
	}

	public Card[] getCards() {
		return cards;
	}

	public int getDeckSize() {
		return cards.length - topOffset;
	}

	public static void main(String[] args) {
		Deck d = new Deck(DeckType.STD);

		int a = 4; // test

		d.shuffleDeck(2);
		d.displayDeck();
		d.sortDeck();
		d.displayDeck();
	}
}
