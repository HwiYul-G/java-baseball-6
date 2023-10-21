package baseball.controller;

import baseball.model.AnswerNumber;
import baseball.model.GameResult;
import baseball.model.UserNumber;
import baseball.service.NumberMatcher;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {

    private AnswerNumber answerNumber;
    private NumberMatcher numberMatcher;
    private InputView inputView;
    private OutputView outputView;

    public GameController() {
        this.numberMatcher = new NumberMatcher();
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void gameStart() {
        outputView.displayStartGame();

        do {
            initializeAnswerNumber();
            playRound();
        } while (isContinued());
    }

    private void playRound() {
        while (true) {
            String userInput = inputView.requestUserNumber();
            UserNumber userNumber = new UserNumber(userInput);

            GameResult result = numberMatcher.match(userNumber.getUserNumber(),
                answerNumber.getAnswerNumber());

            if (result.isSuccess()) {
                outputView.displayWinningMessage();
                break;
            }

            outputView.displayResult(result.getBallCount(), result.getStrikeCount());

        }
    }

    private void initializeAnswerNumber() {
        this.answerNumber = new AnswerNumber();
    }

    private boolean isContinued() {
        int choice = inputView.requestGameRestart();
        return choice == 1;
    }


}
