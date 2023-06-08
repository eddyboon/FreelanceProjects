import backend.javafx.*;
import javafx.stage.*;
import javafx.application.Application;
import model.*;

/**
 * TipApp
 */
public class TipApp extends Application {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setX(ViewLoader.X);
        stage.setY(ViewLoader.Y);
        ViewLoader.showStage(new TipModel(), "/view/TipCalculator.fxml", "Tip Calculator", stage);
    }

}
