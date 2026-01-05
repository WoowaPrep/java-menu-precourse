package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import menu.domain.cuisine.AsianCuisine;
import menu.domain.cuisine.ChineseCuisine;
import menu.domain.cuisine.CuisineType;
import menu.domain.cuisine.JapaneseCuisine;
import menu.domain.cuisine.KoreanCuisine;
import menu.domain.cuisine.WesternCuisine;
import menu.exception.ErrorMessage;
import menu.exception.MenuException;

public interface Cuisine {

    static Cuisine getCuisineWith(String name) {
        return createAllCuisines().stream()
                .filter(cuisine -> cuisine.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> MenuException.from(ErrorMessage.NOT_EXIST_CUISINE));
    }

    static List<Cuisine> createAllCuisines() {
        List<Cuisine> allCuisines = new ArrayList<>();
        allCuisines.addAll(List.of(JapaneseCuisine.values()));
        allCuisines.addAll(List.of(KoreanCuisine.values()));
        allCuisines.addAll(List.of(ChineseCuisine.values()));
        allCuisines.addAll(List.of(AsianCuisine.values()));
        allCuisines.addAll(List.of(WesternCuisine.values()));
        return allCuisines;
    }

    static Cuisine pickCuisine(CuisineType cuisineType, Set<Cuisine> cuisineSet, List<Cuisine> hateCuisines) {
        List<Cuisine> allCuisinesOfType = createCuisines(cuisineType);

        while (true) {
            List<String> menuNames = allCuisinesOfType.stream()
                    .map(Cuisine::getName)
                    .collect(Collectors.toList());

            String selectedMenuName = Randoms.shuffle(menuNames).get(0);

            Cuisine selectedCuisine = allCuisinesOfType.stream()
                    .filter(cuisine -> cuisine.getName().equals(selectedMenuName))
                    .findFirst()
                    .orElseThrow(() -> MenuException.from(ErrorMessage.NOT_EXIST_CUISINE));

            if (!hateCuisines.contains(selectedCuisine) && !cuisineSet.contains(selectedCuisine)) {
                return selectedCuisine;
            }
        }
    }

    static List<Cuisine> createCuisines(CuisineType cuisineType) {
        if (cuisineType.equals(CuisineType.JAPANESE_CUISINE)) return List.of(JapaneseCuisine.values());
        if (cuisineType.equals(CuisineType.KOREAN_CUISINE)) return List.of(KoreanCuisine.values());
        if (cuisineType.equals(CuisineType.CHINESE_CUISINE)) return List.of(ChineseCuisine.values());
        if (cuisineType.equals(CuisineType.ASIAN_CUISINE)) return List.of(AsianCuisine.values());
        if (cuisineType.equals(CuisineType.WESTERN_CUISINE)) return List.of(WesternCuisine.values());

        throw MenuException.from(ErrorMessage.NOT_EXIST_CUISINE);
    }

    String getName();
    CuisineType getCuisineType();
}
