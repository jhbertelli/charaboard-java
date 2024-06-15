import java.util.List;
import java.util.ListIterator;

public class Character implements IFavoritable{
    public String name;
    public String imagePath;
    public int age;
    public String description;
    public String face;
    public String gender;
    public List<Game> RelatedGames;
    public List<CharacterFavorite> Favorites;

    public List<Game> getRelatedGames() {
        return RelatedGames;
    }

    public void setRelatedGames(List<Game> relatedGames) {
        RelatedGames = relatedGames;
    }

    public List<CharacterFavorite> getFavorites() {
        return Favorites;
    }

    public void setFavorites(List<CharacterFavorite> favorites) {
        Favorites = favorites;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
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

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public void AddFavorite(User user) {

    }

    @Override
    public void RemoveFavorite(User user) {

    }

    public Character(String name, String imagePath, int age, String description, String face, String gender, List<Game> relatedGames, List<CharacterFavorite> favorites)
    {
        this.name = name;
        this.imagePath = imagePath;
        this.age = age;
        this.description = description;
        this.face = face;
        this.gender = gender;
        RelatedGames = relatedGames;
        Favorites = favorites;
    }
}
