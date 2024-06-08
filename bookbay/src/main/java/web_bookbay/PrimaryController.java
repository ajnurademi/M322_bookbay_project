package web_bookbay;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import web_bookbay.model.Book;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;

public class PrimaryController implements Initializable {

    @FXML
    private HBox cardLayout;
    private List<Book> recentlyAdded;

    @Override
public void initialize(URL location, ResourceBundle resources) {
    recentlyAdded = recentlyAdded();
    try {
        for (int i = 0; i < recentlyAdded.size(); i++) {
            FXMLLoader fxmlLoader = new FXMLLoader();
            URL resourceUrl = getClass().getResource("./card.fxml");
            System.out.println("Resource URL: " + resourceUrl); // Debugging statement
            fxmlLoader.setLocation(resourceUrl);
            HBox cardBox = fxmlLoader.load();
            CardController cardController = fxmlLoader.getController();
            cardController.setData(recentlyAdded.get(i));
            cardLayout.getChildren().add(cardBox);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}


    private List<Book> recentlyAdded(){
        List<Book> ls = new ArrayList<>();

        Book book = new Book();
        book.setName("RICH DAD\nPOOR DAD");
        book.setImageSrc("/web_bookbay/img/rich-and-poor-dad.png");
        book.setAuthor("Robert T.Kiyosaki");
        ls.add(book);

        

        return ls;

    }

}
