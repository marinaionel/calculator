package state;

public enum Operand {
    PLUS("+"), MINUS("-"), DIVIDE("/"), MULTIPLY("*");

    private String sign;

    Operand(String sign) {
        this.sign = sign;
    }

    public String toString() {
        return sign;
    }
}
