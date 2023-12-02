package baseball;

import baseball.controller.GameController;
import baseball.controller.InputController;
import baseball.controller.OutputController;
import baseball.service.NumberMatcher;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        InputController inputController = new InputController(inputView);
        OutputController outputController = new OutputController(outputView);

        // Service
        NumberMatcher numberMatcher = new NumberMatcher();

        GameController gameController = new GameController(inputController, outputController, numberMatcher);

        gameController.gameStart();
    }
}
