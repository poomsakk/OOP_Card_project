package studyjavafx;

import java.net.URL;
import java.util.ArrayList;
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
    ArrayList<Card> playerCard;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        playerCard = new ArrayList<Card>();
        deck = new Deck();
        Player player1 = new Player();
        deck.shuffleDeck();
        x = 0;
        int deckSize = deck.getDeckSize();
        for(int i = 0 ;i < deckSize/2 ;i++){
            playerCard.add(deck.draw());
            System.out.println("player"+playerCard);
            System.out.println("deck"+deck);
        }
        player1.setPlayerCards(playerCard);
        System.out.println(player1);
    }

    @FXML public void drawButtonClicked(){
        System.out.println(x++);
        imgView1.setImage(deck.draw().getImage());
    }
    
}
