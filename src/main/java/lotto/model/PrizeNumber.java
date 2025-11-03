package lotto.model;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class PrizeNumber {
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
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
    }

    private String[] splitStrings(String numbers) {
        return numbers.split(",");
    }


}
