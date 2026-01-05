package menu.view;

import java.util.Arrays;
import java.util.List;
import menu.domain.Cuisine;
import menu.exception.ErrorMessage;
import menu.exception.MenuException;

public class InputParser {

    private static final String COMMA_DELIMITER = ",";

    public List<String> parseCoaches(String input) {
        validateNotEmpty(input);

        String[] coachNames = input.split(COMMA_DELIMITER);
        List<String> trimmedNames = trimAll(coachNames);
        validateAllNotEmpty(trimmedNames);

        return trimmedNames;
    }

    public List<Cuisine> parseCuisines(String input) {
        if (input == null || input.trim().isEmpty()) {
            return List.of();
        }

        String[] cuisineNames = input.split(COMMA_DELIMITER);
        List<String> trimmedNames = trimAll(cuisineNames);

        List<String> validNames = trimmedNames.stream()
                .filter(name -> !name.isEmpty())
                .toList();

        return validNames.stream()
                .map(Cuisine::getCuisineWith)
                .toList();
    }

    private void validateNotEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw MenuException.from(ErrorMessage.EMPTY_INPUT);
        }
    }

    private void validateAllNotEmpty(List<String> input) {
        if (input.stream().anyMatch(String::isEmpty)) {
            throw MenuException.from(ErrorMessage.EMPTY_VALUE);
        }
    }

    private List<String> trimAll(String[] input) {
        return Arrays.stream(input)
                .map(String::trim)
                .toList();
    }
}
