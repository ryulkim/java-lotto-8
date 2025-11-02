package lotto.common;

public enum ExceptionMessage {
    EXCEED_INTEGER("Integer 범위를 초과했습니다.");
    
    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
