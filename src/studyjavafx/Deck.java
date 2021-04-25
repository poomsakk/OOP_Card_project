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
    }
    
    public Deck(boolean b){
        if(b){
            deck = new ArrayList<Card>();
            String face[] = {"clubs","diamonds","hearts","spades",};
            String suit[] = {"ace","2","3","4","5","6","7","8","9","10","jack","queen","king"};
            int n = 0;
            for(String s : suit){
                for(String f : face){
                    deck.add(new Card(f, s, ++n));
                }
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
    
    public void sortDeck(){
        Collections.sort(deck);
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
    
    public int getSize(){
        return deck.size();
    }
    
    public void addCard(Card card){
        deck.add(card);
    }

    @Override
    public String toString() {
        this.sortDeck();
        return deck+" ";
    }
    
    /*
    *
    *
    +++++++++++++++++For Bot+++++++++++++++++++
    *
    *
    */
    /*
    @instruction This method now move to GameGuiController for comfortable to make a time delay and animate.
    */
    /*public void botDropCard(ArrayList<Card> bot){
        int size = bot.size();
        for(int i = 0;i<size;i++){
            if(i >= size-1) break;
            else{
                for(int j = 0; j< size; j++){
                    if(j == size) break;
                    else if(j == i) continue;
                    else{
                        if(bot.get(i).getSuit().equals(bot.get(j).getSuit())){
                            System.out.println("\nBot Drop!! : "+bot.remove(i).getSuit()+bot.remove(j-1).getSuit()+" i "+i+" j "+j+"\n");
                            j = 0;
                            i = 0;
                        }
                    }
                    size = bot.size();
                }
            }
            size = bot.size();
        }
    }*/
    
    
}
