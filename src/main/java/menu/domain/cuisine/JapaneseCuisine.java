package menu.domain.cuisine;

import menu.domain.Cuisine;

public enum JapaneseCuisine implements Cuisine {

    GYUDONG("규동"),
    UDON("우동"),
    MISO_SIRU("미소시루"),
    SUSHI("스시"),
    KATSUDON("가츠동"),
    ONIGIRI("오니기리"),
    HIGH_RICE("하이라이스"),
    RAMEN("라멘"),
    OKONOMIYAKI("오코노미야끼"),
    ;

    private final String name;

    JapaneseCuisine(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public CuisineType getCuisineType() {
        return CuisineType.JAPANESE_CUISINE;
    }
}
