import java.util.ArrayList;

public class Player {
    private ArrayList<Card> hand;
    private ArrayList<Card> playedCard;

    ArrayList<Card> Hand = new ArrayList<Card>();

    private String playerName;
    private int playerScore;

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
}