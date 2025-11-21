package cards;

import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> cards;

    public Hand() {
        cards = new ArrayList<Card>();
    }

    public void addCard(Card c) {
        cards.add(c);
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public String toString() {
        return cards.toString();
    }
}
