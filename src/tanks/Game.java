package tanks;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import tanks.objects.BaseObject;
import tanks.objects.Tank;

import java.util.ArrayList;

/**
 * Created by ejevgbe on 16.01.2017.
 */
public class Game {
    GameCanvas gameCanvas;
    Tank player1;
    ArrayList<Tank> enemies;
    ArrayList<BaseObject> scenery = new ArrayList<>();
    int count = 0;

    public Game(Canvas canvas) {
        gameCanvas = new GameCanvas(canvas);
    }

    private void initializeLevel() {
        player1 = new Tank(300, 300);
    }

    public void run() {
        initializeLevel();
        startGameLoop();
    }

    private void startGameLoop() {
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                gameCanvas.drawGameCanvas(player1);
            }
        }.start();
    }
}
