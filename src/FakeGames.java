import java.util.Arrays;
import java.util.Date;
import java.util.ArrayList;

public class FakeGames {
    final static Game pokemonRed = new Game(
            "Pokémon Red",
            new Date(1996,2,22),
            "Pokémon Red se trata de um jogo eletrônico de RPG de 1996, desenvolvido pela GameFreak e publicado pela Nintendo para o console portátil Game Boy. Pokémon Red, assim como Pokémon Blue, foi o primeiro jogo eletrônico da série Pokémon",
            "Aventura, JRPG",
            "Nintendo",
            "GameFreak"
    ).addRelatedCharacter(FakeCharacters.redPokemon);

    final static Game game1 = new Game(
            "CyberQuest: Dawn of Horizons",
            new Date(2024,3,25),
            "Explore a vast open world in a futuristic setting where you uncover the secrets of a long-lost civilization.",
            "Action RPG",
            "Epic Worlds",
            "NovaTech Studios"
    );

    final static Game game2 = new Game(
            "Mystic Realms: Enchanted Forest",
            new Date(1980,10,22),
            "A captivating adventure game where players solve intricate puzzles and unravel the mysteries of the Enchanted Forest.",
            "Adventure",
            "Magic Tree Games",
            "DreamCraft"
    );

    final static Game game3 = new Game(
            "Starship Titans: Galactic Wars",
            new Date(2002,8,19),
            "Command your fleet in epic space battles and strategize to conquer the galaxy in this immersive strategy game.",
            "Strategy",
            "Galactic Empires",
            "StarForge Interactive"
    );

    final static Game PokemonBlue = new Game(
            "Pokémon Blue",
            new Date(1996,2,27),
            "Pokémon Blue é um jogo eletrônico de RPG de 1996, desnvolvido pela Game Freak e publicado pela Nintendo para o console portátil Game Boy. Pokémon Red e Pokémon Blue são os primeiros jogos eletrônicos da série Pokémon",
            "Aventura, JRPG",
            "Nintendo",
            "Game Freak"
    ).addRelatedCharacter(FakeCharacters.redPokemon);

    public  static Game[] getFakeGames() {
        return Arrays.stream(new Game[]{
                pokemonRed,
                game1,
                game2,
                game3
        })
        .sorted((a,b)->a.getName().compareToIgnoreCase(b.getName()))
        .toArray(Game[]::new);
    }

}
