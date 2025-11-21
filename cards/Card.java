package cards;

public class Card {
    private String rank;
    private String suit;
    private int value;

    public Card(String r, String s, int v) {
        rank = r;
        suit = s;
        value = v;
    }

    public int getValue() { return value; }

    public String toString() {
        return rank + " of " + suit;
    }
}
