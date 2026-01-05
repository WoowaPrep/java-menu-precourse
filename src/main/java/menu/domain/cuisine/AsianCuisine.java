package menu.domain.cuisine;

import menu.domain.Cuisine;

public enum AsianCuisine implements Cuisine {

    PAD_THAI("팟타이"),
    KAO_POD("카오 팟"),
    NASI_GORENG("나시고렝"),
    PINEAPPLE_FRIED_RICE("파인애플 볶음밥"),
    RICE_NOODLE("쌀국수"),
    TOM_YUM_GOONG("똠얌꿍"),
    BANH_MI("반미"),
    SPRING_ROLL("월남쌈"),
    BUNCHA("분짜"),
    ;

    private final String name;

    AsianCuisine(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
