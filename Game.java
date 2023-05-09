import java.util.ArrayList;
public class Game{

    ArrayList<Card> table = new ArrayList<Card>;

    public Game() {
        Deck deck = new Deck();
    }

    public void startRound(){
        //will be implemented in subclasses. @bba
    }

    public void playCard(){
        //will be implemented in subclasses. @bba
    }

}