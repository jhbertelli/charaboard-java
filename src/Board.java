import java.util.ArrayList;

public class Board {
    private String name;
    private String description;
    private ArrayList<Character> characters = new ArrayList<>();
    private ArrayList<Game> games = new ArrayList<>();

    public Board(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
