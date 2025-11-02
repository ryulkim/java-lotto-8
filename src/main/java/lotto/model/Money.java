package lotto.model;

import static lotto.common.ExceptionMessage.BELOW_MIN;
import static lotto.common.ExceptionMessage.EXCEED_INTEGER;

public class Money {
    private final int money;
    private final int MIN = 1000;

    public Money(String amount) {
        money = parseInt(amount);
    }

    private int parseInt(String amount) {
        try {
            long num = Long.parseLong(amount);
            validInt(num);
            validMin(num);
            return (int) num;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e);
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
