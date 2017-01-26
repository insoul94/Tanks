package tanks;

import javafx.scene.paint.Color;

/**
 * Created by ejevgbe on 15.01.2017.
 */
public enum Colors {
    BLACK(new Color(0.0,0.0,0.0,1.0)) ,
    GREY(new Color(116.0/255, 116.0/255, 116.0/255, 1.0)),
    BRICK(new Color(185.0/255, 80.0/255, 28.0/255, 1.0)),
    TANK_YELLOW(new Color(250.0/255, 229.0/255, 159.0/255, 1.0));

    Color color;

    Colors(Color color) {
        this.color = color;
    }
}
