import java.util.ArrayList;

public class FourPlayer extends Game {

    Player one;
    Player two;
    Player three;
    Player four;

    ArrayList<Card> table = new ArrayList<Card>();
    
    private boolean verboseMode = false;
    private int rounds;
    Deck deck;

    public FourPlayer(String Player1, String Type1, String Player2, String Type2 , String Player3 , String Type3 , String Player4 , String Type4 , int rounds , boolean verboseMode) {
        super();

        playerCreator(Player1 , Type1 , one);
        playerCreator(Player2 , Type2 , two);
        playerCreator(Player3 , Type3 , three);
        playerCreator(Player4 , Type4 , four);

        this.rounds = rounds;
        this.verboseMode = verboseMode;
        
    }

    @Override
    public void startRound() {        
        for (int i = 0 ; i < 4 ; i++) { 
            one.recieveCard(deck.giveCard());
            two.recieveCard(deck.giveCard());
            three.recieveCard(deck.giveCard());
            four.recieveCard(deck.giveCard());
        }

        for(int i = 0 ; i < 4 ; i++) {
            one.playCard(table);
            two.playCard(table);
            three.playCard(table);
            four.playCard(table);
        }
    }
}
