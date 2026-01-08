package menu.controller;

import menu.util.InputValidator;
import menu.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class InputHandler {
    public static String getCoachName() {
        while (true) {
            String input = InputView.readLine("점심 메뉴 추천을 시작합니다.\n\n" + "코치의 이름을 입력해 주세요. (, 로 구분)");
            try {
                InputValidator.validateCoachName(input);
                return input;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static List<List<String>> getMenu(String coachName) {
        String[] coaches = coachName.split(",");
        List<List<String>> coachMenuList = new ArrayList<>();

        for (String coach : coaches) {
            while (true) {
                String input = InputView.readLine("\n" + coach + "(이)가 못 먹는 메뉴를 입력해 주세요.");
                try {
                    List<String> bundle = validateAndConversionMenu(coach, input);
                    coachMenuList.add(bundle);
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return coachMenuList;
    }

    private static List<String> validateAndConversionMenu(String coach, String menu) {
        InputValidator.validateMenu(menu);
        List<String> coachAndMenuBundle = new ArrayList<>();
        coachAndMenuBundle.add(coach);

        String[] menus = menu.split(",");
        for (String oneMenu : menus) {
            coachAndMenuBundle.add(oneMenu);
        }
        return coachAndMenuBundle;
    }
}
