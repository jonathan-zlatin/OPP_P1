public class GeniusPlayer implements Player {
    /**
     * The {@code GeniusPlayer} class represents a Tic-Tac-Toe player
     * with a genius-level strategy. It implements the {@code Player} interface.
     */
    GeniusPlayer() {
    }


    public void playTurn(Board board, Mark mark) {
        /**
         * Plays a turn on the provided board using a strategic
         * approach to block the opponent and fill a column downward.
         *
         * If no blocking move is available, it places the mark in an empty cell.
         *
         * @param board The current game board.
         * @param mark  The mark (X or O) representing the player.
         */

        // First loop: Block the clever one, and fill a column downward
        for (int j = 1; j < board.getSize(); j++) {
            for (int i = 0; i < board.getSize(); i++) {
                if (board.putMark(mark, i, j))
                    return;
            }
        }
        // Third loop: Try to place the mark in an empty cell
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                if (board.putMark(mark, i, j))
                    return;
            }
        }
    }
}

