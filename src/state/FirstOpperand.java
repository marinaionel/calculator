package state;

public class FirstOpperand implements ICalculatorState {
    private static final FirstOpperand INSTANCE = new FirstOpperand();

    private FirstOpperand() {
    }

    public static ICalculatorState getINSTANCE() {
        return INSTANCE;
    }

    @Override
    public void appendDigit(Calculator calculator, Digit digit) {
        if (calculator.getFirstNumber().equals("0")) {
            calculator.setFirstNumber(digit.getDigit() + "");
        } else if (calculator.getFirstNumber().length() <= 10) {
            calculator.setFirstNumber(calculator.getFirstNumber() + digit.getDigit());
        }
        calculator.showNumber(calculator.getFirstNumber());
    }

    @Override
    public void appendDot(Calculator calculator) {
        if (!calculator.getFirstNumber().contains(".")) {
            calculator.setFirstNumber(calculator.getFirstNumber() + ".");
        }
        calculator.showNumber(calculator.getFirstNumber());

    }

    @Override
    public void appendPercentageOperand(Calculator calculator) {
        calculator.setFirstNumber("0");
        calculator.showNumber(calculator.getFirstNumber());
    }

    @Override
    public void calculation(Calculator calculator) {
        calculator.showNumber(calculator.getFirstNumber());
    }

    @Override
    public void changeSign(Calculator calculator) {
        calculator.setFirstNumber(String.valueOf(Double.parseDouble(calculator.getFirstNumber()) * -1));
        calculator.showNumber(calculator.getFirstNumber());
    }

    @Override
    public void multiply(Calculator calculator) {
        calculator.setOperand(Operand.MULTIPLY);
        calculator.setState(SecondOperand.getINSTANCE());
    }

    @Override
    public void division(Calculator calculator) {
        calculator.setOperand(Operand.DIVIDE);
        calculator.setState(SecondOperand.getINSTANCE());
    }

    @Override
    public void plus(Calculator calculator) {
        calculator.setOperand(Operand.PLUS);
        calculator.setState(SecondOperand.getINSTANCE());
    }

    @Override
    public void minus(Calculator calculator) {
        calculator.setOperand(Operand.MINUS);
        calculator.setState(SecondOperand.getINSTANCE());
    }

    @Override
    public void on(Calculator calculator) {
        calculator.setFirstNumber("0");
        calculator.setOperand(null);
        calculator.showNumber(calculator.getFirstNumber());
    }
}
