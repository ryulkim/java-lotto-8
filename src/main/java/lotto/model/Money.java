package lotto.model;

import static lotto.common.ExceptionMessage.EXCEED_INTEGER;

public class Money {
    private final int money;

    public Money(String amount) {
        money = parseInt(amount);
    }

    private int parseInt(String amount) {
        try {
            long num = Long.parseLong(amount);
            validInt(num);
            return Integer.parseInt(amount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private void validInt(long num) {
        if (num > Integer.MAX_VALUE) {
            throw new IllegalArgumentException(EXCEED_INTEGER.getMessage());
        }
    }
}
