package studyjavafx;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

public class FXMLController implements Initializable {
    
    //@FXML key and Variable
    @FXML private ImageView imgView1;
    @FXML private HBox hboxy;
    private ArrayList<ImageView>  imageViewCardOnhands;
    private Deck mainDeck;
    private Deck playerDeck;
    int x = 0;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mainDeck = new Deck(true);
        mainDeck.shuffleDeck();
        
        playerDeck = new Deck();
        
        imageViewCardOnhands = new ArrayList<ImageView>();
        
        imgView1.setImage(new Image("studyjavafx/images/backOfCard.jpg"));
        
        LoadGameForOneBots();
    }

    @FXML public void drawButtonClicked(){
        imgView1.setImage(mainDeck.draw().getImage());
    }
    
    @FXML public void SortCardOnHands(){
        playerDeck.sortDeck();
        updateCardOnHands();
    }

    private void LoadGameForOneBots() {
        for (int i = 0; i < 26; i++) {
            Card cardDraw = mainDeck.draw();
            playerDeck.addCard(cardDraw);
            imageViewCardOnhands.add(new ImageView(cardDraw.getImage()));
            imageViewCardOnhands.get(i).setFitWidth(1300/26);// width = 1300/imageCount
            imageViewCardOnhands.get(i).setFitHeight(726*1300/500/26);// height = 726*1300/imageCount/500
        }
        hboxy.setAlignment(Pos.CENTER);
        hboxy.getChildren().addAll(imageViewCardOnhands);
        
        /**Click On imgView1 to move Down
        imgView1.setImage(new Image("studyjavafx/images/backOfCard.jpg"));
        imgView1.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                imgView1.setY(imgView1.getY()+10);
                //System.out.println(x++);
                //event.consume();
            }
        });
         */
        
    }
    
    private void updateCardOnHands(){
        imageViewCardOnhands.clear();
        int size = playerDeck.getSize();
        for (int i = 0; i < size; i++) {
            imageViewCardOnhands.add(new ImageView(playerDeck.getDeck().get(i).getImage()));
            imageViewCardOnhands.get(i).setFitWidth(1300/size);
            imageViewCardOnhands.get(i).setFitHeight(726*1300/size/500);
        }
        hboxy.getChildren().clear();
        hboxy.getChildren().addAll(imageViewCardOnhands);
    }
    
}
