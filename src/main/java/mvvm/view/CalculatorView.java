package mvvm.view;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import mvvm.viewModel.ICalculatorViewModel;

public class CalculatorView {
    private ICalculatorViewModel calculatorViewModel;
    @FXML
    Label operator;
    @FXML
    JFXButton nine;
    @FXML
    JFXButton eight;
    @FXML
    JFXButton seven;
    @FXML
    JFXButton four;
    @FXML
    JFXButton five;
    @FXML
    JFXButton six;
    @FXML
    JFXButton one;
    @FXML
    JFXButton two;
    @FXML
    JFXButton three;
    @FXML
    JFXButton zero;
    @FXML
    JFXButton onButton;
    @FXML
    JFXButton bullet;
    @FXML
    JFXButton percentage;
    @FXML
    JFXButton multiply;
    @FXML
    JFXButton plus;
    @FXML
    JFXButton sign;
    @FXML
    JFXButton division;
    @FXML
    JFXButton minus;
    @FXML
    JFXButton equals;
    @FXML
    Label display;

    public void on7button() {
        numberButton(7);
    }

    public void on8button() {
        numberButton(8);
    }

    public void on9button() {
        numberButton(9);
    }

    public void on4button() {
        numberButton(4);
    }

    public void on5button() {
        numberButton(5);
    }

    public void on6button() {
        numberButton(6);
    }

    public void on1button() {
        numberButton(1);
    }

    public void on2button() {
        numberButton(2);
    }

    public void on3button() {
        numberButton(3);
    }

    public void on0button() {
        numberButton(0);
    }

    private void numberButton(int digit) {
        if (operator.getText().equals("=")) operator.setText("");
        display.setText(calculatorViewModel.numberInputSet(digit));
    }

    public void onONbutton() {
        if (seven.isDisabled()) {
            display.setText("0");
            disableButtons(false);
        } else {
            clear();
        }
    }

    private void clear() {
        operator.setText("");
        display.setText("");
        calculatorViewModel.clear();
    }

    public void onBulletButton() {
        display.setText(calculatorViewModel.bullet());
    }

    public void onPercentageButton() {
        display.setText(calculatorViewModel.percentage());
    }

    public void onMultiplyButton() {
        operator.setText(calculatorViewModel.setOperator("×"));
    }

    public void onPlusButton() {
        operator.setText(calculatorViewModel.setOperator("+"));
    }

    public void onSignButton() {
        display.setText(calculatorViewModel.signChange());
    }

    public void onDivisionButton() {
        operator.setText(calculatorViewModel.setOperator("÷"));
    }

    public void onMinusButton() {
        operator.setText(calculatorViewModel.setOperator("-"));
    }

    public void onEqualsButton() {
        operator.setText("=");
        display.setText(calculatorViewModel.getResult());
    }

    public void init(ICalculatorViewModel calculatorViewModel) {
        this.calculatorViewModel = calculatorViewModel;
        disableButtons(true);
    }

    private void disableButtons(boolean choice) {
        plus.setDisable(choice);
        minus.setDisable(choice);
        division.setDisable(choice);
        percentage.setDisable(choice);
        nine.setDisable(choice);
        eight.setDisable(choice);
        seven.setDisable(choice);
        six.setDisable(choice);
        five.setDisable(choice);
        four.setDisable(choice);
        three.setDisable(choice);
        two.setDisable(choice);
        one.setDisable(choice);
        zero.setDisable(choice);
        sign.setDisable(choice);
        multiply.setDisable(choice);
        equals.setDisable(choice);
        bullet.setDisable(choice);
    }
}
