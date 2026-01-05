package menu.exception;

public enum ErrorMessage {

    EMPTY_INPUT("입력값이 비어있습니다."),
    EMPTY_VALUE("빈 값은 입력할 수 없습니다."),

    NOT_EXIST_CUISINE("존재하지 않는 메뉴입니다."),

    INVALID_COACH_NAME_LENGTH("코치의 이름은 2이상 4이하 여야 합니다."),
    INVALID_HATE_CUISINE_COUNT("각 코치의 못먹은 메뉴의 수가 2개 이하 여야 합니다."),
    INVALID_NUMBER_OF_COACHES_AT_LUNCH("점심 식사 하는 코치의 수가 2명 이상 5명 이하 여야 합니다."),
    ;

    private static final String PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = PREFIX + message;
    }

    public String getMessage() {
        return message;
    }
}
