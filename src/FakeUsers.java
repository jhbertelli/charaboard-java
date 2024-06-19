import java.util.Arrays;

public class FakeUsers {
    private final User[] fakeUsers;
    private final User userOne;
    private final User userTwo;
    private final User userThree;
    private final User userFour;

    FakeUsers() {
        FakeBoards boards = new FakeBoards();

        userOne = new User(
            "cristopher",
            "Cristopher Robin",
            "cristopher@fake.com",
            "123");

        userOne.addBoard(boards.getBoardOne());

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

        userFour.addBoard(boards.getBoardTwo());

        fakeUsers = Arrays.stream(new User[] {
                userOne,
                userTwo,
                userThree,
                userFour
            })
            .sorted((a, b) -> a.getNickname().compareToIgnoreCase(b.getNickname()))
            .toArray(User[]::new);
    }

    public User[] getFakeUsers() {
        return fakeUsers;
    }

    public User getUserOne() {
        return userOne;
    }

    public User getUserTwo() {
        return userTwo;
    }

    public User getUserThree() {
        return userThree;
    }

    public User getUserFour() {
        return userFour;
    }
}
