package com.robertjgtoth.rubiks.model.orientation;

import com.robertjgtoth.rubiks.model.Colors;
import com.robertjgtoth.rubiks.model.Rotation;

/**
 * Created by rtoth on 11/25/2014.
 */
public class YellowUpRedFront extends Orientation {

    public YellowUpRedFront()
    {
        this.colors = Colors.createCubeColorGeometry(
                Colors.RED, Colors.ORANGE, Colors.GREEN,
                Colors.BLUE, Colors.YELLOW, Colors.WHITE);
    }

    public Orientation move(Rotation rotation)
    {
        switch (rotation)
        {
            case UP:
                return new RedUpWhiteFront();
            case DOWN:
                return new OrangeUpYellowFront();
            case LEFT:
                return new GreenUpRedFront();
            case RIGHT:
                return new BlueUpRedFront();
            case CLOCK:
                return new YellowUpGreenFront();
            case COUNTER_CLOCK:
                return new YellowUpBlueFront();
            default:
                throw new IllegalArgumentException("This should never happen");
        }
    }

}
