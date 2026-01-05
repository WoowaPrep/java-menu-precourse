package menu;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import menu.domain.Coach;
import menu.domain.Coachs;
import menu.domain.Cuisine;
import menu.domain.cuisine.CuisineType;
import menu.view.InputParser;
import menu.view.InputView;
import menu.view.OutputView;

public class LunchMenu {

    private InputView inputView;
    private OutputView outputView;
    private InputParser inputParser;

    public LunchMenu() {
        this(new InputView(), new OutputView(), new InputParser());
    }

    public LunchMenu(InputView inputView, OutputView outputView, InputParser inputParser) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.inputParser = inputParser;
    }

    public void recommend() {
        printMenuRecommendHeader();

        List<String> coachNames = readCoachNames();
        Map<String, List<Cuisine>> hateCuisinesByCoach = readCoachHateCuisines(coachNames);
        Coachs coachs = createCoaches(hateCuisinesByCoach);

        printMenuRecommendResult(coachs);
    }

    private void printMenuRecommendHeader() {
        outputView.printMenuRecommendHeader();
    }

    private List<String> readCoachNames() {
        return retry(() -> {
            String coachesInput = inputView.readCoachNames();
            outputView.printNewLine();
            return inputParser.parseCoaches(coachesInput);
        });
    }

    private Map<String, List<Cuisine>> readCoachHateCuisines(List<String> coaches) {
        return retry(() -> {
            Map<String, List<Cuisine>> hateCuisinesByCoach = new LinkedHashMap<>();
            int coachCount = coaches.size();

            IntStream.range(0, coachCount).forEach(i -> {
                String coachName = coaches.get(i);
                String hateCuisinesInput = inputView.readHateCuisines(coachName);
                outputView.printNewLine();
                List<Cuisine> cuisines = inputParser.parseCuisines(hateCuisinesInput);
                hateCuisinesByCoach.put(coachName, cuisines);
            });

            return hateCuisinesByCoach;
        });
    }

    private Coachs createCoaches(Map<String, List<Cuisine>> hateCuisinesByCoach) {
        List<Coach> coaches = new ArrayList<>();

        for (Entry<String, List<Cuisine>> entry : hateCuisinesByCoach.entrySet()) {
            String coachName = entry.getKey();
            List<Cuisine> hateCuisines = entry.getValue();
            Coach coach = new Coach(coachName, hateCuisines);
            coaches.add(coach);
        }

        return new Coachs(coaches);
    }

    private void printMenuRecommendResult(Coachs coachs) {
        List<CuisineType> cuisineTypes = CuisineType.createCuisineTypes();
        Map<Coach, List<Cuisine>> MenusByCoach = coachs.createMenus(cuisineTypes);

        outputView.printMenuRecommendResultHeader();
        outputView.printMenuRecommendResult(cuisineTypes, MenusByCoach);
        outputView.printMenuRecommendResultTail();
    }

    private <T> T retry(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
