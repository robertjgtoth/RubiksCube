package com.robertjgtoth.rubiks.model.orientation;

import com.robertjgtoth.rubiks.model.Colors;
import com.robertjgtoth.rubiks.model.Rotation;

/**
 * Created by rtoth on 11/25/2014.
 */
public class RedUpGreenFront extends Orientation {

    public RedUpGreenFront()
    {
        this.colors = Colors.createCubeColorGeometry(
                Colors.GREEN, Colors.BLUE, Colors.YELLOW,
                Colors.WHITE, Colors.RED, Colors.ORANGE);
    }

    public Orientation move(Rotation rotation)
    {
        switch (rotation)
        {
            case UP:
                return new GreenUpOrangeFront();
            case DOWN:
                return new BlueUpRedFront();
            case LEFT:
                return new YellowUpGreenFront();
            case RIGHT:
                return new WhiteUpGreenFront();
            case CLOCK:
                return new RedUpYellowFront();
            case COUNTER_CLOCK:
                return new RedUpWhiteFront();
            default:
                throw new IllegalArgumentException("This should never happen");
        }
    }
}
