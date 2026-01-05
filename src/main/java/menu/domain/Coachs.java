package menu.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import menu.domain.cuisine.CuisineType;
import menu.exception.ErrorMessage;
import menu.exception.MenuException;

public class Coachs {

    private static final int MIN_NUMBER_OF_COACHES_AT_LUNCH = 2;
    private static final int MAX_NUMBER_OF_COACHES_AT_LUNCH = 5;

    private List<Coach> coachs;

    public Coachs(List<Coach> coachs) {
        validateCoachs(coachs);
        this.coachs = coachs;
    }

    private void validateCoachs(List<Coach> coachs) {
        int coachCount = coachs.size();
        if (coachCount < MIN_NUMBER_OF_COACHES_AT_LUNCH || coachCount > MAX_NUMBER_OF_COACHES_AT_LUNCH) {
            throw MenuException.from(ErrorMessage.INVALID_NUMBER_OF_COACHES_AT_LUNCH);
        }
    }

    public Map<Coach, List<Cuisine>> createMenus(List<CuisineType> cuisineTypes) {
        Map<Coach, List<Cuisine>> map = new LinkedHashMap<>();
        Map<Coach, Set<Cuisine>> cuisineSets = new LinkedHashMap<>();

        for (Coach coach : coachs) {
            map.put(coach, new ArrayList<>());
            cuisineSets.put(coach, new HashSet<>());
        }

        for (CuisineType cuisineType : cuisineTypes) {
            for (Coach coach : coachs) {
                Set<Cuisine> cuisineSet = cuisineSets.get(coach);
                List<Cuisine> hateCuisines = coach.getHateCuisine();

                Cuisine cuisine = Cuisine.pickCuisine(cuisineType, cuisineSet, hateCuisines);
                map.get(coach).add(cuisine);
                cuisineSet.add(cuisine);
            }
        }

        return map;
    }

    public int count() {
        return coachs.size();
    }
}
