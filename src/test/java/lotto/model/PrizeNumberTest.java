package lotto.model;

import static lotto.common.ExceptionMessage.NOT_BETWEEN_RANGE_NUMBER;
import static lotto.common.ExceptionMessage.NOT_NUMBER;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PrizeNumberTest {

    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 4, 5, 6", "23, 24, 25, 2, 3, 4", "1, 2, 3,4,5, 6"})
    public void 정상_당첨_번호가_들어온_경우(String numbers) {
        // given

        // when
        PrizeNumber prizeNumber = new PrizeNumber(numbers);
        Set<Integer> result = prizeNumber.getPrizeNumbers();

        // then
        Set<Integer> expected = Arrays.stream(numbers.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toSet());

        Assertions.assertThat(result).containsExactlyInAnyOrderElementsOf(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 333, 4, 5, 6", "23, -1, 25, 2, 3, 4", "1, 2, 0,4,5, 6"})
    public void 예외_1부터_45_범위가_아닌_숫자인_경우(String numbers) {
        // given

        // when

        // then
        Assertions.assertThatThrownBy(() -> new PrizeNumber(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_BETWEEN_RANGE_NUMBER.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 4, 5, a", "23, , 25, 2, 3, 4", "1, 2/ 3,4,5, 6"})
    public void 예외_문자일_경우(String numbers) {
        // given

        // when

        // then
        Assertions.assertThatThrownBy(() -> new PrizeNumber(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_NUMBER.getMessage());
    }
}
