import java.util.ArrayList;

public class Character implements IFavoritable<CharacterFavorite> {
    private String name;
    private int age;
    private String description;
    private String race;
    private Gender gender;
    private final ArrayList<Game> relatedGames = new ArrayList<>();
    private final ArrayList<CharacterFavorite> favorites = new ArrayList<>();

    public Character(String name, int age, String description, String race, Gender gender) {
        this.name = name;
        this.age = age;
        this.description = description;
        this.race = race;
        this.gender = gender;
    }

    public ArrayList<Game> getRelatedGames() {
        return relatedGames;
    }

    public void addRelatedGame(Game game){
        relatedGames.add(game);
    }

    public ArrayList<CharacterFavorite> getFavorites() {
        return favorites;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }
    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void addFavorite(CharacterFavorite favorite) {
        favorites.add(favorite);
    }

    public void removeFavorite(CharacterFavorite favorite) {
        favorites.remove(favorite);
    }
}
