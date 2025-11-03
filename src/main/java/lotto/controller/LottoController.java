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
        int[] correctCount = checkLottos();
        long sum = calculateSum(correctCount);
        OutputView.printCalculateStatic(correctCount, (double) sum / money.getMoney());

        InputView.close();
    }

    private long calculateSum(int[] correctCount) {
        long sum = 0;
        int[] winnerPrize = PrizeNumber.getWinningPrizes();
        for (int i = 3; i <= 7; i++) {
            sum += (long) correctCount[i] * winnerPrize[i];
        }
        return sum;
    }

    private int[] checkLottos() {
        int[] correctCount = new int[8];
        lottos.forEach(lotto -> {
            correctCount[getIndexOfCorrectCount(lotto)]++;
        });
        return correctCount;
    }

    private int getIndexOfCorrectCount(Lotto lotto) {
        int count = lotto.countCorrectWithPrizeNumbers(prizeNumber.getPrizeNumbers());
        if (count == 5 && bonusNumber.contains(lotto.getNumbers())) {
            return 6;
        }
        if (count == 6) {
            return 7;
        }
        return count;
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
