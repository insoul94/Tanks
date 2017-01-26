package tanks.objects;

import javafx.scene.paint.Color;

/**
 * Created by ejevgbe on 14.01.2017.
 */
public abstract class BaseObject {
    private int[][] matrix;
    private int[][] model;

    private int x;
    private int y;

    public BaseObject(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    private Color color;

    public abstract int[][] getMatrix();


    public  Color getColor() {
        return color;
    }
}
