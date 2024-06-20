public class CharacterFavorite implements IFavorite {
    private final Character character;

    public CharacterFavorite(Character character) {
        this.character = character;
    }

    public Character getCharacter() {
        return character;
    }
}
