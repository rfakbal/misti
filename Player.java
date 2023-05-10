import java.util.ArrayList;
public class Player {

    ArrayList<Card> Hand = new ArrayList<Card>;

    private String playerName;
    private int playerScore;
    

    public Player(String name) {
        playerName = name;
        playerScore = 0;
    }

    public void recieveCard(Card in) { //  Players will get their cards from the dealer using this method in the Game class. bba
        Hand.add(in);
    }

    public void playCard(){ // Computer players should take Table ArrayList as a parameter to choose their card to play. However, human players don't need it. bba
        //will be implemented in subclasses. bba
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public String getPlayerName() {
        return playerName;
    }
}