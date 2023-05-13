public class Card{
    private char suit;
    private char rank;
    private int point;
    private boolean pointCheck;
    public Card(char suit, char rank){
        this.suit = suit;
        this.rank = rank;
        point = 1;
        pointCheck = false;
    }

    public boolean cardCheck(Card test){
        if(this.getRank()==test.getRank()|| this.getRank()=='J'){
            return true;
        }
        return false;
    }

    public void cardPrint(){
        switch(this.suit){
            case 'S':
            System.out.print( "♠" + this.getRank());
            break;
            case 'H':
            System.out.print( "♥" + this.getRank());
            break;
            case 'D':
            System.out.print( "♦" + this.getRank());
            break;
            case 'C':
            System.out.print( "♣" + this.getRank());
            break;
        }
    }

    public boolean getPointCheck() {
        return pointCheck;
    }

    public void PointCheck() {
        pointCheck = true;
    }

    public char getSuit() {
        return suit;
    }

    public int getPoint(){
        return point;
    }

    public char getRank() {
        return rank;
    }

    public void setSuit(char suit){
        this.suit = suit; 
    }

    public void setRank(char rank){
        this.rank = rank;
    }

    public void setPoint(int point){
        this.point = point;
    }
    
}