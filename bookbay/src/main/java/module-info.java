module web_bookbay {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens web_bookbay to javafx.fxml;

    exports web_bookbay;
}
