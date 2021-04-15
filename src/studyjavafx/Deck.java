/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studyjavafx;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author PREMz
 */
public class Deck {
    private ArrayList<Card> deck;
    
    //Constructors
    public Deck() {
        deck = new ArrayList<Card>();
        String face[] = {"hearts","diamonds","spades","clubs"};
        String suit[] = {"2","3","4","5","6","7","8","9","10","jack","queen","king","ace"};
        for(String f : face){
            for(String s : suit){
                deck.add(new Card(f, s));
            }
        }
    }
    
    public Deck(ArrayList<Card> deck) {
        this.deck = deck;
    }
        
    //getter, setter
    public ArrayList<Card> getDeck() {
        return deck;
    }
    
    //Methods
    public void shuffleDeck(){
        Collections.shuffle(deck);
    }
    
    public Card draw(){
        if(deck.size() > 0) 
            return deck.remove(0);
        else                
            return null;
    }
}
