/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studyjavafx;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author iamsu
 */
public class MultiPlayerController implements Initializable {

    @FXML private ImageView img;
    
    private Image bg = new Image("studyjavafx/images/background.jpg");

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        img.setImage(bg);
        img.getImage();
    }
    @FXML
    public void twoPButtonClicked(ActionEvent event) throws IOException{
        Parent gameRoot = FXMLLoader.load(getClass().getResource("GameGUI.fxml"));
        Scene scene = new Scene(gameRoot);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void threePButtonClicked(ActionEvent event) throws IOException{
       // System.out.println("Button is pressed");
    }
    @FXML
    public void fourPButtonClicked(ActionEvent event) throws IOException{
       // System.out.println("Button is pressed");
    }
    @FXML
    public void backButtonClicked(ActionEvent event) throws IOException{
       // System.out.println("Button is pressed");
       Parent gameRoot = FXMLLoader.load(getClass().getResource("StartGUI.fxml"));
        Scene scene = new Scene(gameRoot);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

}
