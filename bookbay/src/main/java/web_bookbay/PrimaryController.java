package web_bookbay;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.lang.annotation.ElementType;
import java.net.URL;
import java.util.EmptyStackException;
import java.util.ResourceBundle;

public class PrimaryController implements Initializable {

    @FXML
    private ImageView btnlogout;

    @FXML
    private Label logout;


    @FXML
    private HBox yourshelf;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        logout.setOnMouseClicked(this::handleReturnToLogin);
        btnlogout.setOnMouseClicked(this::handleReturnToLogin);
        yourshelf.setOnMouseClicked(this::handleToYourShelf);
    }

    private void handleReturnToLogin(MouseEvent event) {
        try {
            App.setRoot("login");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void handleToYourShelf(MouseEvent event) {
        try {
            App.setRoot("yourshelf");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    
}
