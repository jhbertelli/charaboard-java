import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Date;

import static javax.swing.JOptionPane.*;

public class InputOutput {
    public static final String DATE_FORMAT = "dd/MM/yyyy";

    public static String returnString(String mensagem) throws NullPointerException {
        String message = "";

        while (message.isEmpty()) {
            String input = showInputDialog(mensagem);

            if (input == null) throw new NullPointerException();

            message = input.trim();
            if (message.isEmpty()) showMessage("Informe um valor.");
        }

        return message;
    }

    public static Date returnDate(String mensagem) {
        Date date = new Date();
        var formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu").withResolverStyle(ResolverStyle.STRICT);

        boolean retry;

        do {
            String input = showInputDialog(mensagem);

            if (input == null) return null;

            try {
                var localDate = LocalDate.parse(input, formatter);

                // converte de LocalDate para date
                date = new Date(java.sql.Date.valueOf(localDate).getTime());
                retry = false;
            } catch (DateTimeParseException ex) {
                retry = true;
                showMessageDialog(
                    null,
                    "Você inseriu uma data inválida! Insira uma data válida, no formato: " + DATE_FORMAT
                );
            }
        } while (retry);

        return date;
    }

    public static int returnInt(String mensagem) {
        return Integer.parseInt(showInputDialog(mensagem));
    }

    public static Double returnDouble(String mensagem) {
        Double valor = null;

        while (valor == null) {
            String valorString = showInputDialog(mensagem);

            if (valorString == null) return null;

            try {
                valor = Double.parseDouble(valorString);
            } catch (NumberFormatException ex) {
                showMessage("Por favor, informe um valor real válido.");
            }
        }

        return valor;
    }

    public static void showMessage(String message) {
        showMessageDialog(null, message);
    }

    public static void showCharacter(Character character) {
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

        showMessage(message);
    }

    public static void showBoard(Board board) {
        String message = String.format("""
Dados do board

Nome: %s
Descrição: %s
""",
            board.getName(),
            board.getDescription()
        );

        showMessage(message);
    }
}