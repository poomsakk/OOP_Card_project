/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studyjavafx;

import java.util.ArrayList;

/**
 *
 * @author PolWarapob
 */
public class Player {
    private ArrayList<Card> playerCards; // Cards on player hand.
    
    public Player() {
        
    }

    public ArrayList<Card> getPlayerCards() {
        return playerCards;
    }

    /*@Method
    This method get param Card obj pass in playerCars ArrayList<>.
    */
    public void setPlayerCards(ArrayList<Card> playerCards) {
        playerCards = new ArrayList<>();
        this.playerCards = playerCards;
    }
    
    @Override
    public String toString() {
        return playerCards+" ";
    }
    
    
    
}
