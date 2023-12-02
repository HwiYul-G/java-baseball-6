package baseball.controller;

import baseball.model.RestartChoice;
import baseball.model.UserInputNumber;
import baseball.view.InputView;

public class InputController {

    private final InputView inputView;

    public InputController(final InputView inputView) {
        this.inputView = inputView;
    }

    public UserInputNumber getUserInput() {
        String userInput = inputView.requestUserNumber();
        return new UserInputNumber(userInput);
    }

    public boolean isContinued() {
        String choice = inputView.requestGameRestart();
        RestartChoice restartChoice = new RestartChoice(choice);
        return restartChoice.isContinued();
    }

}
