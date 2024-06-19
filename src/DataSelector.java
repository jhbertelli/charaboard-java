import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class DataSelector {
    private static final Character[] characters = FakeCharacters.getFakeCharacters();
    private static final Game[] games = FakeGames.getFakeGames();

    @Nullable
    public static Character selectCharacter() {
        JPanel panel = new JPanel(new GridLayout(2, 1));

        panel.add(new JLabel("Informe o personagem:"));

        JComboBox<String> options = new JComboBox<>(
            Arrays.stream(characters).map(Character::getName).toArray(String[]::new)
        );

        panel.add(options);

        int result = JOptionPane.showConfirmDialog(
            null,
            panel,
            "Selecionar Personagem",
            JOptionPane.OK_CANCEL_OPTION
        );

        if (result != JOptionPane.OK_OPTION) {
            InputOutput.showMessage("Operação cancelada.");
            return null;
        }

        int selectedIndex = options.getSelectedIndex();

        return characters[selectedIndex];
    }

    @Nullable
    public static Board selectBoard(User user) {
        if (user.getBoards().isEmpty()) {
            InputOutput.showMessage("Você não possui boards no momento.");
            return null;
        }

        JPanel panel = new JPanel(new GridLayout(2, 1));

        panel.add(new JLabel("Informe o board:"));

        JComboBox<String> options = new JComboBox<>(
            user.getBoards().stream().map(Board::getName).toArray(String[]::new)
        );

        panel.add(options);

        int result = JOptionPane.showConfirmDialog(
            null,
            panel,
            "Cadastro",
            JOptionPane.OK_CANCEL_OPTION
        );

        if (result != JOptionPane.OK_OPTION) {
            InputOutput.showMessage("Operação cancelada.");
            return null;
        }

        int selectedIndex = options.getSelectedIndex();

        return user.getBoards().get(selectedIndex);
    }

    @Nullable
    public static Game selectGame() {
        JPanel panel = new JPanel(new GridLayout(2, 1));

        panel.add(new JLabel("Informe o jogo:"));

        JComboBox<String> options = new JComboBox<>(
            Arrays.stream(games).map(Game::getName).toArray(String[]::new)
        );

        panel.add(options);

        int result = JOptionPane.showConfirmDialog(
            null,
            panel,
            "Selecionar Jogo",
            JOptionPane.OK_CANCEL_OPTION
        );

        if (result != JOptionPane.OK_OPTION) {
            InputOutput.showMessage("Operação cancelada.");
            return null;
        }

        int selectedIndex = options.getSelectedIndex();

        return games[selectedIndex];
    }
}
