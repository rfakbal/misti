import java.util.ArrayList;

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
        Game game = new Game();
    }
    
