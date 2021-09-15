package state;

import java.util.Timer;
import java.util.TimerTask;

class Calculator {
    private ICalculatorState state;
    private ICalculatorController controller;
    private String firstNumber;
    private String secondNumber;
    private Operand operand;
    private boolean hasStarted;
    private Timer timer;

    Calculator(ICalculatorController controller) {
        this.controller = controller;
        state = FirstOpperand.getINSTANCE();
        operand = null;
        firstNumber = "0";
        secondNumber = "0";
        hasStarted = false;
    }

    void buttonOnPressedEvent() {
        startTimer();
        controller.turnOn();
    }

    private void startTimer() {
        if (hasStarted) {
            timer.cancel();
            hasStarted = false;
        }
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.exit(0);
            }
        }, 5 * 60 * 1000);
        hasStarted = true;
    }

    // Handle external events
    Operand getOperand() {
        return operand;
    }

    void setOperand(Operand operand) {
        this.operand = operand;
    }

    void setFirstNumber(String firstNumber) {
        this.firstNumber = firstNumber;
    }

    void setSecondNumber(String secondNumber) {
        this.secondNumber = secondNumber;
    }

    String getFirstNumber() {
        return firstNumber;
    }

    String getSecondNumber() {
        return secondNumber;
    }

    void setState(ICalculatorState state) {
        this.state = state;
    }

    // Actions
    void showNumber(String number) {
        controller.showNumber(number);
    }

    void displayError() {
        controller.displayError();
    }

    // Handle external events
    void appendDigit(Digit digit) {
        startTimer();
        state.appendDigit(this, digit);
    }

    void appendDot() {
        startTimer();
        state.appendDot(this);
    }

    void appendPercentageOperand() {
        startTimer();
        state.appendPercentageOperand(this);
    }

    void calculation() {
        startTimer();
        state.calculation(this);
    }

    void changeSign() {
        startTimer();
        state.changeSign(this);
    }

    void multiply() {
        startTimer();
        state.multiply(this);
    }

    void division() {
        startTimer();
        state.division(this);
    }

    void plus() {
        startTimer();
        state.plus(this);
    }

    void minus() {
        startTimer();
        state.minus(this);
    }

    void on() {
        startTimer();
        state.on(this);
    }
}
