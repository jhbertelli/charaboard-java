import java.util.Arrays;

public class FakeUsers {
    final static User userOne = new User(
        "cristopher",
        "Cristopher Robin",
        "cristopher@fake.com",
        "123");

    final static User userTwo = new User(
        "Teste",
        "Teste",
        "teste@teste.com",
        "Teste");

    final static User userThree = new User(
        "USERNAME",
        "USERNAME",
        "username@fake.com",
        "PASSWORD");

    final static User userFour = new User(
        "1",
        "fake",
        "fake@fake.com",
        "1");

    public static User[] getFakeUsers() {
        return Arrays.stream(new User[] {
            userOne,
            userTwo,
            userThree,
            userFour
        })
        .sorted((a, b) -> a.getNickname().compareToIgnoreCase(b.getNickname()))
        .toArray(User[]::new);
    }
}
