package lotto.model;

import static lotto.common.ExceptionMessage.DUPLICATE_NUMBER;
import static lotto.common.ExceptionMessage.NOT_BETWEEN_RANGE_NUMBER;
import static lotto.common.ExceptionMessage.NOT_NUMBER;

public class BonusNumber {
    private final int min = 1;
    private final int max = 45;
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
            int result = Integer.parseInt(number);
            validBetweenNumber(result);
            return result;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER.getMessage());
        }
    }

    private int parseInt(String number) {
        return Integer.parseInt(number);
    }

    private void validBetweenNumber(int number) {
        if (number < min || number > max) {
            throw new IllegalArgumentException(NOT_BETWEEN_RANGE_NUMBER.getMessage());
        }
    }
}
