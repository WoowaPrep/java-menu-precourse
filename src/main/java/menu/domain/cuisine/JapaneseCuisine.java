package menu.domain.cuisine;

public enum JapaneseCuisine {

    GYUDONG("규동"),
    UDON("우동"),
    MISO_SIRU("미소시루"),
    SUSHI("스시"),
    KATSUDON("가츠동"),
    ONIGIRI("오니기리"),
    HIGH_RICE("하이라이스"),
    RAMEN("라멘"),
    OKONOMIYAKKI("오코노미야끼"),
    ;

    private final String name;

    JapaneseCuisine(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
