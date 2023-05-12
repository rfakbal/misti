import java.util.Random;
public class Novice extends Player{
    public Novice(String name){
        super(name);
    }

    @Override
    public Card playCard(){
        Random rd = new Random(System.currentTimeMillis());
        int index = rd.nextInt(Hand.size());
        Card temp = Hand.get(index);
        Hand.remove(index);
        System.out.println(getPlayerName() + " played " + temp.toString());
        return temp;
    }
}