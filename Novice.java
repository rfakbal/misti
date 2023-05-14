import java.util.Random;
public class Novice extends Player{
    public Novice(String name){
        super(name);
        type = "N";
    }

    @Override
    public Card playCard(){
        //System.out.println("\n" + playerName +"'s Hand:");
        //for (Card a : Hand){ //delete in final version bba
        //    a.cardPrint();
        //}
        //System.out.println();
        Random rd = new Random(System.currentTimeMillis());
        int index = rd.nextInt(Hand.size());
        Card temp = Hand.get(index);
        Hand.remove(index);
        if (Game.getVerbose()) {
            System.out.print(getPlayerName() + " played ");
            temp.cardPrint();
            System.out.println();
        }
        return temp;
    }
}