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
 * @author PREMz ,Pollapatronum
 */
public class Deck {
    private ArrayList<Card> deck;
    
    /*@Constructor
    Append the Card to deck ArrayList Obj.
    */
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
    
    /*@method
    This method will shuffle the deck ArrayList Obj.
    */
    public void shuffleDeck(){
        Collections.shuffle(deck);
    }
    
    /*@method
    This method will do fist in-out logic form deck ArrayList Obj.
    */
    public Card draw(){
        if(deck.size() > 0) 
            return deck.remove(0);
        else                
            return null;
    }

    @Override
    public String toString() {
        return deck+" ";
    }
    
}
