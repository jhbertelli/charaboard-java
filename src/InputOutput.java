import java.text.SimpleDateFormat;
import java.util.ArrayList;

import static javax.swing.JOptionPane.*;

public class InputOutput {
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

    public static void showMessage(String message) {
        showMessageDialog(null, message);
    }

    public static void showCharacter(Character character) {
        ArrayList<Game> relatedGames = character.getRelatedGames();

        String message = String.format("""
Dados do personagem

Nome: %s
Idade: %d
Descrição:
%s
Raça: %s
Gênero: %s
Quantidade de favoritos: %d

Jogos relacionados (%d):
""",
            character.getName(),
            character.getAge(),
            character.getDescription(),
            character.getRace(),
            character.getGender().toString(),
            character.getFavorites().size(),
            relatedGames.size()
        );

        for (Game game : relatedGames) {
            message += game.getName() + '\n';
        }

        showMessage(message);
    }


    public static void showGame(Game game){
        String datePattern = "dd/MM/yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(datePattern);

        String message = String.format("""
Dados do Jogo

Nome: %s
Lançamento: %s
Descrição:
%s
Gênero: %s
Distribuidora: %s
Desenvolvedora: %s
Quantidade de favoritos: %d
""",
                game.getName(),
                DateUtils.formatarDataParaString(game.getRelease()),
                game.getDescription(),
                game.getGenre(),
                game.getPublisher(),
                game.getDeveloper(),
                game.getFavorites().size()
        );

        showMessage(message);
    }

    public static void showBoard(Board board) {
        StringBuilder builder = new StringBuilder();

        builder.append(String.format("""
Dados do board

Nome: %s
Descrição: %s
""",
            board.getName(),
            board.getDescription()
        ));

        builder.append(
            String.format("Personagens adicionados (%d):\n", board.getCharacters().size())
        );

        for (Character character : board.getCharacters()) {
            builder.append(character.getName()).append('\n');
        }

        builder.append(
            String.format("\nJogos adicionados (%d):\n", board.getGames().size())
        );

        for (Game game : board.getGames()) {
            builder.append(game.getName()).append('\n');
        }

        builder.append('\n');

        showMessage(builder.toString());
    }

    public static void showFavoriteCharacters(User user) {
        ArrayList<CharacterFavorite> favoriteCharacters = user.getFavoriteCharacters();

        String message = String.format(
            "Personagens favoritos (%d):\n\n",
            favoriteCharacters.size()
        );

        for (CharacterFavorite favorite : favoriteCharacters) {
            message += favorite.getCharacter().getName() + '\n';
        }

        showMessage(message);
    }
}