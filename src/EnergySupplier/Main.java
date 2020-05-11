package EnergySupplier;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        GridPane root = new GridPane();
        new Pane(root);

        primaryStage.setTitle("Send your energy usage");
        primaryStage.setScene(new Scene(root, 640, 480));
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
