package mvvm.viewModel;

public interface ICalculatorViewModel {
    String numberInputSet(int digit);

    String bullet();

    void clear();

    String getResult();

    String setOperator(String s);

    String signChange();

    String percentage();
}
