package lotto.view;

import static lotto.common.Message.INPUT_BONUS_NUMBER;
import static lotto.common.Message.INPUT_MONEY;
import static lotto.common.Message.INPUT_PRIZE_NUMBERS;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.Print;

public class InputView {
    public static String inputMoney() {
        Print.printMessage(INPUT_MONEY);
        return readLine();
    }

    public static String inputPrizeNumbers() {
        Print.printMessage(INPUT_PRIZE_NUMBERS);
        return readLine();
    }

    public static String inputBonusNumber() {
        Print.printMessage(INPUT_BONUS_NUMBER);
        return readLine();
    }

    public static void close() {
        Console.close();
    }

    private static String readLine() {
        return Console.readLine();
    }
}
