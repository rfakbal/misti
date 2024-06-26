import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class Deck{
    private final char[] suits = {'S','C','H','D'};
    private final char[] ranks = {'A','2','3','4','5','6','7','8','9','T','J','Q','K'};
    private ArrayList<Card> Deck = new ArrayList<Card>();
    private Card placeholder;
    public Deck(String fileName){ //Creates deck of cards in order in an ArrayList @bba
        for (char s : suits) {
            for (char r : ranks) {
                placeholder = new Card( s , r );
                Deck.add(placeholder);
                placeholder = null;
            }
        }
        pointRead(Deck,fileName);
    }

    public void shuffleDeck(){
        Collections.shuffle(Deck);
    }

    public void cutDeck(){
        int deckSize = Deck.size();
        int cut = (int)(Math.random()*deckSize);
        ArrayList<Card> top = new ArrayList<Card>(Deck.subList(0, cut));
        ArrayList<Card> bottom = new ArrayList<Card>(Deck.subList(cut, deckSize));
        Deck.clear();
        Deck.addAll(bottom);
        Deck.addAll(top);
    }

    public Card giveCard(){
        Card placeholder = Deck.get(Deck.size()-1);
        Deck.remove(Deck.size()-1);
        return placeholder;
    }
    
    public void pointRead(ArrayList<Card> deck, String fileName){
        String line;
        char suit_input;
        char rank_input;
        int point_input;
        Scanner reader = null;
        try{
             reader = new Scanner(Paths.get(fileName));
             while(reader.hasNextLine()){
                line = reader.nextLine();
                String temp = line.substring(2,line.length()).trim(); 
                suit_input = line.charAt(0);
                rank_input = line.charAt(1);
                point_input = Integer.parseInt(temp);
                if(suit_input=='*'&&rank_input!='*'){
                    for(Card c : deck){
                        if(c.getRank() == rank_input && !c.getPointCheck()){
                            c.setPoint(point_input);
                            c.PointCheck();
                        }
                    }  
                }
                else if(suit_input!='*'&&rank_input==('*')){
                    for(Card c : deck){
                        if(c.getSuit()==suit_input && !c.getPointCheck()){
                            c.setPoint(point_input);
                            c.PointCheck();
                        }
                    }
                }
                else if(suit_input=='*'&&rank_input=='*'){
                    for(Card c : deck){
                        if(!c.getPointCheck()){
                            c.setPoint(point_input);
                            c.PointCheck();
                        }
                    }
                }
                else{
                    for(Card c : deck){
                        if(c.getSuit()==suit_input && c.getRank()==rank_input && !c.getPointCheck()){
                            c.setPoint(point_input);
                            c.PointCheck();
                        }
                    }
                }
             }
        }
        catch(Exception e ){
            System.out.println("Point file not found, default point value for each card is set to 1");
        }
    }
}