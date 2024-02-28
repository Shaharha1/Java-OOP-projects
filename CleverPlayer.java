import java.util.Random;
/**
 * Create a new clever player. this class is intended for use in Tic Tac Toe game
 * each turn the clever player decide where to put his mark on the board according to his strategy
 * @author shahar hamiel
 */
public class CleverPlayer implements Player{
    private Random random;
    private WhateverPlayer whateverPlayer;
    private GeniusPlayer geniusPlayer;
    /**
     * create new clever player
     */
    public CleverPlayer() {
        this.whateverPlayer = new WhateverPlayer();
        this.geniusPlayer = new GeniusPlayer();
        this.random = new Random();
    }

    /**
     * play turn for clever player
     * @param board game board
     * @param mark player mark
     */
    public void playTurn(Board board, Mark mark) {
        if (random.nextBoolean()) {
            whateverPlayer.playTurn(board, mark);
        } else {
            geniusPlayer.playTurn(board, mark);
        }
    }
}
