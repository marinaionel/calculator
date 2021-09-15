package state;

public interface ICalculatorState {
    void appendDigit(Calculator calculator, Digit digit);

    void appendDot(Calculator calculator);

    void appendPercentageOperand(Calculator calculator);

    void calculation(Calculator calculator);

    void changeSign(Calculator calculator);

    void multiply(Calculator calculator);

    void division(Calculator calculator);

    void plus(Calculator calculator);

    void minus(Calculator calculator);

    void on(Calculator calculator);
}
