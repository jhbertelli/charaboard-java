import Exceptions.CharacterAlreadyOnBoardException;
import Exceptions.GameAlreadyOnBoardException;

import java.util.Arrays;
import java.util.Date;

public class Database {
    private Character flandreScarlet;
    private Character solidSnake;
    private Character kratos;
    private Character redPokemon;
    private Character laraCroft;
    private Character ellie;
    private Character frisk;
    private Character arthurMorgan;
    private Character leonKennedy;
    private Character ashleyGraham;
    private Character lewis;
    private Character robin;
    private Character hornet;
    private Character theKnight;

    private Game pokemonRed;
    private Game pokemonBlue;
    private Game tombRaider2013;
    private Game theLastOfUs;
    private Game undertale;
    private Game redDeadRedemption2;
    private Game residentEvil4;
    private Game stardewValley;
    private Game hollowKnight;

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
            pokemonBlue,
            tombRaider2013,
            theLastOfUs,
            undertale,
            redDeadRedemption2,
            residentEvil4,
            stardewValley,
            hollowKnight
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
            solidSnake,
            ellie,
            frisk,
            arthurMorgan,
            leonKennedy,
            ashleyGraham,
            lewis,
            robin,
            hornet,
            theKnight
        })
        .sorted((a, b) -> a.getName().compareToIgnoreCase(b.getName()))
        .toArray(Character[]::new);
    }

    private void addGameCharacterRelations() {
        // Relations for "Pokémon Red" and "Pokémon Blue"
        pokemonBlue.addRelatedCharacter(redPokemon);
        pokemonRed.addRelatedCharacter(redPokemon);
        redPokemon.addRelatedGame(pokemonRed);
        redPokemon.addRelatedGame(pokemonBlue);

        // Relations for "Tomb Raider (2013)"
        laraCroft.addRelatedGame(tombRaider2013);
        tombRaider2013.addRelatedCharacter(laraCroft);

        // Relations for "The Last of Us"
        theLastOfUs.addRelatedCharacter(ellie);
        ellie.addRelatedGame(theLastOfUs);

        // Relations for "Undertale"
        undertale.addRelatedCharacter(frisk);
        frisk.addRelatedGame(undertale);

        // Relations for "Red Dead Redemption 2"
        arthurMorgan.addRelatedGame(redDeadRedemption2);
        redDeadRedemption2.addRelatedCharacter(arthurMorgan);

        // Relations for "Resident Evil 4"
        leonKennedy.addRelatedGame(residentEvil4);
        ashleyGraham.addRelatedGame(residentEvil4);
        residentEvil4.addRelatedCharacter(leonKennedy);
        residentEvil4.addRelatedCharacter(ashleyGraham);

        // Relations for "Stardew Valley"
        lewis.addRelatedGame(stardewValley);
        robin.addRelatedGame(stardewValley);
        stardewValley.addRelatedCharacter(lewis);
        stardewValley.addRelatedCharacter(robin);

        // Relations for "Hollow Knight"
        hornet.addRelatedGame(hollowKnight);
        theKnight.addRelatedGame(hollowKnight);
        hollowKnight.addRelatedCharacter(hornet);
        hollowKnight.addRelatedCharacter(theKnight);
    }

    private void addBoardRelations() {
        try {
            boardOne.addGame(stardewValley);
            boardTwo.addCharacter(hornet);
            boardTwo.addCharacter(theKnight);
            boardTwo.addGame(hollowKnight);
        } catch (CharacterAlreadyOnBoardException | GameAlreadyOnBoardException e) {
            throw new RuntimeException(e);
        }
    }

    private void generateCharacters() {
        flandreScarlet = new Character(
            "Flandre Scarlet",
            495,
"""
Uma vampira que mora na Mansão do Demônio Escarlate. Possui olhos escarlate,
cabelo loiro curto preso em um único lado por um rabo de cavalo. Sua principal
característica é ser uma vampira com grande vontade de destruição""",
            "Vampiro",
            Gender.FEMALE
        );

        solidSnake = new Character(
            "Solid Snake",
            52,
"""
Seu nome real é David, mas também é conhecido como Old Snake, Iroquois Pliskin
ou simplesmente Snake. Nasceu em 1972, possui nacionalidade norte-americana
(Estados Unidos). Foi criado como um clone do soldado Big Boss, inicialmente
participou dos boina verdes e posteriormente introduzido na Unidade de Forças
Especiais de Alta Tecnologia FOXHOUND na década de 1990""",
            "Humano",
            Gender.MALE
        );

        kratos = new Character(
            "Kratos",
            200,
"""
Kratos, também conhecido como o Fantasma de Esparta é o protagonista
de mais de 8 jogos da série God of War, onde atua como uma espécie de
anti-herói tentando mudar seu destino, ao mesmo tempo que trucida
praticamente, ou se não absolutamente, todos os deuses do olimpo""",
            "Deus",
            Gender.MALE
        );

        redPokemon = new Character(
            "Red",
            20,
"""
Red (Japonês: レッド Red) é o personagem com quem o jogador joga na geração 1 de
jogos, Pokémon Red, Blue, Green, Yellow e é a escolha de personagem masculino nos
remakes da terceira geração, Pokémon FireRed e LeafGreen""",
            "Humano",
            Gender.MALE
        );

        laraCroft = new Character(
            "Lara Croft",
            21,
"""
Lara é a protagonista de série Tomb Raider, é uma arqueóloga britânica que se
aventura em antigas tumbas e ruínas perigosas à procura de artefatos valiosos""",
            "Humano",
            Gender.FEMALE
        );

        ellie = new Character(
            "Ellie",
            19,
"""
Ellie é uma jovem corajosa que cresceu em um mundo pós-apocalíptico infestado por
criaturas hostis. Ela é imune à infecção que transformou a maioria da população
em monstros e é fundamental para a história de The Last of Us.""",
            "Humano",
            Gender.FEMALE
        );

        frisk = new Character(
            "Frisk",
            12,
"""
Frisk é o(a) protagonista silencioso(a) de Undertale, um humano que caiu no subsolo
e busca encontrar o caminho de volta para casa. Dependendo das escolhas do jogador,
Frisk pode ser pacifista ou confrontativo.""",
            "Humano",
            Gender.UNKNOWN
        );

        arthurMorgan = new Character(
            "Arthur Morgan",
            36,
"""
Arthur Morgan é um fora da lei e membro da gangue Van der Linde. Ele é um personagem
complexo que enfrenta dilemas morais enquanto tenta sobreviver em um mundo em rápida
transformação no final do século XIX.""",
            "Humano",
            Gender.MALE
        );

        leonKennedy = new Character(
            "Leon S. Kennedy",
            35,
"""
Leon é um agente do governo americano enviado em várias missões contra ameaças
biológicas, incluindo os surtos de vírus em Raccoon City. Ele é habilidoso em
combate e é frequentemente confrontado com horrores inimagináveis.""",
            "Humano",
            Gender.MALE
        );

        ashleyGraham = new Character(
            "Ashley Graham",
            20,
"""
Ashley é a filha do presidente dos EUA, que é sequestrada por uma seita
misteriosa em Resident Evil 4. Ela é resgatada por Leon S. Kennedy e
torna-se uma personagem chave no desenrolar dos eventos do jogo.""",
            "Humano",
            Gender.FEMALE
        );

        lewis = new Character(
            "Lewis",
            55,
"""
Lewis é o prefeito da cidade de Stardew Valley, responsável por administrar
a comunidade e auxiliar os jogadores na integração com os habitantes locais.
Ele é respeitado por sua liderança e sabedoria.""",
            "Humano",
            Gender.MALE
        );

        robin = new Character(
            "Robin",
            40,
"""
Robin é uma construtora talentosa e esposa de Demetrius em Stardew Valley.
Ela é responsável por construir e atualizar estruturas na fazenda do jogador,
além de ser uma pessoa amigável e útil.""",
            "Humano",
            Gender.FEMALE
        );

        hornet = new Character(
            "Hornet",
            0,
"""
Hornet é uma guerreira solitária e misteriosa que protege as profundezas de
Hallownest em Hollow Knight. Ela é habilidosa com sua agulha e representa um
desafio formidável para o protagonista.""",
            "Inseto",
            Gender.FEMALE
        );

        theKnight = new Character(
            "The Knight",
            0,
"""
O Cavaleiro é o protagonista silencioso de Hollow Knight, que explora o vasto
reino de Hallownest em busca de respostas e aventuras. Ele enfrenta inúmeras
criaturas e desafios enquanto desvenda os mistérios do mundo.""",
            "Inseto",
            Gender.UNKNOWN
        );
    }

    private void generateGames() {
        pokemonRed = new Game(
            "Pokémon Red",
            new Date(96,2,22),
"""
Pokémon Red se trata de um jogo eletrônico de RPG de 1996, desenvolvido pela GameFreak
e publicado pela Nintendo para o console portátil Game Boy. Pokémon Red, assim como
Pokémon Blue, foi o primeiro jogo eletrônico da série Pokémon.""",
            "Aventura, JRPG",
            "Nintendo",
            "GameFreak"
        );

        pokemonBlue = new Game(
            "Pokémon Blue",
            new Date(96,2,27),
"""
Pokémon Blue é um jogo eletrônico de RPG de 1996, desenvolvido pela Game Freak e
publicado pela Nintendo para o console portátil Game Boy. Pokémon Red e Pokémon Blue
são os primeiros jogos eletrônicos da série Pokémon.""",
            "Aventura, JRPG",
            "Nintendo",
            "Game Freak"
        );

        tombRaider2013 = new Game(
            "Tomb Raider (2013)",
            new Date(113, 3, 4),
"""
O jogo é um reboot da icônica série de ação e aventura que segue as origens de
Lara Croft, uma arqueóloga jovem e inexperiente que se vê presa em uma ilha
misteriosa após um naufrágio. Lara deve lutar pela sobrevivência contra forças
naturais e humanas enquanto desvenda os segredos da ilha e enfrenta desafios
perigosos para salvar seus amigos.""",
            "Ação, aventura, tiro",
            "Square Enix",
            "Crystal Dynamics"
        );

        theLastOfUs = new Game(
            "The Last of Us",
            new Date(110, 5, 14),
"""
The Last of Us é um jogo de ação e aventura ambientado em um mundo pós-apocalíptico,
onde os jogadores controlam Ellie, uma jovem imune a uma infecção que transformou a
maioria da população em criaturas hostis.""",
            "Ação, Aventura",
            "Sony Interactive Entertainment",
            "Naughty Dog"
        );

        undertale = new Game(
            "Undertale",
            new Date(115, 8, 15),
"""
Undertale é um RPG onde os jogadores assumem o papel de uma criança que caiu no
subsolo, uma grande e isolada região debaixo da superfície da Terra. Eles interagem
com diversos seres enquanto resolvem enigmas e fazem escolhas que afetam o desenrolar
da história.""",
            "RPG",
            "Toby Fox",
            "Toby Fox"
        );

        redDeadRedemption2 = new Game(
            "Red Dead Redemption 2",
            new Date(118, 9, 26),
"""
Red Dead Redemption 2 é um jogo de ação e aventura ambientado no Velho Oeste
americano. Os jogadores assumem o papel de Arthur Morgan, um fora da lei que
deve lidar com o fim da era dos foras da lei enquanto luta para sobreviver.""",
            "Ação, Aventura",
            "Rockstar Games",
            "Rockstar Studios"
        );

        residentEvil4 = new Game(
            "Resident Evil 4",
            new Date(105, 0, 11),
"""
Resident Evil 4 é um jogo de survival horror onde Leon S. Kennedy é enviado em
uma missão para resgatar a filha do presidente dos EUA, que foi sequestrada por
uma seita misteriosa na Europa. Ele descobre uma ameaça biológica terrível que
o coloca contra criaturas horrendas.""",
            "Survival Horror",
            "Capcom",
            "Capcom Production Studio 4"
        );

        stardewValley = new Game(
            "Stardew Valley",
            new Date(115, 1, 26),
"""
Stardew Valley é um jogo de simulação onde os jogadores herdam uma fazenda antiga
e devem restaurá-la enquanto interagem com os habitantes da cidade, cultivam plantas,
criam animais e exploram cavernas misteriosas.""",
            "Simulação, RPG",
            "ConcernedApe",
            "ConcernedApe"
        );

        hollowKnight = new Game(
            "Hollow Knight",
            new Date(117, 1, 24),
"""
Hollow Knight é um jogo de ação e aventura em estilo metroidvania onde os jogadores
exploram um vasto mundo subterrâneo habitado por insetos e criaturas estranhas.
Eles descobrem segredos, enfrentam desafios e desvendam a história do reino em ruínas.""",
            "Ação, Aventura, Metroidvania",
            "Team Cherry",
            "Team Cherry"
        );
    }

    private void generateBoards() {
        boardOne = new Board("Jogos relaxantes", "");
        boardTwo = new Board("Metroidvania", "Personagens e jogos com o tema metroidvania.");
    }

    private void generateUsers() {
        userOne = new User(
            "christopher",
            "Christopher Robin",
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
        userOne.addBoard(boardTwo);
        userFour.addBoard(boardOne);
    }
}
