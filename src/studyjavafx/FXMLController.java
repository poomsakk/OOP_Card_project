package studyjavafx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;

public class FXMLController implements Initializable {
    
    //@FXML key and Variable
    @FXML private ImageView imgView1;
    @FXML private Button drawButton;
    private Deck deck = new Deck();
    int x;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        deck = new Deck();
        deck.shuffleDeck();
        x = 0;
        System.out.println(deck);
    }

    @FXML public void drawButtonClicked(){
        System.out.println(x++);
        imgView1.setImage(deck.draw().getImage());
    }
    
}
