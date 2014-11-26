package com.robertjgtoth.rubiks.model.orientation;

import com.robertjgtoth.rubiks.model.Colors;
import com.robertjgtoth.rubiks.model.Rotation;

/**
 * Created by rtoth on 11/25/2014.
 */
public class WhiteUpGreenFront extends Orientation {

    public WhiteUpGreenFront()
    {
        this.colors = Colors.createCubeColorGeometry(
                Colors.GREEN, Colors.BLUE, Colors.RED,
                Colors.ORANGE, Colors.WHITE, Colors.YELLOW);
    }

    public Orientation move(Rotation rotation)
    {
        switch (rotation)
        {
            case UP:
                return new GreenUpYellowFront();
            case DOWN:
                return new BlueUpWhiteFront();
            case LEFT:
                return new RedUpGreenFront();
            case RIGHT:
                return new OrangeUpGreenFront();
            case CLOCK:
                return new WhiteUpRedFront();
            case COUNTER_CLOCK:
                return new WhiteUpOrangeFront();
            default:
                throw new IllegalArgumentException("This should never happen");
        }
    }
}
