package baseball;

import baseball.controller.GameController;
import baseball.controller.InputController;
import baseball.controller.OutputController;
import baseball.service.GameState;
import baseball.service.NumberMatcher;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        GameState gameState = new GameState();
        NumberMatcher numberMatcher = new NumberMatcher();

        InputController inputController = new InputController(inputView, gameState);
        OutputController outputController = new OutputController(outputView,gameState);

        GameController gameController = new GameController(inputController, outputController, numberMatcher, gameState);
        gameController.gameStart();
    }
}
