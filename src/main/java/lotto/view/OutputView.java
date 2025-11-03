package lotto.view;

import java.util.List;
import lotto.common.Message;
import lotto.model.Lotto;
import lotto.model.PrizeNumber;
import lotto.util.Print;

public class OutputView {
    public static void printLottos(int count, List<Lotto> lottos) {
        Print.printMessageWithAlpha(String.valueOf(count), Message.OUTPUT_PURCHASE);
        lottos.forEach(lotto -> {
            Print.printString(lotto.toString());
        });
        Print.printString("");
    }

    public static void printCalculateStatic(int[] correctCount, double rate) {
        int[] winnerPrize = PrizeNumber.getWinningPrizes();

        StringBuilder sb = new StringBuilder();
        sb.append("당첨 통계").append("\n").append("---").append("\n");
        for (int i = 3; i <= 7; i++) {
            sb.append(printCount(i)).append(String.format("%,d", winnerPrize[i])).append("원) - ")
                    .append(correctCount[i]).append("개").append("\n");
        }
        sb.append("총 수익률은 ").append(String.format("%.1f", rate)).append("%입니다.").append("\n");
        Print.printString(sb.toString());
    }

    private static String printCount(int num) {
        if (num == 6) {
            return "5개 일치, 보너스 볼 일치 (";
        }
        if (num == 7) {
            return "6개 일치 (";
        }
        return String.format("%d개 일치 (", num);
    }
}
