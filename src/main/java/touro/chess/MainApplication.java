package touro.chess;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Touro Chess");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
