package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    @Test
    public void 정상_로또_번호_생성() {
        // given

        // when
        List<Integer> randomLotto = Lotto.createLotto().getNumbers();

        // then
        assertThat(randomLotto).hasSize(6)
                .describedAs(() -> "현재 리스트: " + randomLotto);
    }

    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호는_오름차순으로_정렬된다() {
        // given

        // when
        Lotto lotto = Lotto.createLotto();
        List<Integer> numbers = lotto.getNumbers();

        List<Integer> sorted = new ArrayList<>(numbers);
        Collections.sort(sorted);

        // then
        assertThat(numbers).isEqualTo(sorted);
    }

    @Test
    public void 정상_당첨_확인() {
        // given
        PrizeNumber prizeNumber = new PrizeNumber("1,3,4,7,8,9");

        // when
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // then
        assertThat(lotto.countCorrectWithPrizeNumbers(prizeNumber.getPrizeNumbers())).isEqualTo(3);
    }
}
