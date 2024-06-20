import Exceptions.CharacterAlreadyFavoriteException;

import javax.swing.*;

import static javax.swing.JOptionPane.*;

public class Menu {
    private final User user;

    Menu(User user) {
        this.user = user;
    }

    public void showMenu() {
        int answer;

        // TODO:
        //      exibir jogo
        //      favoritar jogo
        //      remover jogo favorito
        //      relatório de jogos favoritos

        JComboBox<String> options = new JComboBox<>(new String[] {
            "Exibir personagem",
            "Criar board",
            "Exibir board",
            "Adicionar personagem a um board",
            "Adicionar jogo a um board",
            "Remover board",
            "Favoritar personagem",
            "Remover personagem favorito",
            "Exibir personagens favoritos",
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
                    createBoard();
                    break;
                case 2:
                    showBoard();
                    break;
                case 3:
                    addCharacterToBoard();
                    break;
                case 4:
                    addGameToBoard();
                    break;
                case 5:
                    deleteBoard();
                    break;
                case 6:
                    addCharacterFavorite();
                    break;
                case 7:
                    removeCharacterFavorite();
                    break;
                case 8:
                    showFavoriteCharacters();
                    break;
            }
        } while (answer != 9);
    }

    private void showCharacter() {
        Character character = DataSelector.selectCharacter();

        if (character == null) return;

        InputOutput.showCharacter(character);
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
}
