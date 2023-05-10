import java.util.ArrayList;

public class FourPlayer extends TwoPlayer {

    Player one;
    Player two;
    Player three;
    Player four;

    ArrayList<Card> table = new ArrayList<Card>();
    
    private String verboseMode = false;
    private int rounds;

    public FourPlayer() {
        super();
    }

    @override
    public void startRound() {        
        for (int i = 0 ; i < 4 ; i++) {
            public void startRound(){
                for(int i = 0 ; i < 4 ; i++ ) {
                    one.recieveCard(Deck.giveCard());
                    two.recieveCard(Deck.giveCard());
                    three.recieveCard(Deck.giveCard());
                    four.recieveCard(Deck.giveCard());
                }
                
            }
        }
    }
}
