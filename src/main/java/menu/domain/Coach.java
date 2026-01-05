package menu.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import menu.exception.ErrorMessage;
import menu.exception.MenuException;

public class Coach {

    private static final int MIN_COACH_NAME_LENGTH = 2;
    private static final int MAX_COACH_NAME_LENGTH = 4;
    private static final int HATE_CUISINE_COUNT_THRESHOLD = 2;

    private String name;
    private List<Cuisine> hateCuisine;

    public Coach(String name, List<Cuisine> hateCuisine) {
        validateCoachName(name);
        validateHateCuisine(hateCuisine);
        this.name = name;
        this.hateCuisine = hateCuisine;
    }

    private void validateCoachName(String name) {
        int nameLength = name.length();
        if (nameLength < MIN_COACH_NAME_LENGTH || nameLength > MAX_COACH_NAME_LENGTH) {
            throw MenuException.from(ErrorMessage.INVALID_COACH_NAME_LENGTH);
        }
    }

    private void validateHateCuisine(List<Cuisine> hateCuisine) {
        validateCount(hateCuisine);
        validateNoDuplicates(hateCuisine);
    }

    private void validateCount(List<Cuisine> hateCuisine) {
        if (hateCuisine.size() > HATE_CUISINE_COUNT_THRESHOLD) {
            throw MenuException.from(ErrorMessage.INVALID_HATE_CUISINE_COUNT);
        }
    }

    private void validateNoDuplicates(List<Cuisine> hateCuisine) {
        Set<Cuisine> uniqueValues = new HashSet<>(hateCuisine);
        if (uniqueValues.size() != hateCuisine.size()) {
            throw MenuException.from(ErrorMessage.DUPLICATE_HATE_CUISINE);
        }
    }

    public String getName() {
        return name;
    }

    public List<Cuisine> getHateCuisine() {
        return hateCuisine;
    }
}
