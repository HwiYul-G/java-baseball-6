package baseball.service;

import baseball.model.GameResult;
import java.util.List;

public class NumberMatcher {

    private static final int NUMBER_SIZE = 3;

    public GameResult match(final List<Integer> userNumber, final List<Integer> answerNumber) {
        GameResult result = new GameResult();

        for (int i = 0; i < NUMBER_SIZE; i++) {
            boolean isStrike = userNumber.get(i).equals(answerNumber.get(i));
            if (isStrike) {
                result = result.incrementStrike();
            }
            if (!isStrike && answerNumber.contains(userNumber.get(i))) {
                result = result.incrementBall();
            }
        }

        return result;
    }

}
