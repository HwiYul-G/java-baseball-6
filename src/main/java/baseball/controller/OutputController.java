package baseball.controller;

import baseball.model.GameResult;
import baseball.service.GameState;
import baseball.view.OutputView;

public class OutputController {

    private final OutputView outputView;
    private final GameState gameState;

    public OutputController(final OutputView outputView, final GameState gameState) {
        this.outputView = outputView;
        this.gameState = gameState;
    }


    public void displayStartGame() {
        if (gameState.isStartRound()) {
            outputView.displayStartGame();
            gameState.setStartRound(false);
        }
    }

    public void displayResult() {
        GameResult currentGameResult = gameState.getCurrentGameResult();
        if (currentGameResult != null) {
            outputView.displayResult(currentGameResult.ballCount(),
                currentGameResult.strikeCount());
        }
    }

    public void displayWinningMessage() {
        outputView.displayWinningMessage();
        gameState.setStartRound(true);

    }

}
