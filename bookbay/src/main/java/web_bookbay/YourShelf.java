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

    @FXML
    private Label shelfshelf;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        logout.setOnMouseClicked(this::handleReturnToLogin);
        btnlogout.setOnMouseClicked(this::handleReturnToLogin);
        shelfshelf.setOnMouseClicked(this::gobackbrwoise);
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
    private void gobackbrwoise(MouseEvent event) {
        try {
            // Setzen Sie die Wurzel der Szene auf die Login-Seite
            App.setRoot("primary");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


