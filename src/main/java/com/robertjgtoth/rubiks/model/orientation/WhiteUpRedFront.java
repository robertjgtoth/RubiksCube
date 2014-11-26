package com.robertjgtoth.rubiks.model.orientation;

import com.robertjgtoth.rubiks.model.Colors;
import com.robertjgtoth.rubiks.model.Rotation;

/**
 * Created by rtoth on 11/25/2014.
 */
public class WhiteUpRedFront extends Orientation {

    public WhiteUpRedFront()
    {
        this.colors = Colors.createCubeColorGeometry(
                Colors.RED, Colors.ORANGE, Colors.BLUE,
                Colors.GREEN, Colors.WHITE, Colors.YELLOW);
    }

    public Orientation move(Rotation rotation)
    {
        switch (rotation)
        {
            case UP:
                return new RedUpYellowFront();
            case DOWN:
                return new OrangeUpWhiteFront();
            case LEFT:
                return new BlueUpRedFront();
            case RIGHT:
                return new GreenUpRedFront();
            case CLOCK:
                return new WhiteUpBlueFront();
            case COUNTER_CLOCK:
                return new WhiteUpGreenFront();
            default:
                throw new IllegalArgumentException("This should never happen");
        }
    }

}
