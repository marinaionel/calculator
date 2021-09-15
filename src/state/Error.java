package state;

public class Error implements ICalculatorState {
    private static final Error INSTANCE = new Error();

    private Error() {
    }

    public static ICalculatorState getINSTANCE() {
        return INSTANCE;
    }

    @Override
    public void appendDigit(Calculator calculator, Digit digit) {
        calculator.setFirstNumber(digit.toString());
        calculator.setOperand(null);
        calculator.setSecondNumber("0");
        calculator.setState(FirstOpperand.getINSTANCE());
        calculator.showNumber(calculator.getFirstNumber());
    }

    @Override
    public void appendDot(Calculator calculator) {
        calculator.setFirstNumber("0.");
        calculator.setOperand(null);
        calculator.setSecondNumber("0");
        calculator.setState(FirstOpperand.getINSTANCE());
        calculator.showNumber(calculator.getFirstNumber());
    }

    @Override
    public void appendPercentageOperand(Calculator calculator) {
        calculator.displayError();
    }

    @Override
    public void calculation(Calculator calculator) {
        calculator.displayError();
    }

    @Override
    public void changeSign(Calculator calculator) {
        calculator.displayError();
    }

    @Override
    public void multiply(Calculator calculator) {
        calculator.displayError();
    }

    @Override
    public void division(Calculator calculator) {
        calculator.displayError();
    }

    @Override
    public void plus(Calculator calculator) {
        calculator.displayError();
    }

    @Override
    public void minus(Calculator calculator) {
        calculator.displayError();
    }

    @Override
    public void on(Calculator calculator) {
        calculator.setFirstNumber("0");
        calculator.setSecondNumber("0");
        calculator.setOperand(null);
        calculator.setState(FirstOpperand.getINSTANCE());
        calculator.showNumber(calculator.getFirstNumber());
    }
}
