package state;

public enum Digit {
    ZERO(0), ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9);

    private int digit;

    Digit(int digit) {
        this.digit = digit;
    }

    int getDigit() {
        return digit;
    }

}
