package web_bookbay;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PrimaryController implements Initializable {

    @FXML
    private ImageView btnlogout;

    @FXML
    private Label logout;

    @FXML
    private HBox yourshelf;

    @FXML
    private HBox darkmode_hbox;

    @FXML
    private VBox darkmode_vbox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        logout.setOnMouseClicked(this::handleReturnToLogin);
        btnlogout.setOnMouseClicked(this::handleReturnToLogin);
        yourshelf.setOnMouseClicked(this::handleToYourShelf);

        applyDarkMode(AppSettings.getInstance().isDarkMode());
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

    @FXML
    private void handleDarkModeClick(MouseEvent event) {
        boolean isDarkMode = !AppSettings.getInstance().isDarkMode();
        AppSettings.getInstance().setDarkMode(isDarkMode);
        applyDarkMode(isDarkMode);
    }

    private void applyDarkMode(boolean isDarkMode) {
        if (isDarkMode) {
            darkmode_hbox.setStyle("-fx-background-color: #999898;");
            darkmode_vbox.setStyle("-fx-background-color: #999898;");
        } else {
            darkmode_hbox.setStyle("-fx-background-color: #ffffff;");
            darkmode_vbox.setStyle("-fx-background-color: #ffffff;");
        }
    }
}
