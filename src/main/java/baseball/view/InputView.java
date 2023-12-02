package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private enum InputConsoleMessage {
        USER_NUMBER_INPUT("숫자를 입력해주세요 : "),
        RESTART_OR_NOT("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        private final String message;

        InputConsoleMessage(final String message) {
            this.message = message;
        }

        public String getMessage() {
            return this.message;
        }
    }

    public String requestUserNumber() {
        System.out.print(InputConsoleMessage.USER_NUMBER_INPUT.getMessage());
        return Console.readLine();
    }

    public String requestGameRestart() {
        System.out.println(InputConsoleMessage.RESTART_OR_NOT.getMessage());
        return Console.readLine();
    }

}
