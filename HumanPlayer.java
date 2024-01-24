import java.util.*;

public class HumanPlayer implements Player {
    /**
     * The {@code HumanPlayer} class represents a Tic-Tac-Toe player
     * being played by the user. It implements the {@code Player} interface.
     *
     */

    // ############  CONSTANTS ############
    int MAXINPUT = 99;
    int MININPUT = 0;
    public HumanPlayer() {
    }

    private Boolean tryToPutMark(int input, Board board, Mark mark) {
        /**
         * Tries to place the player's mark on the board based on the provided input.
         * Checks if the input is within valid coordinate ranges, and if the specified
         * cell is unoccupied.
         *
         * @param input The user-provided input representing the desired cell on the board.
         * @param board The current game board.
         * @param mark  The mark (X or O) representing the player.
         * @return {True} if the mark is successfully placed on the board, {false} otherwise.
         */
        if (input > MAXINPUT || input < MININPUT) {
            System.out.println(Constants.INVALID_COORDINATE);
            return false;
        }
        int row = input / 10;
        int col = input % 10;
        if (row >= board.getSize() || col >= board.getSize()) {
            System.out.println(Constants.INVALID_COORDINATE);
            return false;
        } else if (!board.putMark(mark, row, col)) {
            System.out.println(Constants.OCCUPIED_COORDINATE);
            return false;
        }
        return true;
    }

    public void playTurn(Board board, Mark mark) {
        /**
         * Plays a turn for the HumanPlayer by requesting input, validating it,
         * and placing the mark on the board.
         *
         * @param board The current game board.
         * @param mark  The mark (X or O) representing the player.
         */
        System.out.println(Constants.playerRequestInputString(mark.toString()));
        int input = KeyboardInput.readInt();
        while (!tryToPutMark(input, board, mark)) {
            input = KeyboardInput.readInt();
        }
    }
}

