public class GameFavorite implements IFavorite {
    private final Game game;

    public GameFavorite(Game game) {
        this.game = game;
    }

    public Game getGame() {
        return game;
    }
}
