import java.util.ArrayList;

public class TwoPlayer extends Game{
    
    Player one;
    Player two;

    ArrayList<Card> table = new ArrayList<Card>();

    private String verboseMode = false;
    private int rounds;

    public TwoPlayer(){
        super();
    }

    public void startRound(){
        for(int i = 0 ; i < 4 ; i++ ) {
            one.recieveCard(Deck.giveCard());
            two.recieveCard(Deck.giveCard());
        }
        
    }
    
}