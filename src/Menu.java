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
            "Criar board",
            "Exibir board",
            "Adicionar personagem a um board",
            "Adicionar jogo a um board",
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
            }
        } while (answer != 5);
    }

    private void showCharacter() {
        Character character = DataSelector.selectCharacter();

        if (character == null) return;

        InputOutput.showCharacter(character);
    }

    private void createBoard() {
        // try catch temporário
        try {
            String name = InputOutput.returnString("Informe o nome do board: ");
            String description = InputOutput.returnString("Informe a descrição do board: ");
            user.addBoard(new Board(name, description));
        } catch (NullPointerException e) {
            InputOutput.showMessage("Operação cancelada.");
        }
    }

    private void showBoard() {
        Board board = DataSelector.selectBoard(user);

        if (board == null) return;

        InputOutput.showBoard(board);
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
}
