package web_bookbay;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import web_bookbay.model.Book;

public class CardController {

    @FXML
    private Label authorName;

    @FXML
    private Label bookName;

    @FXML
    private HBox box;

    @FXML
    private ImageView bookImage;


    public void setData(Book book) {
    Image image = new Image(getClass().getResourceAsStream(book.getImageSrc()));
    bookImage.setImage(image);
    bookName.setText(book.getName());
    authorName.setText(book.getAuthor());
}

}
