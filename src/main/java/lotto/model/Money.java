package lotto.model;

import static lotto.common.ExceptionMessage.BELOW_MIN;
import static lotto.common.ExceptionMessage.EXCEED_INTEGER;
import static lotto.common.ExceptionMessage.NOT_DIVIDE_THOUSAND;
import static lotto.common.ExceptionMessage.NOT_NUMBER;

public class Money {
    private final int money;
    private final int MIN = 1000;
    private final int DIVIDE = 1000;

    public Money(String amount) {
        money = parseInt(amount);
    }

    public int getMoney() {
        return money;
    }

    private int parseInt(String amount) {
        try {
            long num = Long.parseLong(amount);
            validInt(num);
            validMin(num);
            validDivide(num);
            return (int) num;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER.getMessage());
        }
    }

    private void validDivide(long num) {
        if (num % DIVIDE != 0) {
            throw new IllegalArgumentException(NOT_DIVIDE_THOUSAND.getMessage());
        }
    }

    private void validMin(long num) {
        if (num < MIN) {
            throw new IllegalArgumentException(BELOW_MIN.getMessage());
        }
    }

    private void validInt(long num) {
        if (num > Integer.MAX_VALUE) {
            throw new IllegalArgumentException(EXCEED_INTEGER.getMessage());
        }
    }
}
