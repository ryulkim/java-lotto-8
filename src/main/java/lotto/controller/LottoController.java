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
    private PrizeNumber prizeNumber;
    private BonusNumber bonusNumber;
    private Money money;

    public LottoController() {
        lottos = new ArrayList<>();
    }

    public void run() {
        setMoney();
        purchase();
        setPrizeNumber();
        setBonusNumber();

        InputView.close();
    }

    private void purchase() {
        int purchaseCount = calculatePurchaseCount(money.getMoney());
        purchaseLottos(purchaseCount);
        OutputView.printLottos(purchaseCount, lottos);
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

    private void setMoney() {
        money = new Money(InputView.inputMoney());
        Print.printString("");
    }

    private void setPrizeNumber() {
        prizeNumber = new PrizeNumber(InputView.inputPrizeNumbers());
        Print.printString("");
    }

    private void setBonusNumber() {
        bonusNumber = new BonusNumber(InputView.inputBonusNumber(), prizeNumber);
        Print.printString("");
    }

}
