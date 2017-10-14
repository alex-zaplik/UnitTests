package edu.pwr.unit;

public class Card implements Comparable<Card> {
	private int s; // 1 - hearts, 2 - diamonds, 3 - spades, 4 - clubs
	private int v; // 1 - ace, 2..10 - same as value, 11 - jack, 12 - queen, 13 - king

	public Card(int s, int v) {
		this.s = s;
		this.v = v;
	}

	public String toString() {
		String suite = "";
		switch (s) {
			case 1:
				suite = "hearts";
				break;
			case 2:
				suite = "diamonds";
				break;
			case 3:
				suite = "spades";
				break;
			case 4:
				suite = "clubs";
				break;
		}

		String value;
		switch (v) {
			case 1:
				value = "ace";
				break;
			case 11:
				value = "jack";
				break;
			case 12:
				value = "queen";
				break;
			case 13:
				value = "king";
				break;
			default:
				value = Integer.toString(v);
		}

		return "A" + ((v == 1 || v == 8) ? "n" : "") + " " + value + " of " + suite;
	}

	public int getSuite() {
		return s;
	}

	public int getValue() {
		return v;
	}

	@Override
	public int compareTo(Card o) {
		int value = (getSuite() - 1) * 13 + getValue() - 1;
		int oValue = (o.getSuite() - 1) * 13 + o.getValue() - 1;
		return value - oValue;
	}

	@Override
	public boolean equals(Object oth) {
		if (!(oth instanceof Card))
			return false;
		Card o = (Card) oth;

		return getSuite() == o.getSuite() && getValue() == o.getValue();
	}
}
