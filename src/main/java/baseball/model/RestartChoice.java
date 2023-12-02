package baseball.model;

import baseball.utils.ExceptionMessage;

public record RestartChoice(String choice) {

    private static final String RESTART = "1";
    private static final String QUIT = "2";

    public RestartChoice {
        validate(choice);
    }

    private void validate(final String choice) {
        if (!choice.equals(QUIT) && !choice.equals(RESTART)) {
            throw new IllegalArgumentException(
                ExceptionMessage.INVALID_RESTART_OR_NOT_MESSAGE.getMessage());
        }
    }

    public boolean isContinued() {
        return choice().equals(RESTART);
    }

}
