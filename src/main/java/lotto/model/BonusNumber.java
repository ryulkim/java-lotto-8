package lotto.model;

import static lotto.common.ExceptionMessage.DUPLICATE_NUMBER;

public class BonusNumber {
    private int number;

    public BonusNumber(String number, PrizeNumber prizeNumber) {
        this.number = parse(number);
        if (prizeNumber.contains(this.number)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER.getMessage());
        }
    }

    public int getNumber() {
        return number;
    }

    private int parse(String number) {
        return parseInt(number);
    }

    private int parseInt(String number) {
        return Integer.parseInt(number);
    }
}
