package menu.domain;

public enum CuisineType {

    JAPANESE_CUISINE("일식"),
    KOREAN_CUISINE("한식"),
    CHINESE_CUISINE("중식"),
    ASIAN_CUISINE("아시안"),
    WESTERN_CUISINE("양식"),
    ;

    private final String name;

    CuisineType(String name) {
        this.name = name;
    }
}
