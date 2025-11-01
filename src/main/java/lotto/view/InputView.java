package lotto.view;

import static lotto.common.Message.INPUTMONEY;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.Print;

public class InputView {
    public static void inputMoney(){
        Print.printMessage(INPUTMONEY);
        inputConsole();
    }

    public static void close(){
        Console.close();
    }

    private static String inputConsole(){
        return Console.readLine();
    }
}
