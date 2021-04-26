
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studyjavafx;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author PolWarapob
 */
public class GameGUIController implements Initializable {

    //@FXML key and Variable
    @FXML
    private ImageView imgView1, img;
    @FXML
    private HBox hboxy;
    @FXML
    private HBox hbox2;
    @FXML
    private HBox hboxy3;
    @FXML
    private HBox hboxy4;
    @FXML
    private HBox hboxy5;
    @FXML
    private Label labelBot;
    private Deck dropedDeck;
    private ArrayList<ImageView> imageViewCardOnHands;
    private ArrayList<ImageView> imageViewCardOnBots;
    private ArrayList<ImageView> imageViewDropCards;
    private ArrayList<CheckBox> checkBoxs;
    private ArrayList<CheckBox> botCheckBoxs;
    private Deck mainDeck;
    private Deck playerDeck;
    private Image backImage = new Image("studyjavafx/images/backOfCard.jpg");
    int count = 0;
    private Deck botDeck;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        mainDeck = new Deck(true);
        mainDeck.shuffleDeck();

        playerDeck = new Deck();
        botDeck = new Deck();
        dropedDeck = new Deck();

        checkBoxs = new ArrayList<>();
        botCheckBoxs = new ArrayList<>();

        imageViewCardOnHands = new ArrayList<ImageView>();
        imageViewCardOnBots = new ArrayList<ImageView>();
        imageViewDropCards = new ArrayList<ImageView>();
        imgView1.setImage(backImage);

        img.setImage(backImage);

