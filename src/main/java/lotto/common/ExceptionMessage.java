package lotto.common;

public enum ExceptionMessage {
    EXCEED_INTEGER("Integer 범위를 초과했습니다."),
    BELOW_MIN("최솟값보다 더 작습니다."),
    NOT_DIVIDE_THOUSAND("1000으로 나누어 떨어지는 값이어야 합니다."),
    NOT_NUMBER("숫자를 입력해야 합니다."),
    NOT_BETWEEN_RANGE_NUMBER("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    NOT_ENOUGH_NUMBER("숫자 개수가 충분하지 않습니다. 중복 없이 6개여야 합니다."),
    DUPLICATE_NUMBER("숫자가 중복될 수 없습니다."),
    INVALID_NUMBER_COUNT("로또 번호는 6개여야 합니다."),
    ;


    private final String message;

    ExceptionMessage(String message) {
        this.message = "[ERROR] " + message;
    }

    public String getMessage() {
        return message;
    }
}
