package menu.util;

import java.util.List;

public class InputValidator {
    public static void validateCoachName(String input) {
        String coachName[] = input.split(",");
        if (coachName.length < 2 || coachName.length > 5) {
            throw new IllegalArgumentException("[ERROR] 코치는 2명 이상 5명 이하로 입력해야 합니다.");
        }
        for (String coach : coachName) {
            if (coach.length() < 2 || coach.length() > 4) {
                throw new IllegalArgumentException("[ERROR] 코치의 이름은 2글자 이상 4글자 이하로 입력해야 합니다.");
            }
        }
    }

    public static void validateMenu(String menu) {
        List<String> japenMenus = MenuManager.getJapenMenus();
        List<String> koreaMenus = MenuManager.getKoreaMenus();
        List<String> chinaMenus = MenuManager.getChinaMenus();
        List<String> asianMenus = MenuManager.getAsianMenus();
        List<String> westernMenus = MenuManager.getWesternMenus();
        String menus[] = menu.split(",");

        if (menus.length < 0 || menus.length > 2) {
            throw new IllegalArgumentException("[ERROR] 메뉴는 0개 이상 2개 이하로 입력해야 합니다.");
        }
        for (String oneMenu : menus) {
            if (!(japenMenus.contains(oneMenu) || koreaMenus.contains(oneMenu) || chinaMenus.contains(oneMenu) || asianMenus.contains(oneMenu) || westernMenus.contains(oneMenu))) {
                throw new IllegalArgumentException("[ERROR] 올바른 메뉴 이름을 입력해야 합니다.");
            }
        }
    }
}
