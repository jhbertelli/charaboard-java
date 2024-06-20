import Exceptions.CharacterAlreadyFavoriteException;
import Exceptions.GameAlreadyFavoriteException;

import java.util.ArrayList;

public class User {
    private String username;
    private String nickname;
    private String email;
    private String password;
    private final ArrayList<Board> boards = new ArrayList<>();
    private final ArrayList<CharacterFavorite> favoriteCharacters = new ArrayList<>();
    private final ArrayList<GameFavorite> favoriteGames = new ArrayList<>();

    public User(String username, String nickname, String email, String password) {
        this.username = username;
        this.nickname = nickname;
        this.email = email;
        this.password = password;
    }

    public void addBoard(Board board) {
        boards.add(board);
    }

    public void deleteBoard(Board board) {
        boards.remove(board);
    }

    public ArrayList<Board> getBoards() {
        return boards;
    }

    public ArrayList<CharacterFavorite> getFavoriteCharacters() {
        return favoriteCharacters;
    }

    public ArrayList<GameFavorite> getFavoriteGames() {
        return favoriteGames;
    }

    public void addFavoriteCharacter(Character character) throws CharacterAlreadyFavoriteException {
        if (findFavoriteCharacter(character) != null) throw new CharacterAlreadyFavoriteException();

        CharacterFavorite favorite = new CharacterFavorite(character);

        favoriteCharacters.add(favorite);
        character.addFavorite(favorite);
    }

    public void addFavoriteGame(Game game) throws GameAlreadyFavoriteException {
        if (findFavoriteGame(game) != null) throw new GameAlreadyFavoriteException();

        GameFavorite favorite = new GameFavorite(game);

        favoriteGames.add(favorite);
        game.addFavorite(favorite);
    }

    public void removeFavoriteCharacter(Character character) {
        CharacterFavorite favorite = findFavoriteCharacter(character);

        favoriteCharacters.remove(favorite);
        character.removeFavorite(favorite);
    }

    public void removeFavoriteGame(Game game) {
        GameFavorite favorite = findFavoriteGame(game);

        favoriteGames.remove(favorite);
        game.removeFavorite(favorite);
    }

    public CharacterFavorite findFavoriteCharacter(Character character) {
        return favoriteCharacters
            .stream()
            .filter(x -> x.getCharacter() == character)
            .findFirst()
            .orElse(null);
    }

    public GameFavorite findFavoriteGame(Game game) {
        return favoriteGames
            .stream()
            .filter(x -> x.getGame() == game)
            .findFirst()
            .orElse(null);
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
