package baseball.controller;

import baseball.model.GameResult;
import baseball.service.GameState;
import baseball.service.NumberMatcher;

public class GameController {

    private final InputController inputController;
    private final OutputController outputController;
    private final NumberMatcher numberMatcher;
    private final GameState gameState;

    public GameController(final InputController inputController,
        final OutputController outputController,
        final NumberMatcher numberMatcher, final GameState gameState) {
        this.inputController = inputController;
        this.outputController = outputController;
        this.numberMatcher = numberMatcher;
        this.gameState = gameState;
    }

    public void gameStart() {
        outputController.displayStartGame();
        do {
            playRound();
            inputController.isContinued();
        } while (gameState.isRunning());
    }

    private void playRound() {
        gameState.generateAnswerNumber();
        while (true) {
            inputController.getUserInput();

            GameResult result = numberMatcher.match(
                gameState.getCurrentUserInputNumber().convertToDigits(),
                gameState.getAnswerNumber().answerNumberToList()
            );

            gameState.setCurrentGameResult(result);
            outputController.displayResult();
            if(result.isSuccess()){
                outputController.displayWinningMessage();
                break;
            }
        }
    }

}
