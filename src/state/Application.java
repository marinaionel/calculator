package state;

public class Application {
    public static void main(String[] args) {
        ICalculatorController controller = new CalculatorController();
        Calculator calculator = new Calculator(controller);
        calculator.buttonOnPressedEvent();
        calculator.appendDigit(Digit.EIGHT);
        calculator.appendDigit(Digit.FIVE);
        calculator.multiply();
        calculator.appendDigit(Digit.FIVE);
        calculator.appendDot();
        calculator.appendDigit(Digit.EIGHT);
        calculator.calculation();
    }
}
