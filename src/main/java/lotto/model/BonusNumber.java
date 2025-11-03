package lotto.model;

import static lotto.common.ExceptionMessage.DUPLICATE_NUMBER;
import static lotto.common.ExceptionMessage.NOT_NUMBER;

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
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER.getMessage());
        }
    }

    private int parseInt(String number) {
        return Integer.parseInt(number);
    }
}
