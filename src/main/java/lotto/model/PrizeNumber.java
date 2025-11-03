package lotto.model;

import static lotto.common.ExceptionMessage.NOT_BETWEEN_RANGE_NUMBER;
import static lotto.common.ExceptionMessage.NOT_ENOUGH_NUMBER;
import static lotto.common.ExceptionMessage.NOT_NUMBER;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class PrizeNumber {
    private final int min = 1;
    private final int max = 45;
    private final int SIZE = 6;
    private Set<Integer> prizeNumbers;

    public PrizeNumber(String numbers) {
        setPrizeNumbers(numbers);
    }

    public Set<Integer> getPrizeNumbers() {
        return prizeNumbers;
    }

    private void setPrizeNumbers(String numbers) {
        prizeNumbers = Arrays.stream(splitStrings(numbers))
                .map(String::trim)
                .map(this::parseInt)
                .collect(Collectors.toSet());
        if (prizeNumbers.size() != SIZE) {
            throw new IllegalArgumentException(NOT_ENOUGH_NUMBER.getMessage());
        }
    }

    private int parseInt(String number) {
        try {
            int num = Integer.parseInt(number);
            if (num < min || num > max) {
                throw new IllegalArgumentException(NOT_BETWEEN_RANGE_NUMBER.getMessage());
            }
            return num;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER.getMessage());
        }
    }

    private String[] splitStrings(String numbers) {
        return numbers.split(",");
    }


}
