import java.util.List;

public class Board {
    private int size;
    private Mark cells[][];

    public Board() {
        /**
         * Initiate a clean board
         */
        this.size = 4;
        this.cells = new Mark[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.cells[i][j] = Mark.BLANK;
            }
        }
    }

    public Board(int size) {
        /**
         * @param size The size of the size * size board
         */
        this.size = size;
        this.cells = new Mark[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.cells[i][j] = Mark.BLANK;
            }
        }
    }

    public int getSize() {
        return this.size;
    }

    public boolean putMark(Mark mark, int row, int col) {
        /**
         * Places the specified mark at the given position if the cell is empty.
         *
         * @param mark The mark to be placed (X or O).
         * @param row  The row index.
         * @param col  The column index.
         * @return {true} if the mark is placed, {false} if the cell is not empty
         *         or the specified position is out of bounds.
         */
        if (row < 0 || col < 0 || row >= size || col >= size) {
            return false;
        }
        if (this.cells[row][col] != Mark.BLANK) {
            return false;
        }
        this.cells[row][col] = mark;
        return true;
    }

    public Mark getMark(int row, int col) {
        /**
         * Retrieves the mark at the specified position.
         *
         * @param row The row index.
         * @param col The column index.
         * @return The mark at the specified position, or
         *         {Mark.BLANK} if the position is out of bounds.
         */
        if (row >= size || col >= size || row < 0 || col < 0) {
            return Mark.BLANK;
        }
        return this.cells[row][col];
    }
}
