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
            }
        } while (answer != 4);
    }

    private void showCharacter() {
        Character character = DataSelector.selectCharacter();

        if (character == null) return;

        InputOutput.showCharacter(character);
    }

    private void createBoard() {
        try {
            user.createBoard(
                InputOutput.returnString("Informe o nome do board: "),
                InputOutput.returnString("Informe a descrição do board: ")
            );
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

        InputOutput.showBoard(board);
    }
}
