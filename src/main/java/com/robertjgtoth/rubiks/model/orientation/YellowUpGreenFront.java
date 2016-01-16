package com.robertjgtoth.rubiks.model.orientation;

import com.robertjgtoth.rubiks.model.Colors;
import com.robertjgtoth.rubiks.model.Rotation;

/**
 * Created by rtoth on 11/25/2014.
 */
public class YellowUpGreenFront extends Orientation
{
    public YellowUpGreenFront()
    {
        this.colors = Colors.createCubeColorGeometry(
            Colors.GREEN, Colors.BLUE, Colors.ORANGE,
            Colors.RED, Colors.YELLOW, Colors.WHITE);
    }

    public Orientation move(Rotation rotation)
    {
        switch (rotation)
        {
            case UP:
                return new GreenUpWhiteFront();
            case DOWN:
                return new BlueUpYellowFront();
            case LEFT:
                return new OrangeUpGreenFront();
            case RIGHT:
                return new RedUpGreenFront();
            case CLOCK:
                return new YellowUpOrangeFront();
            case COUNTER_CLOCK:
                return new YellowUpRedFront();
            default:
                throw new IllegalArgumentException("This should never happen");
        }
    }
}
