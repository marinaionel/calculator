package mvvm.model;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CalculatorModelTest {
    private ICalculatorModel model = new CalculatorModel();

    @Test
    public void testNegativeNumberAddition() {
        model.numberInputSet(7);
        model.signChange();
        model.setOperator("+");
        model.numberInputSet(7);
        assertEquals("0", model.getResult());

        model.clear();
        model.numberInputSet(8);
        model.numberInputSet(9);
        model.signChange();
        model.setOperator("+");
        model.numberInputSet(7);
        model.numberInputSet(7);
        assertEquals(String.valueOf(-89 + 77), model.getResult());
    }

    @Test
    public void testPositiveNumberAddition() {
        model.numberInputSet(7);
        model.setOperator("+");
        model.numberInputSet(7);
        assertEquals("14", model.getResult());

        model.clear();
        assertEquals("0", model.getResult());
    }

    @Test
    public void division() {
        model.numberInputSet(9);
        model.numberInputSet(0);
        model.setOperator("÷");
        model.numberInputSet(-1);
        assertEquals("-90", model.getResult());
    }

}