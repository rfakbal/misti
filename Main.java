import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        
        String playerName_1;
        String playerName_2;
        String playerName_3;
        String playerName_4;

        String playerExpertise_1;
        String playerExpertise_2;
        String playerExpertise_3;
        String playerExpertise_4;

        int numPlayers = 0;
        String pointFileName;
        boolean verbose = false;

        try {
            // number of players
            numPlayers = Integer.parseInt(args[0]);
            if (numPlayers != 2 && numPlayers != 4) {
                throw new IllegalArgumentException("Player number must be 2 or 4 ");
            }
            
            // point file name
            pointFileName = args[1];

            if(numPlayers== 2 && (args.length > 7) ){
                throw new IllegalArgumentException("Too many arguments, program only used first 6 arguments ");
            }

            if(numPlayers== 4 && (args.length > 11) ){
                throw new IllegalArgumentException("Too many arguments, program only used first 10 arguments ");
            }

            if(numPlayers==2 ){
                playerName_1 = args[2];
                playerExpertise_1 = args[3];
                playerName_2 = args[4];
                playerExpertise_2 = args[5];
                verbose = args[6].equals("true");
            }

            else{
                playerName_1 = args[2];
                playerExpertise_1 = args[3];
                playerName_2 = args[4];
                playerExpertise_2 = args[5];
                playerName_3 = args[6];
                playerExpertise_3 = args[7];
                playerName_4 = args[8];
                playerExpertise_4 = args[9];
                verbose = args[10].equals("true");
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            System.out.println("Try again with valid arguments");
            System.exit(1);

        }
        System.out.println("SA");
    }

}