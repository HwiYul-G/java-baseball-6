package baseball.model;

public record GameResult(int ballCount, int strikeCount) {

    public GameResult() {
        this(0,0);
    }

    public GameResult incrementBall() {
        return new GameResult(ballCount + 1, strikeCount);
    }

    public GameResult incrementStrike() {
        return new GameResult(ballCount, strikeCount + 1);
    }

    public boolean isSuccess() {
        return strikeCount == 3;
    }

}
