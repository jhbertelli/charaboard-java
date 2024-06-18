import javax.swing.*;

import java.awt.*;
import java.util.Arrays;

import static javax.swing.JOptionPane.*;

public class Menu {
    private static final Character[] characters = FakeCharacters.getFakeCharacters();

    public static void showMenu() {
        int answer;

        JComboBox<String> options = new JComboBox<>(new String[] {
            "Listar personagens",
            "Sair"
        });

        do {
            showMessageDialog(null, options, "Opções", INFORMATION_MESSAGE, null);
            answer = options.getSelectedIndex();

            switch (answer) { //Adicionando um novo projeto à lista de projetos da classe GestaoProjetos
                case 0:
                    showCharacters();
                    break;
            }

        } while (answer != 1);
    }

    private static void showCharacters() {
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

        showCharacter(characters[selectedIndex]);
    }

    private static void showCharacter(Character character) {
        String message = String.format("""
Dados do personagem

Nome: %s
Idade: %d
Descrição: %s
Raça: %s
Gênero: %s
Quantidade de favoritos: %d
""",
            character.getName(),
            character.getAge(),
            character.getDescription(),
            character.getRace(),
            character.getGender().toString(),
            character.getFavorites().size()
        );

        InputOutput.showMessage(message);
    }
}
