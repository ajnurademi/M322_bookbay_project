package web_bookbay;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    private static Scene scene;
    private static Stage primaryStage;

    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage;
        setRoot("login");
        primaryStage.setTitle("Bookbay");
        primaryStage.show();
    }

    static void setRoot(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        Parent root = fxmlLoader.load();
        scene = new Scene(root);
        primaryStage.setScene(scene);
    }

    public static void main(String[] args) {
        launch();
    }
}
