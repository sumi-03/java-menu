package menu.controller;

import menu.util.InputValidator;
import menu.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class InputHandler {
    public static String getCoachName() {
        while (true) {
            String input = InputView.readLine("점심 메뉴 추천을 시작합니다.\n" + "\n" + "코치의 이름을 입력해 주세요. (, 로 구분)");
            try {
                InputValidator.validateCoachName(input);
                return input;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void getMenu(String coachName) {
        String coachs[] = coachName.split(",");
        List<List<String>> coachMenuList = new ArrayList<>();
        for (String coach : coachs) {
            while (true) {
                String input = InputView.readLine(coach + "(이)가 못 먹는 메뉴를 입력해 주세요.");
                coachMenuList.add(validateAndConversionMenu(coach, input));
            }
        }
    }

    private static List<String> validateAndConversionMenu(String coach, String menu) {
        List<String> coachAndMenuBundle = new ArrayList<>();
        coachAndMenuBundle.add(coach);
        try {
            InputValidator.validateMenu(menu);
            String menus[] = menu.split(",");
            for (String oneMenu : menus) {
                coachAndMenuBundle.add(oneMenu);
            }
            return coachAndMenuBundle;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return coachAndMenuBundle;
    }
}
