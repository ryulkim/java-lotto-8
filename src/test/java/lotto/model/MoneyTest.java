package lotto.model;

import static lotto.common.ExceptionMessage.EXCEED_INTEGER;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

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
}
