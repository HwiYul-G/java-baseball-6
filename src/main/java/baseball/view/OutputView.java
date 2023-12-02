package baseball.view;

public class OutputView {

    private enum OutputConsoleMessage {

        START_GAME_MESSAGE("숫자 야구 게임을 시작합니다."),
        WINNING_MESSAGE("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),

        BALL_AND_STRIKE("%d볼 %d스트라이크\n"),
        BALL("%d볼\n"),
        STRIKE("%d스트라이크\n"),
        NOTHING("낫싱\n");

        private final String message;

        OutputConsoleMessage(final String message) {
            this.message = message;
        }

        public String getMessage() {
            return this.message;
        }
    }

    public void displayStartGame() {
        System.out.println(OutputConsoleMessage.START_GAME_MESSAGE.getMessage());
    }

    public void displayResult(int balls, int strikes) {
        String message = OutputConsoleMessage.NOTHING.getMessage();
        if (balls > 0 && strikes > 0) {
            message = String.format(OutputConsoleMessage.BALL_AND_STRIKE.getMessage(), balls,
                strikes);
        }
        if (balls > 0 && strikes == 0) {
            message = String.format(OutputConsoleMessage.BALL.getMessage(), balls);
        }
        if (strikes > 0 && balls == 0) {
            message = String.format(OutputConsoleMessage.STRIKE.getMessage(), strikes);
        }
        System.out.print(message);
    }

    public void displayWinningMessage() {
        System.out.println(OutputConsoleMessage.WINNING_MESSAGE.getMessage());
    }

}
