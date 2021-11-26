package state;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static state.Digit.*;

public class CalculatorTest {
    private Calculator calculator;

    @Before
    public void setUp() {
        ICalculatorController controller = new CalculatorController();
        calculator = new Calculator(controller);
        calculator.buttonOnPressedEvent();
    }

    @Test
    public void testDivisionByZero() {
        calculator.appendDigit(EIGHT);
        calculator.division();
        calculator.appendDigit(ZERO);
        calculator.calculation();
        assertEquals(calculator.getFirstNumber(), "0");
        assertEquals(calculator.getSecondNumber(), "0");
        assertNull(calculator.getOperand());
    }

    @Test
    public void digits() {
        calculator.appendDigit(FIVE);
        assertEquals("5", calculator.getFirstNumber());
        calculator.appendDigit(EIGHT);
        assertEquals("58", calculator.getFirstNumber());
        calculator.appendDot();
        assertEquals("58.", calculator.getFirstNumber());
        calculator.appendDot();
        assertEquals("58.", calculator.getFirstNumber());
        calculator.appendPercentageOperand();
        assertEquals("0", calculator.getFirstNumber());
    }

    @Test
    public void test() {
        calculator.buttonOnPressedEvent();
        calculator.appendDigit(EIGHT);
        calculator.appendDigit(FIVE);
        calculator.multiply();
        calculator.appendDigit(FIVE);
        calculator.appendDot();
        calculator.appendDigit(EIGHT);
        calculator.calculation();
        assertEquals(((85 * 5.8) + "").replaceAll("([0-9])\\.0+([^0-9]|$)", "$1$2"), calculator.getFirstNumber());
    }

    @Test
    public void test1() {
        calculator.buttonOnPressedEvent();
        calculator.appendDigit(ZERO);
        calculator.appendDigit(ZERO);
        calculator.plus();
        calculator.appendDigit(FIVE);
        calculator.appendPercentageOperand();
        assertEquals("0", calculator.getFirstNumber());
        assertEquals("0", calculator.getSecondNumber());
    }

    @Test
    public void boundaries() {
        for (int i = 0; i <= 20; i++) {
            calculator.appendDigit(NINE);
        }
        assertEquals("99999999999", calculator.getFirstNumber());
        calculator.plus();
        calculator.appendDigit(NINE);
        calculator.calculation();
        assertEquals("0", calculator.getFirstNumber());
    }

    @Test
    public void test2() {
        calculator.appendDigit(FOUR);
        calculator.appendDigit(ZERO);
        calculator.plus();
        calculator.appendDigit(FOUR);
        calculator.plus();
        calculator.appendDigit(FOUR);
        calculator.calculation();
        assertEquals("48", calculator.getFirstNumber());
    }

    @Test
    public void test3() {
        calculator.appendDigit(FIVE);
        calculator.appendDigit(THREE);
        calculator.appendDigit(NINE);
        calculator.appendDigit(SIX);
        calculator.appendDigit(TWO);
        calculator.appendDot();
        calculator.appendDigit(FIVE);
        calculator.appendDigit(NINE);
        calculator.appendDigit(SIX);
        calculator.appendDigit(TWO);
        calculator.plus();
        calculator.appendDigit(FIVE);
        calculator.appendDigit(THREE);
        calculator.appendDigit(NINE);
        calculator.appendDigit(SIX);
        calculator.appendDigit(TWO);
        calculator.appendDot();
        calculator.appendDigit(FIVE);
        calculator.appendDigit(NINE);
        calculator.appendDigit(SIX);
        calculator.appendDigit(TWO);
        calculator.calculation();
        assertEquals("107925.192", calculator.getFirstNumber());
    }

}