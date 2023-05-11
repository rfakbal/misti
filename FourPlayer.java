import java.util.ArrayList;

public class FourPlayer extends TwoPlayer {

    Player one;
    Player two;
    Player three;
    Player four;

    ArrayList<Card> table = new ArrayList<Card>();
    
    private boolean verboseMode = false;
    private int rounds;
    Deck deck;

    public FourPlayer() {
        super();
    }

    @Override
    public void startRound() {        
        for (int i = 0 ; i < 4 ; i++) { 
            one.recieveCard(deck.giveCard());
            two.recieveCard(deck.giveCard());
            three.recieveCard(deck.giveCard());
            four.recieveCard(deck.giveCard());
        }
    }
}
