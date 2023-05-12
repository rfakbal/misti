public class FourPlayer extends Game {

    Player one;
    Player two;
    Player three;
    Player four;


    public FourPlayer(String Player1, String Type1, String Player2, String Type2 , String Player3 , String Type3 , String Player4 , String Type4 , boolean verboseMode) {
        super();

        playerCreator(Player1 , Type1 , one);
        playerCreator(Player2 , Type2 , two);
        playerCreator(Player3 , Type3 , three);
        playerCreator(Player4 , Type4 , four);

        this.verboseMode = verboseMode;

        
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

        for(int i = 0 ; i < 4 ; i++) {
            printTable();
            addToTable(one.playCard());
            checkPlay(one);
            printTable();
            addToTable(two.playCard());
            checkPlay(two);
            printTable();
            addToTable(three.playCard());
            checkPlay(three);
            printTable();
            addToTable(four.playCard());
            checkPlay(four);
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
        
        Player winner = one;
        Player winner_second = null;
        Player winner_third = null;
        Player winner_fourth = null;
        
        // Check if player two has a higher score
        if (winner.getPlayerScore() < two.getPlayerScore()) {
            winner = two;
            winner_second = null;
            winner_third = null;
            winner_fourth = null;
        } else if (winner.getPlayerScore() == two.getPlayerScore()) {
            // There is a tie between player one and player two
            winner_second = two;
            scoreBoardAdd(one);
            scoreBoardAdd(two);
        }
        
        // Check if player three has a higher score
        if (winner.getPlayerScore() < three.getPlayerScore()) {
            winner = three;
            winner_second = null;
            winner_third = null;
            winner_fourth = null;
        } else if (winner.getPlayerScore() == three.getPlayerScore()) {
            // There is a tie between player one, player two, and player three
            if (winner_second == null) {
                winner_second = three;
            } else if (winner == two) {
                winner_third = three;
            } else {
                winner_fourth = three;
            }
            scoreBoardAdd(one);
            scoreBoardAdd(two);
            scoreBoardAdd(three);
        }
        
        // Check if player four has a higher score
        if (winner.getPlayerScore() < four.getPlayerScore()) {
            winner = four;
            winner_second = null;
            winner_third = null;
            winner_fourth = null;
        } else if (winner.getPlayerScore() == four.getPlayerScore()) {
            // There is a tie between player one, player two, player three, and player four
            if (winner_second == null) {
                winner_second = four;
            } else if (winner_third == null) {
                winner_third = four;
            } else {
                winner_fourth = four;
            }
            scoreBoardAdd(one);
            scoreBoardAdd(two);
            scoreBoardAdd(three);
            scoreBoardAdd(four);
        }
        
        // Check if there is a tie between two or more players
        if (winner_second != null) {
            if (winner_third == null) {
                if (winner_fourth == null) {
                    // There is a tie between two players
                    scoreBoardAdd(winner);
                    scoreBoardAdd(winner_second);
                } else {
                    // There is a tie between three players
                    scoreBoardAdd(winner);
                    scoreBoardAdd(winner_second);
                    scoreBoardAdd(winner_third);
                }
            } else {
                // There is a tie between four players
                scoreBoardAdd(winner);
                scoreBoardAdd(winner_second);
                scoreBoardAdd(winner_third);
                scoreBoardAdd(winner_fourth);
            }
        } else {
            // There is a clear winner
            scoreBoardAdd(winner);
        }
        
    } 

}
