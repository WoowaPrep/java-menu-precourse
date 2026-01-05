package menu.domain.cuisine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

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

    public static List<CuisineType> createCuisineTypes() {
        Map<CuisineType, Integer> countByCuisineType = new EnumMap<>(CuisineType.class);
        List<CuisineType> cuisineTypes = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            CuisineType cuisineType;
            while (true) {
                cuisineType = CuisineType.getRandomCuisineType();
                if (countByCuisineType.getOrDefault(cuisineType, 0) < 2) {
                    countByCuisineType.merge(cuisineType, 1, Integer::sum);
                    break;
                }
            }
            cuisineTypes.add(cuisineType);
        }
        return cuisineTypes;
    }

    public static CuisineType getRandomCuisineType() {
        int cuisineTypeCount = CuisineType.values().length;
        int cuisineIndex = Randoms.pickNumberInRange(1, cuisineTypeCount);
        return CuisineType.values()[cuisineIndex - 1];
    }

    public String getName() {
        return name;
    }
}
