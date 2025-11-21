package cards;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<Card>();

        String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7",
                          "8", "9", "10", "Jack", "Queen", "King"};
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        int[] values =  {1,2,3,4,5,6,7,8,9,10,10,10,10};

        for (String suit : suits)
        {
            for (int i = 0; i < ranks.length; i++)
            {
                cards.add(new Card(ranks[i], suit, values[i]));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card deal() {
        if (cards.size() == 0)
            return null;
        return cards.remove(0);
    }
}
