public class Card{
    private String suit;
    private String rank;
    private int point;
    private final String[] suits = {"S","C","H","D"};
    private final String[] ranks = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
    public Card(String suit, String rank){
        this.suit = suit;
        this.rank = rank;
        point = 1;
    }

    public boolean cardCheck(Card test){
        if(this.getRank().equals(test.getRank())|| this.getRank().equals("J")){
            return true;
        }
        return false;
    }

    public void cardPrint(){
        switch(this.suit){
            case "S":
            System.out.println(this.getRank()+ " of Spades");
            break;
            case "H":
            System.out.println(this.getRank()+ " of Hearts");
            break;
            case "D":
            System.out.println(this.getRank()+ " of Diamonds");
            break;
            case "C":
            System.out.println(this.getRank()+ " of Clubs");
            break;
        }
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