public class Tournament {
    /**
     * Represents a tournament in the game, organizing matches between two players.
     */
    private Player player1, player2;
    private Renderer renderer;
    private int rounds;

    // ############  CONSTANTS ############
    String PLAYER1WON = "Player 1, %s won: %d rounds";
    String PLAYER2WON = "Player 2, %s won: %d rounds";
    String TIES = "Ties: %d";

    public Tournament(int rounds, Renderer renderer, Player player1, Player player2) {
        /**
         * Initializes a tournament with the specified number of rounds, renderer, and players.
         *
         * @param rounds   The number of rounds in the tournament.
         * @param renderer The renderer to be used during the tournament.
         * @param player1  The first player participating in the tournament.
         * @param player2  The second player participating in the tournament.
         */
        this.player1 = player1;
        this.player2 = player2;
        this.renderer = renderer;
        this.rounds = rounds;
    }

    private void printGameStatus(int player1TotalWins, int player2TotalWins, int Ties,
                                 String playerName1, String playerName2) {
        /**
         * Prints the game status, including the total wins for both players and the number of ties.
         *
         * @param player1TotalWins Total wins for player 1.
         * @param player2TotalWins Total wins for player 2.
         * @param Ties Number of ties.
         * @param playerName1 Name of player 1.
         * @param playerName2 Name of player 2.
         */
        System.out.println(String.format(PLAYER1WON, playerName1, player1TotalWins));
        System.out.println(String.format(PLAYER2WON, playerName2, player2TotalWins));
        System.out.println(String.format(TIES, Ties));
    }

    void playTournament(int size, int winStreak, String playerName1, String playerName2) {
        /**
         * Simulates a tournament between two players for a specified number of rounds.
         *
         * @param size         The size of the game board.
         * @param winStreak    The number of consecutive marks required to win.
         * @param playerName1  The name of player 1.
         * @param playerName2  The name of player 2.
         */
        int player1TotalWins = 0; // Is X in EVEN rounds
        int player2TotalWins = 0; // Is X in ODD  rounds
        int Ties = 0;
        for (int roundNumber = 0; roundNumber < rounds; roundNumber++) {
            Game game = new Game(
                    roundNumber % 2 == 0 ? player1 : player2,
                    roundNumber % 2 == 0 ? player2 : player1,
                    size, winStreak, renderer);

            Mark roundWinner = game.run();

            // Add points depending on the round (odd/even)
            if (roundWinner.equals(Mark.X)) {
                player1TotalWins += (roundNumber % 2 == 0) ? 1 : 0; // X+even -> p1
                player2TotalWins += (roundNumber % 2 == 0) ? 0 : 1; // X+odd  -> p2
            } else if (roundWinner.equals(Mark.O)) {
                player1TotalWins += (roundNumber % 2 == 0) ? 0 : 1; // O+odd  -> p1
                player2TotalWins += (roundNumber % 2 == 0) ? 1 : 0; // O+even -> p2
            } else
                Ties ++;
        }

        printGameStatus(player1TotalWins, player2TotalWins, Ties, playerName1, playerName2);
    }

    public static void main(String[] args) {
        int rounds = Integer.parseInt(args[1]);
        int size = Integer.parseInt(args[2]);
        int winStreak = Integer.parseInt(args[3]);
        String rendererName = args[4].toLowerCase();
        String playerName1 = args[5].toLowerCase();
        String playerName2 = args[6].toLowerCase();

        // Initial Factories, renderer and players

        RendererFactory rendererFactory = new RendererFactory();
        PlayerFactory playerFactory = new PlayerFactory();
        Renderer renderer = rendererFactory.buildRenderer(rendererName, size);
        if (renderer == null)
            return;
        Player player1 = playerFactory.buildPlayer(playerName1);
        if (player1 == null)
            return;
        Player player2 = playerFactory.buildPlayer(playerName2);
        if (player2 == null)
            return;

        //Start Tournament
        Tournament tournament = new Tournament(rounds, renderer, player1, player2);
        tournament.playTournament(size, winStreak, playerName1, playerName2);
    }
}
