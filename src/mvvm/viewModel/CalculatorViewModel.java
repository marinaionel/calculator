package mvvm.viewModel;

import mvvm.model.ICalculatorModel;

public class CalculatorViewModel implements ICalculatorViewModel {
    private ICalculatorModel model;

    public CalculatorViewModel(ICalculatorModel model) {
        this.model = model;
    }

    @Override
    public String numberInputSet(int digit) {
        return model.numberInputSet(digit);
    }

    @Override
    public String bullet() {
        return model.bullet();
    }

    @Override
    public void clear() {
        model.clear();
    }

    @Override
    public String getResult() {
        return model.getResult();
    }

    @Override
    public String setOperator(String s) {
        return model.setOperator(s);
    }

    @Override
    public String signChange() {
        return model.signChange();
    }

    @Override
    public String percentage() {
        return model.percentage();
    }
}
