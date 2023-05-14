public class Main {
    public static void main(String[] args) {
        
        String playerName_1 = "";
        String playerName_2 = "";
        String playerName_3 = "";
        String playerName_4 = "";

        String playerExpertise_1 = "";
        String playerExpertise_2 = "";
        String playerExpertise_3 = "";
        String playerExpertise_4 = "";

        int numPlayers = 0;
        String pointFileName = "";
        boolean verbose = false;
        int numRounds = 1;

        try {
            // number of players
            numPlayers = Integer.parseInt(args[0]);
            if (numPlayers != 2 && numPlayers != 4) {
                throw new IllegalArgumentException("Player number must be 2 or 4 ");
            }
            
            // point file name
            pointFileName = args[1];

            if(numPlayers== 2 && (args.length > 8) ){
                throw new IllegalArgumentException("Too many arguments for 2 players. ");
            }

            if(numPlayers== 4 && (args.length > 12) ){
                throw new IllegalArgumentException("Too many arguments for 4 players. ");
            }

            if(numPlayers == 2 && !(args[7].toLowerCase().equals("true")||args[7].toLowerCase().equals("false"))){
                throw new IllegalArgumentException(" ");
            }

            if(numPlayers == 4 && !(args[11].toLowerCase().equals("true")||args[11].toLowerCase().equals("false"))){
                throw new IllegalArgumentException(" ");
            }

            if(numPlayers==2 ){
                playerName_1 = args[2];
                playerExpertise_1 = args[3].toUpperCase();
                playerName_2 = args[4];
                playerExpertise_2 = args[5].toUpperCase();
                numRounds = Integer.valueOf(args[6]);
                verbose = args[7].toLowerCase().equals("true");
            }

            else{
                playerName_1 = args[2];
                playerExpertise_1 = args[3].toUpperCase();
                playerName_2 = args[4];
                playerExpertise_2 = args[5].toUpperCase();
                playerName_3 = args[6];
                playerExpertise_3 = args[7].toUpperCase();
                playerName_4 = args[8];
                playerExpertise_4 = args[9].toUpperCase();
                numRounds = Integer.valueOf(args[10]);
                verbose = args[11].toLowerCase().equals("true");
            }

            int humancount = 0;
            if (playerExpertise_1.equals("H")) {
                humancount++;
            }
            if (playerExpertise_2.equals("H")) {
                humancount++;
            }
            if (playerExpertise_3.equals("H")) {
                humancount++;
            }
            if (playerExpertise_4.equals("H")) {
                humancount++;
            }

            if(humancount > 1) {
                throw new IllegalArgumentException("Maximum one human player is allowed.");
            }


        } catch (Exception e) {
            System.out.println("Try again with valid arguments (EX: <PlayerCount> <PointFilePath> <Name> <Type> (For each player) <RoundCount> <VerboseModeBoolean>)");
            System.out.println("Available Player Counts: 2, 4 | Available Player Types: H(Human), N(Novice), R(Regular), E(Expert) | Verbose Modes: true, false");
            System.exit(1);

        }
        System.out.println(numRounds);
        for (int i = 0 ; i < numRounds ; i++) {
            System.out.println("Round " + (i+1) + ":");
            Game misti = null;
            switch (numPlayers) {
                case 2:
                misti = new TwoPlayer( pointFileName , playerName_1 , playerExpertise_1 , playerName_2 , playerExpertise_2 , verbose);
                for (int k = 0 ; k < 6 ; k++) {
                    misti.startTurn();
                }
                break;
            
                case 4:
                misti = new FourPlayer( pointFileName , playerName_1 , playerExpertise_1 , playerName_2 , playerExpertise_2 , playerName_3 , playerExpertise_3 , playerName_4 , playerExpertise_4 ,verbose);
                for (int k = 0 ; k < 3 ; k++) {
                    misti.startTurn();
                }
                break;
            }
            misti.giveRemainingCards();
            misti.printFinalScores();
            misti.drawScoreBoard();
        }
    }

}