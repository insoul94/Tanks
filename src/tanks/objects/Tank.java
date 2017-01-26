package tanks.objects;

import javafx.scene.paint.Color;
import tanks.Direction;

/**
 * Created by ejevgbe on 14.01.2017.
 */
public class Tank extends BaseObject{
    int[][] matrix = new int[32][32];
    int matrixLength = matrix.length;

    int[][] model = new int[][] {
            {0, 0, 0, 1, 1, 0, 0, 0},
            {0, 0, 0, 1, 1, 0, 0, 0},
            {0, 0, 0, 1, 1, 0, 0, 0},
            {1, 0, 1, 1, 1, 1, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 1, 1, 1, 1, 0, 1}
    };

    private int[] direction;

    public int[] getDirection() {
        return direction;
    }

    public void setDirection(int[] direction) {
        this.direction = direction;
    }

    public Tank(int x, int y) {
        super(x, y, Color.YELLOW);
        direction = Direction.UP;
        drawMatrixFromModel();
    }

    private void drawMatrixFromModel()
    {
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[j][i] = model[j / 4][i / 4];
            }
        }
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void move(int[] newDirection) {
        if (newDirection != direction)
            changeDirection(newDirection);

        setX(getX() + direction[0]*2);
        setY(getY() + direction[1]*2);
    }
/*    public static final int[] UP = {0, -1};
    public static final int[] RIGHT = {1, 0};
    public static final int[] DOWN = {0, 1};
    public static final int[] LEFT = {-1, 0};*/

    private void changeDirection(int[] newDirection) {
        int[][] temp = new int[32][32];

        if (newDirection == Direction.UP) {
            for (int i = 0; i < matrixLength; i++) {
                for (int j = 0; j < matrixLength; j++) {
                    temp[j][i] = model[j / 4][i / 4];
                }
            }
        } else if (newDirection == Direction.DOWN) {
            for (int i = 0; i < matrixLength; i++) {
                for (int j = 0; j < matrixLength; j++) {
                    temp[(matrixLength - 1) - j][i] = model[j / 4][i / 4];
                }
            }
        } else if (newDirection == Direction.RIGHT) {
            for (int i = 0; i < matrixLength; i++) {
                for (int j = 0; j < matrixLength; j++) {
                    temp[i][(matrixLength - 1) - j] = model[j / 4][i / 4];
                }
            }
        } else if (newDirection == Direction.LEFT) {
            for (int i = 0; i < matrixLength; i++) {
                for (int j = 0; j < matrixLength; j++) {
                    temp[i][j] = model[j / 4][i / 4];
                }
            }
        }

        direction = newDirection;
        matrix = temp;
    }
}
