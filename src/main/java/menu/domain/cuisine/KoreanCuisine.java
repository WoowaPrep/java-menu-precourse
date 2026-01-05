package menu.domain.cuisine;

import menu.domain.Cuisine;

public enum KoreanCuisine implements Cuisine {

    RICE_ROLL("김밥"),
    KIMCHI_STEW("김치찌개"),
    SSAMBAP("쌈밥"),
    BEAN_PASTE_STEW("된장찌개"),
    BIBIMBAP("비빔밥"),
    KALGUKSU("칼국수"),
    BULGOGI("불고기"),
    TTEOKBOKKI("떡볶이"),
    JEYUK_BOKKEUM("제육볶음"),
    ;

    private final String name;

    KoreanCuisine(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public CuisineType getCuisineType() {
        return CuisineType.KOREAN_CUISINE;
    }
}
