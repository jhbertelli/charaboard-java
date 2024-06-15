import java.util.Date;
import java.util.List;

public class Game implements IFavoritable{
    public String name;
    public String imagePath;
    public Date release;
    public String description;
    public String genre;
    public List<Character> RelatedCharacters;
    public List<GameFavorite> Favorites;

    public List<Character> getRelatedCharacters() {
        return RelatedCharacters;
    }

    public void setRelatedCharacters(List<Character> relatedCharacters) {
        RelatedCharacters = relatedCharacters;
    }

    public List<GameFavorite> getFavorites() {
        return Favorites;
    }

    public void setFavorites(List<GameFavorite> favorites) {
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

    public Date getRelease() {
        return release;
    }

    public void setRelease(Date release) {
        this.release = release;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String publisher;
    public String developer;


    @Override
    public void AddFavorite(User user) {

    }

    @Override
    public void RemoveFavorite(User user) {

    }

    public Game(String name, String imagePath, Date release, String description, String genre, List<Character> relatedCharacters, List<GameFavorite> favorites, String publisher, String developer)
    {
        this.name = name;
        this.imagePath = imagePath;
        this.release = release;
        this.description = description;
        this.genre = genre;
        RelatedCharacters = relatedCharacters;
        Favorites = favorites;
        this.publisher = publisher;
        this.developer = developer;
    }
}
