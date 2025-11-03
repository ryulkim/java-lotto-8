package lotto.model;

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
        BonusNumber bonusNumber = new BonusNumber(number);

        // then
        Assertions.assertThat(bonusNumber.getNumber()).isEqualTo(Integer.parseInt(number));
    }
}
