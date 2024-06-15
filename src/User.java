import java.util.ArrayList;

public class User {
    private String username;
    private String nickname;
    private String email;
    private String password;
    private ArrayList<Board> boards = new ArrayList<>();
    private ArrayList<CharacterFavorite> favoriteCharacters = new ArrayList<>();
    private ArrayList<GameFavorite> favoriteGames = new ArrayList<>();

    public User(String username, String nickname, String email, String password) {
        this.username = username;
        this.nickname = nickname;
        this.email = email;
        this.password = password;
    }

    public void createBoard(String name, String description) {
        boards.add(new Board(name, description));
    }

    public void deleteBoard(Board board) {
        boards.remove(board);
    }

    public void addFavoriteCharacter(Character character) {
        // TODO: verificar se o personagem já é favorito do usuário e se for, lançar uma exceção
        CharacterFavorite favorite = new CharacterFavorite(character);

        favoriteCharacters.add(favorite);
        character.addFavorite(favorite);
    }

    public void addFavoriteGame(Game game) {
        // TODO: verificar se o jogo já é favorito do usuário e se for, lançar uma exceção
        GameFavorite favorite = new GameFavorite(game);

        favoriteGames.add(favorite);
        game.addFavorite(favorite);
    }

    public void removeFavoriteCharacter(Character character) {
        CharacterFavorite favorite = favoriteCharacters
            .stream()
            .filter(x -> x.getCharacter() == character)
            .findFirst()
            .orElse(null);

        favoriteCharacters.remove(favorite);
        character.removeFavorite(favorite);
    }

    public void removeFavoriteGame(Game game) {
        GameFavorite favorite = favoriteGames
            .stream()
            .filter(x -> x.getGame() == game)
            .findFirst()
            .orElse(null);

        favoriteGames.remove(favorite);
        game.removeFavorite(favorite);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