        //LoadGameForOneBots();
        transFormer();

    }

    @FXML
    public void sortCardOnHands() {
        botDeck.sortDeck();
        playerDeck.sortDeck();
        updateCardOnHand();
    }

    /*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                                @Method Drop!!!
    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
    @FXML
    public void dropCard() throws InterruptedException {
        int check = 0;
        for (CheckBox checkBox : checkBoxs) {
            if (checkBox.isSelected()) {
                check++;
            }
        }
        if (check == 2) {
            for (int i = 0; i < checkBoxs.size(); i++) {
                boolean done = false;
                for (int j = 0; j < checkBoxs.size(); j++) {
                    if (i != j && checkBoxs.get(i).isSelected() && checkBoxs.get(j).isSelected()) {
                        if (playerDeck.getDeck().get(i).getSuit().equals(playerDeck.getDeck().get(j).getSuit())) {
                            System.out.println("i=" + i + " j=" + j);
                            dropedDeck.getDeck().clear(); //clear dropedDeck for display the lastes two cards that droped by player.
                            dropedDeck.addCard(playerDeck.getDeck().get(i));
                            dropedDeck.addCard(playerDeck.getDeck().get(j));

                            System.out.println(playerDeck.getDeck().remove(j).getSuit());
                            System.out.println(playerDeck.getDeck().remove(i).getSuit());
                            done = true;
                            break;
                        }
                    }
                }
                System.out.println(dropedDeck.getDeck());
                if (done) {
                    break;
                }
            }
        }
        System.out.println(botDeck.getSize());
        botDeck.sortDeck();
        botDropCard(botDeck.getDeck());
        //System.out.println(botDeck);
        updateCardOnHand();
    }

    //This Method moved from the deck class.
    public void botDropCard(ArrayList<Card> bot) {
        int size = bot.size();
        for (int i = 0; i < size; i++) {
            if (i >= size - 1) {
                break;
            } else {
                for (int j = 0; j < size; j++) {
                    if (j == size) {
                        break;
                    } else if (j == i) {
                        continue;
                    } else {
                        if (bot.get(i).getSuit().equals(bot.get(j).getSuit())) {
                            dropedDeck.getDeck().clear(); //clear dropedDeck for display the lastes two cards that droped by player.
                            dropedDeck.addCard(botDeck.getDeck().get(i));
                            dropedDeck.addCard(botDeck.getDeck().get(j));

                            System.out.println("\nBot Drop!! : " + bot.remove(i).getSuit() + bot.remove(j - 1).getSuit() + " i " + i + " j " + j + "\n");
                            j = 0;
                            i = 0;
                            updateCardOnHand();
                        }
                    }
                    size = bot.size();
                }
            }
            size = bot.size();
        }
    }
    @FXML
    public void drawCardFromBot() {
        int check = 0;
        for (CheckBox checkBox : botCheckBoxs) {
            if (checkBox.isSelected()) {
                check++;
            }
        }
        boolean done = false;
        if (check == 1) {
            for (int i = 0; i < botCheckBoxs.size(); i++) {
                if (botCheckBoxs.get(i).isSelected()) {
                    playerDeck.addCard(botDeck.getDeck().get(i));
                    System.out.println("BotDeck -> PlayerDeck " + botDeck.getDeck().remove(i).getSuit());
                    updateCardOnHand();
                    done = true;
                    break;
                }
                if (done) {
                    break;
                }
            }
        }
    }


    /*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            This @Method for animateion while draw the Card from mainDeck
    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
    int yy = 0;

    private void transFormer() {
        count++;
        img.setLayoutY(117 - yy);
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(0.3));
        yy += 720;
        transition.setToY(yy);
        transition.setNode(img);
        transition.setOnFinished((eventFin) -> {
            if (count <= 26) {
                playerDeck.addCard(mainDeck.draw());
                System.out.println("platerDeck.getSize()=" + playerDeck.getSize());
                botDeck.addCard(mainDeck.draw());
                labelBot.setText("Bot1 card left x" + botDeck.getSize());
                updateCardOnHand();
                transFormer();
            }
        });
        transition.play();

    }

    /*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            This @method will update the image in the imageview box
    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
    private void updateCardOnHand() {
        labelBot.setText("Bot1 card left x" + botDeck.getSize());
        imageViewCardOnHands.clear();
        hboxy.getChildren().clear();
        hbox2.getChildren().clear();
        checkBoxs.clear();
        int size = playerDeck.getSize();
        for (int i = 0; i < size; i++) {
            imageViewCardOnHands.add(new ImageView(playerDeck.getDeck().get(i).getImage()));
            imageViewCardOnHands.get(i).setFitWidth(1100 / (size < 10 ? 10 : size)); //width of window /26
            imageViewCardOnHands.get(i).setFitHeight(726 * 1100 / (size < 10 ? 10 : size) / 500);//heigh of window /26
            checkBoxs.add(new CheckBox());
        }
        setSpaceHbox(hbox2, (size < 10 ? 10 : size));
        hboxy.getChildren().addAll(imageViewCardOnHands);
        hbox2.getChildren().addAll(checkBoxs);
        /*++++++++++++++++++++++++++++++
        +This part for bot's operation.+
        ++++++++++++++++++++++++++++++*/
        imageViewCardOnBots.clear();
        hboxy3.getChildren().clear();
        hboxy5.getChildren().clear();
        botCheckBoxs.clear();
        int sizeBot = botDeck.getSize();
        for (int i = 0; i < sizeBot; i++) {
            imageViewCardOnBots.add(new ImageView(backImage));
            imageViewCardOnBots.get(i).setFitWidth(1100 / (sizeBot < 10 ? 10 : sizeBot)); //width of window /26
            imageViewCardOnBots.get(i).setFitHeight(726 * 1100 / (sizeBot < 10 ? 10 : sizeBot) / 500);//heigh of window /26
            botCheckBoxs.add(new CheckBox());
        }
        setSpaceHbox(hboxy5, (sizeBot < 10 ? 10 : sizeBot));
        hboxy3.getChildren().addAll(imageViewCardOnBots);
        hboxy5.getChildren().addAll(botCheckBoxs);
        /*++++++++++++++++++++++++++++++++++
        +This part for set image dropedDeck+
        ++++++++++++++++++++++++++++++++++*/
        imageViewDropCards.clear();
        hboxy4.getChildren().clear();
        int sizeDrop = dropedDeck.getSize();
        for (int i = 0; i < sizeDrop; i++) {
            imageViewDropCards.add(new ImageView(dropedDeck.getDeck().get(i).getImage()));
            imageViewDropCards.get(i).setFitWidth(1100 / (sizeDrop < 10 ? 10 : sizeDrop)); //width of window /26
            imageViewDropCards.get(i).setFitHeight(726 * 1100 / (sizeDrop < 10 ? 10 : sizeDrop) / 500);//heigh of window /26
        }
        hboxy4.getChildren().addAll(imageViewDropCards);
    }

    private void setSpaceHbox(HBox hbox, int size) {
        switch (size) {
            case 26:
                hbox.setSpacing(29);
                break;
            case 25:
                hbox.setSpacing(31);
                break;
            case 24:
                hbox.setSpacing(32);
                break;
            case 23:
                hbox.setSpacing(34);
                break;
            case 22:
                hbox.setSpacing(37);
                break;
            case 21:
                hbox.setSpacing(39);
                break;
            case 20:
                hbox.setSpacing(42);
                break;
            case 19:
                hbox.setSpacing(44);
                break;
            case 18:
                hbox.setSpacing(48);
                break;
            case 17:
                hbox.setSpacing(51);
                break;
            case 16:
                hbox.setSpacing(55);
                break;
            case 15:
                hbox.setSpacing(60);
                break;
            case 14:
                hbox.setSpacing(65);
                break;
            case 13:
                hbox.setSpacing(71);
                break;
            case 12:
                hbox.setSpacing(78);
                break;
            case 11:
                hbox.setSpacing(87);
                break;
            case 10:
                hbox.setSpacing(98);
                break;
            default:
                hbox.setSpacing(0);
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
 /*
    //not used now but soon.
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
        
        //Bot Card
        botDeck = new Deck(mainDeck.getDeck());
        labelBot.setText("Bot1 card left x" + botDeck.getSize());
        //System.out.println(botDeck.toString());
    }
     */
}
