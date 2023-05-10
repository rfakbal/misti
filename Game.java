import java.util.ArrayList;
import java.util.Scanner;

public class Game{

    private String verboseMode = false;
    private int rounds;

    ArrayList<Card> table = new ArrayList<Card>;

    public Game() {
        Deck deck = new Deck();
    }

    public void startRound(){
        //will be implemented in subclasses. bba
    }


}