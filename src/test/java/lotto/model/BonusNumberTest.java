package lotto.model;

import static lotto.common.ExceptionMessage.DUPLICATE_NUMBER;

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
}
