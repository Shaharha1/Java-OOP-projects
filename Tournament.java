
/**
 * Create a new tournament. this class is intended for use in Tic Tac Toe game
 * create a new tournament according to the given input and run the tournament
 * @author shahar hamiel
 */
public class Tournament {

    private static final String WIN_STREAK_ERROR="win streak can't be bigger the board size";
    private static final String ROUNDS_ERROR="rounds must be int positive numbeer";
    private Player player1;
    private Player player2;
    private Renderer renderer;
    private int rounds;
    private int player1WinCount;
    private int player2WinCount;
    private int drawCount;

    /**
     * create new Tournament object
     * @param rounds number of rounds
     * @param renderer type of renderer
     * @param player1 first player
     * @param player2 second player
     */
    public Tournament(int rounds, Renderer renderer, Player player1, Player player2) {
        this.rounds = rounds;
        this.renderer = renderer;
        this.player1 = player1;
        this.player2 = player2;
        this.player1WinCount = 0;
        this.player2WinCount = 0;
        this.drawCount = 0;
    }

    /**
     * initialize the tournament
     * @param size board size
     * @param winStreak win streak size
     * @param playerName1 type of player 1
     * @param playerName2 type of player 2
     */
    public void playTournament(int size, int winStreak, String playerName1, String playerName2) {
        Player playerX, playerO;
        for(int i=0; i<rounds; i++) {
            Game game;
            // choose which player will play X
            if(i%2 == 0) {
                playerX = player1;
                playerO = player2;
            }
            else {
                playerX = player2;
                playerO = player1;
            }
            //play one game
            game = new Game(playerX, playerO, size, winStreak, renderer);
            Mark winnerMark = game.run();
            if(i%2 == 0) {
                if(winnerMark == Mark.X) {
                    player1WinCount++;
                } else if (winnerMark == Mark.O) {
                    player2WinCount++;
                } else {
                    drawCount++;
                }
            }
            else {
                if(winnerMark == Mark.X) {
                    player2WinCount++;
                } else if (winnerMark == Mark.O) {
                    player1WinCount++;
                } else {
                    drawCount++;
                }
            }
            //print results
            System.out.println("######### Results #########");
            System.out.println(String.format("Player 1, %s wom: %d rounds",playerName1, player1WinCount));
            System.out.println(String.format("Player 2, %s wom: %d rounds", playerName2, player2WinCount));
            System.out.println(String.format("Ties: %d",drawCount));
        }
    }

    /**
     * initialize the program. gets the input from the user and start the tournament
     * @param args user input
     */
    public static void main(String[] args) {
        int rounds = Integer.parseInt(args[0]);
        int boardSize = Integer.parseInt(args[1]);
        int winStreak = Integer.parseInt(args[2]);;
        String rendererType = args[3];
        String playerName1 = args[4];
        String playerName2 = args[5];
        //check input
        if(winStreak > boardSize) {
            System.out.println(WIN_STREAK_ERROR);
            return;
        }
        PlayerFactory playerFactory = new PlayerFactory();
        Player player1 = playerFactory.buildPlayer(playerName1);
        Player player2 = playerFactory.buildPlayer(playerName2);
        if(player1 == null || player2 == null) {
            return;
        }
        RendererFactory rendererFactory = new RendererFactory();
        Renderer renderer = rendererFactory.buildRenderer(rendererType, boardSize);
        if(renderer == null) {
            return;
        }
        //play tournament
        Tournament tournament = new Tournament(rounds,renderer,player1,player2);
        tournament.playTournament(boardSize, winStreak, playerName1, playerName2);
    }
}
