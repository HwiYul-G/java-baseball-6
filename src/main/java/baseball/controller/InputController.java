package baseball.controller;

import baseball.model.RestartChoice;
import baseball.model.UserInputNumber;
import baseball.service.GameState;
import baseball.view.InputView;

public class InputController {

    private final InputView inputView;
    private final GameState gameState;

    public InputController(final InputView inputView, final GameState gameState) {
        this.inputView = inputView;
        this.gameState = gameState;
    }

    public void getUserInput() {
        String userInput = inputView.requestUserNumber();
        gameState.setCurrentUserInputNumber(new UserInputNumber(userInput));
    }

    public void isContinued() {
        if (gameState.getCurrentGameResult().isSuccess()) {
            String choice = inputView.requestGameRestart();
            RestartChoice restartChoice = new RestartChoice(choice);
            gameState.setRunning(restartChoice.isContinued());
        }
    }

}
