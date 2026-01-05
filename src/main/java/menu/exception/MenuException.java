package menu.exception;

public class MenuException extends IllegalArgumentException {

    private MenuException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
    }

    public static MenuException from(ErrorMessage errorMessage) {
        return new MenuException(errorMessage);
    }
}
