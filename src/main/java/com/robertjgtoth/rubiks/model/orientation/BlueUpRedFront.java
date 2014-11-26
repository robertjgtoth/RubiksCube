package com.robertjgtoth.rubiks.model.orientation;

import com.robertjgtoth.rubiks.model.Colors;
import com.robertjgtoth.rubiks.model.Rotation;

/**
 * Created by rtoth on 11/25/2014.
 */
public class BlueUpRedFront extends Orientation {

    public BlueUpRedFront()
    {
        this.colors = Colors.createCubeColorGeometry(
                Colors.RED, Colors.ORANGE, Colors.YELLOW,
                Colors.WHITE, Colors.BLUE, Colors.GREEN);
    }

    public Orientation move(Rotation rotation)
    {
        switch (rotation)
        {
            case UP:
                return new RedUpGreenFront();
            case DOWN:
                return new OrangeUpBlueFront();
            case LEFT:
                return new YellowUpRedFront();
            case RIGHT:
                return new WhiteUpRedFront();
            case CLOCK:
                return new BlueUpYellowFront();
            case COUNTER_CLOCK:
                return new BlueUpWhiteFront();
            default:
                throw new IllegalArgumentException("This should never happen");
        }
    }

}
