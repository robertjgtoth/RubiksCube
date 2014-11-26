package com.robertjgtoth.rubiks.model.orientation;

import com.robertjgtoth.rubiks.model.Colors;
import com.robertjgtoth.rubiks.model.Rotation;

/**
 * Created by rtoth on 11/25/2014.
 */
public class BlueUpYellowFront extends Orientation {

    public BlueUpYellowFront()
    {
        this.colors = Colors.createCubeColorGeometry(
                Colors.YELLOW, Colors.WHITE, Colors.ORANGE,
                Colors.RED, Colors.BLUE, Colors.GREEN);
    }

    public Orientation move(Rotation rotation)
    {
        switch (rotation)
        {
            case UP:
                return new YellowUpGreenFront();
            case DOWN:
                return new WhiteUpBlueFront();
            case LEFT:
                return new OrangeUpYellowFront();
            case RIGHT:
                return new RedUpYellowFront();
            case CLOCK:
                return new BlueUpOrangeFront();
            case COUNTER_CLOCK:
                return new BlueUpRedFront();
            default:
                throw new IllegalArgumentException("This should never happen");
        }
    }

}
