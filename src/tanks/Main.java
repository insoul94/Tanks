package tanks;/**
 * Created by ejevgbe on 14.01.2017.
 */

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;

import javafx.stage.Stage;
import tanks.objects.Tank;


public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TanksUI.fxml"));
            StackPane stackPane = loader.load();
            Controller controller = loader.getController();

            Scene gameScene = new Scene(stackPane, GameCanvas.width, GameCanvas.height);
            initializeKeyListener(gameScene, controller.game.player1);
            primaryStage.setScene(gameScene);
            primaryStage.setTitle("Tanks Battle City");
            primaryStage.setAlwaysOnTop(false);
            primaryStage.setResizable(false);
            primaryStage.show();

        } catch (Exception e) {
            System.out.println("Exception thrown");
            e.printStackTrace();
        }
    }

    void initializeKeyListener(Scene scene, Tank object) {
        scene.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
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
                event.consume();
            }
        });
    }
}
