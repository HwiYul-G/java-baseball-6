package baseball.model;

import baseball.utils.ExceptionMessage;
import java.util.List;
import java.util.stream.Collectors;

public record UserInputNumber(String userInputNumber) {

    private static final int NUMBER_SIZE = 3;

    public UserInputNumber {
        validate(userInputNumber);
    }

    private void validate(final String userInputNumber) {
        validateLength(userInputNumber);
        validateDigit(userInputNumber);
        validateDuplication(userInputNumber);
    }

    private void validateLength(final String userInputNumber) {
        if (userInputNumber.length() != NUMBER_SIZE) {
            throw new IllegalArgumentException(
                ExceptionMessage.INVALID_NUMBER_SIZE_MESSAGE.getMessage());
        }
    }

    private void validateDigit(final String userInputNumber) {
        if (!userInputNumber.chars()
            .allMatch(ch -> Character.isDigit(ch) && ch >= '1' && ch <= '9')) {
            throw new IllegalArgumentException(
                ExceptionMessage.NON_DIGIT_ERROR_MESSAGE.getMessage()
            );
        }
    }

    private void validateDuplication(final String userInputNumber) {
        long uniqueCount = userInputNumber.chars()
            .distinct()
            .count();
        if (uniqueCount != NUMBER_SIZE) {
            throw new IllegalArgumentException(
                ExceptionMessage.DUPLICATION_ERROR_MESSAGE.getMessage()
            );
        }
    }

    public List<Integer> convertToDigits() {
        return userInputNumber().chars()
            .mapToObj(ch -> Character.digit(ch, 10))
            .collect(Collectors.toList());
    }
}
