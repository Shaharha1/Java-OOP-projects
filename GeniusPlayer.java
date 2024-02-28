/**
 * Create a new genius player. this class is intended for use in Tic Tac Toe game
 * each turn the genius player decide where to put his mark on the board according to his strategy
 * @author shahar hamiel
 */
public class GeniusPlayer implements Player{

    /**
     * create new genius player
     */
    public GeniusPlayer() {}

    /**
     * play turn for genius player
     * @param board game board
     * @param mark player mark
     */
    public void playTurn(Board board, Mark mark) {
        for(int row=0; row< board.getSize(); row++) {
            for(int col=0; col< board.getSize(); col++) {
                if(board.getMark(row,col) == mark) {
                    if(putMarkOnValidCell(board, row, col, mark)) {
                        return;
                    }
                }
            }
        }
        if(board.getMark(0,0) == Mark.BLANK) {
            board.putMark(mark, 0, 0);
        } else {
            board.putMark(mark, 1, 0);
        }
    }

    /**
     * search for empty cell near marked cell
     * @param board game board
     * @param row row of marked cell
     * @param col col of marked cell
     * @param mark player mark
     * @return true if was able to put a mark near marked cell
     */
    private boolean putMarkOnValidCell(Board board, int row, int col, Mark mark) {
        for(int i=-1; i<2; i++) {
            for(int j=-1; j<2; j++) {
                //check board size
                if(i < 0 || j < 0 || i >= board.getSize() || j >= board.getSize()) {
                    continue;
                }
                if(board.getMark(row+i, col+j) == Mark.BLANK) {
                    board.putMark(mark, row+i, col+j);
                    return true;
                }
            }
        }
        return false;
    }
}
