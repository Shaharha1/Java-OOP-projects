/**
 * Create a new player . this class is intended for use in Tic Tac Toe game
 * create a new player interface from given player type
 * @author shahar hamiel
 */
public class PlayerFactory {
    /**
     * create new player factory
     */
    public PlayerFactory() {}

    /**
     * create a new player from the given type
     * @param type player type
     * @return player interface
     */
    public Player buildPlayer(String type) {
        type = type.toLowerCase();
        Player player = null;
        switch (type) {
            case "human":
                player = new HumanPlayer();
                break;
            case "clever":
                player = new CleverPlayer();
                break;
            case "whatever":
                player = new WhateverPlayer();
                break;
            case "genius":
                player = new GeniusPlayer();
                break;
            default:
                System.out.println(Constants.UNKNOWN_PLAYER_NAME);
        }
        return player;
    }
}
