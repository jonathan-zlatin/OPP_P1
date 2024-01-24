public class Game {
    private Player playerX;
    private Player playerO;
    private Renderer renderer;
    private int size;
    private int winStreak;

    public Game(Player playerX, Player playerO, Renderer renderer) {
        /**
         * Constructs a new Game instance with the specified players and renderer.
         *
         * @param playerX   The player using the X mark.
         * @param playerO   The player using the O mark.
         * @param renderer  The renderer for displaying the game.
         */
        this.playerX = playerX;
        this.playerO = playerO;
        this.renderer = renderer;
        this.size = 4;
        this.winStreak = 3;
    }

    public Game(Player playerX, Player playerO, int size, int winStreak, Renderer renderer) {
        /**
         * Constructs a new Game instance with the specified players, size, win streak, and renderer.
         *
         * @param playerX    The player using the X mark.
         * @param playerO    The player using the O mark.
         * @param size       The size of the game board.
         * @param winStreak  The number of consecutive marks needed to win.
         * @param renderer   The renderer for displaying the game.
         */
        this.playerX = playerX;
        this.playerO = playerO;
        this.renderer = renderer;
        this.size = size;
        if (winStreak > size || winStreak < 2)
            this.winStreak = size;
        else
            this.winStreak = winStreak;
    }

    public int getBoardSize() {
        return this.size;
    }

    public int getWinStreak() {
        return winStreak;
    }

    private boolean isPlayerWin(Board board, Mark mark) {
        /**
         * Checks if the specified player represented by the given mark has won on the board.
         *
         * @param board The game board to check.
         * @param mark  The mark representing the player.
         * @return True if the player has won, false otherwise.
         */
        for (int i = 0; i < board.getSize() * board.getSize(); i++) {
            int row = i / board.getSize();
            int col = i % board.getSize();
            if (board.getMark(row, col).equals(mark)) {
                if (checkStreak(board, mark, row, col)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkStreak(Board board, Mark mark, int row, int col) {
        /**
         * Checks if the specified player represented by the given mark
         * has a winning streak on the board.
         *
         * @param board The game board to check.
         * @param mark  The mark representing the player.
         * @param row   The row coordinate to start checking from.
         * @param col   The column coordinate to start checking from.
         * @return True if the player has a winning streak, false otherwise.
         */
        int[][] directions = {{1, 0}, {1, 1}, {0, 1}, {-1, 1}};
        for (int[] direction : directions) {
            int dx = direction[1];
            int dy = direction[0];

            boolean streak = true;
            for (int i = 0; i < winStreak; i++) {
                if (!board.getMark(row + i * dy, col + i * dx).equals(mark))
                    streak = false;
            }
            if (streak) return true;
        }
        return false;
    }


    public Mark run() {
        /**
         * Runs the game and returns the mark of the winning player
         * or {Mark.BLANK} if it's a tie.
         *
         * @return The mark of the winning player or {Mark.BLANK} for a tie.
         */
        Board board = new Board(size);
        for (int moveNumber = 0; moveNumber < size * size; moveNumber++) {
            Player currentPlayer = (moveNumber % 2 == 0) ? playerX : playerO;
            Mark currentMark = (moveNumber % 2 == 0) ? Mark.X : Mark.O;

            currentPlayer.playTurn(board, currentMark);
            renderer.renderBoard(board);

            if (isPlayerWin(board, currentMark))
                return currentMark;
        }
        // The board is full, therefore no winner - Tie.
        return Mark.BLANK;
    }
}

