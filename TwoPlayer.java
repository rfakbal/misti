import java.util.ArrayList;

public class TwoPlayer extends Game{
    
    ArrayList<Card> p1 = new ArrayList<Card>(); //hands of player1 and player2 @bba
    ArrayList<Card> p2 = new ArrayList<Card>();

    ArrayList<Card> table = new ArrayList<Card>();

    public TwoPlayer(){
        super();
    }

    public void startRound(){
        Deck.shuffleDeck();
        for (int i = 0 ; i < 4 ; i++) {
            p1.add(Deck.giveCard());
        }
        for (int k = 0 ; k < 4 ; k++) {
            p2.add(Deck.giveCard());
        }
    }

    
}