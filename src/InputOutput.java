import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Date;

import static javax.swing.JOptionPane.*;

public class InputOutput {
    public static final String DATE_FORMAT = "dd/MM/yyyy";

    public static String returnString(String mensagem) {
        String message = "";

        while (message.isEmpty()) {
            String input = showInputDialog(mensagem);

            if (input == null) return null;

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
}