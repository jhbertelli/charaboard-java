import java.util.List;

public class User {
    private String username;
    private String nickname;
    private String email;
    private String password;
    private List<Board> boards;
//    private List<CharacterFavorite> favoriteCharacters;
//    private List<GameFavorite> favoriteGames;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
