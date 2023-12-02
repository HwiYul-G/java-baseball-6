package baseball.controller;

import baseball.model.GameResult;
import baseball.view.OutputView;

public class OutputController {

    private final OutputView outputView;

    public OutputController(final OutputView outputView) {
        this.outputView = outputView;
    }

    public void displayStartGame(){
        outputView.displayStartGame();
    }

    public void displayResult(final GameResult result){
        outputView.displayResult(result.ballCount(), result.strikeCount());
        if(result.isSuccess()){
            outputView.displayWinningMessage();
        }
    }

}
