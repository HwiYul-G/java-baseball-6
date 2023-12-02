package baseball.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class UserInputNumberTest {

    @DisplayName("3글자가 아닌 경우")
    @ParameterizedTest
    @ValueSource(strings = {"1234", "11"})
    void testInvalidInputLength(String input) {
        assertThatThrownBy(
            () -> new UserInputNumber(input)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복된 숫자가 존재하는 경우")
    @ParameterizedTest
    @ValueSource(strings = {"112", "121", "111"})
    void testDuplication(String input) {
        assertThatThrownBy(
            () -> new UserInputNumber(input)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1과 9 외의 범위가 들어가는 경우")
    @Test
    void testInvalidDigitRange() {
        assertThatThrownBy(
            () -> new UserInputNumber("901")
        ).isInstanceOf(IllegalArgumentException.class);
    }

}