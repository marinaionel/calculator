package state;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class SecondOperand implements ICalculatorState {
    private static final SecondOperand INSTANCE = new SecondOperand();

    private SecondOperand() {
    }

    public static SecondOperand getINSTANCE() {
        return INSTANCE;
    }

    @Override
    public void appendDigit(Calculator calculator, Digit digit) {
        if (calculator.getSecondNumber().equals("0")) {
            calculator.setSecondNumber(digit.getDigit() + "");
        } else if (calculator.getSecondNumber().length() <= 10) {
            calculator.setSecondNumber(calculator.getSecondNumber() + digit.getDigit() + "");
        }
        calculator.showNumber(calculator.getSecondNumber());
    }

    @Override
    public void appendDot(Calculator calculator) {
        if (!calculator.getSecondNumber().contains(".")) {
            calculator.setSecondNumber(calculator.getSecondNumber() + ".");
        }
        calculator.showNumber(calculator.getSecondNumber());
    }

    @Override
    public void appendPercentageOperand(Calculator calculator) {
        reset(String.valueOf((Double.parseDouble(calculator.getSecondNumber()) / 100) * Double.parseDouble(calculator.getFirstNumber())).replaceFirst("\\.0*$|(\\.\\d*?)0+$", "$1"), calculator);
        calculator.setState(FirstOpperand.getINSTANCE());
        calculator.showNumber(calculator.getFirstNumber());
    }

    @Override
    public void calculation(Calculator calculator) {
        if (calculator.getSecondNumber().equals("0") && calculator.getOperand().toString().equals(Operand.DIVIDE.toString())) {
            reset("0", calculator);
            calculator.displayError();
            calculator.setState(Error.getINSTANCE());
        } else {
            if (overflow(calculator)) return;
            reset(calculate(calculator.getFirstNumber(), calculator.getSecondNumber(), calculator.getOperand()), calculator);
            calculator.setState(FirstOpperand.getINSTANCE());
        }
    }

    @Override
    public void changeSign(Calculator calculator) {
        calculator.setSecondNumber(String.valueOf(Double.parseDouble(calculator.getSecondNumber()) * -1));
        calculator.showNumber(calculator.getSecondNumber());
    }

    @Override
    public void multiply(Calculator calculator) {
        nextOperand(calculator, Operand.MULTIPLY);
    }

    @Override
    public void division(Calculator calculator) {
        nextOperand(calculator, Operand.DIVIDE);
    }

    @Override
    public void plus(Calculator calculator) {
        nextOperand(calculator, Operand.PLUS);
    }

    @Override
    public void minus(Calculator calculator) {
        nextOperand(calculator, Operand.MINUS);
    }

    @Override
    public void on(Calculator calculator) {
        reset("0", calculator);
        calculator.setState(FirstOpperand.getINSTANCE());
        calculator.showNumber(calculator.getFirstNumber());
    }

    private void nextOperand(Calculator calculator, Operand operand) {
        if (!calculator.getSecondNumber().equals("0") && !calculator.getOperand().toString().equals(Operand.DIVIDE.toString())) {
            if (overflow(calculator)) return;
            reset(calculate(calculator.getFirstNumber(), calculator.getSecondNumber(), calculator.getOperand()), calculator);
            calculator.setOperand(operand);
            calculator.showNumber(calculator.getFirstNumber());
        } else {
            reset("0", calculator);
            calculator.displayError();
            calculator.setState(Error.getINSTANCE());
        }
    }

    private boolean overflow(Calculator calculator) {
        if (calculate(calculator.getFirstNumber(), calculator.getSecondNumber(), calculator.getOperand()).length() > 10) {
            reset("0", calculator);
            calculator.displayError();
            calculator.setState(Error.getINSTANCE());
            return true;
        }
        return false;
    }

    private void reset(String number1, Calculator calculator) {
        calculator.setFirstNumber(number1);
        calculator.setOperand(null);
        calculator.setSecondNumber("0");
    }

    private String calculate(String n1, String n2, Operand operand) {
        double n11 = Double.parseDouble(n1);
        double n22 = Double.parseDouble(n2);

        double result = switch (operand) {
            case PLUS -> n11 + n22;
            case MINUS -> n11 - n22;
            case DIVIDE -> n11 / n22;
            case MULTIPLY -> n11 * n22;
        };
        DecimalFormatSymbols separator = new DecimalFormatSymbols();
        separator.setDecimalSeparator('.');
        String result1 = new DecimalFormat("#.########", separator).format(result);
        if (result1.contains(".") && result1.length() > 10) {
            result1 = result1.substring(0, 10);
        }
        if (result1.indexOf(".") == result1.length() - 1) {
            return result1.substring(0, result1.length() - 1);
        }
        return result1;
    }
}
