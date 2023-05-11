import java.util.ArrayList;

public class TwoPlayer extends Game{
    
    Player one;
    Player two;


    public TwoPlayer(String Player1, String Type1, String Player2, String Type2 , int rounds , boolean verboseMode){
        super();

        playerCreator(Player1 , Type1 , one);
        playerCreator(Player2 , Type2 , two);

        this.rounds = rounds;
        this.verboseMode = verboseMode;
        
    }

    @Override
    public void startRound(){
        for(int i = 0 ; i < 4 ; i++ ) {
            one.recieveCard(deck.giveCard());
            two.recieveCard(deck.giveCard());
        }

        for(int i = 0 ; i < 4 ; i++) {
            addToTable(one.playCard());
            addToTable(two.playCard());
        }
        
    }
    


}