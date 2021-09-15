package mvvm.model;

public interface ICalculatorModel {

    String numberInputSet(int digit);

    void clear();

    String bullet();

    String getResult();

    String setOperator(String s);

    String signChange();

    String percentage();
}
