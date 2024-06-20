import java.util.Arrays;
import java.util.Date;

public class Database {
    private Character flandreScarlet;
    private Character solidSnake;
    private Character kratos;
    private Character redPokemon;
    private Character laraCroft;
    private Character character1;
    private Character character2;
    private Character character3;

    private Game pokemonRed;
    private Game pokemonBlue;
    private Game game1;
    private Game game2;
    private Game game3;

    private Board boardOne;
    private Board boardTwo;

    private User userOne;
    private User userTwo;
    private User userThree;
    private User userFour;

    Database() {
        generateCharacters();

        generateGames();

        generateBoards();

        generateUsers();

        addGameCharacterRelations();

        addBoardRelations();

        addUserRelations();
    }

    public User[] getUsers() {
        return Arrays.stream(new User[] {
            userOne,
            userTwo,
            userThree,
            userFour
        })
        .sorted((a, b) -> a.getNickname().compareToIgnoreCase(b.getNickname()))
        .toArray(User[]::new);
    }

    public Game[] getGames() {
        return Arrays.stream(new Game[]{
            pokemonRed,
            game1,
            game2,
            game3
        })
        .sorted((a,b)->a.getName().compareToIgnoreCase(b.getName()))
        .toArray(Game[]::new);
    }

    public Character[] getCharacters() {
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

    private void addGameCharacterRelations() {
        pokemonBlue.addRelatedCharacter(redPokemon);
        pokemonRed.addRelatedCharacter(redPokemon);
        redPokemon.addRelatedGames(pokemonRed);
        redPokemon.addRelatedGames(pokemonBlue);

        character1.addRelatedGames(game1);
        game1.addRelatedCharacter(character1);
    }

    private void addBoardRelations() {
        boardOne.addGame(game2);

        boardTwo.addCharacter(character1);
        boardTwo.addCharacter(character2);
        boardTwo.addGame(game1);
    }

    private void generateCharacters() {
        flandreScarlet = new Character(
            "Flandre Scarlet",
            495,
            "Uma vampira que mora na Mansão do Demônio Escarlate.\nPossui olhos escarlate, cabelo loiro curto preso em um único lado por um rabo de cavalo.\nSua principal característica é ser uma vampira com grande vontade de destruição",
            "Vampiro",
            Gender.Female
        );

        solidSnake = new Character(
            "Solid Snake",
            52,
            "Seu nome real é David, mas também é conhecido como Old Snake, Iroquois Pliskin ou simplesmente Snake.\nNasceu em 1972, possui nacionalidade norte americana (Estados Unidos).\nFoi criado como um clone do soldado Big Boss, inicialmente participou dos boina verdes e posteriormente introduzido na Unidade de Forças Especiais de Alta Tecnologia FOXHOUND na década de 1990",
            "Humano",
            Gender.Male
        );

        kratos = new Character(
            "Kratos",
            200,
            "Kratos, também conhecido como o Fantasma de Esparta é o protagonis de mais de 8 jogos da série God of War,\nonde atua como uma espécie de anti-herói tentando mudar seu destino, ao mesmo tempo que trucida praticamente, ou se não absolutamente, todos os deuses do olimpo",
            "Deus",
            Gender.Male
        );

        redPokemon = new Character(
            "Red",
            20,
            "Red (Japonês: レッド Red) é o personagem com quem o jogador joga na geração 1 de jogos, Pokémon Red, Blue, Green,\nYellow e é a escolha de personagem masculino em nos remakes da terceira geração, Pokémon FireRed e LeafGreen",
            "Humano",
            Gender.Male
        );

        laraCroft = new Character(
            "Lara Croft",
            21,
            "Lara é a protagonista de série Tomb Raider, é uma arqueóloga britânica que se aventura em antigas tumbas e ruínas perigosas à procura de artefatos valiosos",
            "Humano",
            Gender.Female
        );

        character1 = new Character(
            "Liora Sunblade",
            27,
            "Liora é uma guerreira habilidosa com uma espada encantada que brilha com uma luz dourada.\nEla é conhecida por sua bravura e senso de justiça, sempre defendendo os fracos e oprimidos.",
            "Elfo",
            Gender.Female
        );

        character2 = new Character(
            "Thorin Oakenshield",
            150,
            "Thorin é um anão robusto e determinado, com uma barba longa e trançada.\nEle é um líder nato, determinado a recuperar o reino perdido de sua linhagem e proteger seu povo a qualquer custo.",
            "Anão",
            Gender.Male
        );

        character3 = new Character(
            "Elysia Nightshade",
            34,
            "Elysia é uma feiticeira misteriosa com olhos violetas e cabelo prateado.\nEla possui vasto conhecimento sobre magia antiga e é frequentemente consultada por aqueles que procuram sabedoria e poder.",
            "Humano",
            Gender.Female
        );
    }

    private void generateGames() {
        pokemonRed = new Game(
            "Pokémon Red",
            new Date(96,2,22),
            "Pokémon Red se trata de um jogo eletrônico de RPG de 1996, desenvolvido pela GameFreak e publicado pela Nintendo para o console portátil Game Boy. Pokémon Red, assim como Pokémon Blue, foi o primeiro jogo eletrônico da série Pokémon",
            "Aventura, JRPG",
            "Nintendo",
            "GameFreak"
        );

        game1 = new Game(
            "CyberQuest: Dawn of Horizons",
            new Date(124,3,25),
            "Explore a vast open world in a futuristic setting where you uncover the secrets of a long-lost civilization.",
            "Action RPG",
            "Epic Worlds",
            "NovaTech Studios"
        );

        game2 = new Game(
            "Mystic Realms: Enchanted Forest",
            new Date(80,10,22),
            "A captivating adventure game where players solve intricate puzzles and unravel the mysteries of the Enchanted Forest.",
            "Adventure",
            "Magic Tree Games",
            "DreamCraft"
        );
        game3 = new Game(
            "Starship Titans: Galactic Wars",
            new Date(102,8,19),
            "Command your fleet in epic space battles and strategize to conquer the galaxy in this immersive strategy game.",
            "Strategy",
            "Galactic Empires",
            "StarForge Interactive"
        );
        pokemonBlue = new Game(
            "Pokémon Blue",
            new Date(96,2,27),
            "Pokémon Blue é um jogo eletrônico de RPG de 1996, desnvolvido pela Game Freak e publicado pela Nintendo para o console portátil Game Boy. Pokémon Red e Pokémon Blue são os primeiros jogos eletrônicos da série Pokémon",
            "Aventura, JRPG",
            "Nintendo",
            "Game Freak"
        );
    }

    private void generateBoards() {
        boardOne = new Board("RPG Maker", "Personagens e jogos feitos em game engines derivadas de RPG Maker.");
        boardTwo = new Board("Apocalipse Zumbi", "Personagens e jogos com o tema apocalipse zumbi.");
    }

    private void generateUsers() {
        userOne = new User(
            "cristopher",
            "Cristopher Robin",
            "cristopher@fake.com",
            "123");

        userTwo = new User(
            "Teste",
            "Teste",
            "teste@teste.com",
            "Teste");

        userThree = new User(
            "USERNAME",
            "USERNAME",
            "username@fake.com",
            "PASSWORD");

        userFour = new User(
            "1",
            "fake",
            "fake@fake.com",
            "1");
    }

    private void addUserRelations() {
        userOne.addBoard(boardOne);
        userFour.addBoard(boardTwo);
    }
}
