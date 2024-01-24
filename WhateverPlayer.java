import java.util.Random;

public class WhateverPlayer implements Player {
    /**
     * The WhateverPlayer class implements the Player interface,
     * representing a player with a flexible or unspecified strategy.
     * Instances of this class play turns on the game board without a specific,
     * defined strategy.
     */
    public WhateverPlayer() {
    }

    public void playTurn(Board board, Mark mark) {
        /**
         * The WhateverPlayer's playTurn method executes turns without a specific, defined strategy.
         * He's just choosing any turn a randomize cell.
         *
         * @param board The game board on which the player makes a turn.
         * @param mark  The mark (X or O) representing the player.
         */
        Random random = new Random();
        int row = random.nextInt(board.getSize());
        int col = random.nextInt(board.getSize());
        while (!board.putMark(mark, row, col)) { // until you find an available cell
            row = random.nextInt(board.getSize());
            col = random.nextInt(board.getSize());
        }
    }
}
