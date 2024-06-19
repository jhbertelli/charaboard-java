import javax.swing.*;

import java.awt.*;
import java.util.Arrays;

import static javax.swing.JOptionPane.*;

public class Menu {
    private final Character[] characters = FakeCharacters.getFakeCharacters();
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
                    showCharacters();
                    break;
                case 1:
                    createBoard();
                    break;
                case 2:
                    showBoards();
                    break;
            }
        } while (answer != 3);
    }

    private void showCharacters() {
        JPanel panel = new JPanel(new GridLayout(1, 2));

        panel.add(new JLabel("Informe o personagem:"));

        JComboBox<String> options = new JComboBox<>(
            Arrays.stream(characters).map(Character::getName).toArray(String[]::new)
        );

        panel.add(options);

        int result = JOptionPane.showConfirmDialog(null, panel, "Cadastro", JOptionPane.OK_CANCEL_OPTION);

        if (result != JOptionPane.OK_OPTION) {
            InputOutput.showMessage("Operação cancelada.");
            return;
        }

        int selectedIndex = options.getSelectedIndex();

        InputOutput.showCharacter(characters[selectedIndex]);
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

    private void showBoards() {
        if (user.getBoards().isEmpty()) {
            InputOutput.showMessage("Você não possui boards no momento.");
            return;
        }

        JPanel panel = new JPanel(new GridLayout(1, 2));

        panel.add(new JLabel("Informe o board:"));

        JComboBox<String> options = new JComboBox<>(
            user.getBoards().stream().map(Board::getName).toArray(String[]::new)
        );

        panel.add(options);

        int result = JOptionPane.showConfirmDialog(null, panel, "Cadastro", JOptionPane.OK_CANCEL_OPTION);

        if (result != JOptionPane.OK_OPTION) {
            InputOutput.showMessage("Operação cancelada.");
            return;
        }

        int selectedIndex = options.getSelectedIndex();

        Board selectedBoard = user.getBoards().get(selectedIndex);

        InputOutput.showBoard(selectedBoard);
    }
}
