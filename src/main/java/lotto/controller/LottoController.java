package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.Money;
import lotto.model.PrizeNumber;
import lotto.view.InputView;

public class LottoController {
    private List<Lotto> lottos;

    LottoController() {
        lottos = new ArrayList<>();
    }

    public void run() {
        Money money = getMoney();
        purchaseLottos(calculatePurchaseCount(money.getMoney()));
        PrizeNumber prizeNumber = getPrizeNumber();
        BonusNumber bonusNumber = getBonusNumber(prizeNumber);

        InputView.close();
    }

    private void purchaseLottos(int count) {
        for (int i = 0; i < count; i++) {
            Lotto lotto = Lotto.createLotto();
            lottos.add(lotto);
        }
    }

    private int calculatePurchaseCount(int amount) {
        return amount / 1000;
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
