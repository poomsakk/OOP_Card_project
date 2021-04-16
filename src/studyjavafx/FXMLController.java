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
    @FXML private ImageView imgView1,card1,card2,card3,card4,card5,card6,card7,card8,card9,card10,card11,card12,card13;
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
        for(int i = 0 ;i < deckSize/4 ;i++){
            playerCard.add(deck.draw());
            System.out.println("player"+playerCard);
            System.out.println("deck"+deck);
        }
        player1.setPlayerCards(playerCard);
        System.out.println(player1);
        System.out.println(player1.getPlayerCards());
        System.out.println(player1.getPlayerCardsSize());
        
        card1.setImage(player1.getPlayerCards().get(0).getImage());
        card2.setImage(player1.getPlayerCards().get(1).getImage());
        card3.setImage(player1.getPlayerCards().get(2).getImage());
        card4.setImage(player1.getPlayerCards().get(3).getImage());
        card5.setImage(player1.getPlayerCards().get(4).getImage());
        card6.setImage(player1.getPlayerCards().get(5).getImage());
        card7.setImage(player1.getPlayerCards().get(6).getImage());
        card8.setImage(player1.getPlayerCards().get(7).getImage());
        card9.setImage(player1.getPlayerCards().get(8).getImage());
        card10.setImage(player1.getPlayerCards().get(9).getImage());
        card11.setImage(player1.getPlayerCards().get(10).getImage());
        card12.setImage(player1.getPlayerCards().get(11).getImage());
        card13.setImage(player1.getPlayerCards().get(12).getImage());
    }

    @FXML public void drawButtonClicked(){
        System.out.println(x++);
        imgView1.setImage(deck.draw().getImage());
    }
    
}
