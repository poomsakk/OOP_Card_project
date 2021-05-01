/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studyjavafx;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author PolWarapob
 */
public class StartGUIController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML private ImageView img;
    @FXML private Button play;
    private Image bg = new Image("studyjavafx/images/background.jpg");
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
     
        img.setImage(bg);
        img.getImage();
    }

    @FXML
    public void startButtonClicked(ActionEvent event) throws IOException {
        
        Parent gameRoot = FXMLLoader.load(getClass().getResource("GameGUI.fxml"));
        Scene scene = new Scene(gameRoot);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }
    @FXML
    public void HTPButtonClicked(ActionEvent event) throws Exception{
        Parent gameRoot = FXMLLoader.load(getClass().getResource("HowToPlay.fxml"));
        Scene scene = new Scene(gameRoot);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void ExitButtonClicked(){
        System.exit(0);
    }
}
