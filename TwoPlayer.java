import java.io.IOException;
import java.nio.file.Paths;
import java.util.Formatter;
import java.io.FileWriter;
import java.util.Scanner;

public class TwoPlayer extends Game{
    
    Player one;
    Player two;


    public TwoPlayer(String Player1, String Type1, String Player2, String Type2 , boolean verboseMode){
        super();

        one = playerCreator(Player1 , Type1 , one);
        two = playerCreator(Player2 , Type2 , two);

        this.verboseMode = verboseMode;
        
    }

    @Override
    public void startTurn(){

        super.startTurn();

        for(int i = 0 ; i < 4 ; i++ ) {
            one.recieveCard(deck.giveCard());
            two.recieveCard(deck.giveCard());
        }

        for(int i = 0 ; i < 4 ; i++) {
            printTable();
            addToTable(one.playCard());
            checkPlay(one);
            printTable();
            addToTable(two.playCard());
            checkPlay(two);
        }
        
    }

    @Override
    public void scoreBoardAdd(Player p){
        boolean stop = false;
        Scanner reader = null;
        Scanner reader1 = null;

        String name = p.getPlayerName();
        String name_updated = name.replace(" ","");
        int score = p.getPlayerScore();
        int[] scores = new int[10];
        int[] scores_last  = new int[11];
        String[] names = new String[10];
        String[] names_last = new String[11];
        String line = "";
        String[] line_arr = new String[2];
        
        try{
            reader = new Scanner(Paths.get("Scores.txt"));
            for(int i = 0;i<10;i++ ){
                line = reader.nextLine();
                line_arr = line.split(" ");
                scores[i] = Integer.valueOf(line_arr[1]);
                names[i] = line_arr[0];
             }
        }
        
        catch(Exception e){
            System.out.println("");
        }
        
        finally{
            if(reader != null) reader.close();
        }
        
        int temp = 0;
        String temp1 = "";
        
        for(int i = 0;i<10;i++){
            if(score>scores[i]&&!stop){
                temp = scores[i];
                temp1 = names[i];
                scores_last[i+1] = temp;
                names_last[i+1] = temp1;
                names_last[i] = name_updated;
                scores_last[i] = score;
                for(int k = 0;k<i;k++){
                    names_last[k] = names[k];
                    scores_last[k] = scores[k];
                }
                for(int j = i+2;j<11-i;j++){
                    names_last[j] = names[j-1];
                    scores_last[j] = scores[j-1];
                }
                stop = true;
            }
        }
        
        for(int i = 0;i<10;i++){
            System.out.println((i+1)+"-) "+names_last[i]+" "+scores_last[i]);
        }

        Formatter f = null;
        FileWriter fw = null;

        try{
            fw = new FileWriter("Scores.txt",false);
            reader1 = new Scanner(Paths.get("Scores.txt"));
            f = new Formatter(fw);
            for(int i = 0;i<10;i++){
                f.format("%s %d\n",names_last[i],scores_last[i]);
            }
        }

        catch(Exception e){
            System.err.println("");
        }

        finally{
            if(f!=null){
                f.close();
            }
        }

    }

    @Override
    public void drawScoreBoard(){
        
        if(one.getPlayerScore()>two.getPlayerScore()){
            System.out.println("The winner is " + one.getPlayerName());
            scoreBoardAdd(one);
        }
        
        else if (one.getPlayerScore()<two.getPlayerScore()){
            System.out.println("The winner is " + two.getPlayerName());
            scoreBoardAdd(two);
        }
        
        else{
            System.out.println("Draw!");
            scoreBoardAdd(one);
            scoreBoardAdd(two);
        }

    }   
}