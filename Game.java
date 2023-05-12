import java.util.ArrayList;

public class Game{
    protected boolean verboseMode = false;
    protected int rounds;

    static ArrayList<Card> table = new ArrayList<Card>();
    Deck deck;

    public Game() {
        deck = new Deck();
        deck.shuffleDeck();
        deck.cutDeck();

        for(int i = 0 ; i < 4 ; i++) { //first 4 card will be opened in the table bba
            table.add(deck.giveCard());
        }

    }

    public void startRound(){
        //implemented in the subclasses bba
    }

    public void playerCreator(String name, String type,Player player) {
        switch (type) { // No default case because all of the exceptions will be handled in the main method. bba
            case "H":
            player = new Human(name);
            break;
            
            case "N":
            player = new Novice(name);
            break;

            case "R":
            player = new Regular(name);
            break;

            case "E":
            player = new Expert(name);
            break; 
        }
    }
    
    public static ArrayList<Card> getTable(){
        return table;
    }

    public Card addToTable(Card c){
        return c;
    }

    public void printTable(){
        for(int i = 0 ; i < table.size()-1 ; i++){
            System.out.print(table.get(i) + ",");
        }
        System.out.print("\n" + table.get(table.size()-1));
    }
    
    public void checkPlay(Player a){
        int point = 0;
        if (table.size() > 1) { 
            if(table.size() == 2) { //checking the misti situation bba
                if (table.get(1).cardCheck(table.get(0))) {
                    System.out.println(a.getPlayerName() + " made misti!");
                    point = (table.get(1).getPoint() + table.get(0).getPoint()) * 5;
                    System.out.println(a.getPlayerName() + " earned " + point + " points.");
                    a.setPlayerScore(point);
                    point = 0;
                    table.clear();
                }
            } else { // every other card gaining situation bba
                if (table.get(table.size()-1).cardCheck(table.get(table.size()-2))) {
                    for(int i = 0 ; i < table.size() ; i++ ) {
                        point += table.get(i).getPoint();
                    }
                    System.out.println(a.getPlayerName() + " earned " + point + " points.");
                    a.setPlayerScore(point);
                    point = 0;
                    table.clear();
                }
            }
        }
    }

}