package baseball.controller;

import baseball.model.AnswerNumber;
import baseball.model.GameResult;
import baseball.model.UserInputNumber;
import baseball.service.NumberMatcher;

public class GameController {

    private final InputController inputController;
    private final OutputController outputController;
    private final NumberMatcher numberMatcher;

    public GameController(final InputController inputController,
        final OutputController outputController, final NumberMatcher numberMatcher) {
        this.inputController = inputController;
        this.outputController = outputController;
        this.numberMatcher = numberMatcher;
    }

    public void gameStart() {
        outputController.displayStartGame();
        do {
            playRound();
        } while (inputController.isContinued());
    }

    private void playRound() {
        AnswerNumber answerNumber = new AnswerNumber();
        while (true) {
            UserInputNumber userInputNumber = inputController.getUserInput();

            GameResult result = numberMatcher
                .match(userInputNumber.convertToDigits(), answerNumber.answerNumberToList());

            outputController.displayResult(result);

            if (result.isSuccess()) {
                outputController.displayStartGame();
                break;
            }
        }
    }


}
