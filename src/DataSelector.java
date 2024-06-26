import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class DataSelector {
    private static final Database db = new Database();

    public static Character selectCharacter() {
        JPanel panel = new JPanel(new GridLayout(2, 1));

        panel.add(new JLabel("Informe o personagem:"));

        JComboBox<String> options = new JComboBox<>(
            Arrays.stream(db.getCharacters()).map(Character::getName).toArray(String[]::new)
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

        return db.getCharacters()[selectedIndex];
    }

    public static Character selectFavoriteCharacter(User user) {
        if (user.getFavoriteCharacters().isEmpty()) {
            InputOutput.showMessage("Você não possui personagens favoritos.");
            return null;
        }

        JPanel panel = new JPanel(new GridLayout(2, 1));

        panel.add(new JLabel("Informe o personagem:"));

        List<Character> characters = user.getFavoriteCharacters()
            .stream()
            .map(CharacterFavorite::getCharacter)
            .toList();

        JComboBox<String> options = new JComboBox<>(
            characters.stream().map(Character::getName).toArray(String[]::new)
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

        return characters.get(selectedIndex);
    }

    public static Game selectFavoriteGame(User user) {
        if (user.getFavoriteGames().isEmpty()) {
            InputOutput.showMessage("Você não possui jogos favoritos.");
            return null;
        }

        JPanel panel = new JPanel(new GridLayout(2,1));

        panel.add(new JLabel("Informe o jogo"));

        List<Game> games = user.getFavoriteGames()
                .stream()
                .map(GameFavorite::getGame)
                .toList();

        JComboBox<String> options = new JComboBox<>(
          games.stream().map(Game::getName).toArray(String[]::new)
        );

        panel.add(options);

        int result = JOptionPane.showConfirmDialog(
                null,
                panel,
                "Selecionar Jogo",
                JOptionPane.OK_CANCEL_OPTION
        );

        if(result != JOptionPane.OK_OPTION) {
            InputOutput.showMessage("Operação cancelada.");
            return null;
        }

        int selectedIndex = options.getSelectedIndex();

        return games.get(selectedIndex);
    }

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

    public static Game selectGame() {
        JPanel panel = new JPanel(new GridLayout(2, 1));

        panel.add(new JLabel("Informe o jogo:"));

        JComboBox<String> options = new JComboBox<>(
            Arrays.stream(db.getGames()).map(Game::getName).toArray(String[]::new)
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

        return db.getGames()[selectedIndex];
    }

    public static Character selectBoardCharacter(Board board) {
        if (board.getCharacters().isEmpty()) {
            InputOutput.showMessage("Você não possui personagens neste board no momento.");
            return null;
        }

        JPanel panel = new JPanel(new GridLayout(2, 1));

        panel.add(new JLabel("Informe o personagem:"));

        JComboBox<String> options = new JComboBox<>(
            board.getCharacters().stream().map(Character::getName).toArray(String[]::new)
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

        return board.getCharacters().get(selectedIndex);
    }

    public static Game selectBoardGame(Board board) {
        if (board.getGames().isEmpty()) {
            InputOutput.showMessage("Você não possui jogos neste board no momento.");
            return null;
        }

        JPanel panel = new JPanel(new GridLayout(2, 1));

        panel.add(new JLabel("Informe o jogo:"));

        JComboBox<String> options = new JComboBox<>(
            board.getGames().stream().map(Game::getName).toArray(String[]::new)
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

        return board.getGames().get(selectedIndex);
    }
}
