import java.util.ArrayList;

public class Player {
    protected ArrayList<Card> playedCard;

    protected ArrayList<Card> Hand = new ArrayList<Card>();

    protected String playerName;
    protected int playerScore;
    protected String type;

    public void setPlayerScore(int score) {
        playerScore += score;
    }

    public Player(String name) {
        playerName = name;
        playerScore = 0;
    }

    public void recieveCard(Card in) { // Players will get their cards from the dealer using this method in the Game
                                       // class. bba
        Hand.add(in);
    }

    public Card playCard() { // Computer players should take Table ArrayList as a parameter to choose their
                             // card to play. However, human players don't need it. bba
        return null;// will be implemented in subclasses. bba
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public String getPlayerName() {
        return playerName;
    }
    
    public ArrayList<Card> getPlayedCards() {
        return null;
    }

    public String getType(){
        return this.type;
    }

    public void printHand(){
        for (int i = 0 ; i < Hand.size() ; i++){
            Hand.get(i).cardPrint();
            if (i+1 < Hand.size()) {
                System.out.print(",");
            }
        }
    }
}