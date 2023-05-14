import java.util.ArrayList;
import java.util.Collections;
import java.util.Formatter;
import java.util.Scanner;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;
import java.nio.file.Path;

public class FourPlayer extends Game {
    boolean ifPrint = false;
    protected Player one;
    protected Player two;
    protected Player three;
    protected Player four;


    public FourPlayer(String fileName , String Player1, String Type1, String Player2, String Type2 , String Player3 , String Type3 , String Player4 , String Type4 , boolean verboseMode) {
        super(fileName);

        one = playerCreator(Player1 , Type1 , one);
        two = playerCreator(Player2 , Type2 , two);
        three = playerCreator(Player3 , Type3 , three);
        four = playerCreator(Player4 , Type4 , four);

        Game.verboseMode = verboseMode;

        playerList.add(one);
        playerList.add(two);
        playerList.add(three);
        playerList.add(four);
    }

    @Override
    public void startTurn() {     
        
        super.startTurn();

        for (int i = 0 ; i < 4 ; i++) { 
            one.recieveCard(deck.giveCard());
            two.recieveCard(deck.giveCard());
            three.recieveCard(deck.giveCard());
            four.recieveCard(deck.giveCard());
        }

        verboseHand(verboseMode , playerList);

        for(int i = 0 ; i < 4 ; i++) {
            if (verboseMode) {
                System.out.println("\n" +(i+1)+ ". turn of the hand:");
            }
            addToTable(one.playCard());
            checkPlay(one);
            addToTable(two.playCard());
            checkPlay(two);
            addToTable(three.playCard());
            checkPlay(three);
            addToTable(four.playCard());
            checkPlay(four);
        }
    }

    @Override
    public void scoreBoardAdd(Player p) {
        String name = p.getPlayerName();
        int score = p.getPlayerScore();
        String expertise = p.getType();
        ArrayList<Integer> scores = new ArrayList<Integer>();
        ArrayList<String> names = new ArrayList<String>();
        ArrayList<String> expertises = new ArrayList<String>();

        try {
            Path file = Paths.get("Scores.txt");
            if (!Files.exists(file)) {
                Files.createFile(file);
            }
        } catch (IOException e) {
        System.err.println("");
        }

        try (Scanner scanner = new Scanner(Paths.get("Scores.txt"))) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] lineArr = line.split(" ");
                if (lineArr.length == 3) {
                    names.add(lineArr[0]);
                    scores.add(Integer.parseInt(lineArr[1]));
                    expertises.add(lineArr[2]);
                }
            }
        } catch (Exception e) {
            System.err.println("");
            return;
        }

        scores.add(score);
        names.add(name);
        expertises.add(expertise);

        ArrayList<Integer> topScores = new ArrayList<Integer>(scores);
        Collections.sort(topScores, Collections.reverseOrder());
        topScores = new ArrayList<Integer>(topScores.subList(0, Math.min(topScores.size(), 10)));

        ArrayList<Integer> topIndexes = new ArrayList<Integer>();
        ArrayList<String> topNames = new ArrayList<String>();
        ArrayList<String> topExpertises = new ArrayList<String>();
        for (int i = 0; i < topScores.size(); i++) {
            int index = scores.indexOf(topScores.get(i));
            topIndexes.add(index);
            topNames.add(names.get(index));
            topExpertises.add(expertises.get(index));
        }

        try (Formatter formatter = new Formatter("Scores.txt")) {
            for (int i = 0; i < topScores.size(); i++) {
                formatter.format("%s %d %s %n", topNames.get(i), topScores.get(i),expertises.get(i));
            }
        } catch (IOException e) {
        System.err.println("");
        }
        for (int i = 0; i < topScores.size(); i++) {
            if(ifPrint){
            System.out.println((i+1)+" -) "+topNames.get(i)+" "+topScores.get(i)+" "+expertises.get(i)); 
            }
        }
    }

    @Override
    public void drawScoreBoard(){
        scoreBoardAdd(one);
        scoreBoardAdd(two);
        scoreBoardAdd(three);
        ifPrint = true;
        scoreBoardAdd(four);
    } 

}
