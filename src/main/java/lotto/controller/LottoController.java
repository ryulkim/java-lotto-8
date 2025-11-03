package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.Money;
import lotto.model.PrizeNumber;
import lotto.util.Print;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private List<Lotto> lottos;

    public LottoController() {
        lottos = new ArrayList<>();
    }

    public void run() {
        Money money = getMoney();
        Print.printString("");

        purchase(money);

        PrizeNumber prizeNumber = getPrizeNumber();
        Print.printString("");

        BonusNumber bonusNumber = getBonusNumber(prizeNumber);
        Print.printString("");

        InputView.close();
    }

    private void purchase(Money money) {
        int purchaseCount = calculatePurchaseCount(money.getMoney());
        purchaseLottos(purchaseCount);
        OutputView.printLottos(purchaseCount, this.lottos);
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
