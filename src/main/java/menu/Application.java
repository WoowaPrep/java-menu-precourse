package menu;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        try {
            new LunchMenu().recommend();
        } finally {
            Console.close();
        }
    }
}
