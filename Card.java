public class Card{
    private String suit;
    private String rank;
    private int point;
    private final String[] suits = {"Spades","Clubs","Hearts","Diamonds"};
    private final String[] ranks = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
    public Card(String suit, String rank, int point){
        this.suit = suit;
        this.rank = rank;
        this.point = point;
    }

    public boolean cardCheck(Card test){
        if(this.getRank().equals(test.getRank())|| this.getRank().equals("J")){
            return true;
        }
        return false;
    }

    public String getSuit() {
        return suit;
    }

    public int getPoint(){
        return point;
    }

    public String getRank() {
        return rank;
    }

    public void setSuit(String suit){
        this.suit = suit; 
    }

    public void setRank(String rank){
        this.rank = rank;
    }

    public void setPoint(int point){
        this.point = point;
    }
    
}