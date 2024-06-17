import javax.swing.*;

import static javax.swing.JOptionPane.*;

public class Menu {
    private Character[] characters = FakeCharacters.getFakeCharacters();

    public static void exibirMenu() {
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
        //InputOutput.showMessage();
    }
}
