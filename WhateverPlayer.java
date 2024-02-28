import java.util.Random;

/**
 * Create a new whatever player. this class is intended for use in Tic Tac Toe game
 * each turn the whatever player decide where to put his mark on the board by random
 * @author shahar hamiel
 */
public class WhateverPlayer implements Player{

    private Random random = new Random();
    /**
     * create new whatever player
     */
    public WhateverPlayer() {}

    /**
     * play a random turn for the whatever player
     * @param board the game board
     * @param mark player mark
     */
    public void playTurn(Board board, Mark mark) {
        int row = -1;
        int col = -1;
        do {
            row = random.nextInt(board.getSize());
            col = random.nextInt(board.getSize());
        }
        while (!board.putMark(mark,row,col));
    }
}
