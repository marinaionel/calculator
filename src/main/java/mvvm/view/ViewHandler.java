package mvvm.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mvvm.model.ICalculatorModel;
import mvvm.viewModel.ViewModelProvider;

import java.io.IOException;

public class ViewHandler implements IViewHandler {

    private ViewModelProvider viewModelProvider;
    private Stage mainStage;

    public ViewHandler(Stage stage, ICalculatorModel model) {
        mainStage = stage;
        viewModelProvider = new ViewModelProvider(model);
    }

    @Override
    public void start() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("fxml/calculatorUI.fxml"));
        Parent root = null;

        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        CalculatorView calculatorView = loader.getController();
        calculatorView.init(viewModelProvider.getCalculatorViewModel());
        mainStage.setResizable(false);
        mainStage.setTitle("Calculator");

        assert root != null;
        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.show();
        mainStage.setOnCloseRequest(t -> System.exit(0));
    }
}
