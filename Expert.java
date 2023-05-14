import java.util.ArrayList;

public class Expert extends Player {
    public Expert(String name) {
        super(name);
        type = "E";
    }

    public Card playCard() {
        ArrayList<Card> Table = Game.getTable();
        Card chosen = null;
        int localOutcome;
        int smallestOutcome = 2147483647;
        int index = 0;

        for (int i = 0 ; i < Hand.size() ; i++) { //for each card in Hand
            if (Table.size() > 0) { // checking if table is empty
                if (Hand.get(i).cardCheck(Table.get(Table.size()-1))) { // if the card is able to take the table
                    localOutcome = Game.countTablePoints() + Hand.get(i).getPoint(); // how many points the player will get if it takes cards on the table
                    if (localOutcome > 0) { // if positive, bot takes cards
                        chosen = Hand.get(i);
                        index = i;
                        break;
                    } else {
                        if (Hand.get(i).getPoint() >= 0) { // if the point value is positive, bot will try to play the card with the lowest point + minimum left in the deck.
                            localOutcome = (Hand.get(i).getPoint() * Memory[getRankIndex(Hand.get(i))]) ; 
                            if (localOutcome <= smallestOutcome) {
                                smallestOutcome = localOutcome;
                                chosen = Hand.get(i);
                                index = i;
                            }
                        } else { // if the point value is negative, bot will try to play the card with the lowest point + maximum left in the deck.
                            localOutcome = (-Hand.get(i).getPoint() * (4 - Memory[getRankIndex(Hand.get(i))])) ;
                            if (localOutcome <= smallestOutcome) {
                                smallestOutcome = localOutcome;
                                chosen = Hand.get(i);
                                index = i;
                            }
                        }
                    }
                } else { // if the bot cannot take the table, it will try to play the most logical card to not give the other player positive points
                    if (Hand.get(i).getPoint() >= 0) {
                        localOutcome = (Hand.get(i).getPoint() * Memory[getRankIndex(Hand.get(i))]) ; // same as line 26
                        if (localOutcome <= smallestOutcome) {
                            smallestOutcome = localOutcome;
                            chosen = Hand.get(i);
                            index = i;
                        }
                    } else {
                        localOutcome = (-Hand.get(i).getPoint() * (4 - Memory[getRankIndex(Hand.get(i))])) ; // same as line 33
                        if (localOutcome <= smallestOutcome) {
                            smallestOutcome = localOutcome;
                            chosen = Hand.get(i);
                            index = i;
                        }
                    }
                }
            } else { // if the table is empty, bot will play the smallest point valued card besides jack
                if (Hand.get(i).getRank() == 'J') {
                    localOutcome = 2147483647; // Biggest integer to prevent the bot from playing Jack on the empty table if any other options available.
                }
                if (Hand.get(i).getPoint() >= 0) {
                    localOutcome = (Hand.get(i).getPoint() * Memory[getRankIndex(Hand.get(i))]) ; // same as line 26
                    if (localOutcome <= smallestOutcome) {
                        smallestOutcome = localOutcome;
                        chosen = Hand.get(i);
                        index = i;
                    }
                } else {
                    localOutcome = (-Hand.get(i).getPoint() * (4 - Memory[getRankIndex(Hand.get(i))])) ; // same as line 33
                    if (localOutcome <= smallestOutcome) {
                        smallestOutcome = localOutcome;
                        chosen = Hand.get(i);
                        index = i;
                    }
                }
            }
        }
        chosen = Hand.get(index);
        Hand.remove(index);
        if (Game.getVerbose()) {
            System.out.print(playerName + " played ");
            chosen.cardPrint();
            System.out.println();
        }
        addToMemory(chosen);
        return chosen;
        
    
    }
        
}
