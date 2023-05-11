import java.util.ArrayList;

public class Game{

    private boolean verboseMode = false;
    private int rounds;

    ArrayList<Card> table = new ArrayList<Card>();
    Deck deck;

    public Game() {
        deck = new Deck();
    }

    public void startRound(){
        //will be implemented in subclasses. bba
    }


}