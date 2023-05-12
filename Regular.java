import java.util.ArrayList;
import java.util.Random;

public class Regular extends Player {
    public Regular(String name) {
        super(name);
    }

    
    public Card playCard(ArrayList<Card> table) {
        // Find the card with the highest point value that can be played
        Card bestCard = null;
        int highestPoint = 0;
        for (Card card : Hand) {
            if (card.getRank() == table.get(table.size() - 1).getRank() && card.getPoint() > highestPoint) {
                bestCard = card;
                highestPoint = card.getPoint();
            }
        }

        // If no card can be played, choose a random card
        if (bestCard == null) {
            Random random = new Random();
            int index = random.nextInt(Hand.size());
            bestCard = Hand.get(index);
        }

        Hand.remove(bestCard);
        System.out.println(getPlayerName() + " played " + bestCard.toString());
        return bestCard;
    }
}
