package menu.view;

import java.util.ArrayList;
import java.util.List;
import menu.domain.Cuisine;

public class InputParser {

    private static final String DELIMITER = ",";

    public List<String> parseCoaches(String input) {
        String[] coachNames = input.split(DELIMITER);
        return List.of(coachNames);
    }

    public List<Cuisine> parseCuisines(String input) {
        List<Cuisine> cuisines = new ArrayList<>();

        if (input.trim().isEmpty()) {
            return cuisines;
        }

        String[] cuisineNames = input.split(DELIMITER);
        for (String cuisineName : cuisineNames) {
            cuisineName = cuisineName.trim();
            if (!cuisineName.isEmpty()) {
                Cuisine cuisine = Cuisine.getCuisineWith(cuisineName);
                cuisines.add(cuisine);
            }
        }

        return cuisines;
    }
}
