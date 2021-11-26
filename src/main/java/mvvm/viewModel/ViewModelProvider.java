package mvvm.viewModel;

import mvvm.model.ICalculatorModel;

public class ViewModelProvider {
    private ICalculatorViewModel calculatorViewModel;

    public ViewModelProvider(ICalculatorModel model) {
        calculatorViewModel = new CalculatorViewModel(model);
    }

    public ICalculatorViewModel getCalculatorViewModel() {
        return calculatorViewModel;
    }
}
