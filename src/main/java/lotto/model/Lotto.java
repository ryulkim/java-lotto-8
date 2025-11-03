package lotto.model;

import static lotto.common.ExceptionMessage.INVALID_NUMBER_COUNT;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

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
        return new Lotto(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }


    private void validate(List<Integer> numbers) {
        validSize(numbers);
    }

    private void validSize(List<Integer> numbers) {
        if (numbers.size() != SIZE) {
            throw new IllegalArgumentException(INVALID_NUMBER_COUNT.getMessage());
        }
    }


}
