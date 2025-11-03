package lotto.model;

import static lotto.common.ExceptionMessage.DUPLICATE_NUMBER;
import static lotto.common.ExceptionMessage.NOT_BETWEEN_RANGE_NUMBER;
import static lotto.common.ExceptionMessage.NOT_NUMBER;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BonusNumberTest {

    static PrizeNumber prizeNumber;

    @BeforeAll
    public static void setUp() {
        prizeNumber = new PrizeNumber("1,2,3,4,5,6");
    }

    @ParameterizedTest
    @ValueSource(strings = {"43", "23"})
    public void 정상_보너스_번호_입력(String number) {
        // given

        // when
        BonusNumber bonusNumber = new BonusNumber(number, prizeNumber);

        // then
        Assertions.assertThat(bonusNumber.getNumber()).isEqualTo(Integer.parseInt(number));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "6"})
    public void 예외_당첨_번호랑_중복된_경우(String number) {
        // given

        // when

        // then
        Assertions.assertThatThrownBy(() -> new BonusNumber(number, prizeNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATE_NUMBER.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", " ", "", "/"})
    public void 예외_숫자가_아닌_경우(String number) {
        // given

        // when

        // then
        Assertions.assertThatThrownBy(() -> new BonusNumber(number, prizeNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_NUMBER.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"46", "1000", "-1", "0"})
    public void 예외_1부터_45_사이의_숫자가_아닐_경우(String number) {
        // given

        // when

        // then
        Assertions.assertThatThrownBy(() -> new BonusNumber(number, prizeNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_BETWEEN_RANGE_NUMBER.getMessage());
    }
}
