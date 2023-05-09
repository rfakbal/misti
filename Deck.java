import java.util.ArrayList;
import java.util.Collections;
public class Deck{
    private final char[] suits = {'S','C','H','D'};
    private final char[] ranks = {'A','2','3','4','5','6','7','8','9','T','J','Q','K'};
    private ArrayList<Card> Deck = new ArrayList<Card>();
    private Card placeholder;
    public Deck(){ //Creates deck of cards in order in an ArrayList @bba
        for (char s : suits) {
            for (char r : ranks) {
                placeholder = new Card( s , r );
                Deck.add(placeholder);
                placeholder = null;
            }
        }
        Test();

    }
    public void Test(){
        for (Card a: Deck){
            a.cardPrint();
        }
    }

    public void shuffleDeck(){
        Collections.shuffle(Deck);
    }

    public Card giveCard(){
        Card placeholder = Deck.get(0);
        Deck.remove(0);
        return placeholder;
    }
}


aaaaAAAaaaa
