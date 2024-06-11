package web_bookbay;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController implements Initializable {

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button signInButton;

    @FXML
    private Button signUpButton;

    @FXML
    private Label messageLabel;

    private static final String FILE_PATH = "users.txt";

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        signInButton.setOnAction(this::handleSignIn);
        signUpButton.setOnAction(e -> handleSignUp());
    }

    private void handleSignIn(ActionEvent event) {
        String email = emailField.getText();
        String password = passwordField.getText();

        if (validateLogin(email, password)) {
            messageLabel.setText("Login successful!");

            // Wechsel zur Haupt-FXML-Datei
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("primary.fxml"));
                Parent root = loader.load();
                Stage stage = (Stage) signInButton.getScene().getWindow();
                stage.setScene(new Scene(root));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            messageLabel.setText("Invalid email or password.");
        }
    }


    private void handleSignUp() {
        String email = emailField.getText();
        String password = passwordField.getText();

        if (addUser(email, password)) {
            messageLabel.setText("Sign up successful! You can now sign in.");
        } else {
            messageLabel.setText("Sign up failed. Email may already be in use.");
        }
    }

    private boolean validateLogin(String email, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equals(email) && parts[1].equals(password)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean addUser(String email, String password) {
        if (email.isEmpty() || password.isEmpty()) {
            return false;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equals(email)) {
                    return false; // Email already in use
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(email + "," + password);
            writer.newLine();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}