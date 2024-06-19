import java.util.Arrays;

public class FakeBoards {
    private final Board[] fakeBoards;
    private final Board boardOne;
    private final Board boardTwo;

    FakeBoards() {
        boardOne = new Board("RPG Maker", "Personagens e jogos feitos em game engines derivadas de RPG Maker.");

        boardOne.addGame(FakeGames.game2);

        boardTwo = new Board("Apocalipse Zumbi", "Personagens e jogos com o tema apocalipse zumbi.");

        boardTwo.addCharacter(FakeCharacters.character1);
        boardTwo.addCharacter(FakeCharacters.character2);
        boardTwo.addGame(FakeGames.game1);

        fakeBoards = Arrays.stream(new Board[] {
                boardOne,
                boardTwo
            })
            .sorted((a, b) -> a.getName().compareToIgnoreCase(b.getName()))
            .toArray(Board[]::new);
    }

    public Board[] getFakeBoards() {
        return fakeBoards;
    }

    public Board getBoardOne() {
        return boardOne;
    }

    public Board getBoardTwo() {
        return boardTwo;
    }
}
