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
        validateCoachCount(coachs);
        validateNoDuplicates(coachs);
    }

    private void validateCoachCount(List<Coach> coachs) {
        int coachCount = coachs.size();
        if (coachCount < MIN_NUMBER_OF_COACHES_AT_LUNCH || coachCount > MAX_NUMBER_OF_COACHES_AT_LUNCH) {
            throw MenuException.from(ErrorMessage.INVALID_NUMBER_OF_COACHES_AT_LUNCH);
        }
    }

    private void validateNoDuplicates(List<Coach> coachs) {
        Set<Coach> uniqueValues = new HashSet<>(coachs);
        if (uniqueValues.size() != coachs.size()) {
            throw MenuException.from(ErrorMessage.DUPLICATE_COACH_NAME);
        }
    }

    public Map<Coach, List<Cuisine>> createMenus(List<CuisineType> cuisineTypes) {
        Map<Coach, List<Cuisine>> lunchMenusByCoach = new LinkedHashMap<>();
        Map<Coach, Set<Cuisine>> cuisineSets = new LinkedHashMap<>();
        initializationMap(lunchMenusByCoach, cuisineSets);

        for (CuisineType cuisineType : cuisineTypes) {
            for (Coach coach : coachs) {
                Set<Cuisine> cuisineSet = cuisineSets.get(coach);
                List<Cuisine> hateCuisines = coach.getHateCuisine();

                Cuisine cuisine = Cuisine.pickCuisine(cuisineType, cuisineSet, hateCuisines);
                lunchMenusByCoach.get(coach).add(cuisine);
                cuisineSet.add(cuisine);
            }
        }

        return lunchMenusByCoach;
    }

    private void initializationMap(Map<Coach, List<Cuisine>> lunchMenusByCoach,
            Map<Coach, Set<Cuisine>> cuisineSets) {
        for (Coach coach : coachs) {
            lunchMenusByCoach.put(coach, new ArrayList<>());
            cuisineSets.put(coach, new HashSet<>());
        }
    }
}
