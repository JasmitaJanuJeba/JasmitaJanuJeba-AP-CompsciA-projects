package cards;

public class Game {

    private Deck deck;
    private Hand playerHand;
    private Hand dealerHand;
    private boolean isPlayerDone;

    public Game(Deck d)
    {
        deck = d;
        isPlayerDone = false;
    }

    public void printRules()
    {
        System.out.println("=== Rules of TwentyOne ===");
        System.out.println("Commands:");
        System.out.println("h = hit");
        System.out.println("s = stand");
        System.out.println("r = reset");
        System.out.println("q = quit");
        System.out.println("===========================\n");
    }

    public void next()
    {
        playerHand = new Hand();
        dealerHand = new Hand();
        isPlayerDone = false;

        playerHand.addCard(deck.deal());
        playerHand.addCard(deck.deal());
        dealerHand.addCard(deck.deal());
        dealerHand.addCard(deck.deal());

        printState();
    }

    public void printState()
    {
        System.out.println("--- Game State ---");
        System.out.println("Player: " + playerHand.getCards() + " Score: " + score(playerHand));
        System.out.println("Dealer: [" + dealerHand.getCards().get(0) + ", HIDDEN]");
        System.out.println("------------------\n");
    }

    public boolean takeTurn(String cmd)
    {
        if (cmd.equals("h"))
        {
            playerHand.addCard(deck.deal());
            System.out.println("Player hits.");
            printState();

            if (score(playerHand) > 21)
            {
                System.out.println("BUST! You lose.");
                return false;
            }
        }
        else if (cmd.equals("s"))
        {
            System.out.println("Player stands.");
            isPlayerDone = true;
            return dealerTurn();
        }

        return true;
    }

    private boolean dealerTurn()
    {
        System.out.println("\nDealer reveals: " + dealerHand.getCards() +
                           " Score: " + score(dealerHand));

        while (score(dealerHand) < 17)
        {
            System.out.println("Dealer hits.");
            dealerHand.addCard(deck.deal());
            System.out.println("Dealer hand: " + dealerHand.getCards() +
                               " Score: " + score(dealerHand));
        }

        if (score(dealerHand) > 21)
            System.out.println("Dealer busts! You win!");
        else if (score(dealerHand) >= score(playerHand))
            System.out.println("Dealer wins.");
        else
            System.out.println("You win!");

        return false;
    }

    public int score(Hand h)
    {
        int total = 0;
        int aces = 0;

        for (Card c : h.getCards()) {
            total += c.getValue();
            if (c.getValue() == 1)
                aces++;
        }

        while (aces > 0 && total + 10 <= 21)
        {
            total += 10;
            aces--;
        }

        return total;
    }
}
