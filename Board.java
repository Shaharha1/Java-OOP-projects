/**
 * Create a new board. this class is intended for use in Tic Tac Toe game
 * each game starts with a blank board according to the given board size
 * @author shahar hamiel
 */
public class Board {
    private static final int DEFAULT_BOARD_SIZE=4;
    private Mark[][] board;
    private int boardSize;

    /**
     * create new default board
     */
    public Board() {
        createBoard(DEFAULT_BOARD_SIZE);
    }

    /**
     * create new custom board
     * @param size board size
     */
    public Board(int size) {
        createBoard(size);
    }

    /**
     * create new board with given size and initialize it to BLANK
     * @param size board size
     */
    private void createBoard(int size) {
        boardSize = size;
        board = new Mark[size][size];
        for(int row=0; row<size; row++) {
            for(int col=0; col<size; col++) {
                board[row][col] = Mark.BLANK;
            }
        }
    }

    /**
     * @return the board size
     */
    public int getSize() {
        return boardSize;
    }

    /**
     * put a new mark on the board
     * @param mark mark type to put on the board
     * @param row row on the board
     * @param col col on the board
     * @return true if was able to put a new mark
     */
    public boolean putMark(Mark mark, int row, int col) {
        if(!validInput(row, col)) {
            return false;
        }
        if(board[row][col] != Mark.BLANK) {
            return false;
        }
        board[row][col] = mark;
        return true;
    }

    /**
     * check if the cell is valid
     * @param row row on the board
     * @param col col on the board
     * @return true if the cell is in the board boundaries
     */
    private boolean validInput(int row, int col) {
        if(row < 0 || row >= boardSize || col <0 || col >= boardSize) {
            return false;
        }
        return  true;
    }

    /**
     * return the Mark on a given cell
     * @param row row on the board
     * @param col col on the board
     * @return the mark on the given cell on the board
     */
    public Mark getMark(int row, int col) {
        if (!validInput(row, col)) {
            return Mark.BLANK;
        }
        return board[row][col];
    }
}
