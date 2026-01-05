package menu.view;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import menu.domain.Coach;
import menu.domain.Cuisine;
import menu.domain.cuisine.CuisineType;

public class OutputView {

    private static final String NEW_LINE = System.lineSeparator();

    private static final String LUNCH_RECOMMENDATION_HEADER = "점심 메뉴 추천을 시작합니다.";

    private static final String LUNCH_RECOMMENDATION_RESULT_HEADER = "메뉴 추천 결과입니다.";
    private static final String LUNCH_RECOMMENDATION_RESULT_DATE =
            "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]";
    private static final String LUNCH_RECOMMENDATION_CUISINE_TYPE =
            "[ 카테고리 | %s | %s | %s | %s | %s ]%n";
    private static final String LUNCH_RECOMMENDATION_MENUS_OF_COACH =
            "[ %s | %s | %s | %s | %s | %s ]%n";

    private static final String LUNCH_RECOMMENDATION_RESULT_TAIL = "추천을 완료했습니다.";

    public void printMenuRecommendHeader() {
        System.out.println(LUNCH_RECOMMENDATION_HEADER);
        printNewLine();
    }

    public void printMenuRecommendResultHeader() {
        System.out.println(LUNCH_RECOMMENDATION_RESULT_HEADER);
    }

    public void printMenuRecommendResult(List<CuisineType> cuisineTypes, Map<Coach, List<Cuisine>> menusByCoach) {
        System.out.println(LUNCH_RECOMMENDATION_RESULT_DATE);
        System.out.printf(LUNCH_RECOMMENDATION_CUISINE_TYPE,
                cuisineTypes.get(0).getName(), cuisineTypes.get(1).getName(), cuisineTypes.get(2).getName(),
                cuisineTypes.get(3).getName(), cuisineTypes.get(4).getName());

        for (Entry<Coach, List<Cuisine>> entry : menusByCoach.entrySet()) {
            String coachName = entry.getKey().getName();
            List<Cuisine> cuisines = entry.getValue();
            System.out.printf(LUNCH_RECOMMENDATION_MENUS_OF_COACH,
                    coachName,
                    cuisines.get(0).getName(), cuisines.get(1).getName(), cuisines.get(2).getName(),
                    cuisines.get(3).getName(), cuisines.get(4).getName());
        }
    }

    public void printMenuRecommendResultTail() {
        printNewLine();
        System.out.println(LUNCH_RECOMMENDATION_RESULT_TAIL);
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }

    public void printNewLine() {
        System.out.printf(NEW_LINE);
    }
}
