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
public class Bot {
    private ArrayList<Card> botCards = new ArrayList<Card>(); // Cards on bot hand.
    
    public Bot() {
        
    }

    public ArrayList<Card> getBotCards() {
        return botCards;
    }

    /*@Method
    This method get param Card obj pass in botCars ArrayList<>.
    */
    public void setBotCards(ArrayList<Card> botCards) {
        this.botCards = botCards;
    }
    
    public int getBotCardsSize(){
        return botCards.size();
    }
    
    @Override
    public String toString() {
        return botCards+" ";
    }
    
    
    
}
