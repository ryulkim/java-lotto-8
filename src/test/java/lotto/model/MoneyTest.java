package lotto.model;

import static lotto.common.ExceptionMessage.BELOW_MIN;
import static lotto.common.ExceptionMessage.EXCEED_INTEGER;
import static lotto.common.ExceptionMessage.NOT_DIVIDE_THOUSAND;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MoneyTest {
    @Test
    public void 예외_Integer_범위를_넘을_경우() {
        // given
        String amount = "3000000000";

        // when

        // then
        assertThatThrownBy(() -> new Money(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(EXCEED_INTEGER.getMessage());

    }

    @Test
    public void 예외_최소_미만일_경우() {
        // given
        String amount = "999";

        // when

        // then
        assertThatThrownBy(() -> new Money(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BELOW_MIN.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"2999", "10001"})
    public void 예외_1000으로_나누어_떨어지지_않을_경우(String amount) {
        // given

        // when

        // then
        assertThatThrownBy(() -> new Money(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_DIVIDE_THOUSAND.getMessage());
    }
}
