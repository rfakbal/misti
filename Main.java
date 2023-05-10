import java.util.ArrayList;
import java.util.Scanner;

public class Main { 
    public static void main(String[] args) {
        int numPlayers = 0;
        String pointFileName = "";
        ArrayList<String> playerNames = new ArrayList<String>();
        ArrayList<String> playerExpertiseLevels = new ArrayList<String>();
        boolean verbose = false;

        try {
            for (int i = 0; i < args.length; i++) {
                //Players information 
                if (args[i].equals("-n")) {
                    numPlayers = Integer.parseInt(args[++i]);
                } else if (args[i].equals("-p")) {
                    pointFileName = args[++i];
                } else if (args[i].equals("-v")) {
                    verbose = true;
                } else if (args[i].startsWith("-e")) {
                    playerExpertiseLevels.add(args[i].substring(2));
                    playerNames.add(args[++i]);
                } else {
                    throw new IllegalArgumentException("Invalid value " + args[i]);
                }
            }
        } catch (Exception e) {
            System.err.println("Has Problem : " + e.getMessage());
            System.exit(1);
        }
        Scanner scan = new Scanner(System.in);
        System.out.println("How Many Players 2 or 4 Choose");
        numPlayers = scan.nextInt();
        Game game;
        if (numPlayers == 2) {
            System.out.println("Which bot do you want to play with?\n1-Novice\n2-Regular\n3-Expert");
            int botChoice = scan.nextInt();
            String choosenBot;
            if (botChoice == 1) {
                choosenBot = "novice";
            } else if (botChoice == 2) {
                choosenBot = "regular";
            } else {
                choosenBot = "expert";
            }
            game = new TwoPlayer();
        } else {
            game = new FourPlayer();
        }
        game.startRound();
    }
    
}


