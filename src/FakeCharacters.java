import java.util.Arrays;

public class FakeCharacters {
    final static Character flandreScarlet = new Character(
        "Flandre Scarlet",
        495,
        "Uma vampira que mora na Mansão do Demônio Escarlate.\nPossui olhos escarlate, cabelo loiro curto preso em um único lado por um rabo de cavalo.\nSua principal característica é ser uma vampira com grande vontade de destruição",
        "Vampiro",
        Gender.Female);

    final static Character solidSnake = new Character(
        "Solid Snake",
        52,
        "Seu nome real é David, mas também é conhecido como Old Snake, Iroquois Pliskin ou simplesmente Snake.\nNasceu em 1972, possui nacionalidade norte americana (Estados Unidos).\nFoi criado como um clone do soldado Big Boss, inicialmente participou dos boina verdes e posteriormente introduzido na Unidade de Forças Especiais de Alta Tecnologia FOXHOUND na década de 1990",
        "Humano",
        Gender.Male);

    final static Character kratos = new Character(
        "Kratos",
        200,
        "Kratos, também conhecido como o Fantasma de Esparta é o protagonis de mais de 8 jogos da série God of War, onde atua como uma espécie de anti-herói tentando mudar seu destino, ao mesmo tempo que trucida praticamente, ou se não absolutamente, todos os deuses do olimpo",
        "Deus",
        Gender.Male);

    final static Character redPokemon = new Character(
        "Red",
        20,
        "Red (Japonês: レッド Red) é o personagem com quem o jogador joga na geração 1 de jogos, Pokémon red, blue, green, yellow e é a escolha de personagem masculino em nos remakes da terceira geração, Pokémon FireRed e LeafGreen",
        "Humano",
        Gender.Male
    ).addRelatedGames(FakeGames.pokemonRed).addRelatedGames(FakeGames.PokemonBlue);

    final static Character laraCroft = new Character(
        "Lara Croft",
        21,
        "Lara é a protagonista de série Tomb Raider, é uma arqueóloga britânica que se aventura em antigas tumbas e ruínas perigosas à procura de artefatos valiosos",
        "Humano",
        Gender.Female);

    //esses próximos eu pedi pro gpt pra testar
    final static Character character1 = new Character(
        "Liora Sunblade",
        27,
        "Liora é uma guerreira habilidosa com uma espada encantada que brilha com uma luz dourada. Ela é conhecida por sua bravura e senso de justiça, sempre defendendo os fracos e oprimidos.",
        "Elfo",
        Gender.Female
    );

    final static Character character2 = new Character(
        "Thorin Oakenshield",
        150,
        "Thorin é um anão robusto e determinado, com uma barba longa e trançada. Ele é um líder nato, determinado a recuperar o reino perdido de sua linhagem e proteger seu povo a qualquer custo.",
        "Anão",
        Gender.Male
    );

    final static Character character3 = new Character(
        "Elysia Nightshade",
        34,
        "Elysia é uma feiticeira misteriosa com olhos violetas e cabelo prateado. Ela possui vasto conhecimento sobre magia antiga e é frequentemente consultada por aqueles que procuram sabedoria e poder.",
        "Humano",
        Gender.Female
    );

    public static Character[] getFakeCharacters() {
        return Arrays.stream(new Character[] {
            flandreScarlet,
            kratos,
            laraCroft,
            redPokemon,
            character1,
            character2,
            character3,
            solidSnake
        })
        .sorted((a, b) -> a.getName().compareToIgnoreCase(b.getName()))
        .toArray(Character[]::new);
    }
}
