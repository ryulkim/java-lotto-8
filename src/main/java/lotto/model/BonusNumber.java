package lotto.model;

public class BonusNumber {
    private int number;

    public BonusNumber(String number) {
        this.number = parse(number);
    }

    public int getNumber() {
        return number;
    }

    private int parse(String number) {
        return parseInt(number);
    }

    private int parseInt(String number) {
        return Integer.parseInt(number);
    }
}
