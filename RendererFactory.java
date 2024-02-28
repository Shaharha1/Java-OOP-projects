/**
 * Create a new renderer . this class is intended for use in Tic Tac Toe game
 * create a new renderer interface from given renderer type
 * @author shahar hamiel
 */
class RendererFactory {
    /**
     * create new renderer factory
     */
    public RendererFactory() {}

    /**
     * create a new renderer from the given type
     * @param type renderer type
     * @param size board size
     * @return renderer interface
     */
    public Renderer buildRenderer(String type, int size) {
        type = type.toLowerCase();
        Renderer renderer = null;
        switch (type) {
            case "none":
                renderer = new VoidRenderer();
                break;
            case "console":
                renderer = new ConsoleRenderer(size);
                break;
            default:
                System.out.println(Constants.UNKNOWN_RENDERER_NAME);
        }
        return renderer;
    }
}
