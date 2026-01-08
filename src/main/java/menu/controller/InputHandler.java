package menu.controller;

import menu.util.InputValidator;
import menu.view.InputView;

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
}
