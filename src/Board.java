import Exceptions.GameAlreadyOnBoardException;

import java.util.ArrayList;

public class Board {
    private String name;
    private String description;
    private final ArrayList<Character> characters = new ArrayList<>();
    private final ArrayList<Game> games = new ArrayList<>();

    public Board(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void addCharacter(Character character) {
        characters.add(character);
    }

    public void addGame(Game game) throws GameAlreadyOnBoardException {
        if(findGameOnBoard(game) != null) throw new GameAlreadyOnBoardException();

        games.add(game);
    }

    public void removeCharacter(Character character) {
        characters.remove(character);
    }

    public void removeGame(Game game) {
        games.remove(game);
    }

    public Game findGameOnBoard(Game game) {
        return games
                .stream()
                .filter(x -> x == game)
                .findFirst()
                .orElse(null);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Character> getCharacters() {
        return characters;
    }

    public ArrayList<Game> getGames() {
        return games;
    }
}
