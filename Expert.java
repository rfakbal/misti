import java.util.ArrayList;
import java.util.Random;

public class Expert extends Player {
    public Expert(String name) {
        super(name);
    }

    public Card playCard(ArrayList<Card> table, ArrayList<Player> players) {
        ArrayList<Card> validCards = new ArrayList<>();
        for (Card card : Hand) {
            
            // Masa üzerindeki son kartın değeri ile aynı olan, pozitif puanlı kartları geçerli kartlar listesine eklenir

            if (card.getRank() == table.get(table.size() - 1).getRank() && card.getPoint() >= 0) {
                validCards.add(card);
            }
        }

        // Geçerli kart yoksa, rastgele bir kart seçin ve onu oynayın.
        if (validCards.size() == 0) {
            Random random = new Random();
            int index = random.nextInt(Hand.size());
            Card chosenCard = Hand.get(index);
            Hand.remove(chosenCard);
            return chosenCard;
        }
        
        // Geçerli kartlar arasından en iyi kkarti secer
        Card bestCard = null;
        int highestPoint = 0;
        for (Card card : validCards) {
            // Her kart için bir değerlendirme yapın ve en yüksek değerli karti bulmaca anlarsin ya
            int cardValue = evaluateCard(card, players);
            if (cardValue > highestPoint) {
                bestCard = card;
                highestPoint = cardValue;
            }
        }
        Hand.remove(bestCard);
        return bestCard;
    }
    // Elimizdeki toplam değerini ve diğer oyuncuların son oynanan kartlarını degerlerini hesaplariz
    public int evaluateCard(Card card, ArrayList<Player> players) {
        int cardValue = card.getPoint();

        int handValue = evaluateHand(Hand, players);
        if (handValue >= 20) {
          
            if (card.getPoint() > 0) {
                cardValue -= 2;
            }
        } else {
            if (card.getPoint() >= 10) {
                cardValue += 2;
            }
        }

        return cardValue;
    }

    public int evaluateHand(ArrayList<Card> hand, ArrayList<Player> players) {
        int handValue = 0;
        // Elimizdeki toplam puanını hesaplar
        for (Card card : hand) {
            handValue += card.getPoint();
        }

        for (Player player : players) {
            if (player == this) {
                continue;
            }
            // Diğer oyuncuların son oynanan kartlarından, 10 veya daha yüksek puanlı bir kart oynandıysa elindeki degere 2 puan ekler 

            int playedCardsCount = player.getPlayedCards().size();
            if (playedCardsCount > 0) {
                Card lastPlayedCard = player.getPlayedCards().get(playedCardsCount - 1);
                if (lastPlayedCard.getPoint() >= 10) {
                    handValue += 2;
                }
            }
        }

        return handValue;
    }
}
