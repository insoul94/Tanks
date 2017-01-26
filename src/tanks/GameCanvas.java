package tanks;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import tanks.objects.BaseObject;
import tanks.objects.Tank;

/**
 * Created by ejevgbe on 14.01.2017.
 */
public class GameCanvas {


    int[][] field = new int[height][width];
    final static int[][] chunk = new int[16][16];

    final static int width = 512;
    final static int height = 480;

    private Canvas canvas;
    private WritableImage image;
    private PixelWriter pixelWriter;
    private GraphicsContext gc;

    {
        for (int i = 0; i < field[0].length; i++) {
            for (int j = 0; j < field.length; j++) {
                field[j][i] = 1;
            }
        }

        for (int i = 2 * chunk.length - 1; i < (2 + 26) * chunk.length; i++) {
            for (int j = 2 * chunk.length - 1; j < (2 + 26) * chunk.length; j++) {
                field[j][i] = 0;
            }
        }
    }

    public GameCanvas(Canvas canvas) {
        this.canvas = canvas;
        this.image = new WritableImage(GameCanvas.width, GameCanvas.height);
        this.pixelWriter = image.getPixelWriter();
        this.gc = canvas.getGraphicsContext2D();
    }

    void drawGameCanvas(BaseObject... objects) {
        for (int i = 0; i < GameCanvas.width; i++) {
            for (int j = 0; j < GameCanvas.height; j++) {
                Color color;
                if (field[j][i] == 0) color = Color.BLACK;
                else color = Color.GRAY;
                pixelWriter.setColor(i, j, color);
            }
        }

        drawObjects(objects);
        gc.drawImage(image, 0, 0);
    }

    private void drawObjects(BaseObject... objects) {

        for (BaseObject object : objects) {
            for (int i = 0; i < object.getMatrix()[0].length; i++) {
                for (int j = 0; j < object.getMatrix().length; j++) {
                    Color color;
                    if (object.getMatrix()[j][i] == 0) continue;
                    else color = object.getColor();
                    pixelWriter.setColor(object.getX() + i, object.getY() + j, color);
                }
            }
        }
    }
}