import java.util.ArrayList;

public class Game{

    private boolean verboseMode = false;
    private int rounds;

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
            player = new NoviceBot(name);
            break;

            case "R":
            player = new RegularBot(name);
            break;

            case "E":
            player = new ExpertBot(name);
            break; 
        }
    }

    

}