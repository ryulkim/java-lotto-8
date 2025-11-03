package lotto.common;

public enum Message {
    INPUT_MONEY("구입금액을 입력해 주세요."),
    INPUT_PRIZE_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    OUTPUT_PURCHASE("개를 구매했습니다.");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
