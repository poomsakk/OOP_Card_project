
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
import javafx.scene.control.CheckBox;
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
    @FXML private HBox hbox2;
    private ArrayList<ImageView> imageViewCardOnHands;
    private ArrayList<CheckBox> checkBoxs;
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
        //mainDeck.shuffleDeck();
        
        playerDeck = new Deck();
        
        checkBoxs = new ArrayList<>();
        
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
        updateCardOnHand();
    }
    
    @FXML public void dropCard(){
        int check = 0;
        for(CheckBox checkBox : checkBoxs)
            if(checkBox.isSelected())
                check++;
        if(check == 2){
            for (int i = 0; i < checkBoxs.size(); i++) {
                boolean done = false;
                for (int j = 0; j < checkBoxs.size(); j++) {
                    if(i!=j && checkBoxs.get(i).isSelected() && checkBoxs.get(j).isSelected())
                    {
                        if(playerDeck.getDeck().get(i).getSuit() == playerDeck.getDeck().get(j).getSuit())
                        {
                            System.out.println("i=" + i + " j=" + j);
                            System.out.println(playerDeck.getDeck().remove(j).getSuit());
                            System.out.println(playerDeck.getDeck().remove(i).getSuit());
                            done = true;
                            break;
                        }
                    }
                }
                if(done) break;
            }
        }
        updateCardOnHand();
    }
    
    private void LoadGameForOneBots(){
        int size = 26;//scale>10
        for(int i = 0; i < size;i++){
            Card cardDraw = mainDeck.draw();
            playerDeck.addCard(cardDraw);
            imageViewCardOnHands.add(new ImageView(cardDraw.getImage()));
            imageViewCardOnHands.get(i).setFitWidth(1100/size); //width = 1200/imageCount
            imageViewCardOnHands.get(i).setFitHeight(726*1100/size/500);// height = 726*1200/imageCount/500
            checkBoxs.add(new CheckBox());
        }
        hboxy.setAlignment(Pos.CENTER);
        hboxy.getChildren().addAll(imageViewCardOnHands);
        
        hbox2.setAlignment(Pos.CENTER);
        hbox2.setSpacing(29);
        hbox2.getChildren().addAll(checkBoxs);
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
    
    private void updateCardOnHand(){
        imageViewCardOnHands.clear();
        hboxy.getChildren().clear();
        hbox2.getChildren().clear();
        checkBoxs.clear();
        int size = playerDeck.getSize();
        for(int i = 0; i< size; i++){
            imageViewCardOnHands.add(new ImageView(playerDeck.getDeck().get(i).getImage()));
            imageViewCardOnHands.get(i).setFitWidth(1100/size); //width of window /26
            imageViewCardOnHands.get(i).setFitHeight(726*1100/size/500);//heigh of window /26
            checkBoxs.add(new CheckBox());
        }
        setSpaceHbox2(size);
        hboxy.getChildren().addAll(imageViewCardOnHands);
        hbox2.getChildren().addAll(checkBoxs);
        
    }
    
    private void setSpaceHbox2(int size){
        System.out.println(size);
        switch (size) {
            case 26: hbox2.setSpacing(29);
                break;
            case 24: hbox2.setSpacing(32);
                break;
            case 22: hbox2.setSpacing(37);
                break;
            case 20: hbox2.setSpacing(42);
                break;
            case 18: hbox2.setSpacing(48);
                break;
            case 16: hbox2.setSpacing(55);
                break;
            case 14: hbox2.setSpacing(65);
                break;
            case 12: hbox2.setSpacing(78);
                break;
            case 10: hbox2.setSpacing(98);
                break;
            case 8: hbox2.setSpacing(125);
                break;       
            case 6: hbox2.setSpacing(160);
                break; 
            case 4: hbox2.setSpacing(185);
                break;
            case 2: hbox2.setSpacing(200);
                break;     
            default: hbox2.setSpacing(0);
                break;
        }
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
    /*
    private void updateCardOnHands(){
        imageViewCardOnHands.clear();
        int size = playerDeck.getSize();
        for(int i = 0; i< size; i++){
            imageViewCardOnHands.add(new ImageView(playerDeck.getDeck().get(i).getImage()));
            imageViewCardOnHands.get(i).setFitWidth(800/26); //width of window /26
            imageViewCardOnHands.get(i).setFitHeight(600/26);//heigh of window /26
        }
        hboxy.setAlignment(Pos.CENTER);
        hboxy.getChildren().addAll(imageViewCardOnHands);
    }
    */
    
}