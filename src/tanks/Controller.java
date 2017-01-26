package tanks;
/**
 * Created by ejevgbe on 14.01.2017.
 */

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import tanks.objects.Tank;

public class Controller implements Initializable {

    Game game;

    @FXML
    private StackPane stackPane;

    @FXML
    private Canvas canvas;

    /**
     * Initializes the controller class.
     */


    @Override
    public void initialize(URL url, ResourceBundle rb) {

        game = new Game(canvas);
        System.out.println("Initialized");
        game.run();
    }

    void initializeKeyListener(Tank object) {
        stackPane.addEventFilter(KeyEvent.ANY, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.UP) {
                    object.move(Direction.UP);
                }
                else if (event.getCode() == KeyCode.RIGHT){
                    object.move(Direction.RIGHT);
                }
                else if (event.getCode() == KeyCode.DOWN){
                    object.move(Direction.DOWN);
                }
                else if (event.getCode() == KeyCode.LEFT){
                    object.move(Direction.LEFT);
                }
                System.out.println("Key");
                event.consume();
            }
        });
    }
}