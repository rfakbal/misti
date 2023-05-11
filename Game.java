import java.util.ArrayList;

public class Game{
    protected boolean verboseMode = false;
    protected int rounds;

    static ArrayList<Card> table = new ArrayList<Card>();
    Deck deck;

    public Game() {
        deck = new Deck();
    }

    public void startRound(){
        //will be implemented in subclasses. bba
    }

    public void playerCreator(String name, String type,Player player) {
        switch (type) { // No default case because all of the exceptions will be handled in the main method. bba
            case "H":
            player = new Human(name);
            break;
            
            case "N":
            player = new Novice(name);
            break;

            case "R":
            player = new Regular(name);
            break;

            case "E":
            player = new Expert(name);
            break; 
        }
    }
    
    public static ArrayList<Card> getTable(){
        return table;
    }

    public Card addToTable(Card c){
        return c;
    }

}