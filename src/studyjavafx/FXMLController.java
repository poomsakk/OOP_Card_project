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
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        deck = new Deck();
        deck.shuffleDeck();
        x = 0;
        
        /*
        *
        ++++++++++Test Bot Class++++++++++
        *
        */
        Bot bot1 = new Bot();
        ArrayList<Card> botCard = new ArrayList<Card>();
        int deckSize = deck.getDeckSize();
        for(int i = 0 ;i < deckSize/2 ;i++){
            botCard.add(deck.draw());
            System.out.println("player"+botCard);
            System.out.println("deck"+deck);
        }
        bot1.setBotCards(botCard);
        System.out.println(bot1);
        System.out.println(bot1.getBotCards());
        System.out.println(bot1.getBotCardsSize());
        /*
        *
        ++++++++++++++++++++++++++++++++++
        *
        */
        
    }

    @FXML public void drawButtonClicked(){
        System.out.println(x++);
        imgView1.setImage(deck.draw().getImage());
    }
    
}
