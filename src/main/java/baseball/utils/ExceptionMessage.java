package baseball.utils;

public enum ExceptionMessage {
    INVALID_RESTART_OR_NOT_MESSAGE("1또는 2만 입력 가능합니다."),
    INVALID_NUMBER_SIZE_MESSAGE("입력 숫자는 세자리 수만 가능합니다."),
    NON_DIGIT_ERROR_MESSAGE("입력 값이 숫자가 아닙니다."),
    DUPLICATION_ERROR_MESSAGE("입력 값에 중복된 값이 있습니다.");

    public static final String BASE_MESSAGE = "[ERROR] %s";
    private final String message;

    ExceptionMessage(final String message){
        this.message = String.format(BASE_MESSAGE, message);
    }

    public String getMessage(){
        return message;
    }
}

