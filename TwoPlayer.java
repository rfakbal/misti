public class TwoPlayer extends Game{
    
    Player one;
    Player two;


    public TwoPlayer(String Player1, String Type1, String Player2, String Type2 , boolean verboseMode){
        super();

        one = playerCreator(Player1 , Type1 , one);
        two = playerCreator(Player2 , Type2 , two);

        this.verboseMode = verboseMode;
        
    }

    @Override
    public void startTurn(){

        super.startTurn();

        for(int i = 0 ; i < 4 ; i++ ) {
            one.recieveCard(deck.giveCard());
            two.recieveCard(deck.giveCard());
        }

        for(int i = 0 ; i < 4 ; i++) {
            printTable();
            addToTable(one.playCard());
            checkPlay(one);
            printTable();
            addToTable(two.playCard());
            checkPlay(two);
        }
        
    }

    


}