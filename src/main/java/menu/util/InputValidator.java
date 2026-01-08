package menu.util;

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
}
