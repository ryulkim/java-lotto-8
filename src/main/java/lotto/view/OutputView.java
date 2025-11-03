package lotto.view;

import java.util.List;
import lotto.common.Message;
import lotto.model.Lotto;
import lotto.util.Print;

public class OutputView {
    public static void printLottos(int count, List<Lotto> lottos) {
        Print.printMessageWithAlpha(String.valueOf(count), Message.OUTPUT_PURCHASE);
        lottos.forEach(lotto -> {
            Print.printString(lotto.toString());
        });
        Print.printString("");
    }
}
