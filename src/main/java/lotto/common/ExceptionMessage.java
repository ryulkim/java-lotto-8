package lotto.common;

public enum ExceptionMessage {
    EXCEED_INTEGER("Integer 범위를 초과했습니다."),
    BELOW_MIN("최솟값보다 더 작습니다."),
    NOT_DIVIDE_THOUSAND("1000으로 나누어 떨어지는 값이어야 합니다."),
    NOT_NUMBER("숫자를 입력해야 합니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
