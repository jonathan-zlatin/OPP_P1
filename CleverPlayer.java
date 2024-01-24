public class CleverPlayer implements Player {
    /**
     * The {@code CleverPlayer} class implements the {@code Player} interface,
     * representing a player with a "try to fill a row" strategy.
     * Instances of this class play turns on the game board by trying to fill
     * the board in the first available cell.
     *
     */

    CleverPlayer() {
    }

    public void playTurn(Board board, Mark mark) {
        /**
         * Plays a turn for the Clever player on the board.
         * The method is: try to fill row after another with the current mark.
         * That way, if no one blocks you, you will fill a row one day.
         * @param board The game board.
         * @param mark  The player's mark (X or O).
         */
        for (int i = 0; i < board.getSize() * board.getSize(); i++) {
            int row = i / board.getSize();
            int col = i % board.getSize();

            if (board.putMark(mark, row, col)) {
                break;
            }
        }
    }
}