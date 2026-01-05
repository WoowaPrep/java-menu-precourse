package menu.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private final static String COACH_NAMES_INPUT_MESSAGE = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private final static String HATE_CUISINES_INPUT_MESSAGE = "%s(이)가 못 먹는 메뉴를 입력해 주세요.%n";

    public String readCoachNames() {
        System.out.println(COACH_NAMES_INPUT_MESSAGE);
        return readLine();
    }

    public String readHateCuisines(String name) {
        System.out.printf(HATE_CUISINES_INPUT_MESSAGE, name);
        return readLine();
    }

    private String readLine() {
        return Console.readLine();
    }
}
