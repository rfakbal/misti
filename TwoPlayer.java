import java.util.ArrayList;

public class TwoPlayer extends Game{
    
    Player one;
    Player two;

    ArrayList<Card> table = new ArrayList<Card>();

    private boolean verboseMode = false;
    private int rounds;
    Deck deck;

    public TwoPlayer(){
        super();
    }

    @Override
    public void startRound(){
        for(int i = 0 ; i < 4 ; i++ ) {
            one.recieveCard(deck.giveCard());
            two.recieveCard(deck.giveCard());
        }
        
    }
    
}