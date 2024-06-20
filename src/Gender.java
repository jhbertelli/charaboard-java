public enum Gender {
    MALE("Masculino"),
    FEMALE("Feminino"),
    OTHER("Outro"),
    UNKNOWN("Desconhecido");

    private final String name;

    Gender(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
