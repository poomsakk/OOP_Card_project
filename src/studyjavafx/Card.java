/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studyjavafx;

import javafx.scene.image.Image;

/**
 *
 * @author PREMz ,Pollapatronum
 */
public class Card implements Comparable<Card>{
    private String faceName, suit;
    private Image image;
    private int priority;
    
    /*@Constructors
    Param for set the face name and suit of cards with image files
    */
    public Card(String faceName, String suit, int priority) {
        
        this.faceName = faceName.toLowerCase();
        this.suit = suit.toLowerCase();
        String fileName = suit + "_of_" + faceName + ".png";
        image = new Image("studyjavafx/images/" + fileName);
        this.priority = priority;
    }
    
    //getter, setter, toString
    public String getFaceName() {
        return faceName;
    }

    public String getSuit() {
        return suit;
    }

    public Image getImage() {
        return image;
    }

    @Override
    public String toString() {
        return suit + "_of_" + faceName + "\n";
    }

    @Override
    public int compareTo(Card o) {
        return Integer.compare(priority, o.priority);
    }

}