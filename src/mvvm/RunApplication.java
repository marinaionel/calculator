package mvvm;

import javafx.application.Application;
import javafx.stage.Stage;
import mvvm.model.CalculatorModel;
import mvvm.model.ICalculatorModel;
import mvvm.view.IViewHandler;
import mvvm.view.ViewHandler;

public class RunApplication extends Application {
    @Override
    public void start(Stage stage) {
        ICalculatorModel model = new CalculatorModel();
        IViewHandler viewHandler = new ViewHandler(stage, model);
        viewHandler.start();
    }
}
