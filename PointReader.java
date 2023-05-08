import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Paths;
public class PointReader{
    private String fileName;
    private Card[] deck;
    private int score;
    private String line;
    private String rankChar;
    private String suitChar;
    public PointReader(String fileName,Card[] deck){
        this.fileName = fileName;
        this.deck = deck;
    }
    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public Card[] getDeck() {
        return deck;
    }
    public void setDeck(Card[] deck) {
        this.deck = deck;
    }
    public void readFile(){
        Scanner reader = null;
        try{
            reader = new Scanner(Paths.get(fileName));
            while(reader.hasNextLine()){
                line = reader.nextLine();
                System.out.println(line[0]);
            }
        }
        catch(Exception e){
            System.out.println("TEST TEST");
        }
    }

}