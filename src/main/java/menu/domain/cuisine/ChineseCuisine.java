package menu.domain.cuisine;

import menu.domain.Cuisine;

public enum ChineseCuisine implements Cuisine {

    KKANPUNGGI("깐풍기"),
    STIR_FRIED_NOODLES("볶음면"),
    DONGPO_MEAT("동파육"),
    BLACK_BEAN_SAUCE_NOODLES("짜장면"),
    JJAMBBONG("짬뽕"),
    MAPA_TOFU("마파두부"),
    SWEET_AND_SOUR_PORK("탕수육"),
    STIR_FRIED_TOMATO_EGG("토마토 달걀볶음"),
    RED_PEPPER_JAPCHAE("고추잡채"),
    ;

    private final String name;

    ChineseCuisine(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public CuisineType getCuisineType() {
        return CuisineType.CHINESE_CUISINE;
    }
}
