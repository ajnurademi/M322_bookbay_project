package web_bookbay;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class YourShelf implements Initializable{
    
    @FXML
    private ImageView btnlogout;

    @FXML
    private Label logout;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        logout.setOnMouseClicked(this::handleReturnToLogin);
        btnlogout.setOnMouseClicked(this::handleReturnToLogin);
    }

    // Methode, um zur Login-Seite zurückzukehren
    private void handleReturnToLogin(MouseEvent event) {
        try {
            // Setzen Sie die Wurzel der Szene auf die Login-Seite
            App.setRoot("login");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


