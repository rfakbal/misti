import java.util.Random;
public class Novice extends Player{
    public Novice(String name){
        super(name);
        type = "N";
    }

    @Override
    public Card playCard(){
        System.out.println("\nNovice's Hand:");
        for (Card a : Hand){
            a.cardPrint();
        }
        System.out.println();
        Random rd = new Random(System.currentTimeMillis());
        int index = rd.nextInt(Hand.size());
        Card temp = Hand.get(index);
        Hand.remove(index);
        System.out.println();
        System.out.println(getPlayerName() + " played ");
        temp.cardPrint();
        System.out.println();
        return temp;
    }
}