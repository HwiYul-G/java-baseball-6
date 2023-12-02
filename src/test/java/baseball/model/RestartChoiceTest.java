package baseball.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RestartChoiceTest {

    @DisplayName("1과 2 외의 값이 들어간 경우 - IllegalArgumentException 처리 된다.")
    @ParameterizedTest
    @ValueSource(strings = {"3", "4", "-1", "5"})
    void testInvalidChoice(String input) {
        assertThatThrownBy(
            () -> new RestartChoice(input)
        ).isInstanceOf(IllegalArgumentException.class);
    }

}