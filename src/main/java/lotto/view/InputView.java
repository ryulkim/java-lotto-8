package lotto.view;

import static lotto.common.Message.INPUT_BONUS_NUMBER;
import static lotto.common.Message.INPUT_MONEY;
import static lotto.common.Message.INPUT_PRIZE_NUMBERS;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.Print;

public class InputView {
    public static void inputMoney() {
        Print.printMessage(INPUT_MONEY);
        readLine();
    }

    public static void inputPrizeNumbers() {
        Print.printMessage(INPUT_PRIZE_NUMBERS);
        readLine();
    }

    public static void inputBonusNumber() {
        Print.printMessage(INPUT_BONUS_NUMBER);
        readLine();
    }

    public static void close() {
        Console.close();
    }

    private static String readLine() {
        return Console.readLine();
    }
}
