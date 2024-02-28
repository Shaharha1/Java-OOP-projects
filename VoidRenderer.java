/**
 * Create an empty renderer . this class is intended for use in Tic Tac Toe game
 * use to play without seeing the board
 * @author shahar hamiel
 */
class VoidRenderer implements Renderer{
    /**
     * create blank renderer
     * @param board game board to not display
     */
    public void renderBoard(Board board) {
        return;
    }
}
