package lotto.model;

import static lotto.common.ExceptionMessage.DUPLICATE_NUMBER;
import static lotto.common.ExceptionMessage.INVALID_NUMBER_COUNT;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final int SIZE = 6;
    private static final int min = 1;
    private static final int max = 45;
    private final List<Integer> numbers;

    Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto createLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(min, max, SIZE);
        sortAsc(numbers);
        return new Lotto(numbers);
    }

    private static void sortAsc(List<Integer> numbers) {
        numbers.sort(Integer::compare);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int countCorrectWithPrizeNumbers(Set<Integer> prizeNumbers) {
        return (int) this.numbers.stream().filter(prizeNumbers::contains).count();
    }

    private void validate(List<Integer> numbers) {
        validSize(numbers);
        duplicateNumber(numbers);
    }

    private void duplicateNumber(List<Integer> numbers) {
        long size = numbers.stream().distinct().count();
        if (size != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER.getMessage());
        }
    }

    private void validSize(List<Integer> numbers) {
        if (numbers.size() != SIZE) {
            throw new IllegalArgumentException(INVALID_NUMBER_COUNT.getMessage());
        }
    }


}
