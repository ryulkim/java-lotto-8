package lotto.util;

import lotto.common.Message;

public class Print {
    public static void printMessage(Message msg) {
        System.out.println(msg.getMessage());
    }

    public static void printMessageWithAlpha(String alpha, Message msg) {
        System.out.println(alpha + msg.getMessage());
    }

    public static void printString(String msg) {
        System.out.println(msg);
    }
}
