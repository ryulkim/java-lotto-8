package lotto.controller;

import java.util.List;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.Money;
import lotto.model.PrizeNumber;
import lotto.view.InputView;

public class LottoController {
    private List<Lotto> lottos;

    public void run() {
        Money money = getMoney();
        PrizeNumber prizeNumber = getPrizeNumber();
        BonusNumber bonusNumber = getBonusNumber(prizeNumber);

        InputView.close();
    }

    private Money getMoney() {
        return new Money(InputView.inputMoney());
    }

    private PrizeNumber getPrizeNumber() {
        return new PrizeNumber(InputView.inputPrizeNumbers());
    }

    private BonusNumber getBonusNumber(PrizeNumber prizeNumber) {
        return new BonusNumber(InputView.inputBonusNumber(), prizeNumber);
    }

}
