/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studyjavafx;

import javafx.scene.image.Image;

/**
 *
 * @author PREMz
 */
public class Card {
    private String faceName, suit;
    private Image image;
    
    //Constructors
    public Card(String faceName, String suit) {
        this.faceName = faceName;
        this.suit = suit;
        String fileName = suit + "_of_" + faceName + ".png";
        System.out.println(fileName);
        image = new Image("studyjavafx/images/" + fileName);
    }
    
    //getter, setter, tostring
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
        return "Card{" + "faceName=" + faceName + ", suit=" + suit + '}';
    }
    
    //Methods
}
