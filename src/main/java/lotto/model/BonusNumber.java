package lotto.model;

import static lotto.common.ExceptionMessage.DUPLICATE_NUMBER;
import static lotto.common.ExceptionMessage.NOT_BETWEEN_RANGE_NUMBER;
import static lotto.common.ExceptionMessage.NOT_NUMBER;

import java.util.List;

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

    public boolean contains(List<Integer> numbers) {
        return numbers.contains(this.number);
    }

    public int getNumber() {
        return number;
    }

    private int parse(String number) {
        int result = parseInt(number);
        validBetweenNumber(result);
        return result;
    }

    private int parseInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER.getMessage());
        }
    }

    private void validBetweenNumber(int number) {
        if (number < min || number > max) {
            throw new IllegalArgumentException(NOT_BETWEEN_RANGE_NUMBER.getMessage());
        }
    }
}
