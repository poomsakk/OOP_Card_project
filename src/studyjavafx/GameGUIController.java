/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studyjavafx;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author PolWarapob
 */
public class GameGUIController implements Initializable {
    //@FXML key and Variable
    @FXML private ImageView imgView1;
    @FXML private HBox hboxy;
    private ArrayList<ImageView> imageViewCardOnHands;
    private Deck mainDeck;
    private Deck playerDeck;
    int x = 0;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        mainDeck = new Deck(true);   
        mainDeck.shuffleDeck();
        
        playerDeck = new Deck();
        
        imageViewCardOnHands = new ArrayList<ImageView>();
        imgView1.setImage(new Image("studyjavafx/images/backOfCard.jpg"));
        
        LoadGameForOneBots();
        
    }   
    
    @FXML
    public void drawButtonClicked(){
        imgView1.setImage(mainDeck.draw().getImage());
    }
    
    @FXML
    public void sortCardOnHands(){
        playerDeck.sortDeck();
        updateCardOnHands();
    }
    
    private void LoadGameForOneBots(){
        for(int i = 0; i < mainDeck.getSize()/2;i++){
            Card cardDraw = mainDeck.draw();
            playerDeck.addCard(cardDraw);
            imageViewCardOnHands.add(new ImageView(cardDraw.getImage()));
            imageViewCardOnHands.get(i).setFitWidth(1080/26); //width of window /26
            imageViewCardOnHands.get(i).setFitHeight(1600/26);//heigh of window /26
        }
        System.out.println(imageViewCardOnHands);
        hboxy.setAlignment(Pos.CENTER);
        hboxy.getChildren().addAll(imageViewCardOnHands);
        System.out.println(hboxy);
         /**Click On imgView1 to move Down
        imgView1.setImage(new Image("studyjavafx/images/backOfCard.jpg"));
        imgView1.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                imgView1.setY(imgView1.getY()+10);
                //System.out.println(x++);
                //event.consume();
            }
        });*/
         
    }
    
    
    /*
    *
    *
    *
    *
    ++++++++For update GUI while start playing++++++++++++
    *
    *
    *
    *
    */
    
    private void updateCardOnHands(){
        hboxy.getChildren().clear();
        imageViewCardOnHands.clear();
        int size = playerDeck.getSize();
        for(int i = 0; i< size; i++){
            imageViewCardOnHands.add(new ImageView(playerDeck.getDeck().get(i).getImage()));
            imageViewCardOnHands.get(i).setFitWidth(1080/26); //width of window /26
            imageViewCardOnHands.get(i).setFitHeight(1600/26);//heigh of window /26
        }
        hboxy.setAlignment(Pos.CENTER);
        hboxy.getChildren().addAll(imageViewCardOnHands);
    }
    
    
}

