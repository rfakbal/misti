import java.util.ArrayList;

public class Player {
    protected ArrayList<Card> playedCard;

    protected ArrayList<Card> Hand = new ArrayList<Card>();
    protected static int[] Memory = new int[13];

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

    public void addToMemory(Card a) {
        for (int b : Memory) {
            System.out.print(b);
        }
        switch(a.getRank()) {
            case 'A':
                Memory[0]++;
                break;
            case '2':
                Memory[1]++;
                break;
            case '3':
                Memory[2]++;
                break;
            case '4':
                Memory[3]++;
                break;
            case '5':
                Memory[4]++;
                break;
            case '6':
                Memory[5]++;
                break;
            case '7':
                Memory[6]++;
                break;
            case '8':
                Memory[7]++;
                break;
            case '9':
                Memory[8]++;
                break;
            case 'T':
                Memory[9]++;
                break;
            case 'J':
                Memory[10]++;
                break;
            case 'Q':
                Memory[11]++;
                break;
            case 'K':
                Memory[12]++;
                break;
        }
    }
}