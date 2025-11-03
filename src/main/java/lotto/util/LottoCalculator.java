package lotto.util;

import java.util.List;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.PrizeNumber;

public class LottoCalculator {

    public static double calculateRate(int[] correctCount, int money) {
        long sum = calculateSum(correctCount);
        return (double) sum / money;
    }

    public static int[] checkLottos(List<Lotto> lottos, PrizeNumber prizeNumber, BonusNumber bonusNumber) {
        int[] correctCount = new int[8];
        lottos.forEach(lotto -> {
            correctCount[getIndexOfCorrectCount(lotto, prizeNumber, bonusNumber)]++;
        });
        return correctCount;
    }

    public static int calculatePurchaseCount(int amount) {
        return amount / 1000;
    }

    private static long calculateSum(int[] correctCount) {
        long sum = 0;
        int[] winnerPrize = PrizeNumber.getWinningPrizes();
        for (int i = 3; i <= 7; i++) {
            sum += (long) correctCount[i] * winnerPrize[i];
        }
        return sum;
    }

    private static int getIndexOfCorrectCount(Lotto lotto, PrizeNumber prizeNumber, BonusNumber bonusNumber) {
        int count = lotto.countCorrectWithPrizeNumbers(prizeNumber.getPrizeNumbers());
        if (count == 5 && bonusNumber.contains(lotto.getNumbers())) {
            return 6;
        }
        if (count == 6) {
            return 7;
        }
        return count;
    }


}
