import Exceptions.CharacterAlreadyFavoriteException;
import Exceptions.GameAlreadyFavoriteException;

import javax.swing.*;

import static javax.swing.JOptionPane.*;

public class Menu {
    private final User user;

    Menu(User user) {
        this.user = user;
    }

    public void showMenu() {
        int answer;

        JComboBox<String> options = new JComboBox<>(new String[] {
            "Exibir personagem",
            "Exibir jogo",
            "Exibir board",
            "Criar board",
            "Adicionar personagem a um board",
            "Adicionar jogo a um board",
            "Remover personagem de um board",
            "Remover jogo de um board",
            "Remover board",
            "Exibir personagens favoritos",
            "Exibir jogos favoritos",
            "Favoritar personagem",
            "Favoritar jogo",
            "Remover personagem favorito",
            "Remover jogo favorito",
            "Sair"
        });

        do {
            showMessageDialog(null, options, "Opções", INFORMATION_MESSAGE, null);
            answer = options.getSelectedIndex();

            switch (answer) {
                case 0:
                    showCharacter();
                    break;
                case 1:
                    showGame();
                    break;
                case 2:
                    showBoard();
                    break;
                case 3:
                    createBoard();
                    break;
                case 4:
                    addCharacterToBoard();
                    break;
                case 5:
                    addGameToBoard();
                    break;
                case 6:
                    removeBoardCharacter();
                    break;
                case 7:
                    removeBoardGame();
                    break;
                case 8:
                    deleteBoard();
                    break;
                case 9:
                    showFavoriteCharacters();
                    break;
                case 10:
                    showFavoriteGames();
                    break;
                case 11:
                    addCharacterFavorite();
                    break;
                case 12:
                    addGameFavorite();
                    break;
                case 13:
                    removeCharacterFavorite();
                    break;
                case 14:
                    removeGameFavorite();
                    break;
            }
        } while (answer != 15);
    }

    private void showCharacter() {
        Character character = DataSelector.selectCharacter();

        if (character == null) return;

        InputOutput.showCharacter(character);
    }

    private void showGame() {
        Game game = DataSelector.selectGame();

        if (game == null) return;

        InputOutput.showGame(game);
    }

    private void createBoard() {
        String name = InputOutput.returnString("Informe o nome do board: ");

        if (name == null) {
            InputOutput.showMessage("Operação cancelada.");
            return;
        }

        String description = InputOutput.returnString("Informe a descrição do board: ");

        if (description == null) {
            InputOutput.showMessage("Operação cancelada.");
            return;
        }

        user.addBoard(new Board(name, description));
    }

    private void showBoard() {
        Board board = DataSelector.selectBoard(user);

        if (board == null) return;

        InputOutput.showBoard(board);
    }

    private void deleteBoard() {
        Board board = DataSelector.selectBoard(user);

        if (board == null) return;

        user.deleteBoard(board);
    }

    private void addCharacterToBoard() {
        Board board = DataSelector.selectBoard(user);

        if (board == null) return;

        Character character = DataSelector.selectCharacter();

        if (character == null) return;

        board.addCharacter(character);
    }

    private void addGameToBoard() {
        Board board = DataSelector.selectBoard(user);

        if (board == null) return;

        Game game = DataSelector.selectGame();

        if (game == null) return;

        board.addGame(game);
    }

    private void addCharacterFavorite() {
        Character character = DataSelector.selectCharacter();

        if (character == null) return;

        try {
            user.addFavoriteCharacter(character);
        } catch (CharacterAlreadyFavoriteException e) {
            InputOutput.showMessage("Você já favoritou este personagem.");
        }
    }

    private void removeCharacterFavorite() {
        Character character = DataSelector.selectFavoriteCharacter(user);

        if (character == null) return;

        user.removeFavoriteCharacter(character);
    }

    private void showFavoriteCharacters() {
        if (user.getFavoriteCharacters().isEmpty()) {
            InputOutput.showMessage("Você não possui personagens favoritos.");
            return;
        }

        InputOutput.showFavoriteCharacters(user);
    }

    private void addGameFavorite() {
        Game game = DataSelector.selectGame();

        if(game == null) return;

        try {
            user.addFavoriteGame(game);
        } catch (GameAlreadyFavoriteException e) {
            InputOutput.showMessage("Você já favoritou este jogo.");
        }
    }

    private void removeGameFavorite() {
        Game game = DataSelector.selectFavoriteGame(user);

        if (game == null) return;

        user.removeFavoriteGame(game);
    }

    private void showFavoriteGames() {
        if (user.getFavoriteGames().isEmpty()){
            InputOutput.showMessage("Você não possui jogos favoritos.");
            return;
        }

        InputOutput.showFavoriteGames(user);
    }

    private void removeBoardCharacter() {
        Board board = DataSelector.selectBoard(user);

        if (board == null) return;

        Character character = DataSelector.selectBoardCharacter(board);

        if (character == null) return;

        board.removeCharacter(character);
    }

    private void removeBoardGame() {
        Board board = DataSelector.selectBoard(user);

        if (board == null) return;

        Game game = DataSelector.selectBoardGame(board);

        if (game == null) return;

        board.removeGame(game);
    }
}

