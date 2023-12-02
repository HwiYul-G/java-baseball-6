package baseball.service;

import baseball.model.AnswerNumber;
import baseball.model.GameResult;
import baseball.model.UserInputNumber;

public class GameState {
    private boolean isStartRound;
    private AnswerNumber answerNumber;
    private boolean isRunning;
    private UserInputNumber currentUserInputNumber;
    private GameResult currentGameResult;

    public GameState(){
        this.isRunning = true;
        this.isStartRound = true;
    }

    public void generateAnswerNumber(){
        this.answerNumber = new AnswerNumber();
    }

    public AnswerNumber getAnswerNumber() {
        return answerNumber;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public UserInputNumber getCurrentUserInputNumber() {
        return currentUserInputNumber;
    }

    public GameResult getCurrentGameResult() {
        return currentGameResult;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    public void setCurrentUserInputNumber(UserInputNumber currentUserInputNumber) {
        this.currentUserInputNumber = currentUserInputNumber;
    }

    public void setCurrentGameResult(GameResult currentGameResult) {
        this.currentGameResult = currentGameResult;
    }

    public boolean isStartRound() {
        return isStartRound;
    }

    public void setStartRound(boolean startRound) {
        isStartRound = startRound;
    }
}
