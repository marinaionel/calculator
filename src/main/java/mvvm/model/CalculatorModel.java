package mvvm.model;

import java.util.Timer;

public class CalculatorModel implements ICalculatorModel {
    private enum Mode {
        FIRST_NUMBER, SECOND_NUMBER
    }

    private boolean hasStarted = false;
    private Timer timer;
    private String[] numbers;
    private String operator;

    public CalculatorModel() {
        operator = "";
        numbers = new String[]{"0", "0"};
        startTimer();
    }

    private void startTimer() {
//        if (hasStarted) {
//            timer.cancel();
//            hasStarted = false;
//        }
//        timer = new Timer();
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                System.exit(0);
//            }
//        }, 5 * 60 * 1000);
//        hasStarted = true;
    }

    private Mode getMode() {
        if (operator.equals("")) return Mode.FIRST_NUMBER;
        return Mode.SECOND_NUMBER;
    }

    @Override
    public String numberInputSet(int digit) {
        startTimer();
        if (getMode() == Mode.FIRST_NUMBER) {
            if (numbers[0].equals("0")) numbers[0] = String.valueOf(digit);
            else numbers[0] = numbers[0] + digit;
            return numbers[0];
        } else {
            if (numbers[1].equals("0")) numbers[1] = String.valueOf(digit);
            else numbers[1] = numbers[1] + digit;
            return numbers[1];
        }
    }

    @Override
    public void clear() {
        startTimer();
        numbers[0] = "0";
        numbers[1] = "0";
        operator = "";
    }

    @Override
    public String bullet() {
        startTimer();
        if (getMode() == Mode.FIRST_NUMBER) {
            if (!numbers[0].contains(".")) numbers[0] += ".";
            return numbers[0];
        }
        if (!numbers[1].contains(".")) numbers[1] += ".";
        return numbers[1];

    }

    @Override
    public String getResult() {
        startTimer();
        if (getMode() == Mode.FIRST_NUMBER) return numbers[0];
        return switch (operator) {
            case "+" -> resultReset(String.valueOf(Double.parseDouble(numbers[0]) + Double.parseDouble(numbers[1])));
            case "-" -> resultReset(String.valueOf(Double.parseDouble(numbers[0]) - Double.parseDouble(numbers[1])));
            case "÷" -> checkDivision();
            case "×" -> resultReset(String.valueOf(Double.parseDouble(numbers[0]) * Double.parseDouble(numbers[1])));
            default -> null;
        };
    }

    private String checkDivision() {
        if (Double.parseDouble(numbers[1]) == 0) {
            clear();
            return "undefined";
        }
        return resultReset(String.valueOf(Double.parseDouble(numbers[0]) / Double.parseDouble(numbers[1]))).replaceFirst("\\.0*$|(\\.\\d*?)0+$", "$1");
    }

    private String resultReset(String r) {
        r = r.replaceFirst("\\.0*$|(\\.\\d*?)0+$", "$1");
        numbers[0] = r;
        numbers[1] = "0";
        operator = "";
        return r;
    }

    @Override
    public String setOperator(String s) {
        startTimer();
        operator = s;
        return s;
    }

    @Override
    public String signChange() {
        startTimer();
        if (getMode() == Mode.FIRST_NUMBER) {
            numbers[0] = String.valueOf(Double.parseDouble(numbers[0]) * -1).replaceFirst("\\.0*$|(\\.\\d*?)0+$", "$1");
            return numbers[0];
        }
        numbers[1] = String.valueOf(Double.parseDouble(numbers[1]) * -1).replaceFirst("\\.0*$|(\\.\\d*?)0+$", "$1");
        return numbers[1];
    }

    @Override
    public String percentage() {
        startTimer();
        if (getMode() == Mode.FIRST_NUMBER) {
            clear();
            return "0";
        }
        String result = String.valueOf((Double.parseDouble(numbers[1]) / 100) * Double.parseDouble(numbers[0])).replaceFirst("\\.0*$|(\\.\\d*?)0+$", "$1");
        numbers[1] = result;
        return result;
    }
}
