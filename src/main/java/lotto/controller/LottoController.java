package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.Money;
import lotto.model.PrizeNumber;
import lotto.util.LottoCalculator;
import lotto.util.Print;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private List<Lotto> lottos;
    private PrizeNumber prizeNumber;
    private BonusNumber bonusNumber;
    private int money;

    public LottoController() {
        lottos = new ArrayList<>();
    }

    public void run() {
        setMoney();
        purchase();
        setPrizeNumber();
        setBonusNumber();
        calculateWinner();
        InputView.close();
    }

    private void calculateWinner() {
        int[] correctCount = LottoCalculator.checkLottos(lottos, prizeNumber, bonusNumber);
        double rate = LottoCalculator.calculateRate(correctCount, money);
        OutputView.printCalculateStatic(correctCount, rate);
    }

    private void purchase() {
        int purchaseCount = LottoCalculator.calculatePurchaseCount(money);
        purchaseLottos(purchaseCount);
        OutputView.printLottos(purchaseCount, lottos);
    }

    private void purchaseLottos(int count) {
        for (int i = 0; i < count; i++) {
            Lotto lotto = Lotto.createLotto();
            lottos.add(lotto);
        }
    }


    private void setMoney() {
        while (true) {
            try {
                money = new Money(InputView.inputMoney()).getMoney();
                Print.printString("");
                return;
            } catch (IllegalArgumentException e) {
                Print.printString(e.getMessage());
                Print.printString("");
            }
        }
    }

    private void setPrizeNumber() {
        while (true) {
            try {
                prizeNumber = new PrizeNumber(InputView.inputPrizeNumbers());
                Print.printString("");
                return;
            } catch (IllegalArgumentException e) {
                Print.printString(e.getMessage());
                Print.printString("");
            }
        }

    }

    private void setBonusNumber() {
        while (true) {
            try {
                bonusNumber = new BonusNumber(InputView.inputBonusNumber(), prizeNumber);
                Print.printString("");
                return;
            } catch (IllegalArgumentException e) {
                Print.printString(e.getMessage());
                Print.printString("");
            }
        }

    }

}
