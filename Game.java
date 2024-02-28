/**
 * Create a new game . this class is intended for use in Tic Tac Toe game
 * create a new board according to the given size for 2 players and run it according to the given win streak
 * @author shahar hamiel
 */
public class Game {
    private static final int DEFAULT_WIN_STREAK_SIZE=3;
    private Player playerX, playerO;
    private Renderer renderer;
    private int winStreak;
    private Board board;


    /**
     * create new default game
     * @param playerX player with X mark
     * @param playerO player with Y mark
     * @param renderer renderer type
     */
    public Game(Player playerX, Player playerO, Renderer renderer) {
        this.playerX = playerX;
        this.playerO = playerO;
        this.renderer = renderer;
        this.winStreak = DEFAULT_WIN_STREAK_SIZE;
        this.board = new Board();
    }

    /**
     * create new game with custom size board and custom win streak size
     * @param playerX player with X mark
     * @param playerO player with Y mark
     * @param size board size
     * @param winStreak length of win streak
     * @param renderer renderer type
     */
    public Game(Player playerX, Player playerO, int size, int winStreak, Renderer renderer) {
        if(winStreak < 2 || winStreak > size) {
            winStreak = size;
        }
        this.playerX = playerX;
        this.playerO = playerO;
        this.renderer = renderer;
        this.winStreak = winStreak;
        this.board = new Board(size);
    }

    /**
     * @return win streak size
     */
    public int getWinStreak() {
        return winStreak;
    }

    /**
     * @return board size
     */
    public int getBoardSize() {
        return board.getSize();
    }

    /**
     * run one game
     * @return the mark of the winner player, blank if draw
     */
    public Mark run() {
        //initialization
        Mark currentMark = Mark.BLANK;
        boolean isPlayerXTurn = true;
        //game
        do{
            //check which player play now
            if (isPlayerXTurn) {
                currentMark = Mark.X;
                playerX.playTurn(board,Mark.X);
            }
            else {
                currentMark = Mark.O;
                playerO.playTurn(board,Mark.O);
            }
            //end of turn
            renderer.renderBoard(board);
            if(checkWin(currentMark)) {
                return currentMark;
            }
            isPlayerXTurn = !isPlayerXTurn;
        }
        while (!isBoardFull()); //while the board is not full
        return Mark.BLANK;
    }

    /**
     * check if the given mark won the game
     * @param mark X or Y
     * @return true if won
     */
    private boolean checkWin(Mark mark){
        for(int row=0; row<board.getSize(); row++) {
            for(int col=0; col<board.getSize(); col++) {
                if(board.getMark(row,col) != mark) {
                    continue;
                }
                if(checkStreak(mark, row, col)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * check if there is a streak down / right / diagonal down-right
     * @param mark player mark
     * @param row row on board to start the check
     * @param col col on board to start the check
     * @return true if there is a streak of the mark
     */
    private boolean checkStreak(Mark mark, int row, int col) {
        //check right
        boolean check = true;
        for(int i=1; i<winStreak; i++) {
            if(board.getMark(row,col+i) != mark) {
                check = false;
            }
        }
        if(check) {
            return true;
        }
        //check down
        check = true;
        for(int i=1; i<winStreak; i++) {
            if(board.getMark(row+i,col) != mark) {
                check = false;
            }
        }
        if(check) {
            return true;
        }
        //check diagonal down-right
        check = true;
        for(int i=1; i<winStreak; i++) {
            if(board.getMark(row+i,col+i) != mark) {
                check = false;
            }
        }
        if(check) {
            return true;
        }
        return false;
    }

    /**
     * check if the board is full
     * @return true is the board full
     */
    private boolean isBoardFull() {
        int size = board.getSize();
        for(int row=0; row<size; row++) {
            for(int col=0; col<size; col++) {
                if(board.getMark(row,col) == Mark.BLANK) {
                    return false;
                }
            }
        }
        return true;
    }
}
