/**
 * Create a new human player. this class is intended for use in Tic Tac Toe game
 * each turn the human player decide where to put his mark on the board according to the user input
 * @author shahar hamiel
 */
public class HumanPlayer implements Player{
    private static final int SPLIT_INPUT=10;

    /**
     * create new human player
     */
    public HumanPlayer() {}

    /**
     * play a turn of the human player
     * @param board the game board
     * @param mark player mark
     */
    public void playTurn(Board board, Mark mark) {
        int row = -1;
        int col = -1;
        boolean canPutMark;
        while (true) {
            System.out.println(Constants.playerRequestInputString(mark.name()));
            int userInput = KeyboardInput.readInt();
            row = userInput / SPLIT_INPUT;
            col = userInput % SPLIT_INPUT;
            if(!validInput(board, row, col)) {
                continue;
            }
            canPutMark = board.putMark(mark, row, col);
            if(canPutMark) {
                break;
            }
            else {
                System.out.println(Constants.OCCUPIED_COORDINATE);
            }
        }
    }

    /**
     * check if the cell is valid
     * @param board game board
     * @param row row on the board
     * @param col col on the board
     * @return true if the cell is in the board boundaries
     */
    private boolean validInput(Board board, int row, int col) {
        if(row < 0 || row >= board.getSize() || col <0 || col >= board.getSize()) {
            System.out.println(Constants.INVALID_COORDINATE);
            return false;
        }
        return  true;
    }
}
