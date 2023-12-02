package baseball.service;

import static org.junit.jupiter.api.Assertions.*;

import baseball.model.GameResult;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NumberMatcherTest {

    private NumberMatcher matcher;

    @BeforeEach
    void setUp() {
        matcher = new NumberMatcher();
    }

    @Test
    void match_allStrikes() {
        List<Integer> userNumber = Arrays.asList(1, 2, 3);
        List<Integer> answerNumber = Arrays.asList(1, 2, 3);
        GameResult result = matcher.match(userNumber, answerNumber);
        assertEquals(3, result.strikeCount());
        assertEquals(0, result.ballCount());
    }

    @Test
    void match_allBalls() {
        List<Integer> userNumber = Arrays.asList(3, 1, 2);
        List<Integer> answerNumber = Arrays.asList(1, 2, 3);
        GameResult result = matcher.match(userNumber, answerNumber);
        assertEquals(0, result.strikeCount());
        assertEquals(3, result.ballCount());
    }

    @Test
    void match_someStrikes_someBalls() {
        List<Integer> userNumber = Arrays.asList(1, 3, 2);
        List<Integer> answerNumber = Arrays.asList(1, 2, 3);
        GameResult result = matcher.match(userNumber, answerNumber);
        assertEquals(1, result.strikeCount());
        assertEquals(2, result.ballCount());
    }

    @Test
    void match_noStrikes_noBalls(){
        List<Integer> userNumber = Arrays.asList(4,5,6);
        List<Integer> answerNumber = Arrays.asList(1,2,3);
        GameResult result = matcher.match(userNumber, answerNumber);
        assertEquals(0, result.strikeCount());
        assertEquals(0, result.ballCount());
    }
}