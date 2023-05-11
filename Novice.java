import java.util.Random;
public class Novice extends Player{
    public Novice(String name){
        super(name);
    }
    public Card playCard(){
        boolean loop = true;
        Random rd = new Random(System.currentTimeMillis());
        int index = rd.nextInt(Hand.size());
        Card temp = Hand.get(index);
        Hand.remove(index);
        return temp;
    }
}