/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studyjavafx;

import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

/**
 *
 * @author PolWarapob
 */
public class Player {
    private ArrayList<Card> playerCards = new ArrayList<Card>(); // Cards on player hand.
    @FXML private ImageView card1,card2,card3,card4,card5,card6,card7,card8,card9,card10,card11,card12,card13;
    
    public Player() {
        
    }

    public ArrayList<Card> getPlayerCards() {
        return playerCards;
    }

    /*@Method
    This method get param Card obj pass in playerCars ArrayList<>.
    */
    public void setPlayerCards(ArrayList<Card> playerCards) {
        this.playerCards = playerCards;
    }
    
    public int getPlayerCardsSize(){
        return playerCards.size();
    }
    
    @Override
    public String toString() {
        return playerCards+" ";
    }
    
    
    
}
