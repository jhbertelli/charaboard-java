import java.util.Date;
import java.util.ArrayList;

public class Game implements IFavoritable{
    private String name;
    private Date release;
    private String description;
    private String genre;
    private ArrayList<Character> relatedCharacters = new ArrayList<>();
    private ArrayList<GameFavorite> favorites = new ArrayList<>();

    public Game(String name, Date release, String description, String genre, String publisher, String developer) {
        this.name = name;
        this.release = release;
        this.description = description;
        this.genre = genre;
        this.publisher = publisher;
        this.developer = developer;
    }

    public ArrayList<Character> getRelatedCharacters() {
        return relatedCharacters;
    }

    public ArrayList<GameFavorite> getFavorites() {
        return favorites;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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


    public void addFavorite(User user) {

    }

    public void removeFavorite(User user) {

    }
}
